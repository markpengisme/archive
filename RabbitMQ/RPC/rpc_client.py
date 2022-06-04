#!/usr/bin/env python
import pika
import uuid
import sys


class FibonacciRpcClient(object):

    def __init__(self):
        # We establish a connection, channel and declare an exclusive callback_queue for replies.
        self.connection = pika.BlockingConnection(
            pika.ConnectionParameters(host='localhost'))
        self.channel = self.connection.channel()
        result = self.channel.queue_declare(queue='', exclusive=True)
        self.callback_queue = result.method.queue

        self.channel.basic_consume(
            queue=self.callback_queue,
            on_message_callback=self.on_response,
            auto_ack=True)

    # The on_response callback checks if the correlation_id is the one we're looking for.
    # If so, it saves the response in self.response and breaks the consuming loop.
    def on_response(self, ch, method, props, body):
        if self.corr_id == props.correlation_id:
            self.response = body

    # The call method does the actual RPC request
    def call(self, n):
        self.response = None

        # we generate a unique correlation_id number and save it
        # the on_response callback function will use this value to catch the appropriate response.
        self.corr_id = str(uuid.uuid4())

        # we publish the request message, with two properties:  reply_to and correlation_id.
        self.channel.basic_publish(
            exchange='',
            routing_key='rpc_queue',
            properties=pika.BasicProperties(
                reply_to=self.callback_queue,
                correlation_id=self.corr_id,
            ),
            body=str(n))

        # At the end we wait until the proper response arrives and return the response back to the user.
        while self.response is None:
            self.connection.process_data_events()
        return int(self.response)


fibonacci_rpc = FibonacciRpcClient()
parm = sys.argv[1]
print(" [x] Requesting fib(%s)" % parm)
response = fibonacci_rpc.call(int(parm))
print(" [.] Got %r" % response)

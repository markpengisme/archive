#!/usr/bin/env python

import pika
import time

connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()

# The durability options let the tasks survive even if RabbitMQ is restarted.
channel.queue_declare(queue='task_queue', durable=True)


# Our old receive.py script also requires some changes:
# it needs to fake a second of work for every dot in the message body.
def callback(ch, method, properties, body):
    print(" [x] Received %r" % body.decode())
    time.sleep(body.count(b'.'))
    print(" [x] Done")
    # Using this code we can be sure that even if you kill a worker using CTRL+C while it was processing a message,
    # nothing will be lost. Soon after the worker dies all unacknowledged messages will be redelivered.
    ch.basic_ack(delivery_tag=method.delivery_tag)


# This uses the basic.qos protocol method to tell RabbitMQ not to give more than one message to a worker at a time.
channel.basic_qos(prefetch_count=1)
channel.basic_consume(queue='task_queue', on_message_callback=callback)

channel.start_consuming()

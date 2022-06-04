#!/usr/bin/env python

import pika
import os
import sys


def main():
    # Again, first we need to connect to RabbitMQ server.
    connection = pika.BlockingConnection(
        pika.ConnectionParameters('localhost'))
    channel = connection.channel()

    # The next step, just like before, is to make sure that the queue exists.
    channel.queue_declare(queue='hello')

    # Receiving messages from the queue is more complex.
    # It works by subscribing a callback function to a queue.
    # Whenever we receive a message, this callback function is called by the Pika library.
    # In our case this function will print on the screen the contents of the message.
    def callback(ch, method, properties, body):
        print(" [x] Received %r" % body)

    # Next, we need to tell RabbitMQ that this particular callback function should receive messages from our hello queue:
    channel.basic_consume(queue='hello',
                          auto_ack=True,
                          on_message_callback=callback)

    # And finally, we enter a never-ending loop that waits for data and runs callbacks whenever necessary,
    # and catch KeyboardInterrupt during program shutdown.
    print(' [*] Waiting for messages. To exit press CTRL+C')
    channel.start_consuming()


if __name__ == '__main__':
    try:
        main()
    except KeyboardInterrupt:
        print('Interrupted')
        try:
            sys.exit(0)
        except SystemExit:
            os._exit(0)

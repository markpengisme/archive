#!/usr/bin/env python

import pika
import time

connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()

# The fanout exchange is very simple. it just broadcasts all the messages it receives to all the queues it knows.
channel.exchange_declare(exchange='logs', exchange_type='fanout')

# Temporary queues
result = channel.queue_declare(queue='', exclusive=True)
queue_name = result.method.queue

# Binding
channel.queue_bind(exchange='logs', queue=queue_name)
print(' [*] Waiting for logs. To exit press CTRL+C')


def callback(ch, method, properties, body):
    print(" [x] %r" % body)


channel.basic_consume(
    queue=queue_name, on_message_callback=callback, auto_ack=True)

channel.start_consuming()

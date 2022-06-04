#!/usr/bin/env python

import pika
import sys

connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()


# The fanout exchange is very simple. it just broadcasts all the messages it receives to all the queues it knows.
channel.exchange_declare(exchange='logs', exchange_type='fanout')

message = ' '.join(sys.argv[1:]) or "Hello World!"
# We can publish to our named exchange instead,
# routing_key value is ignored for fanout exchanges.
channel.basic_publish(exchange='logs',
                      routing_key='',
                      body=message)

print(" [x] Sent %r" % message)
connection.close()

#!/usr/bin/env python

import pika

# We're connected now, to a broker on the local machine - hence the localhost.
connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()

# Next, before sending we need to make sure the recipient queue exists.
channel.queue_declare(queue='hello')

# Our first message will just contain a string Hello World! and we want to send it to our hello queue.
# In RabbitMQ a message can never be sent directly to the queue, it always needs to go through an exchange.
# The queue name needs to be specified in the routing_key parameter:
channel.basic_publish(exchange='',
                      routing_key='hello',
                      body='Hello World!')
print(" [x] Sent 'Hello World!'")

# Before exiting the program we need to make sure the network buffers were flushed and our message was actually delivered to RabbitMQ.
connection.close()

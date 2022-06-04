#!/usr/bin/env python

import pika
import sys

connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()

# Topic exchange
channel.exchange_declare(exchange='topic_logs', exchange_type='topic')

# Temporary queues
result = channel.queue_declare(queue='', exclusive=True)
queue_name = result.method.queue

# Read topics: <facility>.<severity>
binding_keys = sys.argv[1:]
if not binding_keys:
    sys.stderr.write("Usage: %s [binding_key]...\n" % sys.argv[0])
    sys.exit(1)

# Subscribing: create a new binding for each pattern(topic).
for binding_key in binding_keys:
    channel.queue_bind(
        exchange='topic_logs',
        queue=queue_name,
        routing_key=binding_key)

print(' [*] Waiting for logs. To exit press CTRL+C')


def callback(ch, method, properties, body):
    print(" [x] %r:%r" % (method.routing_key, body))


channel.basic_consume(
    queue=queue_name, on_message_callback=callback, auto_ack=True)

channel.start_consuming()

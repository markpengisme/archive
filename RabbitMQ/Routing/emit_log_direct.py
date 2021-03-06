#!/usr/bin/env python

import pika
import sys

connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()

# Direct exchange
channel.exchange_declare(exchange='direct_logs', exchange_type='direct')

# Severity and message
severity = sys.argv[1] if len(sys.argv) > 1 else 'info'
message = ' '.join(sys.argv[2:]) or "Hello World!"

# Emit logs, and supply the log severity as a routing key
channel.basic_publish(exchange='direct_logs',
                      routing_key=severity,
                      body=message)

print(" [x] Sent %r:%r" % (severity, message))
connection.close()

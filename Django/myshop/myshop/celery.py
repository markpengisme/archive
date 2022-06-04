import os
from celery import Celery


class Config:
    broker_url = os.environ.get(
        'CLOUDAMQP_URL', 'amqp://guest:guest@localhost:5672/')
    broker_pool_limit = 1  # Will decrease connection usage
    broker_heartbeat = None  # We're using TCP keep-alive instead
    # May require a long timeout due to Linux DNS timeouts etc
    broker_connection_timeout = 30
    # AMQP is not recommended as result backend as it creates thousands of queues
    result_backend = None
    # Will delete all celeryev. queues without consumers after 1 minute.
    event_queue_expires = 60
    # Disable prefetching, it's causes problems and doesn't help performance
    worker_prefetch_multiplier = 1
    # If you tasks are CPU bound, then limit to the number of cores, otherwise increase substainally
    worker_concurrency = 2


os.environ.setdefault('DJANGO_SETTINGS_MODULE',
                      os.environ.get('DJANGO_SETTINGS_MODULE'))
app = Celery('myshop')
app.config_from_object(Config, namespace='CELERY')
# app.config_from_object('django.conf:settings', namespace='CELERY')
app.autodiscover_tasks()

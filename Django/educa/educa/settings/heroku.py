import os
import dj_database_url

from .base import *


SECRET_KEY = os.environ["SECRET_KEY"]

# DEBUG = False
ALLOWED_HOSTS = ['*']

SECURE_SSL_REDIRECT = True
SESSION_COOKIE_SECURE = True
CSRF_COOKIE_SECURE = True


# postgreSQL
DATABASES['default'] = dj_database_url.config(
    conn_max_age=600,
)

# memcached
CACHES = {
    'default': {
        'BACKEND': 'django.core.cache.backends.memcached.PyLibMCCache',
        # TIMEOUT is not the connection timeout! It's the default expiration
        # timeout that should be applied to keys! Setting it to `None`
        # disables expiration.
        'TIMEOUT': None,
        'LOCATION': os.environ['MEMCACHIER_SERVERS'],
        'OPTIONS': {
            'binary': True,
            'username': os.environ['MEMCACHIER_USERNAME'],
            'password': os.environ['MEMCACHIER_PASSWORD'],
            'behaviors': {
                # Enable faster IO
                'no_block': True,
                'tcp_nodelay': True,
                # Keep connection alive
                'tcp_keepalive': True,
                # Timeout settings
                'connect_timeout': 2000,  # ms
                'send_timeout': 750 * 1000,  # us
                'receive_timeout': 750 * 1000,  # us
                '_poll_timeout': 2000,  # ms
                # Better failover
                'ketama': True,
                'remove_failed': 1,
                'retry_timeout': 2,
                'dead_timeout': 30,
            }
        }
    }
}


# redis channel
REDIS_URL = os.environ["REDIS_URL"]
CHANNEL_LAYERS = {
    'default': {
        'BACKEND': 'channels_redis.core.RedisChannelLayer',
        'CONFIG': {
            'hosts': [REDIS_URL],
        },
    },
}

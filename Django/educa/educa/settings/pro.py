from .base import *
from dotenv import dotenv_values
import dj_database_url

config = dotenv_values(".env")
DEBUG = False
SECRET_KEY = config["SECRET_KEY"]

SECURE_SSL_REDIRECT = True
SESSION_COOKIE_SECURE = True
CSRF_COOKIE_SECURE = True

ALLOWED_HOSTS = ['.educa.com']
INSTALLED_APPS += ['memcache_status']

# postgreSQL
DATABASES['default'] = dj_database_url.config(
    conn_max_age=600,
    default=config['DATABASE_URL']
)

# memcached
CACHES = {
    'default': {
        'BACKEND': 'django.core.cache.backends.memcached.PyLibMCCache',
        'LOCATION': '127.0.0.1:11211',
    }
}


# redis channel
CHANNEL_LAYERS = {
    'default': {
        'BACKEND': 'channels_redis.core.RedisChannelLayer',
        'CONFIG': {
            'hosts': [config["REDIS_URL"]],
        },
    },
}

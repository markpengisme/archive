from .base import *
import os

# secure
SECRET_KEY = os.environ["SECRET_KEY"]

DEBUG = False
ALLOWED_HOSTS = ['*']

SECURE_SSL_REDIRECT = True
SESSION_COOKIE_SECURE = True
CSRF_COOKIE_SECURE = True

# postgresql
DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.postgresql',
        'NAME': os.environ["PSQL_DBNAME"],
        'USER': os.environ["PSQL_USER"],
        'PASSWORD': os.environ["PSQL_PWD"],
        'HOST': os.environ["PSQL_HOST"],
        'PORT': '5432'
    }
}

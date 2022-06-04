from .base import *
from dotenv import dotenv_values

# secure
config = dotenv_values(".env")
SECRET_KEY = config["SECRET_KEY"]

DEBUG = False
ALLOWED_HOSTS = ['*']

SECURE_SSL_REDIRECT = True
SESSION_COOKIE_SECURE = True
CSRF_COOKIE_SECURE = True

# postgreSQL
DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.postgresql',
        'NAME': config["PSQL_DBNAME"],
        'USER': config["PSQL_USER"],
        'PASSWORD': config["PSQL_PWD"],
        'HOST': 'localhost',
        'PORT': '5432'
    }
}

from .base import *
from dotenv import dotenv_values
import os
import dj_database_url

# secure
config = dotenv_values(".env")
SECRET_KEY = config["SECRET_KEY"]

DEBUG = True
ALLOWED_HOSTS = ['*']

SECURE_SSL_REDIRECT = True
SESSION_COOKIE_SECURE = True
CSRF_COOKIE_SECURE = True

# postgreSQL
DATABASES['default'] = dj_database_url.config(
    conn_max_age=600,
    default=config['DATABASE_URL']
)

# redis
REDIS_URL = config["REDIS_URL"]

# Braintree settings
BRAINTREE_MERCHANT_ID = config['BRAINTREE_MERCHANT_ID']
BRAINTREE_PUBLIC_KEY = config['BRAINTREE_PUBLIC_KEY']
BRAINTREE_PRIVATE_KEY = config['BRAINTREE_PRIVATE_KEY']
BRAINTREE_CONF = braintree.Configuration(
    braintree.Environment.Sandbox,
    BRAINTREE_MERCHANT_ID,
    BRAINTREE_PUBLIC_KEY,
    BRAINTREE_PRIVATE_KEY
)

# gmail
EMAIL_BACKEND = 'django.core.mail.backends.smtp.EmailBackend'
EMAIL_HOST = 'smtp.gmail.com'
EMAIL_PORT = 587
EMAIL_USE_TLS = True
EMAIL_HOST_USER = config['EMAIL_HOST_USER']
EMAIL_HOST_PASSWORD = config['EMAIL_HOST_PASSWORD']

from .base import *
import os
import dj_database_url

# Secure
SECRET_KEY = os.environ["SECRET_KEY"]

DEBUG = False
ALLOWED_HOSTS = ['*']

SECURE_SSL_REDIRECT = True
SESSION_COOKIE_SECURE = True
CSRF_COOKIE_SECURE = True


# postgres
DATABASES['default'] = dj_database_url.config(
    conn_max_age=600,
)

# redis
REDIS_URL = os.environ["REDIS_URL"]

# Braintree settings
BRAINTREE_MERCHANT_ID = os.environ['BRAINTREE_MERCHANT_ID']
BRAINTREE_PUBLIC_KEY = os.environ['BRAINTREE_PUBLIC_KEY']
BRAINTREE_PRIVATE_KEY = os.environ['BRAINTREE_PRIVATE_KEY']
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
EMAIL_HOST_USER = os.environ['EMAIL_HOST_USER']
EMAIL_HOST_PASSWORD = os.environ['EMAIL_HOST_PASSWORD']

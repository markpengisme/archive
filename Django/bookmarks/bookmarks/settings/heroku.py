from .base import *
import os
import cloudinary
import cloudinary.uploader
import cloudinary.api

# Secure
SECRET_KEY = os.environ["SECRET_KEY"]

DEBUG = False
ALLOWED_HOSTS = ['*']

SECURE_SSL_REDIRECT = True
SESSION_COOKIE_SECURE = True
CSRF_COOKIE_SECURE = True


ALLOWED_HOSTS = ['*']

# cloudinary
INSTALLED_APPS += [
    'cloudinary',
    'cloudinary_storage',
]

cloudinary.config( 
  cloud_name = os.environ["CLOUDINARY_STORAGE_CLOUD_NAME"],
  api_key = os.environ["CLOUDINARY_STORAGE_API_KEY"],
  api_secret = os.environ["CLOUDINARY_STORAGE_API_SECRET"],
  secure = True
)

# postgres
DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.postgresql',
        'NAME': os.environ["PSQL_DBNAME"],
        'USER': os.environ["PSQL_USER"],
        'PASSWORD': os.environ["PSQL_PWD"],
        'HOST': os.environ["PSQL_HOST"],
        'PORT': os.environ["PSQL_PORT"]
    }
}

# redis
REDIS_HOST = os.environ["REDIS_HOST"]
REDIS_PORT = os.environ["REDIS_PORT"]
REDIS_DB = os.environ["REDIS_DB"]
REDIS_PASSWORD = os.environ["REDIS_PASSWORD"]

# three oauth
SOCIAL_AUTH_FACEBOOK_KEY = os.environ['SOCIAL_AUTH_FACEBOOK_KEY']
SOCIAL_AUTH_FACEBOOK_SECRET = os.environ['SOCIAL_AUTH_FACEBOOK_SECRET']
SOCIAL_AUTH_FACEBOOK_SCOPE = ['email']
SOCIAL_AUTH_FACEBOOK_PROFILE_EXTRA_PARAMS = {'fields': 'id, name, email'}
SOCIAL_AUTH_TWITTER_KEY = os.environ['SOCIAL_AUTH_TWITTER_KEY']
SOCIAL_AUTH_TWITTER_SECRET = os.environ['SOCIAL_AUTH_TWITTER_SECRET']
SOCIAL_AUTH_GOOGLE_OAUTH2_KEY = os.environ['SOCIAL_AUTH_GOOGLE_OAUTH2_KEY']
SOCIAL_AUTH_GOOGLE_OAUTH2_SECRET = os.environ['SOCIAL_AUTH_GOOGLE_OAUTH2_SECRET']

# gmail
EMAIL_BACKEND = 'django.core.mail.backends.smtp.EmailBackend'
EMAIL_HOST = 'smtp.gmail.com'
EMAIL_PORT = 587
EMAIL_USE_TLS = True
EMAIL_HOST_USER = os.environ['EMAIL_HOST_USER']
EMAIL_HOST_PASSWORD = os.environ['EMAIL_HOST_PASSWORD']

# for bookmarklet_launcher 
HOST = 'markpengisme-django-bookmarks.herokuapp.com'
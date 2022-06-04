from .base import *
import os
from dotenv import dotenv_values

# secure
config = dotenv_values(".env")
SECRET_KEY = config["SECRET_KEY"]

# https
INSTALLED_APPS += [
    'django_extensions',
]

# sqlite
DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.sqlite3',
        'NAME': os.path.join(BASE_DIR, 'db.sqlite3'),
    }
}

# redis
REDIS_HOST = 'localhost'
REDIS_PORT = 6379
REDIS_DB = 0
REDIS_PASSWORD = ''

# three oauth
SOCIAL_AUTH_FACEBOOK_KEY = config['SOCIAL_AUTH_FACEBOOK_KEY']
SOCIAL_AUTH_FACEBOOK_SECRET = config['SOCIAL_AUTH_FACEBOOK_SECRET']
SOCIAL_AUTH_FACEBOOK_SCOPE = ['email']
SOCIAL_AUTH_FACEBOOK_PROFILE_EXTRA_PARAMS = {'fields': 'id, name, email'}
SOCIAL_AUTH_TWITTER_KEY = config['SOCIAL_AUTH_TWITTER_KEY']
SOCIAL_AUTH_TWITTER_SECRET = config['SOCIAL_AUTH_TWITTER_SECRET']
SOCIAL_AUTH_GOOGLE_OAUTH2_KEY = config['SOCIAL_AUTH_GOOGLE_OAUTH2_KEY']
SOCIAL_AUTH_GOOGLE_OAUTH2_SECRET = config['SOCIAL_AUTH_GOOGLE_OAUTH2_SECRET']

# for bookmarklet_launcher 
HOST = '127.0.0.1:8000'

# cloudinary
import cloudinary
import cloudinary.uploader
import cloudinary.api
INSTALLED_APPS += [
    'cloudinary',
    'cloudinary_storage',
]

cloudinary.config( 
  cloud_name = config["CLOUDINARY_STORAGE_CLOUD_NAME"],
  api_key = config["CLOUDINARY_STORAGE_API_KEY"],
  api_secret = config["CLOUDINARY_STORAGE_API_SECRET"],
  secure = True
)
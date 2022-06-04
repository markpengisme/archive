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

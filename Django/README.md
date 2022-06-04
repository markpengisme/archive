# Django

## Mysite

- dev
  - export DJANGO_SETTINGS_MODULE=mysite.settings.local
  - python manage.py makemigrations
  - python manage.py migrate
  - python manage.py createsuperuser
  - python manage.py runserver
  - <http://127.0.0.1:8000>
- dev https
  - export DJANGO_SETTINGS_MODULE=mysite.settings.local
  - python manage.py makemigrations
  - python manage.py migrate
  - python manage.py createsuperuser
  - python manage.py runserver_plus --cert-file ssl/cert.crt
  - <https://mysite.com:8000>
- pro
  - export DJANGO_SETTINGS_MODULE=mysite.settings.pro
  - python manage.py collectstatic
  - createuser -dP mysite
  - createdb -E utf8 -U mysite mysite
  - python manage.py makemigrations
  - python manage.py migrate
  - python manage.py createsuperuser
  - sudo nginx -s reload
  - uwsgi --ini config/uwsgi.ini
  - <https://mysite.com>
- heroku
  - export DJANGO_SETTINGS_MODULE=mysite.settings.heroku
  - python manage.py collectstatic
  - python manage.py migrate
  - python manage.py createsuperuser
  - <https://markpengisme-django-mysite.herokuapp.com>
- Fake data

  ```python
  ## pip install Faker
  ## python manage.py shell
  from blog import fake
  fake.posts()
  fake.comments()
  ```

## Bookmarks

- dev https
  - export DJANGO_SETTINGS_MODULE=bookmarks.settings.local
  - python manage.py makemigrations
  - python manage.py migrate
  - python manage.py createsuperuser
  - python manage.py runserver_plus --cert-file ssl/cert.crt
  - <https://bookmarks.com:8000>
- pro
  - export DJANGO_SETTINGS_MODULE=bookmarks.settings.pro
  - python manage.py collectstatic
  - createuser -dP bookmarks
  - createdb -E utf8 -U bookmarks bookmarks
  - python manage.py makemigrations
  - python manage.py migrate
  - python manage.py createsuperuser
  - sudo nginx -s reload
  - gunicorn --config config/gunicorn.py
  - <https://bookmarks.com>
- heroku
  - export DJANGO_SETTINGS_MODULE=bookmarks.settings.heroku
  - python manage.py collectstatic
  - python manage.py makemigrations
  - python manage.py migrate
  - python manage.py createsuperuser
  - <https://markpengisme-django-bookmarks.herokuapp.com>


## Myshop

- dev https
  - export DJANGO_SETTINGS_MODULE=myshop.settings.local
  - python manage.py makemigrations
  - python manage.py migrate
  - python manage.py createsuperuser
  - python manage.py runserver_plus --cert-file ssl/cert.crt
  - <https://myshop.com:8000>
- pro
  - export DJANGO_SETTINGS_MODULE=myshop.settings.pro
  - python manage.py collectstatic
  - createuser -dP myshop
  - createdb -E utf8 -U myshop myshop
  - python manage.py makemigrations
  - python manage.py migrate
  - python manage.py createsuperuser
  - python manage.py loaddata fixtures/data.json
  - sudo nginx -s reload
  - gunicorn --config config/gunicorn.py
  - <https://myshop.com>
- heroku
  - export DJANGO_SETTINGS_MODULE=myshop.settings.heroku
  - python manage.py collectstatic
  - python manage.py makemigrations
  - python manage.py migrate
  - python manage.py createsuperuser
  - python manage.py loaddata fixtures/data.json
  - <https://markpengisme-django-myshop.herokuapp.com>


## Educa

- dev http(Because runserver_plus does not support ASGI)
  - export DJANGO_SETTINGS_MODULE=educa.settings.local
  - python manage.py makemigrations
  - python manage.py migrate
  - python manage.py createsuperuser
  - python manage.py runserver
  - <http://educa.com:8000>
- pro
  - export DJANGO_SETTINGS_MODULE=educa.settings.pro
  - python manage.py collectstatic
  - createuser -dP educa
  - createdb -E utf8 -U educa educa
  - python manage.py makemigrations
  - python manage.py migrate
  - python manage.py createsuperuser
  - python manage.py loaddata courses/fixtures/subjects.json
  - sudo nginx -s reload
  - uwsgi --ini config/uwsgi.ini
  - daphne -u /tmp/daphne.sock educa.asgi:application
  - <https://educa.com>
- heroku
  - export DJANGO_SETTINGS_MODULE=educa.settings.heroku
  - python manage.py collectstatic
  - python manage.py makemigrations
  - python manage.py migrate
  - python manage.py createsuperuser
  - python manage.py loaddata courses/fixtures/subjects.json
  - <https://markpengisme-django-educa.herokuapp.com>

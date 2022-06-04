#!/bin/bash

daphne -u /tmp/daphne.sock educa.asgi:application &
uwsgi --ini config/uwsgi.heroku.ini
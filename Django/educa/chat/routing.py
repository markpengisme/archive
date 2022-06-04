from django.urls import re_path, path
from . import consumers

urlpatterns = [
    re_path(r'ws/chat/room/(?P<course_id>\d+)/$',
            consumers.ChatConsumer.as_asgi(), name="chat_room_ws"),
]

from django.shortcuts import render, get_object_or_404
from django.http import HttpRequest, HttpResponseForbidden
from django.contrib.auth.decorators import login_required
from django.urls import reverse_lazy
from django.conf import settings


@login_required
def course_chat_room(request: HttpRequest, course_id: int):
    try:
        course = request.user.courses_joined.get(id=course_id)
        chat_room_ws = reverse_lazy("chat_room_ws",
                                    args=[course.id],
                                    urlconf=settings.CHANNELS_URLCONF)
    except:
        return HttpResponseForbidden()
    return render(request, 'chat/room.html', {
        'course': course,
        'chat_room_ws': chat_room_ws
    })

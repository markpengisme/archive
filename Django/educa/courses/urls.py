from django.urls import path
from django.views.decorators.cache import cache_page
from . import views

urlpatterns = [
    # manage courses(CRUD)
    path('read/',
         views.ManageCourseListView.as_view(),
         name='manage_course_list'),
    path('create/',
         views.ManageCourseCreateView.as_view(),
         name='manage_course_create'),
    path('<pk>/edit/',
         views.ManageCourseUpdateView.as_view(),
         name='manage_course_edit'),
    path('<pk>/delete/',
         views.ManageCourseDeleteView.as_view(),
         name='manage_course_delete'),

    # manage modules in a course(CRUD)
    path('<pk>/module/',
         views.ModuleView.as_view(),
         name='manage_module'),

    # manage contents in a module
    path('module/<int:module_id>/content/<model_name>/create/',
         views.ContentCreateUpdateView.as_view(),
         name='content_create'),
    path('module/<int:module_id>/content/<model_name>/<int:id>/edit/',
         views.ContentCreateUpdateView.as_view(),
         name='content_update'),
    path('module/<int:module_id>/content/<model_name>/<int:id>/delete/',
         views.ContentDeleteView.as_view(),
         name='content_delete'),
    path('module/<int:module_id>/content/',
         views.ContentListView.as_view(),
         name='content_list'),

    # manage order
    path('module/order/',
         views.ModuleOrderView.as_view(),
         name='module_order'),
    path('content/order/',
         views.ContentOrderView.as_view(),
         name='content_order'),

    # courses(open)
    path('subject/<slug:subject>/',
         cache_page(60 * 15)(views.CourseListView.as_view()),
         name='course_list_subject'),
    path('<slug:slug>/',
         views.CourseDetailView.as_view(),
         name='course_detail'),
]

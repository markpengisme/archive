import os
from django.contrib import admin
from .models import Content, Subject, Course, Module

# use memcache admin index site
if os.environ['DJANGO_SETTINGS_MODULE'] in ['educa.settings.local',  'educa.settings.pro']:
    admin.site.index_template = 'memcache_status/admin_index.html'


@admin.register(Subject)
class SubjectAdmin(admin.ModelAdmin):
    list_display = ['id', 'title', 'slug']
    prepopulated_fields = {'slug': ('title',)}


class ModuleInline(admin.StackedInline):
    model = Module


@admin.register(Course)
class CourseAdmin(admin.ModelAdmin):
    list_display = ['id', 'title', 'subject', 'created']
    list_filter = ['created', 'subject']
    search_fields = ['title', 'overview']
    prepopulated_fields = {'slug': ('title',)}
    inlines = [ModuleInline]
    filter_horizontal = ['students']


class ContentInline(admin.StackedInline):
    model = Content


@admin.register(Module)
class ModuleAdmin(admin.ModelAdmin):
    list_display = ['id', 'course', 'title', 'order']
    list_filter = ['course']
    search_fields = ['course']
    inlines = [ContentInline]

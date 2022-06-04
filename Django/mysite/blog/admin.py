from django.contrib import admin
from django.db.models.aggregates import Count

from .models import Post, Comment


@admin.register(Post)
class PostAdmin(admin.ModelAdmin):
    list_display = ('id', 'title', 'slug', 'author',
                    'publish', 'status', 'get_comments_count', 'get_tags')
    list_filter = ('status', 'created', 'publish', 'author', 'tags')
    search_fields = ('title', 'body', 'tags__name')
    prepopulated_fields = {'slug': ('title',)}
    raw_id_fields = ('author',)
    date_hierarchy = 'publish'
    ordering = ('status', 'publish')

    @admin.action(description='comments')
    def get_comments_count(self, post):
        return post.comments.count()

    @admin.action(description='tags')
    def get_tags(self, post):
        tags = []
        for tag in post.tags.all():
            tags.append(str(tag))
        return ', '.join(tags)


@admin.register(Comment)
class PostAdmin(admin.ModelAdmin):
    list_display = ('id', 'name', 'email', 'post', 'created', 'active')
    list_filter = ('active', 'created', 'updated')
    search_fields = ('name', 'email', 'body')

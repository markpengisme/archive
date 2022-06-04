from faker import Faker
from django.contrib.auth.models import User

from .models import Post, Comment


def posts(count=100):
    fake = Faker()
    for _ in range(count):
        u = User.objects.first()
        p = Post(title=fake.sentence(),
                 slug=fake.slug(),
                 body=fake.text(),
                 author=u,
                 status='published')
        p.save()
        for _ in range(5):
            p.tags.add(fake.word())
        p.save()


def comments(count=100):
    fake = Faker()
    for i in range(count):
        for _ in range(count):
            c = Comment(post=Post.published.order_by('?').first(),
                        name=fake.name(),
                        email=fake.email(),
                        body=fake.text())
            c.save()

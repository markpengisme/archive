from django.db import models
from django.conf import settings
from django.db.models.deletion import CASCADE
from django.utils.text import slugify
from django.urls import reverse
# heroku adjustment
from cloudinary.models import CloudinaryField

class Image(models.Model):
    user = models.ForeignKey(settings.AUTH_USER_MODEL,
                             related_name='images_created',
                             on_delete=CASCADE)
    title = models.CharField(max_length=200)
    slug = models.SlugField(max_length=200)
    url = models.URLField()
    # heroku adjustment
    # image = models.ImageField(upload_to='images/%Y/%m/%d')
    cloudinary_public_id = CloudinaryField('image')
    cloudinary_secure_url = models.URLField()
    
    description = models.TextField(blank=True)
    created = models.DateField(auto_now_add=True,
                               db_index=True)
    users_like = models.ManyToManyField(settings.AUTH_USER_MODEL,
                                        related_name='images_liked',
                                        blank=True)
    total_likes = models.PositiveIntegerField(db_index=True, default=0)

    class Meta:
        ordering = ['-pk']
        
    def __str__(self):
        return self.title

    def save(self, *args, **kwargs):
        if not self.slug:
            self.slug = slugify(self.title)
        super().save(*args, **kwargs)

    def get_absolute_url(self):
        return reverse('images:detail', args=[self.id, self.slug])

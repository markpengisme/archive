from django.contrib.auth import get_user_model
from django.db import models
from django.conf import settings
from django.contrib.auth.models import User

# heroku adjustment
from cloudinary.models import CloudinaryField

# User required
User._meta.get_field('email').blank = False
User._meta.get_field('first_name').blank = False


class Profile(models.Model):
    def user_directory_path(instance, filename):
        # file will be uploaded to MEDIA_ROOT/user_<id>/<filename>
        return 'user_{0}/{1}'.format(instance.user.id, filename)

    user = models.OneToOneField(settings.AUTH_USER_MODEL,
                                on_delete=models.CASCADE)
    date_of_birth = models.DateField(blank=True, null=True)
    # heroku adjustment
    # photo = models.ImageField(upload_to=user_directory_path, blank=True)
    photo = CloudinaryField('image', blank=True)

    def __str__(self):
        return f'Profile for user {self.user.username}'


class Contact(models.Model):
    user_from = models.ForeignKey('auth.User',
                                  related_name='rel_from_set',
                                  on_delete=models.CASCADE)
    user_to = models.ForeignKey('auth.User',
                                related_name='rel_to_set',
                                on_delete=models.CASCADE)
    created = models.DateTimeField(auto_now_add=True,
                                   db_index=True)

    class Meta:
        ordering = ('-created',)

    def __str__(self):
        return f'{self.user_from} follows {self.user_to}'


# Add following field to User dynamically
user_model = get_user_model()
user_model._meta.get_field('email')._unique = True
user_model.add_to_class('following',
                        models.ManyToManyField('self',
                                               through=Contact,
                                               related_name='followers',
                                               symmetrical=False))

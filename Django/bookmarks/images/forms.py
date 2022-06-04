from django import forms
from urllib import request
from django.core.files.base import ContentFile
from django.utils.text import slugify
from .models import Image
# heroku adjustment
import cloudinary.uploader

class ImageCreateForm(forms.ModelForm):

    class Meta:
        model = Image
        fields = ('title', 'url', 'description')
        widgets = {
            'url': forms.HiddenInput,
        }

    def clean_url(self):
        url = self.cleaned_data['url']
        valid_extensions = ['jpg', 'jpeg', 'png']
        extension = url.rsplit('.', 1)[1].lower()
        if extension not in valid_extensions:
            raise forms.ValidationError(
                'The given URL does not match valid image extensions.')
        return url

    def save(self, force_insert=False, force_update=False, commit=True):
        image = super().save(commit=False)
        image_url = self.cleaned_data['url']
        name = slugify(image.title)
        extension = image_url.rsplit('.', 1)[1].lower()
        # heroku adjustment
        # image_name = f'{name}.{extension}'
        # response = request.urlopen(image_url)
        # image.image.save(image_name,
        #                  ContentFile(response.read()),
        #                  save=False)
        assest = cloudinary.uploader.upload(image_url)
        image.cloudinary_public_id = f"{assest['public_id']}"
        image.cloudinary_secure_url = f"{assest['secure_url']}"


        if commit:
            image.save()
        return image

from django import template
register = template.Library()


@register.filter
def model_name(obj):
    try:
        return obj._meta.model_name
    except AttributeError:
        return None


@register.filter
def has_group(user, group_name):
    return user.groups.filter(name=group_name).exists()

from celery import shared_task
from celery.utils.log import get_task_logger, logger
from django.core.mail import send_mail
from django.conf import settings
from .models import Order

logger = get_task_logger('__name__')

@shared_task
def order_created(order_id):
    """
    Task to send an e-mail notification when an order is
    successfully created.
    """
    try:
        order = Order.objects.get(id=order_id)
        subject = f'Order nr. {order.id}'
        message = f'Dear {order.first_name},\n\n' \
                f'You have successfully placed an order.' \
                f'Your order ID is {order.id}.'
        send_mail(subject,
                  message,
                  settings.EMAIL_HOST_USER + '@gmail.com',
                  [order.email])
    except Exception as e:
        logger.error(f"order_created task send_mail failed: order_id={order_id}")
        raise e


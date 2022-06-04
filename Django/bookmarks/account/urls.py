from django.urls import path
from django.contrib.auth import views as auth_views
from . import views

# app_name = 'account'
urlpatterns = [
    path('', views.dashboard, name='dashboard'),
    path('register/', views.register, name='register'),
    # login/logout urls
    path('login/',
         auth_views.LoginView.as_view(
             template_name='account/login.html'
         ), name='login'),
    path('logout/',
         auth_views.LogoutView.as_view(
             template_name='account/logged_out.html'
         ), name='logout'),
    # change password urls
    path('password_change/',
         auth_views.PasswordChangeView.as_view(
             template_name='account/password_change_form.html'
         ), name='password_change'),
    path('password_change/done/',
         auth_views.PasswordChangeDoneView.as_view(
             template_name='account/password_change_done.html'
         ), name='password_change_done'),
    # reset password urls
    path('password_reset/',
         auth_views.PasswordResetView.as_view(
             template_name='account/password_reset_form.html'
         ), name='password_reset'),
    path('password_reset/done/',
         auth_views.PasswordResetDoneView.as_view(
             template_name='account/password_reset_done.html'
         ), name='password_reset_done'),
    path('reset/<uidb64>/<token>/',
         auth_views.PasswordResetConfirmView.as_view(
             template_name='account/password_reset_confirm.html'
         ), name='password_reset_confirm'),
    path('reset/done/',
         auth_views.PasswordResetCompleteView.as_view(
             template_name='account/password_reset_complete.html'
         ), name='password_reset_complete'),
    path('edit/', views.edit, name='edit'),
    path('users/', views.user_list, name='user_list'),
    path('users/follow/', views.user_follow, name='user_follow'),
    path('users/<username>/', views.user_detail, name='user_detail'),
]

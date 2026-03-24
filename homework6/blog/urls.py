from django.urls import path
from blog.views import homepage

app_name = 'blog'
urlpatterns = [
    path("", homepage.as_view(), name="home"),
]
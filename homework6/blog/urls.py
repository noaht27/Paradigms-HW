# Noah Thompson
# 24 March 2026

from django.urls import path
from blog.views import index, PostView

app_name = 'blog'
urlpatterns = [
    # this is default binding when entering blog, thats why its ""
    path("", index, name="index"),
    # this unique thing gets individual id of item
    path("<int:pk>/", PostView.as_view(), name='view')
]
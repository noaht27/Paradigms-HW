from django.urls import path
from blog.views import homepage
from blog.views import index, PostView

app_name = 'blog'
urlpatterns = [
    path("", index, name="index"),
    path("<int:pk>/", PostView.as_view(), name='view')
]
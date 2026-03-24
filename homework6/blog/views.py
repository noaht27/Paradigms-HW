# Noah Thompson
# 24 March 2026

from django.http import HttpResponse
from django.shortcuts import render
from blog.models import Post
from django.core.paginator import Paginator
from django.views.generic import DetailView

def index(request):
    # i just decided to order posts by publication since professor did so
    all_posts = Post.objects.order_by('-pub_date')
    
    # this only gets 5 posts per page, have to see django documentation for this
    #https://docs.djangoproject.com/en/6.0/ref/paginator/
    paginator = Paginator(all_posts, 5)

    page_number = request.GET.get('page')

    page = paginator.get_page(page_number)

    context = {
        "posts": page,
    }

    return render(request, "index.html", context)

# detail view is built into Django to display the detailed info of a single database record
class PostView(DetailView):
    model = Post
    template_name = "view_post.html"

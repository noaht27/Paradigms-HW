from django.db import models

# Create your models here.
# post model, as specified by project requirements
class Post(models.Model):
    title = models.CharField(max_length=200)
    author_name = models.CharField(max_length=200)
    pub_date = models.DateTimeField('date published')
    content = models.TextField() # there is no max length
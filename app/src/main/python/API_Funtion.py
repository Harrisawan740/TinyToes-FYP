#!/usr/bin/env python
# coding: utf-8

# In[ ]:


def API_Call(url,file_path):
    with open(file_path, 'rb') as f:
        files = {'image': f}
        response = requests.post(url, files=files)
    return response.content


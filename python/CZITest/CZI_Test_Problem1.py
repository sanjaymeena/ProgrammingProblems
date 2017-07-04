
# coding: utf-8

# ``
# Task 1: Identifying common words between documents
# For this task, you need to generate a matrix, where each entry contains the number of unique
# common tokens (words) between each pair of documents. The output should include no headers for
# rows or columns. The matrix should be symmetric, and follow the numbering conventions of the files.
# The diagonal entries would be the count of unique terms in each document.
# For example, the first number on the first line is the number of unique terms in 001.txt, the second
# number on the second line is the number of unique terms in 002.txt, etc.
# Similarly, the first element on the second line would be the number of unique terms that appear in
# both 001.txt and 002.txt, the 23rd number on the 16th line is the number of unique common terms
# between 023.txt and 016.txt, etc.
# ``

# In[52]:

import collections
import re
import sys
import glob
import os
import numpy as np
np.set_printoptions(linewidth=120)


# In[53]:

def tokenize(string):
    
    return re.findall(r'\w+',string.lower())



# In[54]:

data_folder='./data/'

content_dict = {}

total_content=[]
for content in os.listdir(data_folder): # "." means current directory
    filepath=data_folder+ content
    lines=[]
    with open(filepath) as f:
        lines=f.readlines()
    f.close()    
    #print lines
    #print content
    #print len(lines)
    tokenized=[]
    for line in lines :
        words=tokenize(line)
        string=' '.join(w for w in words)
        tokenized.append(string)
    tokenset=set(tokenized)
    string=' '.join(token for token in tokenset)
    f=int(content.replace('.txt', ''))
    #print f
    content_dict[f]=string


# In[55]:

# w1=content_dict[20].split()
# w2=content_dict[21].split()
# intersection = set(w1) & set(w2)
# print len(intersection)


# In[56]:

rows, columns = 100, 100
matrix = [[0 for x in range(rows)] for y in range(columns)] 

for i in range(0,rows):
    for j in range(0,columns):
        w1=content_dict[i+1].split()
        w2=content_dict[j+1].split()
        intersection = set(w1) & set(w2)
        matrix[i][j]=len(intersection)
    


# In[58]:

np.set_printoptions(linewidth=120)
print(np.matrix(matrix))

# test case
# vals=set(content_dict[1].split())
# print len(vals)
# print matrix[0][0]


# In[ ]:





# coding: utf-8

# ``
# Task 2: Identifying words by frequency
# A bigram is sequence of two consecutive tokens. The previous sentence, for example, contains the
# bigrams: (a bigram), (bigram is), (is sequence), (sequence of), (of two), (two consecutive), and
# (consecutive tokens).
# Across the entire corpus find (1) the top 50 most frequent unigrams (single tokens), and (2) the top
# 50 most frequent bigrams.
# The output should be a list of 100 lines, where the first 50 lines contain a single term each, in order
# of frequency, followed by 50 lines containing two terms each, in order of the bigram frequency.
# ``

# In[49]:

import collections
import re
import sys
import glob
import os


# In[89]:


def tokenize(string):
    
    return re.findall(r'\w+',string.lower())

def count_ngrams(lines,min_length=1,max_length=2):
    
    
    # list of consecutive elements from min_length to max_length
    lengths=range(min_length,max_length+1)
    
    # dictionary of length as key and Counter as value
    # [2: Counter(), 3:Counter(), 4:Counter]
    ngrams={length: collections.Counter() for length in lengths}
    
    # create queue of max length maxlen
    queue=collections.deque(maxlen=max_length)
        
    def add_queue():
        current=tuple(queue)
        for length in lengths:
            if len(current)>= length:
                ngrams[length][current[:length]] += 1
                
    # iterate over all the lines    
    for line in lines:
        for word in tokenize(line):
            queue.append(word)
            if len(queue)>= max_length:
                # after every element over maxlength, queue pops the word from the front
                add_queue()
                
    
    while len(queue)> min_length:
        queue.popleft()
        add_queue()
     
    return ngrams

def print_common_ngrams(ngrams,num=50):
    
    for n in sorted(ngrams):
        for gram,count in ngrams[n].most_common(num):
            string= "{0} {1} ".format(' '.join(gram), count)
            print string
    


# In[90]:

data_folder='./data/'

#content_dict = {}

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
    for line in lines :
        total_content.append(line)

#len(total_content)


# In[91]:


min_length=1
max_length=2

print 'total lines in the data are :  ' , len(total_content)

ngrams=count_ngrams(lines,min_length,max_length)


# In[92]:

print print_common_ngrams(ngrams,50)


# In[ ]:




# In[ ]:




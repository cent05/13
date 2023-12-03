# -*- coding: utf-8 -*-
"""
Created on Mon Dec 21 12:44:36 2020

@author: dell
"""

import pandas as pd  
import matplotlib.pyplot as plt  
  
data = pd.read_csv("iris.csv")  
    
print (data.head(20))
  
data.plot(kind ="scatter",  x ='sepal_length', y ='petal_length') 
plt.grid() 
plt.show()
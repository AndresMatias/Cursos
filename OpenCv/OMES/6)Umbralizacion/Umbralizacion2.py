#!/usr/bin/env python
# coding: utf-8

# In[9]:


#https://www.youtube.com/watch?v=pPcuzYqPMhE&ab_channel=OMES
import cv2
import numpy as np
image = cv2.imread('img3.jpg', 0)
_, binarizada = cv2.threshold(image, 210, 255, cv2.THRESH_BINARY)
_, binarizadaInv = cv2.threshold(image, 210, 255, cv2.THRESH_BINARY_INV)
cv2.imshow('Tipos: Binary - Binary Inv',np.hstack([binarizada,binarizadaInv]))
cv2.waitKey(0)
cv2.destroyAllWindows()


# In[ ]:





#!/usr/bin/env python
# coding: utf-8

# In[5]:


#https://www.youtube.com/watch?v=iI35ZTe5b3g&ab_channel=OMES
import cv2
image = cv2.imread('ave.jpg')
#Recortar una imagen
imageOut = image[60:220,280:480]
cv2.imshow('Imagen de entrada',image)
cv2.imshow('Imagen de salida',imageOut)
cv2.waitKey(0)
cv2.destroyAllWindows()


# In[ ]:





# In[ ]:





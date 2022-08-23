#!/usr/bin/env python
# coding: utf-8

# In[3]:


#https://www.youtube.com/watch?v=iI35ZTe5b3g&ab_channel=OMES

import cv2
import numpy as np
image = cv2.imread('ave.jpg')
ancho = image.shape[1] #columnas
alto = image.shape[0] # filas
# Rotación
M = cv2.getRotationMatrix2D((ancho//2,alto//2),15,1) #getRotationMatrix2D(centro,angulo,escala)
imageOut = cv2.warpAffine(image,M,(ancho,alto))
cv2.imshow('Imagen de entrada',image)
cv2.imshow('Imagen de salida',imageOut)
cv2.waitKey(0)
cv2.destroyAllWindows()


# In[ ]:





# In[ ]:





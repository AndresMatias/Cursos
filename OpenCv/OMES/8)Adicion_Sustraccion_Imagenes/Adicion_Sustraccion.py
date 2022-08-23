#!/usr/bin/env python
# coding: utf-8

# In[14]:


#https://www.youtube.com/watch?v=qZeOwG-DzwA&ab_channel=OMES
import cv2
img1 = cv2.imread('cadena.jpg')
img2 = cv2.imread('sacapuntas.jpg')

#--Sumo ambas imagenes con add--
resA = cv2.add(img1,img2) 
cv2.imshow('resA',resA)

#--Sumo ambas imagenes con addWeighted--
resAW = cv2.addWeighted(img1,0.5,img2,0.9,0) #(imagen1,transparencia,imagen2,transparencia,CREO q suma un valor adicional)
cv2.imshow('resAW',resAW)

#--Resta de imagenes con subtract--
#Si la resta da negativa subtract reemplaza pro el valor 0
resultado = cv2.subtract(img1,img2)
cv2.imshow('resultado',resultado)

#--Resta de imagenes con absdiff--
#Si la resta da negativa absdiff reemplaza por el valor absoluto del resultado es decir el mismo numero en positivo
resultado2 = cv2.absdiff(img1,img2)
cv2.imshow('resultado2',resultado2)

cv2.waitKey(0)
cv2.destroyAllWindows()


# In[ ]:





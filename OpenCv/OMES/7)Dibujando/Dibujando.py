#!/usr/bin/env python
# coding: utf-8

# In[8]:


#https://www.youtube.com/watch?v=q_C0F4DA1R8&ab_channel=OMES
import cv2
import numpy as np
imagen = 255*np.ones((400,600,3),dtype=np.uint8) #Creo imagen para lineas
imagen2 = 255*np.ones((400,600,3),dtype=np.uint8) #Creo imagen para rectangulos
imagen3 = 255*np.ones((400,600,3),dtype=np.uint8) #Creo imagen para circulos
imagen4 = 255*np.ones((400,600,3),dtype=np.uint8) #Creo imagen para texto
imagen5 = 255*np.ones((400,600,3),dtype=np.uint8) #Creo imagen para texto
#Dibujando lineas
cv2.line(imagen,(0,0),(600,400),(255,0,0),4) #linea azul
cv2.line(imagen,(300,0),(300,200),(255,100,255),10) #linea magenta

#Dibujando un rectangulo
cv2.rectangle(imagen2,(50,80),(200,200),(0,255,0),1) 
cv2.rectangle(imagen2,(300,80),(450,230),(0,0,0),-1)

#Dibujando un círculos
cv2.circle(imagen3,(300,200),100,(255,255,0),-1)#(punto, radio, color, -1 se llena el circulo)
cv2.circle(imagen3,(300,20),10,(255,0,255),3)

#Dibujando Texto
font = cv2.FONT_HERSHEY_SIMPLEX #fuente
cv2.putText(imagen4,'Practicando con OpenCV',(10,30),font,1,(0,255,255),2,cv2.LINE_AA)

cv2.putText(imagen5,'Practicando con OpenCV',(10,30),0,1,(255,0,0),2) #despues del punto de coordenadas puedo poner del 0 a 7 para elejir la fuetne en vez de usar cv2.FONT_HERSHEY_SIMPLEX o el que sea
cv2.putText(imagen5,'Practicando con OpenCV',(10,60),1,1,(255,0,0),2)
cv2.putText(imagen5,'Practicando con OpenCV',(10,90),2,1,(255,0,0),2)
cv2.putText(imagen5,'Practicando con OpenCV',(10,120),3,1,(255,0,0),2)
cv2.putText(imagen5,'Practicando con OpenCV',(10,150),4,1,(255,0,0),2)
cv2.putText(imagen5,'Practicando con OpenCV',(10,180),5,1,(255,0,0),2)
cv2.putText(imagen5,'Practicando con OpenCV',(10,210),6,1,(255,0,0),2)
cv2.putText(imagen5,'Practicando con OpenCV',(10,240),7,1,(255,0,0),2)

cv2.imshow('imagen',imagen)
cv2.imshow('imagen2',imagen2)
cv2.imshow('imagen3',imagen3)
cv2.imshow('imagen4',imagen4)
cv2.imshow('imagen5',imagen5)
cv2.waitKey(0)
cv2.destroyAllWindows()


# In[ ]:





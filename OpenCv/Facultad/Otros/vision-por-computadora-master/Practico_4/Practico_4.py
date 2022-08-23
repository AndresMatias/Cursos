#Schwab Urbani, Danel. Visión por computadora: TP4
#! /usr/bin/env python
# -*- coding: utf-8 -*-
#Escribir un programa que permita seleccionar una porcion rectangular de una imagen. Luego presionando
# 'g' guardo imagen recortada, con 'r' restauro a la imagen original, con 'q' sale
import cv2
import numpy as np


drawing = False # true if mouse is pressed
ix, iy = -1, -1 #coord de inicio
fx, fx = -1, -1 #coord de fin

def coordenadas():
	global ix, iy, fx, fy # Si coordenada de fin es menor a la inicial, invierto las coordenadas para evitar error

	if(iy>fy):
	    aux_y = iy
	    iy = fy
	    fy = aux_y
	    
	if(ix>fx):
	    aux_x = ix
	    ix = fx
	    fx = aux_x



def recortar_rectangulo(event, x, y, flags, param):
    global ix, iy, fx, fy, drawing
    
    if event == cv2.EVENT_LBUTTONDOWN: #Presiono boton izquierdo del mousse -> Guardo coordenadas de inicio.
        drawing = True
        ix, iy = x, y
         
    elif event == cv2.EVENT_MOUSEMOVE:
	    if(drawing is True):
		    img_dibujada[:] = img_auxiliar[:] #Para que no se vean superposicion de rectangulos
		    fx, fy = x, y   
		    cv2.rectangle(img_dibujada, (ix, iy), (fx, fy), (0, 0, 255) , 1)
		                
    elif event == cv2.EVENT_LBUTTONUP: #Suelto boton izquierdo del mousse -> Guardo coordenadas de fin.
        fx, fy = x, y
        drawing = False
        cv2.rectangle(img, (ix, iy), (fx, fy), (0, 0, 255) , 1) #Una vez que suelto el boton izquierdo, dibujo el rectangulo.

img = cv2.imread('homero.jpg', 1) 
img_auxiliar = img.copy() #Genero una imagen auxiliar
img_dibujada = img.copy() 


cv2.namedWindow('image')
cv2.setMouseCallback('image', recortar_rectangulo)

while(1):
	
	if(drawing is True): 
	    cv2.imshow('image', img_dibujada)
	        
	else:
	    cv2.imshow('image', img)
		
	k = cv2.waitKey(1) & 0xFF
	if k == ord('g'): #Presiono 'g' para guardar
	    cv2.destroyWindow('image')
	    coordenadas() #Nueva función, corrige error en rectángulos dibujados al revés
	    img_nueva = img[(iy+1):fy, (ix+1):fx] #Sumo un pixel para que no se vea el rectangulo de recorte
	    cv2.imwrite('homero_rectanculo.png', img_nueva)
	    cv2.imshow('Antes', img_auxiliar)
	    cv2.imshow('Despues', img_nueva) 
	    cv2.waitKey(0) #Muestra imagen antes y despues, presiono una tecla para salir
	    break
	elif k == ord('r'): #Presiono 'r' cargar la imagen original
	    img = img_auxiliar.copy()
	elif k == ord('q'): #Presiono 'q' para salir
	    break
cv2.destroyAllWindows()

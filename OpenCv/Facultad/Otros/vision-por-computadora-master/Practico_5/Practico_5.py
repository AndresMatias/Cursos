#Schwab Urbani, Danel. Visión por computadora: TP5
#! /usr/bin/env python
# -*- coding: utf-8 -*-
#Escribir un programa que permita seleccionar una porcion rectangular de una imagen. Luego presionando
# 'g' guardo imagen recortada, con 'r' restauro a la imagen original, con 'q' sale
# Con 'e' Realizo una transformación euclidiana a la imagen recortada
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
	    
def transformacion_euclidiana(imagen,filas, columnas, traslacion_x, traslacion_y, angulo_rotacion):
   
    rad = angulo_rotacion * np.pi/180 
    
    M = np.float32([[np.cos(rad), np.sin(rad), traslacion_x],
                    [-np.sin(rad), np.cos(rad), traslacion_y]])
                 
    tran_euc = cv2.warpAffine(imagen, M, (columnas, filas))
    return tran_euc
    
def mensaje_bienvenida():
	print("Bienvenido!")
	print("Recorte la imagen con el mouse y luego:")
	print("Presione 'g' para guardar el recorte rectangular.")
	print("Presione 'e' realizar una transformación euclidiana al recorte rectangular.")
	print("Presione 'r' volver a la imagen original.")
	print("Presione 'q' para salir del programa.")
	print(" ")
	

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

img = cv2.imread('manu.jpg', 1) 
img_auxiliar = img.copy() #Genero una imagen auxiliar
img_dibujada = img.copy() 

mensaje_bienvenida()
cv2.namedWindow('image')
cv2.setMouseCallback('image', recortar_rectangulo)


while True:
	
	if(drawing is True): 
	    cv2.imshow('image', img_dibujada)
	        
	else:
	    cv2.imshow('image', img)
		
	k = cv2.waitKey(1) & 0xFF
	if k == ord('g'): #Presiono 'g' para guardar
	    coordenadas() #Nueva función, corrige error en rectángulos dibujados al revés
	    img_nueva = img[(iy+1):fy, (ix+1):fx] #Sumo un pixel para que no se vea el rectangulo de recorte
	    cv2.imwrite('manu_recortado.png', img_nueva)
	    cv2.imshow('Antes', img_auxiliar)
	    cv2.imshow('Despues', img_nueva)
	    cv2.waitKey(0)
	    break
	elif k == ord('e'): #Presiono e para hacer transformación euclidiana
		cv2.destroyWindow("image")
		img_nueva = img[(iy+1):fy, (ix+1):fx]
		filas, columnas = (img_nueva.shape[0], img_nueva.shape[1]) #Averiguo el numero de filas y columnas de la imagen recortada
		angulo = int(input('Ingrese ángulo de rotación (sexagecimal): '))
		t_x = int(input('Ingrese traslación en el eje "x": '))
		t_y = int(input('Ingrese la traslacion en el eje "y": '))
		img_euclidiana = transformacion_euclidiana(img_nueva, filas, columnas, t_x, t_y, angulo) #Asigno imagen al retorno de la función creada
		cv2.imwrite('manu_euclidiano.png', img_euclidiana) 
		cv2.imshow('Antes', img_auxiliar) #Muestra imagen original
		cv2.imshow('Despues', img_euclidiana) #Muestra imagen con transformacion euclidiana
		cv2.waitKey(0) #Presiono una tecla para salir
		break
	elif k == ord('r'): #Presiono 'r' cargar la imagen original
	    img = img_auxiliar.copy()
	elif k == ord('q'): #Presiono 'q' para salir
	    break
cv2.destroyAllWindows()

#Schwab Urbani, Danel. Visión por computadora: TP9
#! /usr/bin/env python
# -*- coding: utf-8 -*-

#En base a las medidas de una puerta, hacer un programa que permita medir el largo de cosas en el plano de la fachada.

## Desde el pixel 742,404 a  742,72 hay 203cm es decir 1.6354 px por cm (Largo de una hoja de la puerta)
## 742,72 a 849,72 hay 65 cm es decir 1.646 pixel por cm (Ancho de una hoja de la puerta)
## Aproximadamente hay 1.64 px por cm. Entonces cada pixel en esta imagen mide 0,61 cm

##LA casilla del gas a lo ancho mide 38 cm y midiendolo con el programa mide 40 aprox.
## El ancho de los numeros de la dirección mide 18 cm y con el programa entre 19 y 20.

import cv2
import numpy as np
from math import sqrt



puntos = [[165,85],[862,1],[862,449],[165,370]] #Puntos seleccionados para la tansformada perspectiva 
puntos_aux = [[-1,-1],[-1,-1]]
i=0
drawing = False

def transformada_perspectiva(img):
    p_2 = np.float32([[0, 0], [img.shape[1], 0],  [img.shape[1],img.shape[0]],[0, img.shape[0]]]) #Arriba izquierda, derecha arriba, derecha abajo, izquierda abajo
    p_1 = np.float32([[puntos[0]], [puntos[1]], [puntos[2]], [puntos[3]]])
    warp_mat = cv2.getPerspectiveTransform(p_1, p_2)
    perspective = cv2.warpPerspective(img, warp_mat, (img.shape[1], img.shape[0]))
    return perspective

def mensaje_bienvenida():
    print("Bienvenido!")
    print("Haga click para medir en la figura:")
    print("Presione 'h' para mostrar la imagen original.")
    print("Presione 'r' para restaurar imagen.")
    print("Presione 'q' para salir del programa.")
    print("Presione 'g' para guardar la imagen con medidas.")
    print(" ")
	

def sel_puntos(event, x, y, flags, param):
	global i,puntos_aux, drawing
	if event == cv2.EVENT_LBUTTONDOWN:
		drawing = True
		puntos_aux[i] = x,y
		print("Punto: ",i)
		print ("Coordenada X :",x)
		print ("Coordenada Y :",y)
		i = i+1
		
		if i == 2:
			i=0
			drawing = False
			#medida = medicion(puntos_aux[0][0],puntos_aux[0][1],puntos_aux[1][0],puntos_aux[1][1])
			cv2.line(img_dibujada, (puntos_aux[0][0],puntos_aux[0][1]), (puntos_aux[1][0],puntos_aux[1][1]), (0,195,255))
			#cv2.putText( img_dibujada , medida, (puntos_aux[0][0] + 20,puntos_aux[0][1]+20), cv2.FONT_HERSHEY_SIMPLEX, 0.6, (0,195,255), 2 , cv2.LINE_AA)
			img_perspectiva[:] = img_dibujada[:]

	elif event == cv2.EVENT_MOUSEMOVE:
		if(drawing is True):
			img_dibujada[:] = img_perspectiva[:] #Para que se actualice la recta con la medida en metros  	
			medida = medicion(puntos_aux[0][0],puntos_aux[0][1],x,y)
			cv2.line(img_dibujada, (puntos_aux[0][0],puntos_aux[0][1]), (x,y), (0,195,255))
			cv2.putText( img_dibujada , medida, (x+20, y+20), cv2.FONT_HERSHEY_SIMPLEX, 0.6, (0,195,255), 2 , cv2.LINE_AA)
			
def medicion(x1,y1,x2,y2):
	
	x = x2-x1 #medida en pixeles en x e y
	y = y2-y1
	
	x_cm = x*0.61/100 #Paso de px a metro
	y_cm = y*0.61/100
	
	x_mt = x_cm**2
	y_mt = y_cm**2
	
	resultado = sqrt(x_mt + y_mt)
	resultado = round(resultado, 2)
	
	return str(resultado) + " mt"

img = cv2.imread('fachada.jpg')
img_perspectiva=transformada_perspectiva(img)
img_perspectiva_aux = img_perspectiva.copy()
img_dibujada = img_perspectiva.copy()
cv2.imwrite('Imagen perspectiva.png', img_perspectiva)
mensaje_bienvenida()
cv2.namedWindow('image')
cv2.setMouseCallback('image', sel_puntos)


while True:
	
  
	cv2.imshow('image',img_dibujada)
	k = cv2.waitKey(1) & 0xFF
    
	if k == ord('h'): #Presiono 'h' para transformada perspectiva
		cv2.destroyWindow('image')
		cv2.imshow('Sin perspectiva',img)
		cv2.waitKey(0)
		break
	elif k == ord('r'): #Presiono 'r' cargar la imagen original
		img_dibujada = img_perspectiva_aux.copy()
		img_perspectiva = img_perspectiva_aux.copy()
		i=0
	elif k == ord('g'): #Presiono 'g' para guardar
		cv2.imwrite('Imagen medida.png', img_dibujada)
		break
	elif k == ord('q'): #Presiono 'q' para salir
		break
cv2.destroyAllWindows()

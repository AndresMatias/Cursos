#Schwab Urbani, Danel. Visión por computadora: TP8
#! /usr/bin/env python
# -*- coding: utf-8 -*-
#Crear un método que compute la homografía entre los 4 pares de puntos correspondientes.
#con la letra “h” permita seleccionar con el mouse 4 puntos no colineales en una
# imagen y transforme (rectifique) la selección en una nueva imagen rectangular.
import cv2
import numpy as np


drawing = True #Comienzo con drawing = True y cuando i=2 pasa a false.
puntos = [[-1, -1], [-1, -1], [-1, -1], [-1 , -1]] 
i = 0

def transformada_perspectiva(img):
    p_2 = np.float32([[0, 0], [img.shape[1], 0],  [img.shape[1],img.shape[0]],[0, img.shape[0]]]) #Arriba izquierda, derecha arriba, derecha abajo, izquierda abajo
    p_1 = np.float32([[puntos[0]], [puntos[1]], [puntos[2]], [puntos[3]]])
    warp_mat = cv2.getPerspectiveTransform(p_1, p_2)
    perspective = cv2.warpPerspective(img, warp_mat, (img.shape[1], img.shape[0]))
    return perspective

def mensaje_bienvenida():
    print("Bienvenido!")
    print("Haga los click como los indica la figura y luego:")
    print("Presione 'h' transformada de perspectiva:")
    print("Presione 'r' para restaurar imagen.")
    print("Presione 'q' para salir del programa.")
    print(" ")
	

def sel_puntos(event, x, y, flags, param):
    global drawing,i,puntos
    if event == cv2.EVENT_LBUTTONDOWN:
        if i <= 4 :
            puntos[i]=x,y
            cv2.circle(img_dibujada, (x,y),6,(0,255,0),-1)
            i=i+1;
        else:
            drawing=False


img = cv2.imread('prueba.jpg') #background
img_dibujada = img.copy() #Genero una imagen auxiliar


mensaje_bienvenida()
cv2.namedWindow('image')
cv2.setMouseCallback('image', sel_puntos)


while True:
	

    cv2.imshow('image', img_dibujada)	
    k = cv2.waitKey(1) & 0xFF
    if k == ord('h'): #Presiono 'h' para transformada perspectiva
        cv2.destroyWindow('image')
        img_perspectiva=transformada_perspectiva(img)
        cv2.imwrite('Imagen perspectiva.png', img_perspectiva)
        cv2.imshow('Sin perspectiva',img)
        cv2.imshow('Con perspectiva',img_perspectiva)
        cv2.waitKey(0)
        break
    elif k == ord('r'): #Presiono 'r' cargar la imagen original
	    img_dibujada = img.copy()
	    i=0
    elif k == ord('q'): #Presiono 'q' para salir
	    break
cv2.destroyAllWindows()

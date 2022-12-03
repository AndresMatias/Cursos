#Schwab Urbani, Danel. Visión por computadora: TP7
#! /usr/bin/env python
# -*- coding: utf-8 -*-
#Crear un metodo que compute la transformación afin entre 3 pares de puntos correspondientes.
#Con la letra 'a' permita permita seleccionar con el mouse 3 puntos no colineales en una
# imagen e incruste entre estos puntos seleccionados una segunda imagen.
# Mezcla para la máscara => I=alpha*Foreground + (1 - alpha)*Background. 
#La imagen foreground no es la cargada originalmente sino que es un umbral de la misma
# La imagen alpha se obtubo umbralizando la imagen Foreground con el TP2 
import cv2
import numpy as np


drawing = True #Comienzo con drawing = True y cuando i=2 pasa a false.
puntos1 = [[-1, -1], [-1, -1], [-1, -1]] 
puntos2 = [[-1, -1], [-1, -1], [-1, -1]]
i = 0

def transformada_afin(img):
    p_1 = np.float32([[0, 0], [img.shape[1] - 1, 0], [0, img.shape[0] - 1]]) 
    p_2 = np.float32([[puntos2[0]], [puntos2[1]], [puntos2[2]]])
    warp_mat = cv2.getAffineTransform(p_1, p_2)
    afin = cv2.warpAffine(img, warp_mat, (img.shape[1], img.shape[0]))
    return afin

def mensaje_bienvenida():
	print("Bienvenido!")
	print("Seleccione 3 puntos y luego:")
	print("Presione 'a' incrustar imagen.")
	print("Presione 'r' para restaurar imagen.")
	print("Presione 'q' para salir del programa.")
	print(" ")
	

def sel_puntos(event, x, y, flags, param):
    global drawing,i,puntos2
    if event == cv2.EVENT_LBUTTONDOWN and drawing == True:
        if i <= 3 :
            puntos2[i]=x,y
            cv2.circle(img_dibujada, (x,y),3,(255,0,0),-1)
            i=i+1;
        else:
            drawing=False

def mascara(background,foreground,alpha):
    #filas, columnas = (background.shape[0], background.shape[1])
    #bg = cv2.resize(background,(filas,columnas))
    #alpha = cv2.resize(alpha, (filas,columnas))
    #fg = cv2.resize(foreground,(filas,columnas))
    #No utilizo las lineas anteriores ya que debo redimensionar las imagenes antes de realizar la transformada afin, sino no coinciden las
    # esquinas de las fotos seleccionadas con las de la mascara resultado.
    bg=background
    fg=foreground
    
    
    # Convert these images two floating point image.
    fg = fg.astype(float)
    bg = bg.astype(float)
    # Normalize the alpha mask to keep intensity between 0 and 1
    alpha = alpha.astype(float)/255.0

    # Multiply the foreground with the alpha matte
    foreground = cv2.multiply(alpha, fg)
 
    # Multiply the background with ( 1 - alpha )
    background = cv2.multiply(1.0 - alpha, bg)
 
    # Add the masked foreground and background.
    outImage = cv2.add(foreground, background)
    return outImage
    
def umbralizado(foreground_name):
    img = cv2.imread (foreground_name, 0)
    nf,nc=img.shape
    for i in range (nf):
        for j in range (nc):
            if img[i][j] < 200: # 200 es el umbral.
                img[i][j]=255
            else:
                img[i][j]=0
                
    alpha_name= 'logo_utn_umbralizado.png'           
    cv2.imwrite(alpha_name, img)
    return alpha_name

	
        

img = cv2.imread('background.jpg', 1) #background
img_dibujada = img.copy() #Genero una imagen auxiliar
foreground_name= 'logo_utn.png' #Cargo nombre de la imagen foreground
foreground = cv2.imread(foreground_name) 
alpha_name = umbralizado(foreground_name) #Le paso a la funcion el nombre de la foto y me retorna el nombre de la foto umbralizada
alpha = cv2.imread(alpha_name)



mensaje_bienvenida()
cv2.namedWindow('image')
cv2.setMouseCallback('image', sel_puntos)


while True:
	

    cv2.imshow('image', img_dibujada)	
    k = cv2.waitKey(1) & 0xFF
    if k == ord('a'): #Presiono 'a' para superponer fotos
        cv2.destroyWindow('image')
		#--------------------------------------------------------------------------------------------------------------
        filas, columnas = (img.shape[0], img.shape[1]) #Redimensiono las imagenes antes de realizar la transformada afin
        alpha = cv2.resize(alpha, (filas,columnas)) 
        foreground = cv2.resize(foreground, (filas,columnas))
        #--------------------------------------------------------------------------------------------------------------                        
        foreground_afin=transformada_afin(foreground) #realizo transformada afin a foreground y alpha
        alpha_afin=transformada_afin(alpha)
        #--------------------------------------------------------------------------------------------------------------
        img_final=mascara(img,foreground_afin,alpha_afin)
        cv2.imwrite('Imagen Final.png', img_final)
        cv2.imshow('Foreground',foreground_afin)
        cv2.imshow('Background',img)
        cv2.imshow('Imagen final', img_final/255) #Si no lo pongo se ve distinta a la que guarda
        cv2.waitKey(0)
        break
    elif k == ord('r'): #Presiono 'r' cargar la imagen original
	    img_dibujada = img.copy()
	    i=0
    elif k == ord('q'): #Presiono 'q' para salir
	    break
cv2.destroyAllWindows()

# UTN-FRC. Ing. Electrónica.
# Práctico 2: Segmentando una imagen
# Visión por computadora
# Francisco Gabriel Rainero. Legajo 71967.

import cv2                          #Importa módulo de OpenCV

img = cv2.imread('hojas.jpg', 0)    #Lectura de la imagen en escala de grises (0->Escala de grises).

cv2.imwrite('esc_grises.png', img)  #Guardo la imagen en escala de grises, previo a modificar

#Se utilizan dos for anidados para pasar a blanco y negro

N = len(img)                        #Numero de filas
R = len(img[0])                     #Numero de columnas

for i in range(0,N):
    for j in range(0,R):
        if img[i][j] < 220:         #Si es menor a 220 paso a negro (0)
            img[i][j] = 0
        else:
            img[i][j] = 255         #Si es mayor paso a blanco (255)
        

cv2.imwrite('resultado.png', img)   #Guarda la nueva imagen

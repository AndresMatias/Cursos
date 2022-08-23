# UTN-FRC. Ing. Electrónica.
# Práctico 8: Rectificando imágenes (Homografía)
# Visión por computadora
# Francisco Gabriel Rainero. Legajo 71967.

import cv2
import numpy as np

blue = (255, 0, 0); green = (0, 255, 0); red = (0, 0, 255); yellow = (0, 255, 255);    #Define colores

puntos = 4                                              #Variable que controla los puntos a tomar de image

def homografia(image, origen, destino):                 #Mod Homografia: recibe 4 pares de puntos.
    (al, an) = image.shape[:2]

    M = cv2.getPerspectiveTransform(origen, destino)    #Matriz homografia

    img_out = cv2.warpPerspective(image, M, (al,an))    #Transformacion homográfica: mapea 4 puntos en puntos
                                                        #Mapea rectas en rectas 
    return img_out

def dibuja_punto (event, x, y, flags, param):           #Función que grafica el rectángulo
    global x1, y1, x2, y2, x3, y3, x4, y4, puntos       #Variables globales para no perder el valor
    if event == cv2.EVENT_LBUTTONDOWN:                  #Click izquierdo abajo
        if puntos == 4:
            x1, y1 = x, y                               #Guardo el punto 1
            cv2.circle(image, (x,y),2,red,-1)           #Grafico un círculo rojo en punto 1
            puntos = 3
        elif puntos == 3:
            x2, y2 = x, y                               #Guardo el punto 2
            cv2.circle(image, (x,y),2,blue,-1)          #Grafico un círculo azul en punto 2 
            puntos = 2
        elif puntos == 2:
            x3, y3 = x, y                               #Guardo el punto 3
            cv2.circle(image, (x,y),2,green,-1)         #Grafico un círculo verde en punto 3
            puntos = 1
        elif puntos == 1:
            x4, y4 = x, y                               #Guardo el punto 3
            cv2.circle(image, (x,y),2,yellow,-1)        #Grafico un círculo amarillo en punto 4
            puntos = 0

image = cv2.imread('RedBus.jpg')                        #Imagen a rectificar
#(h, w) = image.shape[:2]                               #Tamaño imagen de fondo (con esta la salida queda cuadrada)
(h, w) = (300, 600)                                     #Tamaño tarjeta RedBus

while True: 
    cv2.imshow('Presione h para seleccionar 4 puntos y luego g', image) #Muestro imagen de fondo
    k = cv2.waitKey(1) & 0xFF
    if k == ord('q'):                                                   #Sale al presionar 'q'
        break

    if k == ord('h'):                                   #Selecciona cuatro puntos con 'h'
        cv2.namedWindow('Presione h para seleccionar 4 puntos y luego g')
        cv2.setMouseCallback('Presione h para seleccionar 4 puntos y luego g', dibuja_punto)   #Cuando hay un evento del mouse se llama a f
    
    if k == ord('g'):                                   #Guardo al presionar 'g'
        
        destino = np.float32([[0,0],[w-1,0],[0,h-1],[w-1,h-1]])    #4 vertices de la imagen 
        origen = np.float32([[x1,y1],[x2,y2],[x3,y3],[x4,y4]])     #Puntos seleccionados 
        
        img_out = homografia(image,origen,destino)      #Transformación homográfica de la imagen
        img_out = img_out[0:h, 0:w]

        cv2.imwrite('output.jpg',img_out)               #Guardo la imagen de salida
        break 

cv2.imshow('Imagen de salida', img_out) 
cv2.waitKey(0)

cv2.destroyAllWindows()                                 #Cierra las ventanas
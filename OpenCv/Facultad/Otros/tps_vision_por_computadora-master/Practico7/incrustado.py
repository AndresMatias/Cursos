# UTN-FRC. Ing. Electrónica.
# Práctico 7: Transformación afín. Incrustando imágenes
# Visión por computadora
# Francisco Gabriel Rainero. Legajo 71967.

import cv2
import numpy as np

blue = (255, 0, 0); green = (0, 255, 0); red = (0, 0, 255);     #Define colores

puntos = 3                                              #Variable para controlar 

def t_afin(image, origen, destino):                     #Mod T_Afin: recibe 3 pares de puntos.
    (al, an) = image.shape[:2]

    M = cv2.getAffineTransform(origen, destino)         #Matriz transf afin

    img_out = cv2.warpAffine(image, M, (al,an))         #Transformacion afin: mapea 3 puntos en puntos
                                                        #Mantiene paralelismo y mapea rectas en rectas
    return img_out

def dibuja_punto (event, x, y, flags, param):           #Función que grafica el rectángulo
    global x1, y1, x2, y2, x3, y3, puntos               #Variables globales para no perder el valor
    if event == cv2.EVENT_LBUTTONDOWN:                  #Click izquierdo abajo
        if puntos == 3:
            x1, y1 = x, y                               #Guardo el punto 1
            cv2.circle(image, (x,y),2,red,-1)           #Grafico un círculo rojo en punto1
            puntos = 2
        elif puntos == 2:
            x2, y2 = x, y                               #Guardo el punto 2
            cv2.circle(image, (x,y),2,blue,-1)          #Grafico un círculo azul en punto2
            puntos = 1
        elif puntos == 1:
            x3, y3 = x, y                               #Guardo el punto 3
            cv2.circle(image, (x,y),2,green,-1)         #Grafico un círculo verdeq en punto 3
            puntos = 0

image = cv2.imread('Paris.jpg')                         #Imagen de fondo
(h, w) = image.shape[:2]                                #Tamaño imagen de fondo

huella = cv2.imread('Ovni.jpg')                         #Imagen de incruste
(H, W) = huella.shape[:2]


img_out = np.zeros((h,w), np.uint8)                     #Imagen de salida

while True: 
    cv2.imshow('Presione a para seleccionar 3 puntos y luego g', image) #Muestro imagen de fondo
    k = cv2.waitKey(1) & 0xFF

    if k == ord('q'):                                   #Sale al presionar 'q'
        break

    if k == ord('a'):                                   #Selecciona tres puntos con 'a'

        cv2.namedWindow('Presione a para seleccionar 3 puntos y luego g')
        cv2.setMouseCallback('Presione a para seleccionar 3 puntos y luego g', dibuja_punto)     #Cuando hay un evento del mouse se llama a f
    
    if k == ord('g'):                                   #Guardo al presionar 'g'
        origen = np.float32([[0,0],[W-1,0],[0,H-1]])    #3 vertices de la imagen a incrustar
        destino = np.float32([[x1,y1],[x2,y2],[x3,y3]]) #Puntos seleccionados en el fondo
        huella = t_afin(huella,origen,destino)          #Transformación afin del incruste

        mascara = np.array([[x1,y1],[x3,y3],[x3+x2-x1,y3+y2-y1],[x2,y2]],np.int32)  #Mascara para sumar imagenes
        cv2.fillPoly(image, [mascara], (0,0,0), cv2.LINE_AA)                        #Aplico máscara al fondo

        huella = huella[0:h, 0:w]                       #Cambio de tamaño al de imagen de fondo. (Huella debe ser mayor)

        img_out = cv2.add(image,huella)                 #Combinación lineal del fondo con el incruste
        cv2.imwrite('output.jpg',img_out)               #Guardo la imagen de salida
        break 

cv2.imshow('Imagen de salida', img_out) 
cv2.waitKey(0)

cv2.destroyAllWindows()                                 #Cierra las ventanas
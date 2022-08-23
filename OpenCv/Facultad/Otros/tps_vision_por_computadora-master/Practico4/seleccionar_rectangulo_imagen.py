# UTN-FRC. Ing. Electrónica.
# Práctico 4: Manipulación de imágenes
# Visión por computadora
# Francisco Gabriel Rainero. Legajo 71967.

import cv2                                                      #Importa módulo de OpenCV
import numpy as np                                              #Importa módulo numpy

blue = (255, 0, 0); green = (0, 255, 0); red = (0, 0, 255);     #Define colores
drawing = False                                                 #Bandera dibujando rectángulo
ix = -1; iy = -1                                                #Punto x,y de inicio del rectángulo                           
fx = -1; fy = -1                                                #Punto x,y final del rectángulo

img = cv2.imread('hojas.jpg')                                   #Leo imagen y la respaldo con una auxiliar
img_aux = cv2.imread('hojas.jpg')
H = len(img)                                                    #Leo altura (height)
W = len(img[0])                                                 #Leo ancho (width)

def dibuja_cuadrado (event, x, y, flags, param):                #Función que grafica el rectángulo
    global ix, iy, fx, fy, drawing, img_aux                     #Variables globales para no perder el valor
    if event == cv2.EVENT_LBUTTONDOWN:                          #Click izquierdo abajo
        drawing = True                                          #Bandera de arranque
        ix, iy = x, y                                           #Guardo ubicación de arranque
    elif event == cv2.EVENT_MOUSEMOVE:                          #Evento de movimiento del mouse
        if drawing is True:
            img[:] = img_aux[:]                                 #Esto borra las líneas no deseadas
            cv2.rectangle(img, (ix, iy), (x,y), red, 0)         #Grafico rectángulo
    elif event == cv2.EVENT_LBUTTONUP:                          #Click derecho arriba
        drawing = False                                         #Bandera de finalización
        fx, fy = x, y                                           #Guardo ubicación de final

cv2.namedWindow('image')
cv2.setMouseCallback('image', dibuja_cuadrado)                  #Cuando hay un evento del mouse se llama
                                                                #a la función
while(1):                                      

    cv2.imshow('image', img)                                        
    k = cv2.waitKey(1) & 0xFF
    if k == ord('q'):                                           #Sale al presionar 'q'
        break
    if k == ord('r'):                                           #Con 'r' restauramos la imagen
        img = cv2.imread('hojas.jpg')           
    if k == ord('g'):                                           #Con 'g' guarda los cambios y sale
        img_out = np.zeros((abs(fy-iy)+1,abs(fx-ix)+1,3), np.uint8)   # Creo una imagen en negro
        for i in range(0,abs(fy-iy)+1):                                     # Recorrido del recorte
            for j in range(0,abs(fx-ix)+1):
                if (ix > fx and iy > fy):                            
                    img_out[i][j]=img[i+fy][j+fx]                     
                elif (ix > fx and iy < fy):                            
                    img_out[i][j]=img[i+iy][j+fx]                     
                elif (ix < fx and iy > fy):                              
                    img_out[i][j]=img[i+fy][j+ix]                     
                elif (ix < fx and iy < fy):                   
                    img_out[i][j]=img[i+iy][j+ix]
        cv2.imwrite('output.jpg',img_out)
        break

cv2.destroyAllWindows()                                         #Cierra las ventanas
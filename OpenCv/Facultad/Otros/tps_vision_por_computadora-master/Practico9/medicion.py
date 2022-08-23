# UTN-FRC. Ing. Electrónica.
# Práctico 9: Medición de objetos
# Visión por computadora
# Francisco Gabriel Rainero. Legajo 71967.

import cv2
import numpy as np
import math

blue = (255, 0, 0); green = (0, 255, 0); red = (0, 0, 255); yellow = (0, 255, 255);    #Define colores

drawing = False
ix, iy = 0, 0

def homografia(image, origen, destino):                 #Mod Homografia: recibe 4 pares de puntos.
    (al, an) = image.shape[:2]

    M = cv2.getPerspectiveTransform(origen, destino)    #Matriz homografia

    img_out = cv2.warpPerspective(image, M, (an,al))    #Transformacion homográfica: mapea 4 puntos en puntos
                                                        #Mapea rectas en rectas 
    return img_out

def medicion(event, x, y, flags, param):                #Medición e impresión de mediciones

    global ix, iy, drawing, img_rect, img_rec_copia, img_rect_medida
    
    if event == cv2 .EVENT_LBUTTONDOWN:                 #Pulsando botón izq empiezo a medir
        ix, iy = x, y
        drawing = True

    elif event == cv2.EVENT_MOUSEMOVE:                  #Grafica a medida que se mueve el mouse
        if drawing is True:
            img_rect[:] = img_rect_medida[:]                                    
            cv2.line(img_rect, (ix, iy), (x, y), yellow, 2)
            medida = (np.sqrt((ix-x)**2+(iy-y)**2))            #Cálculo de longitud en cm (Distancia entre dos puntos)
            medida = medida/2                                  #Debo dividir por dos porque dupliqué el tamaño de imagen                              
            x_y_text = int((ix+x)/2+10), int((iy+y)/2-10)      #Coordenadas del texto                                
            cv2.putText(img_rect, "{:.2f} cm" .format(medida), (x_y_text), cv2.FONT_HERSHEY_PLAIN, 1, blue, 1) #Imprime texto

    elif event == cv2.EVENT_LBUTTONUP:                  #Termina de graficar soltando botón izquierdo
        img_rect_medida[:] = img_rect[:]
        drawing = False

image = cv2.imread('fachada.jpg')                       #Imagen a rectificar
(h,w) = (438, 488)                                      #2*Tamaño de la puerta en cm(El doble para crear una imagen mas grande)
                                                        #Cada pixel equivaldrá 2cm
x1=168; y1=147;                                         #Vértice superior izquierdo del portón
x2=587; y2=102;                                         #Vértice superior derecho del portón
x3=181; y3=538;                                         #Vértice inferior izquierdo del portón
x4=580; y4=574;                                         #Vértice inferior derecho del portón

destino = np.float32([[x1,y1],[x1+w,y1],[x1,y1+h],[x1+w,y1+h]])    #4 vertices con offset para ver toda la imagen
origen = np.float32([[x1,y1],[x2,y2],[x3,y3],[x4,y4]])             #Puntos seleccionados 
        
img_rect = homografia(image,origen,destino)             #Transformación homográfica de la imagen y dos copias
img_rect_copia = img_rect.copy()
img_rect_medida = img_rect.copy()
cv2.imwrite('Imagen_rectificada.jpg',img_rect)          #Guardo la imagen rectificada
        
cv2.namedWindow('Rectificada. Realice sus mediciones')
cv2.setMouseCallback('Rectificada. Realice sus mediciones',medicion) #Cuando hay un evento del mouse llama a esta función

while True:
    cv2.imshow('Rectificada. Realice sus mediciones', img_rect)      #Muestro imagen rectificada 
    
    k = cv2.waitKey(1) & 0xFF

    if k == ord('q'):                                                #Sale al presionar 'q'
        break

    if k == ord('r'):                                                #Con r restauramos la medición
        img_rect = img_rect_copia.copy()                        
        img_rect_medida = img_rect.copy()
        
cv2.imwrite('Imagen_con_mediciones.jpg',img_rect)       #Guardo la imagen rectificada

cv2.destroyAllWindows()                                 #Cierra las ventanas
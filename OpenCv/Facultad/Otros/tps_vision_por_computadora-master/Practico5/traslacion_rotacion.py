# UTN-FRC. Ing. Electrónica.
# Práctico 5: Rotación + Traslación (Transformación Euclidiana)
# Visión por computadora
# Francisco Gabriel Rainero. Legajo 71967.

import cv2                                                  #Importa módulo de OpenCV
import numpy 

blue = (255, 0, 0); green = (0, 255, 0); red = (0, 0, 255); #Define colores
drawing = False                                             #Bandera dibujando rectangulo

ix = -1; iy = -1

image = cv2.imread('Paris.jpg')                             #Leo imagen
img_aux = cv2.imread('Paris.jpg')                           #Leo misma imagen para respaldo
(h,w) = image.shape[:2]                                     #Obtengo tamaño

def rotar_trasladar(image, angle,tx,ty):

    (h,w) = image.shape[:2]                                 #Obtiene alto y ancho de la imagen
    center = (w/2, h/2)                                     #Fija el centro de rotación en el centro de la img

    M_r = cv2.getRotationMatrix2D(center,angle,1)           #Matriz de rotación

    img_r = cv2.warpAffine(image, M_r, (w,h))               #Imagen rotada

    M_t = numpy.float32([[1,0,tx],[0,1,ty]])                #Matriz de traslación

    img_tr = cv2.warpAffine(img_r, M_t, (w,h))

    return img_tr

def dibuja_cuadrado (event, x, y, flags, param):                #Función que grafica el rectángulo
    global ix, iy, fx, fy, drawing, img_aux                     #Variables globales para no perder el valor
    if event == cv2.EVENT_LBUTTONDOWN:                          #Click izquierdo abajo
        drawing = True                                          #Bandera de arranque
        ix, iy = x, y                                           #Guardo ubicación de arranque
    elif event == cv2.EVENT_MOUSEMOVE:                          #Evento de movimiento del mouse
        if drawing is True:
            image[:] = img_aux[:]                               #Esto borra las líneas no deseadas
            cv2.rectangle(image, (ix, iy), (x,y), red, 0)       #Grafico rectángulo
    elif event == cv2.EVENT_LBUTTONUP:                          #Click derecho arriba
        drawing = False                                         #Bandera de finalización
        fx, fy = x, y                                           #Guardo ubicación de final

cv2.namedWindow('image')
cv2.setMouseCallback('image', dibuja_cuadrado)                  #Cuando hay un evento del mouse se llama a f

while True:                                      

    cv2.imshow('image', image)                                        
    k = cv2.waitKey(1) & 0xFF
    if k == ord('q'):                                                       #Sale al presionar 'q'
        break
    if k == ord('r'):                                                       #Con 'r' restauramos la imagen
        img = cv2.imread('Paris.jpg')           
    if k == ord('e'):                                                       #Con 'e' aplica transf y sale
        img_out = numpy.zeros((abs(fy-iy)+1,abs(fx-ix)+1,3), numpy.uint8)   # Creo una imagen en negro
        for i in range(0,abs(fy-iy)+1):                                     # Recorrido del recorte
            for j in range(0,abs(fx-ix)+1):
                if (ix > fx and iy > fy):                            
                    img_out[i][j]=image[i+fy][j+fx]                     
                elif (ix > fx and iy < fy):                            
                    img_out[i][j]=image[i+iy][j+fx]                     
                elif (ix < fx and iy > fy):                              
                    img_out[i][j]=image[i+fy][j+ix]                     
                elif (ix < fx and iy < fy):                   
                    img_out[i][j]=image[i+iy][j+ix]
        img_out = rotar_trasladar(img_out, 45, 50, 10)                      #Aplico transformación
        cv2.imwrite('output.jpg',img_out)                                   #Guardo la nueva imagen
        break

cv2.destroyAllWindows()                                                     #Cierra las ventanas
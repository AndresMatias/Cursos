# UTN-FRC. Ing. Electrónica.
# Práctico 3: Propiedades de video
# Visión por computadora
# Francisco Gabriel Rainero. Legajo 71967.

import cv2                                              #Importa módulo de OpenCV
import sys                                              #Importa módulo sys

if(len(sys.argv)>1):                                    #Verifica que se llame al video
    filename = sys.argv[1]                              #Asigna el argumento pasado 
else:
    print('Pasar nombre del video como argumento')
    sys.exit(0)                                         #Sale si no se pasa un argumento

cap = cv2.VideoCapture(filename)                        #Captura de un video

fourcc = cv2.VideoWriter_fourcc('X', 'V', 'I', 'D')     #Código de 4bytes usado para el códec

ret, frame = cap.read()                                 #Leo una sola vez una imagen para medir su tamaño
H = len(frame)                                          #Leo altura (height)
W = len(frame[0])                                       #Leo ancho (width)
framesize = (W, H)                                      

fps = cap.get(cv2.CAP_PROP_FPS)                         #Obtensión de las imágenes por segundo
t_delay_ms = int(1000/fps)                              #Delay en ms entre imagen e imagen = 1/(fps/1000) 

out = cv2.VideoWriter('salida.avi', fourcc, fps, framesize) #Creo archivo de salida

while(cap.isOpened()):                                  #Chequea que se abra correctamente el video

    ret, frame = cap.read()                             #Tupla: ret-> estado ; frame -> imagen
    if ret is True:    
        gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)      #Pasa a blanco y negro
        out.write(gray)                                     #Escribe la salida
        cv2.imshow('frame', gray)                           #Muestra la imagen
        if((cv2.waitKey(t_delay_ms)& 0xFF) == ord('q')):    #Delay según fps. Sale al presionar 'q'.
            break
    else:
        break

cap.release()                                           #Cierra el video
cv2.destroyAllWindows()                                 #Cierra las ventanas
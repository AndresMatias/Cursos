# UTN-FRC. Ing. Electrónica.
# Práctico 3: Propiedades de video
# Visión por computadora
# Francisco Gabriel Rainero. Legajo 71967.

import cv2                                              #Importa módulo de OpenCV

cap = cv2.VideoCapture(0)                               #Captura de video por cámara 0

ret, frame = cap.read()                                 #Leo una sola vez una imagen para medir su tamaño
H = len(frame)                                          #Leo altura (height)
W = len(frame[0])                                       #Leo ancho (width)
fps = cap.get(cv2.CAP_PROP_FPS)                         #Leo fps
delay = int(1000/fps)                                   #Delay entre imágenes en ms

fourcc = cv2.VideoWriter_fourcc('X', 'V', 'I', 'D')     #Código de 4bytes usado para el códec

out = cv2.VideoWriter('output.avi', fourcc, fps, (W,H))
#Guarda el video. Recibe: nombre, código fourcc, fps, resolución. 

while(cap.isOpened()):                                  #Chequea que se abra correctamente el video

    ret, frame = cap.read()                             #Tupla: ret-> estado ; frame -> imagen

    if ret is True:
        out.write(frame)                                #Escribe imagen actual 
        cv2.imshow('frame', frame)                      #Muestra imagen actual
        if cv2.waitKey(delay) & 0xFF == ord('q'):       #Con 'q' sale. Delay de 1 ms
            break
    else:
        break                                           #Sale si no se abrió bien la imagen

cap.release()                                           #Cierra la cámara
out.release()                                           #Cierra el video de salida
cv2.destroyAllWindows()                                 #Cierra las ventanas
import cv2
captura = cv2.VideoCapture(0) #Inicio la camara, el nro dentro del parentesis representa la camara a utilizar en caso de que haya mas de dos
salida = cv2.VideoWriter('videoSalida.avi',cv2.VideoWriter_fourcc(*'XVID'),20.0,(640,480)) #Para grabar video cv2.VideoWriter(Nombre,code del video,frames,resolucion(tupla))
while (captura.isOpened()): #Mientras la camara este abierta 
  ret, imagen = captura.read() #Leo un frame de la camara, ret(var boolean) es true si se ha capturado una imagen
  if ret == True: #Si se captura una imagen
    cv2.imshow('video', imagen) #Muestro la img
    salida.write(imagen) #Guardo la imagen en el video
    if cv2.waitKey(1) & 0xFF == ord('s'): #Si se apreto una tecla y esta es la 's' se sale del while el 0xFF es para maquinas de 64 bits segun opencv 
      break
  else: break
captura.release() #Cierro el acceso a la camara
salida.release() #Cierro el acceso al video
cv2.destroyAllWindows()
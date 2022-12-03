import cv2
#Ver git de Vision_Computadora para una programacion mas completa que incluye determinar la version de opencv y los frame del video etc
captura = cv2.VideoCapture('videoSalida.avi')
while (captura.isOpened()):
  ret, imagen = captura.read()
  if ret == True:
    cv2.imshow('video', imagen)
    if cv2.waitKey(30) == ord('s'): #el 30 son 30 ms
      break
  else: break
captura.release()
cv2.destroyAllWindows()
import cv2
imagen = cv2.imread('logo.png',0) #Leo imagen en grises
cv2.imwrite('Grises.png',imagen) #Guardo imagen en gris
cv2.imshow('Logo OpenCV Grises',imagen) #Muestro img
cv2.waitKey(0) #Tecla para continuar
cv2.destroyAllWindows() #Cierro Ventana
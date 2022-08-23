import cv2

#Inversion de arriba abajo
imagen = cv2.imread('ave.jpg')
flip0 = cv2.flip(imagen,0)
cv2.imshow('flip0',flip0)
cv2.waitKey(0)

#Inversion de lateral
imagen = cv2.imread('ave.jpg')
flip1 = cv2.flip(imagen,1)
cv2.imshow('flip1',flip1)
cv2.waitKey(0)

#Inversion combinada de lo anterior
imagen = cv2.imread('ave.jpg')
flip_1 = cv2.flip(imagen,-1)
cv2.imshow('flip_1',flip_1)
cv2.waitKey(0)
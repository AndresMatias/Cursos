# Visión por computadora: TP2. Danel Schwab Urbani
import cv2

img = cv2.imread ('mickey.jpg', 0) # Lee imagen (El valor 0 indica que cargo la imagen en byn)
filas, columnas = (img.shape[0],img.shape[1]) # obtengo cantidad de filas y columnas (tamaño imagen).

for i in range (filas):
    for j in range (columnas):
        if img[i][j] <= 170: #170 es el umbral (Intensidad del pixel). (Escala de grises)
            img[i][j]=0
        else:
            img[i][j]=255


cv2.imwrite('mickey_byn.png', img)
cv2.imshow('imagen',img)
cv2.waitKey(0)
cv2.destroyAllWindows()

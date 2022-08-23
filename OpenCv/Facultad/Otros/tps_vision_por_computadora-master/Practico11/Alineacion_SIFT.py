# UTN-FRC. Ing. Electrónica.
# Práctico 11: Alineación SIFT
# Visión por computadora
# Francisco Gabriel Rainero. Legajo 71967. 

import cv2
import numpy as np

blue = (255, 0, 0); green = (0, 255, 0); red = (0, 0, 255)

MIN_MATCH_COUNT = 10

img1 = cv2.imread('Imagen1.jpg') 				#Leemos imagen 1
img2 = cv2.imread('Imagen2.jpg') 				#Leemos imagen 2
img1_copy = img1.copy()
img2_copy = img2.copy()

dscr = cv2.xfeatures2d.SIFT_create(100) 		#Inicialización del detector y el descriptor

kp1, des1 = dscr.detectAndCompute(img1, None)	#Encontramos los puntos clave y los descriptores con SIFT en img1
kp2, des2 = dscr.detectAndCompute(img2, None)	#Encontramos los puntos clave y los descriptores con SIFT en img2

# Gráfica de puntos clave
cv2.drawKeypoints(img1,kp1,img1_copy,red)
cv2.drawKeypoints(img1,kp2,img2_copy,blue)
img_concatenate = np.concatenate((img1_copy, img2_copy), axis=0)	#Concatenamos verticalmente
cv2.imshow('Puntos clave de las imagenes', img_concatenate)
cv2.imwrite('Puntos_clave.jpg',img_concatenate)
cv2.waitKey(0)

# Establecemos matches
matcher = cv2.BFMatcher(cv2.NORM_L2)
matches = matcher.knnMatch(des1, des2, k=2)

# Guardamos los buenos matches usando el test de razón de Lowe
good = []
all = []
for m, n in matches:
	all.append(m)
	if m.distance < 0.7*n.distance:
		good.append(m)

if(len(good)>MIN_MATCH_COUNT):
	scr_pts = np.float32([kp1[m.queryIdx].pt for m in good]).reshape(-1, 1, 2)
	dst_pts = np.float32([kp2[m.trainIdx].pt for m in good]).reshape(-1, 1, 2)
	
	H,mask = cv2.findHomography(dst_pts, scr_pts, cv2.RANSAC, 5.0) 	#Computamos la homografía con RANSAC

wimg2 = cv2.warpPerspective(img2, H, img2.shape[:2][::-1])			#Aplicamos la transformación perspectiva H a img2

# Gráfica de matches pre Lowe
img_matches = cv2.drawMatches(img1, kp1, img2, kp2, all, None)	
cv2.imshow('Matches pre Lowe', img_matches)
cv2.imwrite('Matches_pre_Lowe.jpg',img_matches)
cv2.waitKey(0)

# Gráfica de matches post Lowe
img_matches = cv2.drawMatches(img1, kp1, img2, kp2, good, None)	
cv2.imshow('Matches post Lowe', img_matches)
cv2.imwrite('Matches_post_Lowe.jpg',img_matches)
cv2.waitKey(0)

#Mezclamos ambas imágenes
alpha = 0.5
blend = np.array( wimg2*alpha + img1*(1-alpha), dtype=np.uint8)
cv2.imshow('Imagen de salida', blend)
cv2.imwrite('Imagen_mezcla.jpg',blend)
cv2.waitKey(0)
cv2.destroyAllWindows
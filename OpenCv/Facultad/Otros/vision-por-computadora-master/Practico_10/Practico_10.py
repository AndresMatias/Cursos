# Schwab Urbani, Danel. Visión por computadora: TP10

# Consigna: Realizar una aplicación simple en base al teórico presentado de ArUCo. 
# En este tp esta realizado sobre la tematica realidad aumentada y medición de objetos. Consiste en 4 marcadores ArUCo
# colocados en las 4 esquinas de un TV, las cuales son utilizadas para hacer una transformada de perspectiva de una imagen
# seleccionada por el usuario y sumarla al video. Además, estos cuatro marcadores, permiten tomar las medidas aproximadas
# del televisor



import cv2
import cv2.aruco as aruco
import numpy as np
from math import sqrt

def mensaje_bienvenida():
	print("Bienvenido a TV Aruco!!")
	print("Presione 'a' para subir de canal.")
	print("Presione 'b' para bajar de canal.")
	print("Presione 'c' para detener la transmision.")
	print("Presione 'm' para obtener una medida aproximada del TV.")
	print("Presione 'q' para salir del programa.")
	print(" ")

def findArucoMarkers(img, markerSize = 6, totalMarkers = 250, draw=True ):
	#MarkerSize es que el aruco marker es de 6x6
	#totalMarkers es la cantidad de marcadores aruco que puede haber en la imagen
	imgGray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
	key = getattr(aruco,f'DICT_{markerSize}X{markerSize}_{totalMarkers}')
	arucoDict = aruco.Dictionary_get(key)
	arucoParam = aruco.DetectorParameters_create()
	bbox, ids, rejected = aruco.detectMarkers(imgGray, arucoDict, parameters=arucoParam)

	if draw:
		aruco.drawDetectedMarkers(img,bbox)
	
	return [bbox, ids]

def augmentAruco(bbox, id, img, imgAug, medicion, transmision):
	#Medida marcador aruco 21 : 5.1cm x 5.1cm
	arucoInd = [-1,-1,-1,-1]
	
	for j in range(4):
		arucoInd[j] = int(id[j])


	aruco42 = arucoInd.index(42)
	aruco49 = arucoInd.index(49)
	aruco43 = arucoInd.index(43)
	aruco45 = arucoInd.index(45)

	tl = bbox [aruco42][0][0][0], bbox [aruco42][0][0][1]
	tr = bbox [aruco49][0][0][0], bbox [aruco49][0][0][1]
	br = bbox [aruco45][0][0][0], bbox [aruco45][0][0][1]
	bl = bbox [aruco43][0][0][0], bbox [aruco43][0][0][1]

	h, w, c = imgAug.shape

	pts1 = np.array([tl,tr,br,bl])
	pts2 = np.float32([[0,0],[w,0],[w,h],[0,h]])

	if transmision:
		matrix, _ = cv2.findHomography(pts2,pts1)
		imgOut = cv2.warpPerspective(imgAug , matrix, (img.shape[1], img.shape[0]))
		cv2.fillConvexPoly(img, pts1.astype(int),(0,0,0))
		imgOut = img + imgOut
	else:
		imgOut=img
	if medicion:
		cv2.line(imgOut, (int(tl[0]),int(tl[1])) , (int(tr[0]),int(tr[1])), (0,195,255))
		medida = medidaTV(int(tl[0]),int(tl[1]) , int(tr[0]),int(tr[1]),bbox,arucoInd)
		cv2.putText( imgOut , "ancho: "+ medida,  (int(tl[0]),int(tl[1])) , cv2.FONT_HERSHEY_SIMPLEX, 1, (0,195,255), 2 , cv2.LINE_AA)

		cv2.line(imgOut, (int(tr[0]),int(tr[1])) , (int(br[0]),int(br[1])), (0,195,255))
		medida = medidaTV(int(tr[0]),int(tr[1]) , int(br[0]),int(br[1]),bbox,arucoInd)
		cv2.putText( imgOut , "alto: "+ medida,  (int(tr[0]),int(tr[1])) , cv2.FONT_HERSHEY_SIMPLEX, 1, (0,195,255), 2 , cv2.LINE_AA)

		cv2.line(imgOut, (int(br[0]),int(br[1])) , (int(bl[0]),int(bl[1])), (0,195,255))
		cv2.line(imgOut, (int(bl[0]),int(bl[1])) , (int(tl[0]),int(tl[1])), (0,195,255))

		cv2.line(imgOut, (int(tl[0]),int(tl[1])) , (int(br[0]),int(br[1])), (0,195,255))
		medida = medidaTV(int(tl[0]),int(tl[1]) , int(br[0]),int(br[1]),bbox,arucoInd)
		cv2.putText( imgOut , "diagonal: "+ medida,  (int(bl[0]),int(bl[1])) , cv2.FONT_HERSHEY_SIMPLEX, 1, (0,195,255), 2 , cv2.LINE_AA)

		cv2.line(imgOut, (int(tr[0]),int(tr[1])) , (int(bl[0]),int(bl[1])), (0,195,255))
	
	return imgOut

def medidaTV(x1,y1,x2,y2,bbox,arucoInd):
	#5.1cm miden los marcadores aruco
	aruco42 = arucoInd.index(42)
	referencia = bbox [aruco42][0][1][0] - bbox [aruco42][0][0][0]

	px_cm = 5.1/referencia

	x = x2-x1 #medida en pixeles en x e y
	y = y2-y1
	
	x_cm = x*px_cm/100 #Paso de px a metro
	y_cm = y*px_cm/100
	
	x_mt = x_cm**2
	y_mt = y_cm**2
	
	resultado = sqrt(x_mt + y_mt)
	resultado = round(resultado, 1)
	
	return str(resultado) + " mt"


def main():
	cap = cv2.VideoCapture("tele.mp4")
	fps = cap.get(cv2.CAP_PROP_FPS)
	i=0
	transmision = True
	medicion = False 


	while cap.isOpened():

		if i == 0:
			imgAug = cv2.imread("shrek.jpg")
		elif i == 1:
			imgAug = cv2.imread("iron man.jpg")
		elif i == 2:
			imgAug = cv2.imread("messi.jpg")
						
		elif i == 3:
			imgAug = cv2.imread("hulk.jpg") 

		sccuess, img = cap.read()
		arucoFound = findArucoMarkers(img)
		

		if len(arucoFound[0]) == 4:
			img = augmentAruco (arucoFound[0], arucoFound[1], img, imgAug, medicion, transmision)				

		cv2.imshow("Image", img)
		k = cv2.waitKey(int(fps))

		if k == ord('q'): #Presiono 'q' para salir
			break

		elif k == ord('a'):
			i=i+1
			
			if i==4:
				i=0

		elif k == ord ('b'):
			i=i-1

			if i < 0:
				i=3

		elif k == ord ('c'):
			if transmision is True:
				transmision = False
			else:
				transmision=True

		elif k == ord ('m'):
			if medicion is True:
				medicion = False
			else:
				medicion=True
				
	cap.release()
	cv2.destroyAllWindows()	
		
mensaje_bienvenida()
main()

# UTN-FRC. Ing. Electrónica.
# Práctico 10: ArUCo
# Visión por computadora
# Francisco Gabriel Rainero. Legajo 71967. 

import cv2
import cv2.aruco as aruco
import numpy as np

def findMarkers(img, markerSize=4, totalMarkers=250, draw = True):
	gray = cv2.cvtColor (img,cv2.COLOR_BGR2GRAY)
	key = getattr(aruco, f'DICT_{markerSize}X{markerSize}_{totalMarkers}')      #4x4_250
	arucoDict = aruco.Dictionary_get(key)
	arucoParam = aruco.DetectorParameters_create()
	bb ,ids,rejected = aruco.detectMarkers(img, arucoDict, parameters= arucoParam)
	if draw:
		aruco.drawDetectedMarkers (img, bb)
	return [bb, ids]

def replacementAruco(bb,id, img, img_r , drawId = True):
	ul=bb[0][0][0], bb[0][0][1]
	ur=bb[0][1][0], bb[0][1][1]
	dr=bb[0][2][0], bb[0][2][1]
	dl=bb[0][3][0], bb[0][3][1]

	h,w = img_r.shape[:2]

	pt1 = np.array([ul,ur,dr,dl])
	pt2 = np.float32 ([[0,0],[w,0],[w,h],[0,h]])
	mtx, _= cv2.findHomography (pt2,pt1)
	img_out = cv2.warpPerspective (img_r, mtx, (img.shape[1], img.shape[0]))

	cv2.fillConvexPoly (img, pt1.astype(int),(0,0,0))
	img_out = img + img_out

	return img_out

cap = cv2.VideoCapture(0)
mask = cv2.imread('Shrek.jpg')

while (True):
	ret, img = cap.read()
	arucoFound= findMarkers(img)

	if len(arucoFound[0])!=0:
		for bb, id in zip (arucoFound[0],arucoFound[1]):		 #Si coincide una porción con algún aruco muestro mask
			img = replacementAruco (bb,id,img,mask)
	cv2.imshow ("Aruco", img)
	k = cv2.waitKey(1) & 0xFF
	if k == ord('q'):                                            #Sale al presionar 'q'
		break
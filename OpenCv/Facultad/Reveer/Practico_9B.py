import cv2
import numpy as np
from math import sqrt

#Dimensiones puertas:2.10m de alto por 0.73m de ancho, en pixeles da 1407-1192=215 pixeles para el ancho y para el largo 853-165=688
#lo que da 2.945 pixeles por cm en "x" y en "y" son 3.3 pixeles por cm 

puntos=[] #Lista que contendra los tres puntos escogidos para mapear, cada posicion de la lista, sera una tupla de las coordenadas x e y
puntosRef=[[161, 243], [1530, 150], [1541, 842], [173, 707]]
imgOutP=0

def transformacionPerspectiva(scr):
	dst = np.float32([[0, 0], [scr.shape[1], 0],  [scr.shape[1],scr.shape[0]],[0, scr.shape[0]]])
	p=np.float32([[puntosRef[0]],[puntosRef[1]],[puntosRef[2]],[puntosRef[3]]])
	M=cv2.getPerspectiveTransform(p,dst)
	iO=cv2.warpPerspective(scr,M,(scr.shape[1],scr.shape[0])) #Imagen de salida de la trasformacion
	return iO #Imagen perspectiva de la puerta

def medida(x1,y1,x2,y2):
	#medida en pixeles en x e y

	x = abs(x2-x1) 
	y = abs(y2-y1)
	print(x)
	#Paso de px a metro
	x_m = (x/2.4931)/100 
	y_m = (y/3.3)/100
	rta = round(sqrt((x_m**2) + (y_m**2)),2)
	return rta

def draw(event,x,y,flags,param):
	global ix,iy,imgOutP,guardar
	if event==cv2.EVENT_LBUTTONDOWN: #Clic izq 
		ix,iy=x,y #Coordenadas iniciales del mouse
		print("[{0},{1}]".format(x,y))
		if len(puntos)!=2:
			puntos.append([x,y])
			cv2.circle(imgOutP, (x, y), 7, (255,0,0), 2)
		else:
			print("Ya no puede escoger mas puntos para mapear")		
		if len(puntos)==2:
			cv2.line(imgOutP, (puntos[0][0],puntos[0][1]), (puntos[1][0],puntos[1][1]), (0,195,255))
			metros=medida(puntos[0][0],puntos[0][1],puntos[1][0],puntos[1][1])
			cv2.putText( imgOutP , str(metros)+"mt", (x+20, y+20), cv2.FONT_HERSHEY_SIMPLEX, 0.6, (0,195,255), 2 , cv2.LINE_AA)
			guardar=True
			for i in range(0,len(puntos)): puntos.pop() #Elimino todos los puntos
			
nombre='casa.png'
imgIn=cv2.imread(nombre,1) #Leo la imagen de entrada
guardar=True #Bandera para indicar si se puede o no guardar
ix,iy=-1,-1

print("Para transformar imagen presione: h")
print("Para mostrar imagen original presione: r")
print("Limpiar imagen presione transformada: l")
print("Para salir presione : Esc")



cv2.namedWindow('imagen')
cv2.setMouseCallback('imagen',draw) #Metodo de mouse
while(1):
	cv2.imshow('imagen',imgIn)
	k=cv2.waitKey (1)&0xFF
	if k==ord('h') and guardar==True: #Aplico Transformacion euclidiana y guardo imagen
		imgOutP=transformacionPerspectiva(imgIn) #Genero la matriz para trasformar
		imgIn=imgOutP
		nombre='ResultadoB.jpg'
		cv2.imwrite(nombre,imgOutP)	
	elif k==ord('r'): #Restaurar
		nombre='casa.png'
		imgIn=cv2.imread(nombre,1)
		print("Imagen Restaurada")
	elif k==ord('l') and nombre=='ResultadoB.jpg': #Restaurar
		imgIn=cv2.imread(nombre,1)
		imgOutP=imgIn
		print("Imagen Restaurada")
	elif k==27: #Salir
		break				
cv2.destroyAllWindows()
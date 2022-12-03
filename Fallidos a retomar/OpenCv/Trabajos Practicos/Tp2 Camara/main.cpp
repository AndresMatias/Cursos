#include "opencv2/opencv.hpp"
#include "opencv2/highgui/highgui.hpp"
#include "stdlib.h"
#include "stdio.h"
#include "iostream"

using namespace std;
using namespace cv;

int main(int argc, char** argv) 
{
	namedWindow("Tp2_Video",CV_WINDOW_AUTOSIZE);//Creo una ventana
	VideoCapture Video(0);//Creo un dispositivo de captura de video
	Mat cuadro;//Creo un tipo de dato mat para almacenar cuadro por cuadro del video(imagen por imagen)
	if(Video.isOpened()!=true)
	{
		cout<<"La camara no funciona"<<endl;
		getchar();
		return 0;//salgo de la funcion y vuelve al main
	}
	while(Video.isOpened()==true)//"True" numericamente es igual a 1
	{
		Video>>cuadro;//Obtiene un nuevo cuadro(fotograma) de la cámara
		
		//Analisis del cuadro(fotograma) obtenido en "Video>>cuadro;"
		if(cuadro.empty()==true)//"empty" devuelve verdadero si no hay elementos en el array y sale del bucle
		{
			break;
		}
		imshow("Tp2_Video",cuadro);//Muestro el cuadro
		if(waitKey(30)>=0)//Si aprieto una tecla sale del bucle
		{
			break;
		}
	}
	return 0;
} 

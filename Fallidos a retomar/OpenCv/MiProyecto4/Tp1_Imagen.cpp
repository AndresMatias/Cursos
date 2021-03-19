#include "opencv2/opencv.hpp"
#include "opencv2/highgui/highgui.hpp"
#include "Tp1_Imagen.h"

using namespace cv;

int Tp1_Imagen()
{
	Mat Imagen=imread("img.png",1);	//Creo un tipo de dato "Mat"(Mat=IplImage) para almacernar mi imagen
	namedWindow("Tp1_Imagen",CV_WINDOW_AUTOSIZE);//Creo una ventana que toma tamaño sola automaticamente
	imshow("Tp1_Imagen",Imagen);//Muestro en la ventana "Tp1_Imagen" mi imagen almacenada en "Imagen"(imshow=cvShowImage)
	waitKey(0);//Aprieto una tecla para salir
	
	//Libero Recursos
	//cvReleaseImage(&Imagen);//Libero espacio de memoria donde esta almacenada mi Imagen
	destroyWindow("Tp1_Imagen");//Cierro la ventana donde mostre mi imagen		   
}

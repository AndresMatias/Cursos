#include "Hola_Mundo.h"
#include "opencv2/opencv.hpp"
#include "opencv2/highgui/highgui.hpp"

using namespace cv;
void Hola_Mundo()
{
	//Creo una ventana llama "Output":
	namedWindow("Salida",CV_WINDOW_AUTOSIZE);
	//Inicializo una matriz de pixeles negros de 120X350 :
	Mat output=Mat::zeros( 120, 350, CV_8UC3 );
	//Escribo el texto en la matriz:
	putText(output,"Hola Mundo :)",cvPoint(15,70),FONT_HERSHEY_PLAIN,3,cvScalar(0,255,0),4);
	//Muestro la imagen
	imshow("Salida", output);
	//Tecla para salir(creo)
	waitKey(0);
}

#include "opencv2/opencv.hpp"
#include "opencv2/highgui/highgui.hpp"

using namespace cv;

int main(int argc, char** argv) 
{
	//Creo una ventana llama "Output":
	namedWindow("Output",CV_WINDOW_AUTOSIZE);
	//Inicializo una matriz de pixeles negros de 120X350 :
	Mat output=Mat::zeros( 120, 350, CV_8UC3 );
	//Escribo el texto en la matriz:
	putText(output,"Hello World :)",cvPoint(15,70),FONT_HERSHEY_PLAIN,3,cvScalar(0,255,0),4);
	//Muestro la imagen
	imshow("Output", output);
	//Tecla para salir(creo)
	waitKey(0);
	return 0;
} 

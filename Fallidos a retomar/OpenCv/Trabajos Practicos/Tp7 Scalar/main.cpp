#include "opencv2/opencv.hpp"
#include "opencv2/highgui/highgui.hpp"
#include "iostream"

using namespace cv;
using namespace std;
//Este programa dibuja un rectangulo en una imagen previamente seteada
int main(int argc, char** argv) 
{
	Mat imagen(600,600,CV_8UC3,Scalar(0,0,0));//Si no seteo la "imagen" me tira error de assertion failed debido a no contiene nada la imagen
	cout<<imagen.row;
	rectangle(imagen,Point(150,150),Point(300,300),Scalar(225,255,255),100);
	//rectangle( imagen,Punto1,Punto2,Scalar("RGB"),Espesor de linea,tipo de linea,Número de bits fraccionarios en las coordenadas del punto);
	namedWindow("Tp7 Scalar",CV_WINDOW_AUTOSIZE);//Puedo no usar namedWindow en este casi
	//Scalar: Vector de cuatro espacios, sirve para acceder a los valores de pixeles de una imagen(Su valor "RGB")
	imshow("Tp7 Scalar",imagen);
	waitKey(0);
	return 0;
} 

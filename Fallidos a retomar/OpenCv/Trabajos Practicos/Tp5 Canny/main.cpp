#include "opencv2/opencv.hpp"
#include "opencv2/highgui/highgui.hpp"

using namespace cv;
//Este programa usa la funcion canny para detectar lineas
//En la carpeta hay un bloc de notas con dos link que explica como funciona y se llama
//"Funcio Canny

int main(int argc, char** argv) 
{
	Mat Imagen=imread("img.png",0); //"cero" para que tengo un solo canal y sea en blanco y negro
	double Limite_Inferior=50,Limite_Superior=500; //Defino lso limites en pixeles sobre los cuales estaran lso minimos y maximos
	namedWindow("Tp5 Canny",CV_WINDOW_AUTOSIZE);
	/*if(Imagen.channels!=1) //Ver Despues
	{
		return(0);
	}*/
	Canny(Imagen,Imagen,Limite_Inferior,Limite_Superior,3,true); //Aplico el detector de linea y lo guarda en Imagen
	imshow("Tp5 Canny",Imagen); 
	waitKey(0);
	return 0;
} 

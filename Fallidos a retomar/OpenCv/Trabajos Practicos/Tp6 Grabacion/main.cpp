#include "opencv2/opencv.hpp"
#include "opencv2/highgui/highgui.hpp"
#include "iostream"

using namespace std;
using namespace cv;
// Este programa manipula una grabacion o un video en vivo(nose si una grabacion pero si un video en vivo)
int main(int argc, char** argv) 
{
	VideoCapture Video(0);
	Mat bgr_cuadro,logPolar_cuadro;
	double fps=Video.get(CAP_PROP_FPS);
	namedWindow("Tp6 Grabaciones",CV_WINDOW_AUTOSIZE);
	Size Dimensiones(Video.get(CV_CAP_PROP_FRAME_WIDTH),Video.get(CV_CAP_PROP_FRAME_HEIGHT));
	VideoWriter Grabacion;// Declaro el tipo de dato para trabajar grabando video
	Grabacion.open("Tp6 Grabaciones",CV_FOURCC('M','J','P','G'),fps,Dimensiones,0);//Abro a "Grabacion" e introdusco los parametros
	
	if(Video.isOpened()!=true)
	{
		cout<<"La camara no funciona"<<endl;
		getchar();
		return 0;//salgo de la funcion y vuelve al main
	}
	while(Video.isOpened()==true)//"True" numericamente es igual a 1
	{
		//Video>>bgr_cuadro;//Obtiene un nuevo cuadro(fotograma) de la cámara
		Video.read(bgr_cuadro);//Obtiene un nuevo cuadro(fotograma) de la cámara
		
		//Analisis del cuadro(fotograma) obtenido en "Video>>cuadro;"
		if(bgr_cuadro.empty()==true)//"empty" devuelve verdadero si no hay elementos en el array y sale del bucle
		{
			break;
		}
		logPolar(bgr_cuadro,logPolar_cuadro,Point2d(bgr_cuadro.rows/2,bgr_cuadro.cols/2),40,INTER_LINEAR+WARP_FILL_OUTLIERS);
		imshow("Tp6 Grabaciones",logPolar_cuadro);//Muestro el cuadro
		//Grabacion<<cuadro; hace lo mismo que Grabacion.write
		Grabacion.write(logPolar_cuadro);
		if(waitKey(30)>=0)//Si aprieto una tecla sale del bucle
		{
			break;
		}
	}
	return 0;
} 

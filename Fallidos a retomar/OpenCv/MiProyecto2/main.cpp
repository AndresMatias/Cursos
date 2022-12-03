#include "opencv2/opencv.hpp"
#include "opencv2/highgui/highgui.hpp"

using namespace cv;

int main(int argc, char** argv) 
{
	//Creo una ventana llamada "avidemo"
	cvNamedWindow("avidemo", CV_WINDOW_AUTOSIZE);
	//Creo un dispositivo de captura de video
	CvCapture*capture =cvCreateFileCapture(argv[0]);
	//Creo un puntero de Ipimagen donde se guardaran lso frame
	IplImage* frame; 
	//Bucle infinito
	while(1)
	{
		//Obtengo cada frame del formato ".avi"
		frame=cvQueryFrame( capture );
		//Lo muestro
		cvShowImage("avidemo",frame);
		//Si frame es NULL
		if(!frame)
		{
		   break;
		}
	}
	char c = cvWaitKey(33);
	//Libero Recursos
	cvReleaseCapture( &capture ); 
	cvDestroyWindow( "avidemo");
	return 0;
} 

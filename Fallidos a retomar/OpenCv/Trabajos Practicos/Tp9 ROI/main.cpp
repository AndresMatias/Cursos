#include "opencv2/opencv.hpp"
#include "opencv2/highgui/highgui.hpp"

using namespace cv;

int main(int argc, char** argv) 
{
	int x=100,y=100,Ancho=200,Alto=200;
	CvRect Rec(x,y,Ancho,Alto);//Seteo la posicion en x e y y la dimension de mi region de interes
	Mat Imagen=imread("img.png",1);	//Creo un tipo de dato "Mat"(Mat=IplImage) para almacernar mi imagen
	Mat Region_Interes=Imagen(Rec); //Aislo mi region de interes en una imagen
	//IplImage *Imagen=cvLoadImage("img.png",1); //Creo un tipo de dato donde almaceno mi imagen
	namedWindow("Tp_9_ROI",CV_WINDOW_AUTOSIZE);//Creo una ventana que toma tamaño sola automaticamente
	//cvSetImageROI(Imagen,R); //Esto solo puede ser usado por IplImage
	rectangle(Imagen,Rec,Scalar(255), 1, 8, 0); //Dibujo mi rectangulo rectangulo en la imagen y obtengo mi roi
	imshow("Tp_9_ROI",Imagen); //Muestro mi imagen y mi region de interes
	imshow("ROI",Region_Interes); //Muestro mi solo mi region de interes
	waitKey(0);
	destroyWindow("Tp_9_ROI");//Cierro la ventana donde mostre mi imagen
	destroyWindow("ROI");//Cierro la ventana donde mostre mi imagen
	return 0;
} 

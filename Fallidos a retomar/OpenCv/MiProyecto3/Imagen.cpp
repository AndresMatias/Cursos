#include "Hola_Mundo.h"
#include "opencv2/opencv.hpp"
#include "opencv2/highgui/highgui.hpp"
#include "Imagen.h"
using namespace cv;
int Imagen()
{
	
	//Mat img(rows, cols, CV_8UC3, Scalar::all(0)), creo una imagen
	
	//rows: Cantidad de filas o pixeles de alto que tendrá nuestra imagen
	
	//cols: Cantidad de columnas o pixeles de ancho de nuestra imagen
	
	//CV_8UC3: puede ser alguno de los valores mencionados abajo seguido de C3 para tres canales
    //		, o C1, C2, C4 para 1, 2, 4, canales respectivamente:	
    //		CV_8U - 8-bit unsigned integers ( 0..255 )
    //		CV_8S - 8-bit signed integers ( -128..127 )
    //		CV_16U - 16-bit unsigned integers ( 0..65535 )
    //		CV_16S - 16-bit signed integers ( -32768..32767 )
    //		CV_32S - 32-bit signed integers ( -2147483648..2147483647 )
	//		CV_32F - 32-bit floating-point numbers ( -FLT_MAX..FLT_MAX, INF, NAN )
    
	//Scalar::all(0): Scalar representa el color de la imagen en formato BGR,
    //				  podemos establecer un color diferente estableciendo los diferentes canales 
    //				  de este modo: Scalar(azul, verde, rojo), 
    //				  				podemos usar el macro CV_RGB(rojo, verde, azul) 
    //				  				si nos resulta más cómodo.																																																				 CV_64F - 64-bit floating-point numbers ( -DBL_MAX..DBL_MAX, INF, NAN )
	int rows = 600;
	int cols = 800;
	int rec = 150;
	
	//crear una imagen de 800x600 pixeles
	//canal BGR de tipo CV_8U( valores de 0 a 255)
	//inicializamos a 0 (color negro)
	Mat img(rows, cols, CV_8UC3, Scalar::all(0));
	
	//dibuja un circulo en el centro de la imagen de un radio de 250
	circle(img, Point(cols / 2, rows / 2), 250, Scalar(255,0,0), 3);
	
	//dibuja una linea
	line(img, Point(), Point(cols, rows), CV_RGB(255,0,0), 2, CV_AA);
	
	//dibuja un rectangulo
	rectangle(img, Point(rec, rec), Point(cols - rec, rows - rec), CV_RGB(0,255,255));
	
	//dibuja el texto Opencv 2
	putText(img, "OpenCV 2", Point(180,320), FONT_HERSHEY_SCRIPT_COMPLEX, 3, CV_RGB(125,12,145), 2);
	
	imshow("Drawing", img);
	waitKey(0);
}

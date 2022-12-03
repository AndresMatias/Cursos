#include "opencv2/opencv.hpp"
#include "opencv2/highgui/highgui.hpp"
#include "stdlib.h"
#include "stdio.h"
#include "Detectar_Lineas.h"

using namespace cv;
void Detectar_Lineas()
{
	
	/*Para la detecci�n de l�neas usamos dos m�todos: 
		El m�todo est�ndar HougLines Standard Hough Line Transform. 
		El m�todo probabil�stico es m�s eficiente HougLinesP Probabilistic Line Transform.*/
	
	/*Antes de usar alguna de estas funciones primero aplicaremos dos funciones a la imagen, 
	Canny para detectar los bordes de la imagen y 
	cvtColor para cambiar la imagen de escala de grises a BGR y poder mostrar los resultados.*/
	Canny(src, dst, 50, 200, 3);
	cvtColor(dst, cdst, CV_GRAY2BGR);
	
	/*Aplicar el m�todo HoughLines con los par�metros indicados, 
	  de las l�nea # 3 a 13 se dibujan la l�neas encontradas:
		dst: proporcionado por Canny. 
		lines: almacena las lineas detectadas. 
		rho : usaremos 1 pixel. 
		theta: usaremos 1 grado (CV_PI/180). 
								 threshold: numero m�nimo de l�neas a detectar. 
								 srn and stn: zero por defecto.*/
		vector<Vec2f> lines;
		HoughLines(dst, lines, 1, CV_PI/180, 200, 0, 0 );
		for ( size_t i = 0; i < lines.size(); i++ ) 
		{
			float rho = lines[i][0], theta = lines[i][1];
			Point pt1, pt2;
			double a = cos(theta), b = sin(theta);
			double x0 = a*rho, y0 = b*rho;
			pt1.x = cvRound(x0 + 1000*(-b));
			pt1.y = cvRound(y0 + 1000*(a));
			pt2.x = cvRound(x0 - 1000*(-b));
			pt2.y = cvRound(y0 - 1000*(a));
			line( cdst, pt1, pt2, Scalar(0,0,255), 3, CV_AA);
		}
		/*Para aplicar el m�todo HoughLinesP se hace  de manera similar solo cambian algunos 
		par�metros y la manera como devuelve las lineas:
			 dst: proporcionado por Canny.
			 lines: almacena las lineas detectadas.
			 rho : usaremos 1 pixel.
			 theta: usaremos 1 grado (CV_PI/180).
			 threshold: numero m�nimo de l�neas a detectar.
			 minLinLength: m�nimo de puntos que forman una l�nea.*/
		vector<Vec4i> lines;
		HoughLinesP(dst, lines, 1, CV_PI/180, 50, 50, 10 );
		for ( size_t i = 0; i < lines.size(); i++ ) 
		{
			Vec4i l = lines[i];
			line( cdst, Point(l[0], l[1]),Point(l[2], l[3]), Scalar(0,0,255),3, CV_AA);
		}
}

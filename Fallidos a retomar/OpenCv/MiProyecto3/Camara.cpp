#include <opencv\cv.h>
#include <opencv2\highgui\highgui.hpp>
#include <opencv2\imgproc\imgproc.hpp>
#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include "Camara.h"
using namespace std;
using namespace cv;
int Camara()
{
	Mat frame;
	namedWindow("video",CV_WINDOW_AUTOSIZE);
	VideoCapture cap(0);
	if(!cap.isOpened())
	{
		cout<<"Camera not found"<<endl;
		getchar();
		return -1;
	}
	while ( cap.isOpened() )
	{
		cap >> frame;//Obtiene un nuevo cuadro(fotograma) de la cámara
		if(frame.empty()) break;
	
		imshow("video", frame);
		if(waitKey(30) >= 0) break;
	}  
}

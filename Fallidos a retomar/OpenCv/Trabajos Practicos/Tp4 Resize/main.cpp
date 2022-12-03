#include "opencv2/opencv.hpp"
#include "opencv2/highgui/highgui.hpp"
#include "iostream"
using namespace std;
using namespace cv;
//Este programa maneja la escala de una imagen
int main(int argc, char** argv) 
{
	Mat Img_In=imread("img.png",1),Img_Out;
	int rows=Img_In.rows,cols=Img_In.cols;	//Ver 
	Size Escala(cols/2,rows/2);//si pongo Escala(Img_In.rows/2,Img_In.cols/2); no funciona
	resize(Img_In,Img_Out,Escala,0,0,INTER_LINEAR);//Investigar "resize" contiene tres parametros mas, resize sirve pra cambiar la escala de la imagen
	namedWindow("Tp 4",CV_WINDOW_AUTOSIZE);
	cout<<"rows:"<<rows<<endl<<"cols:"<<cols<<endl<<"rows:"<<Img_Out.rows<<endl<<"cols:"<<Img_Out.cols<<endl;
	imshow("Tp 4",Img_Out);
	waitKey(0);
	return 0;
} 
/*resize(Img_In,Img_Out,Size(),fx,fy,INTER_LINEAR); a lso ultimos tres parametros los 
puedo sacar si pongo la escala automaciamente y si no lso saco entonces tienen que 
tenes lso siguientes valores fx=0,fy=0,INTER_LINEAR*/

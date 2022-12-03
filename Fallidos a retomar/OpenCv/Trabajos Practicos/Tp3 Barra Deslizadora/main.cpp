#include "opencv2/opencv.hpp"
#include "opencv2/highgui/highgui.hpp"
#include "stdlib.h"
#include "stdio.h"
#include "iostream"
using namespace std;
using namespace cv;
int posicion_del_deslizador=0;
VideoCapture Video("T.B. - Temporada 1 Capitulo 13.mp4");
void Control_Deslizante(int,void*)//Si uso la funcion abajo no funciona nose porque
{
 Video.set(CV_CAP_PROP_POS_FRAMES,posicion_del_deslizador);
};

int main(int argc, char** argv) 
{
	int cuadro2=Video.get(CV_CAP_PROP_FRAME_COUNT);//Video.get(CV_CAP_PROP_FRAME_COUNT):Numeros total de cuadros del video lo igualos a cuadro2 para determinar el rango de la barra dezplazadora
	namedWindow("Tp3 Deslizador",CV_WINDOW_AUTOSIZE);
	Mat cuadro;//Creo un tipo de dato mat para almacenar cuadro por cuadro del video(imagen por imagen)
	if(Video.isOpened()!=true)
	{
		cout<<"La camara no funciona"<<endl;
		getchar();
		return 0;
	}
	while(Video.isOpened()==true)//"True" numericamente es igual a 1
	{
		Video>>cuadro;//Obtiene un nuevo cuadro(fotograma) de la cámara
		
		//Analisis del cuadro(fotograma) obtenido en "Video>>cuadro;"
		if(cuadro.empty()==true)//"empty" devuelve verdadero si no hay elementos en el array y sale del bucle
		{
			break;
		}
		imshow("Tp3 Deslizador",cuadro);//Muestro el cuadro
		if(waitKey(30)>=0)//Si aprieto una tecla sale del bucle
		{
			break;
		}
		if(cuadro2>0)
		{
			createTrackbar("pocision del deslizador","Tp3 Deslizador",&posicion_del_deslizador,cuadro2,Control_Deslizante);
		}
	}
	return 0;
} 
//void Control(int posicion,void* hola()) si pongo aca la funcion cuando la llamo me tira error
//{
//	//Video.set(CV_CAP_PROP_POS_FRAMES,posicion_del_deslizador);
//}

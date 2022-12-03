#include <iostream>
#include<stdio.h>					
#include<stdlib.h>
#include<conio.h>
using namespace std;

//Este programa lee una cadena de caracter y nros con fscanf
int main(int argc, char *argv[]) 
{
	int Nro=0;
	char Cadena[10];
	FILE *Archivo; //Declaro el "Archivo" que voy a usar como puntero
	Archivo=fopen("Archivo.txt","r+"); //Abro el archivo si no exite el archivo Texto es NULL y entro al if de abajo
	if(Archivo==NULL) //En caso de que el archivo no exista
	{
		cout<<"Error al abrir el Archivo"<<endl<<"Se esta creando un nuevo Archivo"<<endl;
		Archivo=fopen("Archivo.txt","w+"); //w+ Abre el archivo y si extiste lo reemplaza pero como Texto es igua la NULL no existe y crea uno
		cout<<"Archivo creado"<<endl;
	}
	while(!feof(Archivo))
	{
		fscanf(Archivo,"%d%s",&Nro,&Cadena); //Extraigo los datos de Archivo de una sola linea y los guardo en Cadena y Nro
		cout<<Nro<<" "<<Cadena<<endl; //Imprimo el dato y salto a la line de abajo
	}
	fclose(Archivo); //Cierro el archivo
	return 0;
}

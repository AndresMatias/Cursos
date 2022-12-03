#include <iostream>
#include<stdio.h>					
#include<stdlib.h>
#include<conio.h>
using namespace std;

//Este programa lee caracter por caracter con fgetc
int main(int argc, char *argv[]) 
{
	int Dato=0;
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
	 fscanf(Archivo,"%d",&Dato);
	 cout<<Dato<<endl;
	}
	fclose(Archivo);  //Cierro el archivo
	return 0;
}

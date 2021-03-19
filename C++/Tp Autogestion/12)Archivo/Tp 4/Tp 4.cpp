#include <iostream>
#include<stdio.h>					
#include<stdlib.h>
#include<conio.h>
using namespace std;
//Este programa lee una cadena de caracter y nros con fscanf
void Escribir(FILE *Archivo,char *);
void Mostrar(FILE *Archivo,char *);
int main(int argc, char *argv[]) 
{
	char *Cadena;
	FILE *Archivo; //Declaro el "Archivo" que voy a usar como puntero
	Archivo=fopen("Archivo.txt","ab+"); //Abro el archivo y escribo al final 
	/*if(Archivo==NULL) //Si no exite el archivo Texto es NULL y entro al if de abajon caso de que el archivo no exista
	{
		cout<<"Error al abrir el Archivo"<<endl<<"Se esta creando un nuevo Archivo"<<endl;
		Archivo=fopen("Archivo.txt","wb+"); //w+ Abre el archivo y si extiste lo reemplaza pero como Texto es igua la NULL no existe y crea uno
		cout<<"Archivo creado"<<endl;
	}*/
	Cadena=new char[20];
	Escribir(Archivo,Cadena);
	Mostrar(Archivo,Cadena);
	return 0;
}

void Escribir(FILE *Archivo,char *Cadena)
{
	int Nro=0,Nro_1=0;
	fseek(Archivo,0,SEEK_END); //Me muevo al final del archivo
	Nro=ftell(Archivo); //Pregunto el nro de elementos del archivo
	rewind(Archivo); //Vuelvo al principio del archivo
	while(Nro_1!=3)
	{
		Nro_1++;
		cout<<"Ingrese Nombre y Apellido:";
		cin.getline(Cadena,20);
		cout<<endl;
		fwrite(Cadena,sizeof(Cadena),1,Archivo);
	}
}
void Mostrar(FILE *Archivo,char *Cadena)
{
	rewind(Archivo);
	//fseek(Archivo,0,SEEK_SET); //Me muevo al principio del archivo
	fread(Cadena,sizeof(Cadena),1,Archivo); //Leo la primera linea
	while(!feof(Archivo))
	{
		cout<<"Nombre y Apellido:"<<Cadena<<endl;
		fread(Cadena,sizeof(Cadena),1,Archivo); //Leo la siguiente Cadena
	}
	fclose(Archivo); //Cierro el archivo
}

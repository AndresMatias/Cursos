#include <iostream>
#include<stdio.h>					
#include<stdlib.h>
#include<conio.h>
using namespace std;
struct Archivo
{
	char Datos[20];
	int Edad;
};
int main(int argc, char *argv[]) 
{
	int Bandera=0;
	Archivo Persona;
	FILE *Texto; //Declaro el "Archivo" que voy a usar como puntero
	Texto=fopen("Archivo.txt","r+"); //Abro el archivo si no exite el archivo Texto es NULL y entro al if de abajo
		//Variable de FILE=fopen("Nombre del Archivo",Modo de apertura)
		/*Modo de Apertura:
		r :  Abre un archivo de texto para solo lectura. Si el archivo no existe, devuelve un error 
		w : Abre el archivo de texto para solo escritura. Si el archivo no existe, lo crea, y si existe lo machaca. 
		a : Abre el archivo de texto para añadir al final. Si el archivo no existe, lo crea. 
		r+: Abre el archivo de texto para lectura/escritura. Si el archivo no existe, da un error 
		w+: Abre el archivo de texto para lectura/escritura. Si el archivo no existe, lo crea, y si existe lo machaca. 
		a+: Abre el archivo de texto para añadir al final, con opción de lectura. Si el archivo no existe, lo crea. 
		rb: Abre un archivo binario para solo lectura. Si el archivo no existe, devuelve un error 
		wb: Abre el archivo binario para solo escritura. Si el archivo no existe, lo crea, y si existe lo machaca. 
		ab: Abre el archivo binario para añadir al final. Si el archivo no existe, lo crea. 
		rb+: Abre el archivo binario para lectura/escritura. Si el archivo no existe, da un error 
		wb+: Abre el archivo binario para lectura/escritura. Si el archivo no existe, lo crea, y si existe lo machaca. 
		ab+: Abre el archivo binario para añadir al final, con opción de lectura. Si el archivo no existe, lo crea.*/
	if(Texto==NULL) //En caso de que el archivo no exista
	{
		cout<<"Error al abrir el Archivo"<<endl<<"Se esta creando un nuevo Archivo"<<endl;
		Texto=fopen("Archivo.txt","w+"); //w+ Abre el archivo y si extiste lo reemplaza pero como Texto es igua la NULL no existe y crea uno
		cout<<"Archivo creado"<<endl;
	}
	else
	{
		fseek(Texto,0,SEEK_END); //Me muevo al final del archivo
	}
	while(Bandera!=1)
	{
		cout<<"Ingrese su nombre y apellido:";
		cin.getline(Persona.Datos,20);
		cout<<endl;
		cout<<"Ingrese su edad:";
		cin>>Persona.Edad;
		cout<<endl;
		cout<<"Presione 1 si desea salir:";
		cin>>Bandera;
		cout<<endl;
		cin.ignore(15,'\n');
		fwrite(&Persona,sizeof(Persona),1,Texto);
	}
	fseek(Texto,0,SEEK_SET); //Me muevo al principio del archivo
	fread(&Persona,sizeof(Persona),1,Texto);
	while(!feof(Texto))
	{
		cout<<"Nombre y Apellido:"<<Persona.Datos<<endl;
		cout<<"Edad:"<<Persona.Edad<<endl;
		fread(&Persona,sizeof(Persona),1,Texto);
	}
	fclose(Texto);
	return 0;
}


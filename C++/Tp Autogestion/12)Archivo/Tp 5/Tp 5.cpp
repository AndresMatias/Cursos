#include <iostream>
#include<stdio.h>					
#include<stdlib.h>
#include<conio.h>
using namespace std;

//Estructura de Datos
struct Persona
{
	int Edad,Valides;
	char Nombre[30],Sexo;
};

//Funciones
int Menu();
void Escribir(FILE *);
void Modificar(FILE *,FILE *);
void Imprimir(FILE *);

int main(int argc, char *argv[]) 
{	
	int Bandera_1=0;
	FILE *Archivo,*Archivo_Aux;//Archivo con el cual voy a trabajar 
	Archivo=fopen("Datos.txt","ab+"); //Abre un arhcivo al final para lectura/escritura sino existe lo crea
	Archivo_Aux=fopen("Auxiliar.txt","wb+"); //Abre el archivo para lectura y escritura , si no existe lo crea y si existe lo elemina y crea uno nuevo
	if(Archivo==NULL)
	{
		cout<<"Error el archivo no existe"<<endl;
		return(0);
	}
	while(Bandera_1!=4)
		{
		Bandera_1=Menu();
		switch(Bandera_1)
			{
			case 1:
				Escribir(Archivo);
				break;
			case 2:
				Modificar(Archivo,Archivo_Aux);
				break;
			case 3:
				Imprimir(Archivo);
				break;
			case 4:
				break;
			}
		}
	fclose(Archivo);
	fclose(Archivo_Aux);
	return(0);
}

int Menu()
{
	int Bandera_1=0;
	while((Bandera_1<1)||(Bandera_1>4))
	{
		cout<<"Para ingresar datos presione 1"<<endl;
		cout<<"Para borrar datos presione 2"<<endl;
		cout<<"Para imprimir datos presione 3"<<endl;
		cout<<"Para salir presione 4"<<endl;
		cout<<"Ingrese la opcion deseada: ";
		cin>>Bandera_1;
		cout<<endl;
	}
	return(Bandera_1);
}

void Escribir(FILE *Archivo_Aux)
{
	int Bandera_1=0;
	Persona P_Aux;
	fseek(Archivo_Aux,0,SEEK_END);
	while(Bandera_1!=1)
	{
		fflush(stdin);
		cout<<"Ingrese nombre y apellido: ";
		cin.getline(P_Aux.Nombre,30);
		cout<<endl;
		cout<<"Ingrese la edad: ";
		cin>>P_Aux.Edad;
		cout<<endl;
		P_Aux.Valides=true;
		P_Aux.Sexo='a';
		while((P_Aux.Sexo!='H')&&(P_Aux.Sexo!='M'))
		{
			fflush(stdin); //Limpio Buffer
			cout<<"Ingrese el sexo con la letra H(Hombre) o M(Mujer): ";
			cin.get(P_Aux.Sexo);
			cout<<endl;
		}
		fflush(stdin);
		fwrite(&P_Aux,sizeof(P_Aux),1,Archivo_Aux);  // le paso la direcion de memoria(&P_Aux) el tamaño(P_Aux) ver
		cout<<"Si desea salir al menu presione 1: ";
		cin>>Bandera_1;
		cout<<endl;
		//cout<<"Nombre y Apellido: "<<P_Aux.Nombre<<endl;
	}
}

void Modificar(FILE *Archivo,FILE *Archivo_Aux)
{
	int Bandera=0,Bandera_1=0;
	Persona P_Aux_1;
	while((Bandera<1)||(Bandera>3))
	{
		cout<<"Si desea eliminar archivos presione 1"<<endl;
		cout<<"Si desea modificar archivos presione 2"<<endl;
		cout<<"Para salir al menu presione 3"<<endl;
		cout<<"Seleccione una opcion:";
		cin>>Bandera;
		cout<<endl<<endl;
	}
	switch(Bandera)
	{
	case 1:
		fseek(Archivo,0,SEEK_SET); //Me paro al principio del Archivo
		fseek(Archivo_Aux,0,SEEK_SET);
		fread(&P_Aux_1,sizeof(P_Aux_1),1,Archivo);
		while(!feof(Archivo))
		{
			Bandera_1=0;
			cout<<ends<<"Nombre y Apellido: "<<P_Aux_1.Nombre<<endl;
			cout<<ends<<"Edad: "<<P_Aux_1.Edad<<endl;
			cout<<ends<<"Genero: "<<P_Aux_1.Sexo<<endl;
			cout<<"Para eliminar presione 1 sino otro ingrese otro numero:";
			cin>>Bandera_1;
			cout<<endl;
			if(Bandera_1==1)
			{
				P_Aux_1.Valides=false;
			}
			else
			{
				fwrite(&P_Aux_1,sizeof(P_Aux_1),1,Archivo_Aux);
			}
			fread(&P_Aux_1,sizeof(P_Aux_1),1,Archivo);
		}
		fclose(Archivo_Aux);
		fclose(Archivo); //Cierro los archivos para poder eliminar y renombrar la base de datos "Datos.txt"
		remove("Datos.txt");
		rename("Auxiliar.txt","Datos.txt");
		remove("Auxiliar.txt");
		Archivo=fopen("Datos.txt","ab+");
		break;
	case 2:
		fseek(Archivo,0,SEEK_SET); //Me paro al principio del Archivo
		fseek(Archivo_Aux,0,SEEK_SET);
		fread(&P_Aux_1,sizeof(P_Aux_1),1,Archivo);
		while(!feof(Archivo))
		{
			Bandera_1=0;
			cout<<ends<<"Nombre y Apellido: "<<P_Aux_1.Nombre<<endl;
			cout<<ends<<"Edad: "<<P_Aux_1.Edad<<endl;
			cout<<ends<<"Genero: "<<P_Aux_1.Sexo<<endl;
			cout<<"Para modificar presione 1 sino otro ingrese otro numero:";
			cin>>Bandera_1;
			cout<<endl;
			if(Bandera_1==1)
			{
				fflush(stdin);
				cout<<"Ingrese nombre y apellido: ";
				cin.getline(P_Aux_1.Nombre,30);
				cout<<endl;
				cout<<"Ingrese la edad: ";
				cin>>P_Aux_1.Edad;
				cout<<endl;
				P_Aux_1.Valides=true;
				P_Aux_1.Sexo='a';
				while((P_Aux_1.Sexo!='H')&&(P_Aux_1.Sexo!='M'))
				{
					fflush(stdin); //Limpio Buffer
					cout<<"Ingrese el sexo con la letra H(Hombre) o M(Mujer): ";
					cin.get(P_Aux_1.Sexo);
					cout<<endl;
				}
			}
			fwrite(&P_Aux_1,sizeof(P_Aux_1),1,Archivo_Aux);
			fread(&P_Aux_1,sizeof(P_Aux_1),1,Archivo);
		}
		fclose(Archivo_Aux);
		fclose(Archivo); //Cierro los archivos para poder eliminar y renombrar la base de datos "Datos.txt"
		remove("Datos.txt");
		rename("Auxiliar.txt","Datos.txt");
		remove("Auxiliar.txt");
		Archivo=fopen("Datos.txt","ab+");
		break;
	case 3:
		break;
	}
	
}

void Imprimir(FILE *Archivo_Aux)
{
	Persona P_Aux_2;
	fseek(Archivo_Aux,0,SEEK_SET); //Me paro al principio del archivo
	fread(&P_Aux_2,sizeof(P_Aux_2),1,Archivo_Aux);
	while(!feof(Archivo_Aux))
	{
		cout<<endl<<endl;
		cout<<"Nombre y Apellido: "<<P_Aux_2.Nombre<<endl;
		cout<<"Edad: "<<P_Aux_2.Edad<<endl;
		cout<<"Genero: "<<P_Aux_2.Sexo<<endl;
		fread(&P_Aux_2,sizeof(P_Aux_2),1,Archivo_Aux);
	}
	cout<<endl<<endl;
}


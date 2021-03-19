#include <iostream>
#include <stdio.h>
#include <stdlib.h>
using namespace std;
//Nota: Siempre trabajar con un fichero auxiliar para copiar todo por cuestienes de evitar errores
//Estructura De Datos
struct Datos
{
	char Dato[30];
};

//Funciones
int Menu(int);
void Escritura(FILE *,Datos *);
void Lectura(FILE *,Datos *);
void Modificar(FILE *,FILE *,Datos *);
void Borrar(FILE *,FILE *,Datos *);

int main(int argc, char *argv[]) 
{
	int B_1=0;
	FILE *Archivo,*Archivo_Aux;
	Datos *D=new Datos(); //Creo el Nodo
	Archivo=fopen("Datos.txt","ab+");
	while(B_1!=5)
	{
		B_1=Menu(1);
		switch(B_1)
		{
		case 1:
			cout<<"Presione 1 para dejar de ingresar datos cuando lo desee"<<endl;
			D->Dato[0]='a';
			fseek(Archivo,0,SEEK_END);
			while(D->Dato[0]!='1')
			{
				Escritura(Archivo,D); 			//Asi reutilizo el codigo si lo necesito
			}
			break;
		case 2:
			Lectura(Archivo,D);
			break;
		case 3:
			Archivo_Aux=fopen("Auxiliar.txt","wb+");
			Modificar(Archivo,Archivo_Aux,D);
			break;
		case 4:
			Archivo_Aux=fopen("Auxiliar.txt","wb+");
			Borrar(Archivo,Archivo_Aux,D);
			break;
		case 5:
			break;
		}
	}
	fclose(Archivo);
	return 0;
}
int Menu(int B_1)
{
	int B_2=0;
	switch(B_1)
	{
	case 1: 	//Menu Principal
		while((B_2<1)||(B_2>5))
		{
			cout<<endl;
			cout<<"Presione 1 para ingresar nuevos datos:"<<endl;
			cout<<"Presione 2 para leer nuevos datos:"<<endl;
			cout<<"Presione 3 para modificar datos:"<<endl;
			cout<<"Presione 4 para borrar datos:"<<endl;
			cout<<"Presione 5 para salir:"<<endl;
			cin>>B_2;
			cout<<endl;
		}
		return(B_2);
		break;
	}
	return(0);
}

void Escritura(FILE *Archivo,Datos *D)
{
	fflush(stdin);
	cout<<"Ingrese los datos: ";
	cin.getline(D->Dato,30);
	cin.sync(); //Sincronizo 
	cin.clear();//Limpio el buffer
	if(D->Dato[0]!='1')
	{
		fwrite(D,sizeof(*D),1,Archivo);
	}
	cout<<endl;
}
void Lectura(FILE *Archivo,Datos *D)
{
	fseek(Archivo,0,SEEK_SET);
	cout<<endl<<endl;
	while(!feof(Archivo))
	{
		fread(D,sizeof(*D),1,Archivo);
		if(!feof(Archivo))
		{
			cout<<"Datos: "<<D->Dato<<endl;
		}
	}
}
void Modificar(FILE *Archivo,FILE *Archivo_Aux,Datos *D)
{
	int Tam=0,N=0,i=0;
	fseek(Archivo,0,SEEK_END);
	Tam=ftell(Archivo)/sizeof(*D);
	cout<<"Existe "<<Tam<<" estructuras"<<endl;
	cout<<"Ingrese el numero de la estructura que desea modificar: ";
	cin>>N;
	cout<<endl;
	fseek(Archivo,0,SEEK_SET);
	while(!feof(Archivo))
	{
		i++;
		fread(D,sizeof(*D),1,Archivo);
		if(!feof(Archivo))
		{
			if(i!=N)
			{
				fwrite(D,sizeof(*D),1,Archivo_Aux);
			}
			else
			{
				Escritura(Archivo_Aux,D);
			}
		}
	}
	fclose(Archivo);
	fclose(Archivo_Aux);
	remove("Datos.txt");
	rename("Auxiliar.txt","Datos.txt");
	remove("Auxiliar.txt");
	Archivo=fopen("Datos.txt","ab+");
}
void Borrar(FILE *Archivo,FILE *Archivo_Aux,Datos *D)
{
	fflush(stdin);
	int Tam=0,N=0,i=0;
	fseek(Archivo,0,SEEK_END); //Me posiciono al final para usar ftell y ver cuantos elementos hay
	Tam=(ftell(Archivo)/sizeof(Datos));
	fseek(Archivo,0,SEEK_SET);
	fseek(Archivo_Aux,0,SEEK_SET);
	cout<<"Existe "<<Tam<<" estructuras"<<ends<<Tam<<endl;
	cout<<"Ingrese el numero de la estructura que desea borrar: ";
	cin>>N;
	cout<<endl;
	while(!feof(Archivo))
	{
		i++;
		fread(D,sizeof(*D),1,Archivo);
		if(!feof(Archivo))
		{
			if(i!=N)
			{
				fwrite(D,sizeof(*D),1,Archivo_Aux);
			}
		}
	}
	fclose(Archivo);
	fclose(Archivo_Aux);
	remove("Datos.txt");
	rename("Auxiliar.txt","Datos.txt");
	remove("Auxiliar.txt");
	Archivo=fopen("Datos.txt","ab+");
}

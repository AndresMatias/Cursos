#include <iostream>
#include <stdio.h>
#include <stdlib.h>
using namespace std;

class Pila
{
private:
	struct Nodo
	{
		int Dato;
		Nodo *Anterior=NULL;	
	};
	Nodo *Base=NULL,*Mem=NULL;
	int Bandera_1,i,j;
public:
	void Crear_Nodo();
	void Borrar_Nodo();
	void Mostrar_Pila();
};
int main(int argc, char *argv[]) 
{
	int Bandera=0;
	Pila P1;
	while(Bandera==0)
	{
		while((Bandera<1)||(Bandera>5)) //Menu Principal
		{
			cout<<"A)Presione 1 para crear un nodo(ingrese -1 para salir mientras ingresa los datos)"<<endl;
			cout<<"B)Presione 2 para borrar un nodo"<<endl;
			cout<<"C)Presione 3 para imprimir la pila"<<endl;
			cout<<"D)Presione 4 para salir del programa"<<endl;
			cout<<"Seleccione una opcion:";
			cin>>Bandera;
			cout<<endl<<endl;
		}
		switch(Bandera)
		{
			case 1:
				P1.Crear_Nodo();
				Bandera=0;
				break;
			case 2:
				P1.Borrar_Nodo();
				Bandera=0;
				break;
			case 3:
				P1.Mostrar_Pila();
				Bandera=0;
				break;
			case 4:
				break;
		}
	}
	return 0;
}

void Pila::Crear_Nodo()
{
	int Dato_Aux=0;
	Bandera_1=0;
	while(Bandera_1!=-1) //Creo nuevos nodos
	{
		cout<<"Ingrese el dato:";
		cin>>Dato_Aux;
		cout<<endl;
		Bandera_1=Dato_Aux;
		if(Dato_Aux!=-1)
		{
		Mem=new Nodo();
		Mem->Dato=Dato_Aux;
		Mem->Anterior=Base;
		Base=Mem;
		Mem=NULL;
		}
	}
}
void Pila::Borrar_Nodo()
{
	Bandera_1=0;
	while(Bandera_1!=-1) //Borro los nodos
	{
		cout<<"Ingrese -1 para salir:";
		cin>>Bandera_1;
		cout<<endl;
		if(Bandera_1!=-1)
		{
			Mem=Base->Anterior;
			delete(Base);
			Base=Mem;
			cout<<"Nodo Borrado"<<endl;
			if(Mem==NULL)
			{
				Bandera_1=-1;
			}
		}
	}
}
void Pila::Mostrar_Pila()
{
	Mem=Base;
	while(Mem!=NULL) //Muestro los Datos
	{
		cout<<Mem->Dato<<endl;
		Mem=Mem->Anterior;
	}
}

#include <iostream>
using namespace std;

struct Nodo
{
	int Dato;
	struct Nodo *Siguiente;
};
int main(int argc, char *argv[]) 
{
	Nodo *Base=NULL,*Nodo_N=NULL,*Nodo_Aux=NULL; //Declaro las variables struct como punteros
	int i=0,Dato_Aux;	
	cout<<"Para salir ingrese -1"<<endl;
	while(Dato_Aux!=-1)
	{
		cout<<"Ingrese el dato:";
		cin>>Dato_Aux;
		cout<<endl;
		i++;
		if(i==1)	//Creo el primer nodo
		{
			Nodo_Aux=new Nodo();	//Como el programa pasa pro aca una sola vez creo el nodo auxiliar para los demas nodos
			Nodo_Aux->Dato=Dato_Aux;
			Nodo_Aux->Siguiente=NULL;
			Base=Nodo_Aux;
		}
		if((Dato_Aux!=-1)&&(i!=1))
		{
			Nodo_N=new Nodo();
			Nodo_N->Dato=Dato_Aux;
			Nodo_N->Siguiente=NULL;
			Nodo_Aux->Siguiente=Nodo_N;	
			Nodo_Aux=Nodo_N;
		}
	}
	Nodo_Aux=Base;
	while(Nodo_Aux!=NULL)
	{
		cout<<"Dato:"<<Nodo_Aux->Dato<<endl;
		Nodo_Aux=Nodo_Aux->Siguiente;
	}
	return 0;
}


#include <iostream>
using namespace std;

struct Nodo
{
	char Dato;
	struct Nodo *Siguiente;
		
};
int main(int argc, char *argv[]) 
{
	char Bandera='a';
	Nodo *N=NULL,*Base=NULL;
	cout<<"Ingrese los datos debajo:"<<endl;
	while(Bandera!='s')		//Cargo los Datos
	{
		cin>>Bandera;
		if(Bandera!='s')
		{
			N=new Nodo();
			N->Dato=Bandera;
			N->Siguiente=Base;
			Base=N;
		}
	}
	cout<<endl<<endl;
	while(N!=NULL) //Muestro los Datos
	{
		cout<<N->Dato<<endl;
		N=N->Siguiente;
	}
	return 0;
}


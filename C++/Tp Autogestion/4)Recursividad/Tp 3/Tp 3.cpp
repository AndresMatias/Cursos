#include <iostream>
using namespace std;

int Algoritmo_de_Euclides(int,int);
int main(int argc, char *argv[]) 
{
	int Numerador=0,Denominador=0,Resultado=0;
	cout<<"Ingrese el numerador:";
	cin>>Numerador;
	cout<<endl;
	cout<<"Ingrese el denominador menor al numerador:";
	cin>>Denominador;
	cout<<endl;
	while(Denominador>=Numerador)
	{
		cout<<"Ingrese el denominador menor al numerador:";
		cin>>Denominador;
		cout<<endl;
	}
	Resultado=Algoritmo_de_Euclides(Numerador,Denominador);
	cout<<"Maximo Comun Multiplo:"<<Resultado<<endl;
	return 0;
}

int Algoritmo_de_Euclides(int N,int D)
{
	int Aux_1=0;
	Aux_1=D;//Si D!=0 el denominador se almacena en Aux_2 y se carga en Algoritmo_de_Euclides como numerador
	D=N%D; //Modulo:Devuelve el resto de la division y se alamacena en el Denominador
	if(D==0)
	{
		return(Aux_1);
	}
	else
	{
		Algoritmo_de_Euclides(Aux_1,D);
	}
}

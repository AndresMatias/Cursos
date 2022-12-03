#include <iostream>
#include <stdio.h>
#include <stdlib.h>
using namespace std;
class Vector
{
 private: //Atributos
	int Arreglo[10];
 public: //Metodos
	Vector(){for(int i=0;i<10;i++){Arreglo[i]=0;}} //Inicializo el vector a cero con el constructor
	void Cargar_Arreglo();
	void Mostrar_Arreglo();
	void Comparacion_Arreglo(int *,int *,int *,int *);
};

int main(int argc, char *argv[]) 
{
	int Mayor=0,Menor=0,Posicion_Mayor=0,Posicion_Menor=0; //Luego paso la direccion de memoria con "&" para trabajar con punteros en la funcion comparar y poder mostrar los datos en el main
	Vector Vec_1; //Uso Vec_1 que es la "Variable Vector seria como el "Tipo de Dato"
	Vec_1.Cargar_Arreglo();
	Vec_1.Mostrar_Arreglo();
	Vec_1.Comparacion_Arreglo(&Mayor,&Menor,&Posicion_Mayor,&Posicion_Menor);
	cout<<"Dato Mayor:"<<Mayor<<endl<<"Posicion del dato mayor: "<<Posicion_Mayor<<endl; //NO poner el puntero con * en cout proque genera error
	cout<<"Dato Menor:"<<Menor<<endl<<"Posicion del dato menor: "<<Posicion_Menor<<endl;
	return 0;
}

void Vector::Cargar_Arreglo()
{
	int i=0;
	for(i=0;i<10;i++)
	{
		cout<<"Ingrese el Dato Nro "<<i+1<<":";
		cin>>Arreglo[i];
		cout<<endl;
	}
}
void Vector::Comparacion_Arreglo(int *Mayor_Aux,int *Menor_Aux,int *Pos_Mayor,int *Pos_Menor)
{
	int Dato_Aux_1=0,Dato_Aux_2,i=0;
	Dato_Aux_1=Arreglo[1]; //Para la posicion menor en vez de 0 pongo 1 nose proque pero asi funciona
	Dato_Aux_2=Arreglo[1]; //Para la posicion mayor
	for(i=0;i<10;i++)
	{
		if(Dato_Aux_1>Arreglo[i])
		{
			Dato_Aux_1=Arreglo[i];
			*Menor_Aux=Dato_Aux_1;
			*Pos_Menor=(i+1);
		}
		if(Dato_Aux_2<Arreglo[i])
		{
			Dato_Aux_2=Arreglo[i];
			*Mayor_Aux=Arreglo[i];
			*Pos_Mayor=(i+1);
		}
	}
	
}
void Vector::Mostrar_Arreglo()
{
	int i=0;
	for(i=0;i<10;i++)
	{
		cout<<"Dato Nro "<<i+1<<":"<<Arreglo[i]<<endl;
	}
}

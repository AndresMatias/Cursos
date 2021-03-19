#include <iostream>
#include <stdio.h>
#include <math.h> //Para funcion pow
using namespace std;
class Coordenadas
{
 private: //Atributos: Variables
	int x,y;
	float d;
 public: //Metodos: Funciones para acceder a los atributos(variables)
	Coordenadas(){x=0;y=0;d=0;};
	void Leer_Coordenadas();
	void Mostrar_Coordenadas();
	void Calcular_Distancia();
};
int main(int argc, char *argv[]) 
{
	Coordenadas Clase_1;
	Clase_1.Leer_Coordenadas();
	Clase_1.Calcular_Distancia();
	Clase_1.Mostrar_Coordenadas();
	return 0;
}

void Coordenadas::Leer_Coordenadas()
{
	cout<<"Ingrese x:";
	cin>>x;
	cout<<endl;
	cout<<"Ingrese y:";
	cin>>y;
	cout<<endl;
}
void Coordenadas::Mostrar_Coordenadas()
{
	cout<<"x:"<<x<<endl;
	cout<<"y:"<<y<<endl;
	printf("d:%f.2",d); //Uso printf para limitar los decimales del float
	fflush(stdin);	//Limpio el buffer ya que printf no limpia el buffer luego de ejecutarse
}
void Coordenadas::Calcular_Distancia()
{
	d=pow(x,2)+pow(y,2);
	d=sqrt(d);
}

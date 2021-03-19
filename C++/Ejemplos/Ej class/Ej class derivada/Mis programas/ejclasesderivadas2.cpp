#include <iostream>
using namespace std;
class base	//Clase "base"
{
	protected:
		int x;
		int y;
	public:
		base();	//Constructor
		int imprimir1();		
};
class herencia:public base		//Clase "Herencia" hereda a "base"
{
	protected:
		int z;
	public:
		herencia();			//Constructor 
		int imprimir2();
};
int main(int argc, char *argv[]) //Cuerpo del programa
{
	//class base b;	//Creo una clase "base" llamada "b"
	class herencia h;	//Creo una clase "herencia" llamada "h"
	//b.imprimir1();
	//h.imprimir1();	//hereda la funcion imprimir de la clase base
	h.imprimir2();
	return 0;
}

base::base()	//Contructor de clase base
{
	cout<<"\nIngrese x:";
	cin>>x;
	cout<<"\nIngrese y:";
	cin>>y;
}
int base::imprimir1() 		
{
	cout<<x<<y<<"\n";	
	return(0);
}
herencia::herencia()	//Constructor de clase herencia los al inicializar una clase la programacion en lso contuctores se ejecutara independientemente si el usuario llamo o no a la clase
{
	cout<<"\nIngrese z:";
	cin>>z;
}
int herencia::imprimir2()
{
	imprimir1(); //puedo llamar a la funcion de base 
	cout<<"\n"<<x<<y<<z<<"\n";
	return(0);
}


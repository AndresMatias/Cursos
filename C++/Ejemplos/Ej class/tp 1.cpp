//Diseñar un progrma que contenga un tpo de dato entero que lo lea he imprima
using namespace std;
#include <iostream>
#include <stdlib.h>

class demo
{
	int a;
	public:
	demo();		//Constructor
	int impresion();  //Funsion impresion
};

int main()
{
	class demo e1; 
	e1.impresion();
	return 0;
}
int demo::impresion()
{	
	cout<< "Nro:";
	cout<< a ;
	return 0;
}
demo::demo()
{
	cout<< "Ingrese el Nro:";
	cin>> a ;
}

	

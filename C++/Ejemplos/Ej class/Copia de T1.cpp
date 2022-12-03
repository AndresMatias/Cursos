/*Codificar un programa que defina una clase que tenga un tipo de dato entero y lo lea o imprima*/
using namespace std;
#include <iostream>

class entero{
int i;
public:
entero();
int impresion();
};

int main()
{
	class entero e1=entero();
	e1.impresion();
};

int entero::impresion(){
	cout<<i;
	return 0;
};

entero::entero(){
	cin>>i;

};

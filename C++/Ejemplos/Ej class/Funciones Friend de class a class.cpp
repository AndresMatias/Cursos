#include <iostream>
using namespace std;
class prueba2;

class prueba1
{
		int a;
	public:
		prueba1(){};			//Constructor
		int imprimir(prueba2 p2);		
};
class prueba2
	{
		int b;
		friend int prueba1::imprimir(prueba2 p2);
	public:
		prueba2(){};	//Constructor
		void imprimir1();
	};
int main(int argc, char *argv[])
{
	class prueba1 p1;
	class prueba2 p3;
	p1.imprimir(p3);
	p3.imprimir1();
	return 0;
}

int prueba1::imprimir(prueba2 p2)		
{
	p2.b=2;
	cout<<p2.b;
	return (0);
}
void prueba2::imprimir1()
{
	cout<<"\nholaaa";
}	

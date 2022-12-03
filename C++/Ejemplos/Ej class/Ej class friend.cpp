#include <iostream>
using namespace std;

class prueba1
{
		int a;
		friend class prueba2;
	public:
			prueba1()			//Constructor
				{
					a=0;
				};
			
			
	
};
class prueba2
{
		int b;
		class prueba1 p1;
	public:
		prueba2(){};		//Constructor
		int imprimir()		//accede a la variable de la funcion de prueba 1
			{
				cout<<p1.a;
				p1.a=2;				
				cout<<p1.a;
				return(0);
			};		
};


int main()
{
	class prueba2 p2;	
	p2.imprimir();
	return 0;
}


#include <iostream>
using namespace std;
class base
{
	protected:
		int a;
	public:
		base(int edad){a=edad;};
		int imprimir()
		{
			cout<<"\n";
			cout<<"Su Edad1:"<< a;
			cout<<"\n";
		};
};
class derivada1:public base
{
	protected:
		int b;
	public:
		derivada1(int edad,int FDN):base(edad){b=FDN;};    /*FDN:Fecha de nacimiento*/
		int imprimir()
		{
			cout<<"\n";
			cout<<"Su Edad2:"<<a;
			cout<<"\n";
			cout<<"Su Fecha de Nacimiento2:"<<b;
			cout<<"\n";
		};
};
class derivada2:public derivada1
	{
	protected:
		int c;
	public:
		derivada2(int edad,int FDN,int DNI):derivada1(edad,FDN){c=DNI;};   
		int imprimir()
		{
			cout<<"\n";
			cout<<"Su Edad3:"<<a;
			cout<<"\n";
			cout<<"Su Fecha de Nacimiento3:"<<b;
			cout<<"\n";
			cout<<"Su Documento3:"<<c;
			cout<<"\n";
		};
	};	


int main(int argc, char *argv[]) 
{
	
	class base e1(4);
	class derivada1 e2(2,1);
	class derivada2 e3(3,2,1);
	e1.imprimir();
	e2.imprimir();
	e3.imprimir();
	return 0;
}


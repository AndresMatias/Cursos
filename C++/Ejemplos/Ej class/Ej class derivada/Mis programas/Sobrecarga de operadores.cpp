#include <iostream>
#include <stdio.h>
#include <stdlib.h>
using namespace std;
class sobrecarga
{
		int r;	//Num real
		int i;	//Num imaginario
	public:
		sobrecarga(int a,int b);
		sobrecarga operator+(sobrecarga z);
		void Mostrar();

									
};
int main(int argc, char *argv[]) 
{
	int a,b,c,d;
	cout<<"\nIngrese los numeros reales e imaginarios\n";
	cin>>a>>b>>c>>d;
	class sobrecarga c1(a,b);
	class sobrecarga c2(c,d);
	class sobrecarga c3(0,0);
	c3=c1+c2;
	fflush(stdin);
	c3.Mostrar();
	
}

sobrecarga::sobrecarga(int a,int b)
{
	r=a;
	i=b;	
}
sobrecarga sobrecarga::operator+(sobrecarga z) //La clase "z" toma lso valores de c2;
{
	r=r+z.r;
	i=i+z.i;
	cout<<"\n"<<r<<"+"<<i<<"i";
	sobrecarga Resultado=sobrecarga(r,i);
	return Resultado;
	
}
void sobrecarga::Mostrar()
{
	cout<<"\n"<<r<<"+"<<i<<"i";
}

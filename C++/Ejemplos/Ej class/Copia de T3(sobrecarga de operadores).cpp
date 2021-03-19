/*sobrecarga de operadores:redefina el campo de operacion de nuevos operadores*/
/*codificar un programa que defina una clase complex(num complejos) que contenga 2 
variables mienbro 1 para parte real y otra para parte complejo, una funcion 
constructor una funcion de impresion y un operador cargado para la suma*/
using namespace std;
#include<stdio.h>
#include<stdlib.h>
#include <iostream>

class complex 
{
	float re;
	float im;
	
	public:
	complex(float a, float b);
	int print(){cout<<re<<"+"<<im<<"j";};
	complex operator+(complex z);
};


complex::complex(float a, float b)
{
re=a;
im=b;
}


complex complex::operator+(complex z)
{
	/*opcion 2:
	  complex rdo=complex(0,0);*/
	  /*opcion 1:*/
	re=re+z.re;
	im=im+z.im;
	complex rdo=complex(re,im);
	/*opcion 2:
	  rdo.re=re+z.re;
	  rdo.im=im+z.im;*/

	return rdo;
}
	
int main()
{
	float a,b,c,d;
	cin>>a>>b>>c>>d;
	class complex c1=complex(a,b);
	class complex c2=complex(c,d);

	c1.print();
	cout<<"\n";
	c2.print();
	cout<<"\n";
	c1=c1+c2;  
	cout<<"\n";
	c1.print();
	/*ó c1.operator +(c2)*/
}
	

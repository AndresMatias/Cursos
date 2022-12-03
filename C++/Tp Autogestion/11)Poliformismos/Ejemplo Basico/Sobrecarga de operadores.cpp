#include <iostream>
#include <stdio.h>
#include <stdlib.h>
using namespace std;

//Funciona
class sobrecarga
{
		int r;	//Num real
		int i;	//Num imaginario
	public:
		sobrecarga(int a,int b);
		sobrecarga operator+(sobrecarga z);
		sobrecarga operator-(sobrecarga z);
		void Mostrar();

									
};
int main(int argc, char *argv[]) 
{
	int a,b,c,d;
	cout<<"\nIngrese los numeros reales e imaginarios\n";
	cin>>a>>b>>c>>d;
	class sobrecarga c1(a,b);
	class sobrecarga c2(c,d);
	class sobrecarga c3(c,d);
	class sobrecarga c4(c,d);
	class sobrecarga c5(0,0);
	c5=c1+c2+c3+c4;
	c5.Mostrar();
	c5=c1-c2-c3-c4;
	c5.Mostrar();
	
}

sobrecarga::sobrecarga(int a,int b)
{
	r=a;
	i=b;	
}
sobrecarga sobrecarga::operator+(sobrecarga z) //La clase "z" toma lso valores de c2, y los valores de c1 son tomados por "r" e "i"
{
	int r_aux,i_aux; //Variables auxiliares para no modificar al "r" e "i" ya que estos pertenecen a c1 
	r_aux=r+z.r;
	i_aux=i+z.i;
	sobrecarga Resultado=sobrecarga(r_aux,i_aux);
	return Resultado;
}
sobrecarga sobrecarga::operator-(sobrecarga z) //La clase "z" toma lso valores de c2, y los valores de c1 son tomados por "r" e "i";
{
	int r_aux,i_aux; //Variables auxiliares para no modificar al "r" e "i" ya que estos pertenecen a c1 
	r_aux=r-z.r;
	i_aux=i-z.i;
	sobrecarga Resultado=sobrecarga(r_aux,i_aux);
	return Resultado;
	
}
void sobrecarga::Mostrar()
{
	cout<<"\n("<<r<<")+("<<i<<"i)";
}

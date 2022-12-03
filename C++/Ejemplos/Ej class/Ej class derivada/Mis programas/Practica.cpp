#include <iostream>
#include <stdio.h>
#include <stdlib.h>
using namespace std;
class herencia;			//Declaracion previa de "herencia" para poderla declararla a "herencia" como amiga de "amigo"
void amigo(herencia);	//Funcion amiga de herencia declaro con el operador & para tratarlo como puntero
class amigo		//Clase "herencia" amiga de Clase "amigo"
{
	int suma;
	//class herencia h2();	// No la uso pero puedo llegar a usarla si quiero 
public:
	amigo();	//Constructor
	int datos3(herencia h1);
	void imprimir();
};
class base		//Clase "base"
{
protected:
		int x;
		int y;	
	public:
		base();		//Constructor
		int datos1();
		void imprimir();
			
};
class herencia:public base
{
	protected:
		int z;
		int *v;		//Vector
		int tam;	//Tamaño del vector
		friend void amigo(herencia);	//Declaro a "amigo" como amigo de "herencia"
		friend class amigo;	//Declaro a "amigo" como amigo de "herencia"
	public:
		herencia();		//Constructor
		int datos2();
		void imprimir();
};
int main(int argc, char *argv[]) 
{
	class herencia h;
	class amigo a;
	h.datos2();
	a.datos3(h);
	h.imprimir();			//Llamo a la funcion imprimir de herencia
	cout<<"\n";
	h.base::imprimir();		//Llamo a la funcion imprimir de base poliformismo
	a.imprimir();
	amigo(h);
	return 0;
}

base::base()		//Uso constructor para inicializar a cero las variable de "base"
{
	x=0;
	y=0;
}	

int base::datos1()	//Funcion "datos1"
{
	cout<<"\nIngrese x:";	//Ingreso x;
	cin>>x;
	cout<<"\nIngrese y:";	//Ingreso y;
	cin>>y;
	return(0);
}

void base::imprimir()	//Funcion "imprimir" preteneciente a "base"
{
	cout<<x<<"\t"<<y<<"\n";	//Imprimo x,y
}

herencia::herencia():base()	//Uso constructor para inicializar a cero las variable de "base" y "herencia"
{
	z=0;		//En el construtor "herencia" se incluye la programacion del constructor "base" al ser heredado
}	

int herencia::datos2()	//Funcion "datos2"
{
	int i=0;
	datos1();										//Llamo a la funcio nde "datos1" de bae para ingresar x,y;
	cout<<"\nIngrese z:";							//Ingreso variable z;
	cin>>z;
	cout<<"\nIngrese el tamaño del vector:";		//Ingreso vector
	cin>>tam;
	v=new int(tam);			
	for(i=0;i<tam;i++)
	{
		v[i]=rand()&50;		//Genero vector con numeros aleatoreos con funcion rand el &50 es para numeros entre 1 y 50
	}
	//'a.suma=3;
	return(0);
}

void herencia::imprimir()	//Funcion "imprimir" preteneciente a "herencia"
{
	base::imprimir();				//Poliformismo llamo a la funcion imprimir pero de la clase base
	cout<<"\n"<<x<<"\t"<<y<<"\t"<<z<<"\n";		//Imprimo x,y,z tambien puedo imprimir solo z y llamara imprimir de la clase base uso poliformismo en el main o aca lo use en los dos para un ejemplo	
}

amigo::amigo()	//Constructor de la clase "amigo" lo uso para inicializar suma a cero
{
	suma=0;
}	

int amigo::datos3(herencia h2)	//Funcion "datos3" de la clase "amigo" 
{
	suma=h2.x+h2.y+h2.z;
	return(0);
}

void amigo::imprimir()	//Funcion "imprimir" de la clase "amigo" 
{
	cout<<"\nResultado de la funcion 'imprimir' de la clase 'amigo':"<<suma;
}
 
void amigo(herencia E)	//Funcion amiga
{
	int i=0,tam=0;
	tam=E.tam;
	cout<<"\nTam:"<<tam<<"\tVector:\n";	
	for(i=0;i<tam;i++)
		{
			cout<<"\n"<<E.v[i];
		}
}	

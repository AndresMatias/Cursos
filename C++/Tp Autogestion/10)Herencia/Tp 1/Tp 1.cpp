#include <iostream>
using namespace std;
class Punto
{
protected: //Con protected puedo acceder a las variables directamente desde una funcion de una clase derivada con private no puedo hacer eso
	int x,y;
public:
	Punto();
	void Imprimir_1();
};
class Circunferencia:public Punto
{
 private:
	int Radio;
 public:
	 Circunferencia();
	 void Imprimir_2();
};
int main(int argc, char *argv[]) 
{
	Circunferencia C1;
	C1.Imprimir_2(); //Circunferencia heredo los metodos de Punto
	return 0;
}

Punto::Punto()
{
	cout<<"Ingrese x:";
	cin>>x;
	cout<<endl;
	cout<<"Ingrese y:";
	cin>>y;
	cout<<endl;
}
void Punto::Imprimir_1()
{
	cout<<"x:"<<x<<endl;
	cout<<"y:"<<y<<endl;
}

Circunferencia::Circunferencia() //Cuando llamo al a clases de Circunferencia pro defecto el constructor se llama actomaticamente
{								 //y como "Circunferencia" heredo los metodos de "Punto", el constructor de "Punto" se llama automaticamente
	cout<<"Ingrese el radio:";
	cin>>Radio;
	cout<<endl;
}
void Circunferencia::Imprimir_2()
{
	cout<<endl<<x<<y<<Radio<<endl;
	Imprimir_1(); //En caso que no tenga protected en clase "Punto" llamo a la funcion
}

#include <iostream>
using namespace std;
//Clase Base
class Base
{
private:
	int x;
public:
	virtual void Cargar_Datos(); //Introdusco "virtual" en la clase base solo funciona con punteros
};
//Clase Hija_1
class Hija_1:public Base
{
private:
	int y;
public:
	void Cargar_Datos();
};

int main(int argc, char *argv[]) 
{
	Base *B=new Hija_1();
	Hija_1 H_1;
	B->Base::Cargar_Datos(); //Accedo al metodo "Cargar_Datos" de la clase "Base"
	B->Cargar_Datos(); //EL metodo "Cargar_Datos" de la clase "Base" esta declarada con la palabra virtual esto me permite
	return 0;		   //acceder al metodo "Cargar_Datos" de la clase "Hija_1" siempre cuando trabaje con punteros
			  
}

void Base::Cargar_Datos()
{
	x=0;
	cout<<"Base"<<endl;
}
void Hija_1::Cargar_Datos()
{
	cout<<"Hija_1"<<endl;
	Base::Cargar_Datos(); //Accedo al metodo "Cargar_Datos" de la clase "Base"
}

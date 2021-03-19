#include <iostream>
using namespace std;

class Base
{
private:
	int x;
public:
	void Cargar_Datos();
};
class Hija_1:public Base
{
private:
	int y;
public:
	void Cargar_Datos();
};
class Hija_2:public Hija_1
{
private:
	int z;
public:
	void Cargar_Datos();
};
int main(int argc, char *argv[]) 
{
	Base B;
	Hija_1 H_1;
	Hija_2 H_2;
	
	//B.Cargar_Datos();
	//H_1.Base::Cargar_Datos(); //Llamo al metodo "Cargar Datos" de la clase base desde "Hija_1"
	//H_2.Base::Cargar_Datos(); //Llamo al metodo "Cargar Datos" de la clase "Base" desde "Hija_2"
	//H_2.Hija_1::Cargar_Datos(); //Llamo al metodo "Cargar Datos" de la clase "Hija_1" desde "Hija_2"
	H_2.Cargar_Datos();
	return 0;
}

void Base::Cargar_Datos()
{
	cout<<"Base"<<endl;
}
void Hija_1::Cargar_Datos()
{
	cout<<"Hija_1"<<endl;
}
void Hija_2::Cargar_Datos()
{
	Base::Cargar_Datos(); //Llama al metodo "Cargar_Datos" de la clase Base desde el metodo "Cargar_Datos" de la "clase Hija_2"
	Hija_1::Cargar_Datos(); //Llama al metodo "Cargar_Datos" de la clase Hija_1 desde el metodo "Cargar_Datos" de la "clase Hija_2"
	cout<<"Hija_2"<<endl;
}

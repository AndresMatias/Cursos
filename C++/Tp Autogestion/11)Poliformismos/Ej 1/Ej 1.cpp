#include <iostream>
using namespace std;
class Nodo_Primario
{
	public:
		Nodo_Primario(){};
		virtual void Hablar(){cout<<"Hola"<<endl;}
};
class Nodo_Secundario_1: public Nodo_Primario
{
public:
	Nodo_Secundario_1(){};
	void Hablar(){cout<<"Hola_S_1"<<endl;}
};
class Nodo_Secundario_2: public Nodo_Primario
{
public:
	Nodo_Secundario_2(){};
	void Hablar(){cout<<"Hola_S_2"<<endl;}
};
class Nodo_Secundario_3: public Nodo_Secundario_2
{
public:
	Nodo_Secundario_3(){};
	void Hablar(){cout<<"Hola_S_3"<<endl;}
};
int main(int argc, char *argv[]) 
{
	Nodo_Primario *Saludo_1=new Nodo_Secundario_1();
	Nodo_Primario *Saludo_2=new Nodo_Secundario_2();
	Nodo_Primario *Saludo_3=new Nodo_Primario();
	Nodo_Primario *Saludo_4=new Nodo_Secundario_3;
	Saludo_1->Hablar();
	Saludo_2->Hablar();
	Saludo_3->Hablar();
	Saludo_4->Hablar();
		
	return 0;
}


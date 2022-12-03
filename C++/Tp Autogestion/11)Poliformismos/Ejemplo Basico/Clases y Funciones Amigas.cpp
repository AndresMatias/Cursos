#include <iostream>
using namespace std;
class Amigo; //Declaracion previa
class Base
{
private: //Las funciones(metodos)de la clase "Amigo" son amigas de clase Base por lo cual la clase Amigo puede disponer de las variables de la clase base
	friend class Amigo; //"Base" es amigo de "Amigo" y "Amigo" puede disponer de "Base" pero no al reves
	friend void Funcion_Amigo(); //"Base" es amigo de "Funcion_Amigo" y "Funcion_Amigo" peude disponer de base
	int x;
public:
	void Datos(Amigo A_1);
	void Datos_2();
};
class Amigo
{
private:
	int y;
	Base C_1; 
public:
	void Datos_1();
	friend void Base::Datos(Amigo A_1); //"Amigo" cree que la funcion "Datos" es su amigos y la funcion "Datos" pertenece a la clase "Base"
};

void Funcion_Amigo();
int main(int argc, char *argv[]) 
{
	Base B;
	Amigo A;
	B.Datos(A); 
	B.Datos_2(); 
	A.Datos_1();
	Funcion_Amigo();
	return 0;
}

void Base::Datos(Amigo A_1)
{
	cout<<"Ingrese y:";
	cin>>A_1.y;
}
void Amigo::Datos_1()
{
	cout<<"Ingrese x:";
	cin>>C_1.x;
}
void Funcion_Amigo()
{
	Base C_2;
	cout<<"Ingrese x:";
	cin>>C_2.x;
}
void Base::Datos_2()
{
	
}

#include <iostream>
using namespace std;
class pareja {
public:
	// Constructor
	pareja(int a2, int b2);
	pareja();
	// Funciones miembro de la clase "pareja"
	void Lee(int &a2, int &b2);
	void Guarda(int a2, int b2);
private:
	// Datos miembro de la clase "pareja"
	int a, b;
};
int main(int argc, char *argv[]) {
	pareja p1(0,0); //Llama al solo al constructor de dos variables 
	pareja p2; //Llama al solo al constructor que no contiene parametros
	
	return 0;
}
pareja::pareja(int a2, int b2)
{
	cout<<"Hola_1"<<endl;
}
pareja::pareja()
{
	cout<<"Hola_2"<<endl;
}

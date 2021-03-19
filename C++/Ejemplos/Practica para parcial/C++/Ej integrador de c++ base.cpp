#include <iostream>
#define tam 50
using namespace std;

class base
{
	protected:
		int	edad;
		int Dni;
		int	FechadeNacimiento;
		char NombreyApellido[50];
		char Sexo;
	public:
		base();
		void ingresodedatos();
		void impresion();
		
		
}; 
int main(int argc, char *argv[])
{
	//int tam=1;
	tam=3;
	class base b[tam];
	
	
	return 0;
}

base::base()
{
	
}

#include <iostream>
using namespace std;
class prueba
	{
		int a;
		friend void amigo(prueba&);
	public:
		prueba();
	};
void amigo(prueba &E);

int main(int argc, char *argv[]) 
{
	class prueba e;
	amigo(e);
	return 0;
}

prueba::prueba()
{
	a=3;
}
void amigo(prueba &E)
{
	cout<<E.a<<"\n";
	E.a=2;
	cout<<"hola "<<E.a;
}

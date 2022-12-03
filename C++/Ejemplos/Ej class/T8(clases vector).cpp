#include<iostream>
using namespace std;

class vector
{
	int dim;
	int *v;
public:
	vector(int Tam);
	int imprimir();
	~vector();
};
int main()
{
	int tamref;
	cin>>tamref;
	class vector e1(tamref);
	e1.imprimir();
}
vector::vector(int Tam)
{
	dim=Tam;
	v=new int[Tam];
	for(int i=0;i<Tam;i++) 
	{
		cin>>v[i];
	}
}
int vector::imprimir()
{
	int tam,i;
	tam=dim;
	for(i=0;i<tam;i++) 
	{
		cout<<v[i];
	}
	return 0;
}
vector::~vector()
{
	delete[] v;
}

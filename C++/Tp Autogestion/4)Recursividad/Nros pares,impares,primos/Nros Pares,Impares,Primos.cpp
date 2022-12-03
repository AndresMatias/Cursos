#include <iostream>
#include <stdlib.h> 
using namespace std;

int main(int argc, char *argv[]) 
{
	int a=0,i=0,Bandera=0;
	cin>>a;
	a=abs(a); //Valor Absoluto
	while(Bandera!=1)
	{
		i++;
		if((a%i==0)&&(i==2))
		{
			cout<<"Par"<<endl;
			Bandera=1;
		}
		if((a%i==0)&&(a!=i)&&(i!=2)&&(i!=1))
		{
			cout<<"Impar"<<endl;
			Bandera=1;
		}
		if((a%i==0)&&(a==i))
		{
			cout<<"Primo"<<endl;
			Bandera=1;
		}
	}
	return 0;
}


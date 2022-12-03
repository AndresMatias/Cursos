#include <stdio.h>
#include <stdlib.h>
#include <iostream>
using namespace std;

int main(int argc, char *argv[]) 
{
	int *Vector_Dinamico,n=0,i=0;
	cout<<"Ingrese el tamaño del vector:";
	cin>>n;
	Vector_Dinamico=new int[n];
	for(i=0;i<n;i++)
	{
		Vector_Dinamico[i]=i+1;
		cout<<""<<Vector_Dinamico[i]<<endl;
	}
	i=0;
	delete[]Vector_Dinamico;
		cout<<"The End"<<endl;
	return 0;
}
//Si uso new [] libero con delete []

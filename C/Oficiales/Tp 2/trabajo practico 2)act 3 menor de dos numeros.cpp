#include <stdio.h>
#include<conio.h>
#include<stdlib.h>

int main(int argc, char *argv[]){
	int n1,n2;
	printf("Este programa determina el menor de 2 numeros\n");
	printf("Por favor ingrese el primer numero: \n");
	scanf("%d",&n1);
	printf("Ingrese el segundo numero: \n");
	scanf("%d",&n2);
	if(n1==n2)
	{	
		printf("los numeros son iguales\n");
	}
	if(n2<n1)
	{
		printf("El menor es el numero : %d\n",n2);
	}
	if(n1<n2)
	{
		printf("El menor es el numero : %d\n",n1);
	}
	system("PAUSE");
	return 0;
}

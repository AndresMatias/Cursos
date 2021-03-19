#include <stdio.h>
int factorial(int);	//Funcion factorial
int main(int argc, char *argv[]) 
{
	int Numero=0;
	while(Numero<=0)	//Evita ingresar un numero negativo 
	{
		printf("Ingrese el numero que desea factorear");
		scanf("%d",&Numero);
	}
	Numero=factorial(Numero);	//Llamo a la funcion factorial
	printf("Numero Factoriado:%d",Numero);
	return 0;
}

int factorial(int n)
{
	if(n>1)		//Evita que n se iguale a cero
	{
		n=n*factorial(n-1);	//Se llama a si misma y en cada llama se le resta uno a n
	}
	return(n);	//Devuelve el valor n en cada llamada 
}



#include <stdio.h>
int fibonacci(int,int,int,int);
int main(int argc, char *argv[]) 
{
	int Numero=0;
	while(Numero<=0)	//Evita ingresar un numero negativo 
	{
		printf("Ingrese el numero para calcular con fibonacci:");
		scanf("%d",&Numero);
	}
	fibonacci(0,Numero,1,0);	//Llamo a la funcion factorial
	printf("\nListo");
	return 0;
}
 
int fibonacci(int n,int n2,int n3,int n4)
{	
	if(n2!=0)
	{
		printf("\nNumero Factoriado:%d\t%d",n,n2);
		n2--;
		n=n3+n4;
		n3=n4;
		n4=n;		
		fibonacci(n,n2,n3,n4);
	}
	return(n);
}

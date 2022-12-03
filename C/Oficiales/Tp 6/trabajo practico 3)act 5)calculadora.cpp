#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
	int sel,n1,n2,op,i=0;
	printf("BIENVENIDO/a A LA NUEVA CALCULADORA CUANTICA!!!\n");
	while(i==0)
	{
		printf("ingrese el PRIMER NUMERO:\n");
	scanf("%d",&n1);
	printf("ingrese el SEGUNDO NUMERO:\n"); 
	scanf("%d",&n2);    
	printf("Seleccione alguna operacion que aparece en el menu\n");
	printf("1---sumar\n2---multiplicar\n3---restar\n4---dividir\n");
	scanf("%d",&sel);
	if(sel==2)
	{
		op=n1*n2;        
	}
	if(sel==3)
	{
		op=n1-n2;        
	}
	if(sel==4)
	{
		op=n1/n2;
	}
	if(sel>4)
	{
		printf("\terror: usted no ha seleccionado una operacion valida\n");      
	}	
	if(sel==1)
	{
		op=n1+n2;
	}	
	printf("Este es el resultado de la operacion :%d\n",op);
	printf("para salir presione un numero distinto de 0,\n para seguir presione 0\n");
	scanf("%d",&i);
	}
	system("PAUSE");	
	return 0;
}

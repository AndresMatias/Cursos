#include <stdio.h>
#include<conio.h>
#include<stdlib.h>

int main(int argc, char *argv[]){
	int n1,n2,n3;
	printf("Este programa determina el mayor de 3 numeros\n");
	printf("Ingrese el primer numero: \n");
	scanf("%d",&n1);
	printf("Ingrese el segundo numero: \n");
	scanf("%d",&n2);
	printf("Ingrese el tercer numero: \n");
	scanf("%d",&n3);
	if(n1>n2)
	{
		if(n1>n3)
		{
			printf("El mayor es: %d\n",n1);         
		} 
		else
			{
				printf("El mayor es: %d\n",n3);    
			}        
	}
	else
		{
			if(n2>n3)
			{
				printf("El mayor es: %d\n",n2);         
			}  
			else
				{
					printf("El mayor es: %d\n",n3);    
				}  
		}
	system("PAUSE");	
	return 0;
}

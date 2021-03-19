#include <stdio.h>
#include<conio.h>
#include<stdlib.h>

int main(int argc, char *argv[]){
	int n1,n2,n3,n4;
	printf("Este programa determina el menor y mayor de 4 numeros\n");
	printf("Ingrese el primer numero:\n");
	scanf("%d",&n1);
	printf("Ingrese el segundo numero:\n");
	scanf("%d",&n2);
	printf("Ingrese el tercer numero:\n");
	scanf("%d",&n3);
	printf("Ingrese el cuarto numero:\n");
	scanf("%d",&n4);
	if((n1>n2)&&(n1>n3)&&(n1>n4))
	{
		printf("El mayor es: %d\n",n1);                             
	}
	else
		{
			if((n2>n3)&&(n2>n4))
			{
				printf("El mayor es: %d\n",n2);                     
			}    
			else
				{
					if(n3>n4)
					{
						printf("El mayor es: %d\n",n3);          
					}    
					else
						{
							printf("El mayor es: %d\n",n4);     
						}
				}
		}
	if((n1<n2)&&(n1<n3)&&(n1<n4))
	{
		printf("El menor es: %d\n",n1);                             
	}
	else
		{
			if((n2<n3)&&(n2<n4))
			{
				printf("El menor es: %d\n",n2);                     
			}    
			else
				{
					if(n3<n4)
					{
						printf("El menor es: %d\n",n3);          
					}    
					else
						{
							printf("El menor es: %d\n",n4);     
						}
				}
		}
	system("PAUSE");	
	return 0;
}

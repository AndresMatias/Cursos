#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#define tam 3

int main(int argc, char *argv[]) 
	{
	float a=0,op=0,b=0,e=0;
	int c=0,d=0;
	char s[tam]={' '};
	printf("Bienvenido, este programa sirve para sumar, restar, multiplicar, dividir y potenciar numeros\n");
while(d!=2)
{	
	a=0;
	op=0;
	b=0;
	c=0;
	d=0;
	e=0;
	printf("Para sumar presione 1\nPara restar presione 2\nPara multiplicar presione 3\nPara dividir presione 4\nPara potenciar numeros enteros presione 5\n");
	scanf("%d",&c);
	while((c<1)||(c>5)) /* Este while sirve para determinar si los numeros ingresados entan dentro del rango para elegir las operaciones mencionadas arriba*/
	{
			printf("Elija nuevamente la operacion que desea pero con los numeros enteros del 1 al 5\n");
			scanf("%d",&c);
	}
	if((c>=1)&&(c<=4))    
		{
			printf("Ingrese el primer numero\n");
			scanf("%f",&a);
			printf("Ingrese el segundo numero\n");
			scanf("%f",&b);
		}
	if(c==5)
		{
			printf("Ingrese la base de la potencia\n");
			scanf("%f",&a);
			printf("Ingrese la potencia\n");
			scanf("%f",&b);
		}
	switch(c)
		{
			case 1:
					op=a+b;
					printf("El resultado de la suma es %.2f\n",op);
					break;
			case 2:
					op=a-b;
					printf("El resultado de la resta es %.2f\n",op);
					break;
			case 3:
					op=a*b;
					printf("El resultado de la multiplicacion es %.2f\n",op);
					break;
			case 4:
					op=a/b;
					printf("El resultado de la division es %.2f\n",op);
					break;
			case 5:				
					op=1;
					while(b!=e)  /* Este while sirve para determinar la pontecia sin necesidad de usar la funcion de exp solo para numeros enteros*/
						{	
							op=op*a;
							if(b>0)
							{
								e++;						
							}
							if(b<0)
							{
								e--;					
							}
							if((b<0)&&(b==e))
							{
								op=(1/op);								
							}
						}
					if(c==5)
						{
							printf("El resultado de la potenciacion es %.5f\n",op);
						}
				
		}
	printf("Si desea salir del programa presione la letra ""s""\npara seguir presione la letra ""n""\n");
	scanf("%s",&s[tam]);
	if(s[tam]=='s')
		{
			d=2;
		}
	}
return 0;
}


#include <stdio.h>
#include<stdlib.h>
main()
{
	int cont, var, sum, sub, mul, div, num1, num2, num3, num4;
	cont=1;
	printf("Este programa es una calculadora mortal\n");
	printf("\ningrese 1 para sumar, 2 para restar, 3 para multiplicar y 4 para dividir\n");	
	scanf("%d", &var);	
		if (var==1);
		{
		printf("\ningrese los numeros para sumar(presione enter)\n");
		scanf("%d", &num1);
		scanf("%d", &num2);
		sum = num1 + num2;
		printf("\n EL RESULTADO ES %d\n", sum);
		}
		sistem(pause);
		return(1);

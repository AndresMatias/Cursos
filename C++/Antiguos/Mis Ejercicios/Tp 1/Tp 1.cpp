#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main(int argc, char *argv[]) 
{	
	float dividendo=0,divisor=2,bandera=0,resultado=0;
	int resultado2=0,matriz[2][50]={0},i=0,j=0,k=0,potencia[2][10]={0},numero[2][10],MCD[2][10]={0},mcd=1;
	printf("\nEste programa calcula el maximo comun divisor de dos numeros:");
	printf("\nIngrese el numero que quiere dividir:");
	scanf("%f",&dividendo);
	while(bandera==0)	//Metodo de comparacion para saber si un numero es divisible por otro numero y da un entero
	{
		//printf("\nDividendo:%0.2f\tDivisor:%0.2f",dividendo,divisor);
		resultado=dividendo/divisor;
		resultado2=dividendo/divisor;
		//system("pause");
		if(resultado!=resultado2)
		{
			divisor++;
		}
		if(resultado==resultado2)
		{
			matriz[0][i]=divisor;
			printf("\n%d",matriz[0][i]);
			i++;
			dividendo=resultado;
			if(resultado==1)
			{
				bandera=1;
			}
			
		}
	}
	printf("\nIngrese el numero que quiere dividir:");
	scanf("%f",&dividendo);
	bandera=0;
	divisor=2;
	i=0;
	while(bandera==0)	//Metodo de comparacion para saber si un numero es divisible por otro numero y da un entero
	{
		resultado=dividendo/divisor;
		resultado2=dividendo/divisor;
		//system("pause");
		if(resultado!=resultado2)
		{
			divisor++;
		}
		if(resultado==resultado2)
		{
			matriz[1][i]=divisor;
			printf("\n%d",matriz[1][i]);
			i++;
			dividendo=resultado;
			if(resultado==1)
			{
				bandera=1;
			}
		}
	}
	for(j=0;j<2;j++)	//Determino la potencia de cada numero  y el numero
	{
		for(i=0;i<10;i++)
		{
			if((matriz[j][i]==matriz[j][i+1])&&(matriz[j][i]>0))
			{
				potencia[j][k]=potencia[j][k]+1;
				numero[j][k]=matriz[j][i];
			}
			if(matriz[j][i]!=matriz[j][i+1])
			{
				potencia[j][k]=potencia[j][k]+1;
				numero[j][k]=matriz[j][i];
				k++;
			}
		}
	}
	j=0;
	for(j=0;j<2;j++)	//Muestros los numeros y sus potencias
	{
		for(i=0;i<10;i++)
		{
			if(potencia[j][i]>0)
			{
				if(j==0)
				{
				printf("\nNumero:%d\tPotencias:%d",numero[j][i],potencia[j][i]);
				}
				if(j==1)
				{
					printf("\nNumero:%d\tPotencias:%d",numero[j][i],potencia[j][i]);
				}
			}
		}
		printf("\n\n\n");
	}
	k=0;
	for(j=0;j<10;j++) //Algoritmo de seleccion de factores comunes elevados al menor exponente
	{
		for(i=0;i<10;i++)
		{
			if(numero[0][j]==numero[1][i])
			{
				if((potencia[0][j]<potencia[1][i])||(potencia[0][j]==potencia[1][i]))
				{
					MCD[0][k]=numero[0][j];
					MCD[1][k]=potencia[0][j];
					k++;
				}
				if(potencia[0][j]>potencia[1][i])
				{
					MCD[0][k]=numero[1][i];
					MCD[1][k]=potencia[1][i];
					k++;
				}
			}
		}
	}
	mcd=1;
	for(i=0;i<10;i++)//Calculo el MCD
	{
		if(MCD[0][i]>0)
		{
			mcd=mcd*pow(MCD[0][i],MCD[1][i]);
		}
	}
	printf("\nMCD:%d",mcd);
	return 0;
}


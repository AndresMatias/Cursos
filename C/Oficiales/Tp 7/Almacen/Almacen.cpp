#include <stdio.h>
#include<conio.h>
#include<stdlib.h>

int main(int argc, char *argv[])
	{
	int contpan=0,contbaz=0,contalm=0,contfres=0,contotro=0,i=0,codr=0;
	printf("Este programa calcula la cantidad de articulos de cada tipo\n");
	for(i=1;i<51;i++)
		
	{
		printf("\nIngrese el codigo del articulo\n");/*tabla de codigos para recordar*/
		printf("\nRUBRO----------COD.\n");
		printf("\nBAZAR           10\n");
		printf("\nPANADERIA       20\n");
		printf("\nALMACEN         30\n");
		printf("\nOTROS PRODUCTOS 40\n");
		printf("\n--Presione 99 para terminar \\ Sino, siga ingresando codigo\n");
		{
		printf("\nIngrese codigo de art.:\n");
		scanf("%d",&codr);/*ingreso de codigo para c articulo*/
		switch(codr)
			{
			case 10:contbaz++;/* inicio de contador*/
				break;
			case 20:contpan++;/* inicio de contador*/
				break;
			case 30:contalm++;/* inicio de contador*/
				break;
			case 40:contfres++;
				break;/* inicio de contador*/
			case 99:
				printf("\nUsted ha salido del contador!!\n");
				i=51;
			}
		}
	}
		printf("\nLa cantidad de articulos de bazar es %d",contbaz);
		printf("\n");
		printf("\nLa cantidad de articulos de panaderia es %d",contpan);
		printf("\n");
		printf("\nLa cantidad de articulos del almacen es %d",contalm);
		printf("\n");
		printf("\nLa cantidad de articulos de frescos es %d",contfres); 
		printf("\n");
		printf("\nLa cantidad de articulos de otros productos es %d",contotro);
		printf("\n");
		system("PAUSE");
		return 0;
	}
	

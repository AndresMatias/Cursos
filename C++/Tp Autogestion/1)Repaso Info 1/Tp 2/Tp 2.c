#include <stdio.h>

int main(int argc, char *argv[]) 
{
	int Nro1=0,Nro2=0,Nro3=0,Suma=0;
	//Ingreso de Variables
	printf("Introdusca el Nro1:");	
	scanf("%d",&Nro1);
	printf("\nIntrodusca el Nro2:");
	scanf("%d",&Nro2);
	printf("\nIntrodusca el Nro3:");
	scanf("%d",&Nro3);
	//Logica del programa
	if((Nro1>Nro2)&&(Nro1>Nro3))	
	{
		if(Nro2>Nro3)
		{
			Suma=Nro1+Nro3;
		}
		if(Nro2<Nro3)
		{
			Suma=Nro1+Nro2;
		}
	}
	if((Nro2>Nro1)&&(Nro2>Nro3))
	{
		if(Nro1>Nro3)
		{
			Suma=Nro2+Nro3;
		}
		if(Nro1<Nro3)
		{
			Suma=Nro1+Nro2;
		}
	}
	if((Nro3>Nro1)&&(Nro3>Nro2))
	{
		if(Nro1>Nro2)
		{
			Suma=Nro2+Nro3;
		}
		if(Nro1<Nro2)
		{
			Suma=Nro1+Nro3;
		}
	}
	if((Nro1==Nro2)||(Nro2==Nro3)||(Nro1==Nro3))
	{
		if(Nro1!=Nro3)
		{
			Suma=Nro1+Nro3;
		}
		if(Nro1!=Nro2)	
		{
			Suma=Nro1+Nro2;
		}
		if(Nro2!=Nro3)
		{
			Suma=Nro2+Nro3;
		}
	}
	if((Nro1==Nro2)&&(Nro2==Nro3))
	{
		printf("\nLos tres numeros son iguales");
	}
	else
	{
		printf("\nLa suma del mayor y el menor es igual a: %d",Suma);
	}
	return 0;
}


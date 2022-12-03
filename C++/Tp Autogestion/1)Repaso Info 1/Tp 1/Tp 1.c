#include <stdio.h>
/*Leer dos números desde el teclado, calcule  y muestre 
  por pantalla el cociente entre el mayor y el menor*/
int main(int argc, char *argv[]) 
{
	int Bandera=0; //Para salir del while mas abajo
	float Cociente=0,Nro1=0,Nro2=0;
	printf("Ingrese un numero:");
	scanf("%f",&Nro1);
	while((Nro1==Nro2)||(Bandera==0)) //El 2do nro ingresado no debe ser igual al primer nro ingresado
	{
		printf("\nIngrese otro numero mayor o menor a %0.2f: ",Nro1);
		scanf("%f",&Nro2);
		if((Nro1>Nro2)||(Nro1<Nro2))	//Para salir del while en casa de que los dos nros sean distintos
		{
			Bandera=1;
		}
	}
	if(Nro1>Nro2)
	{
		Cociente=Nro2/Nro1;
	}
	else
	{
		Cociente=Nro1/Nro2;
	}
	printf("\nEL cociente entre el mayor y el menor (Mayor/Menor) es igual a:%0.2f",Cociente);
	
	return 0;
}


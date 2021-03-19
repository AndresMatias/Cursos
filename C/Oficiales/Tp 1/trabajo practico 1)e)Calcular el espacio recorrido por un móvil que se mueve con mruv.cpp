#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	int v1,v2,a,d;
	printf("Este programa calcula la distancia recorrida por un vehiculo (CON M.R.U.V)\n");
	printf("A continuacion: Ingrese la velocidad inicial\n");
	scanf("%d",&v1);
	printf("Ingrese la velocidad final\n");
	scanf("%d",&v2);
	printf("ingrese la aceleracion\n");
	scanf("%d",&a);
	d=((v2*v2)-(v1*v1))/(2*a);
	printf("la distancia recorrida es de :%d\n",d);
	printf("fin del programa\n");
	system("PAUSE");	
	return 0;
}

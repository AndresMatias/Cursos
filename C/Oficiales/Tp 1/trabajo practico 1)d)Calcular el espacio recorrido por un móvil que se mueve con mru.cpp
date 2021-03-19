#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	int vel,t,d;
	printf("Este programa calcula el espacio recorrido por un vehiculo (EN M.R.U)\n");
	printf("A continuacion: Ingrese la velocidad del vehiculo\n");
	scanf("%d",&vel);
	printf("ingrese el tiempo transcurrido\n");
	scanf("%d",&t);
	d=vel*t;
	printf("La distancia recorrida es de :%d\n",d);
	printf("Fin del programa\n");
	system("PAUSE");   
	return 0;
}

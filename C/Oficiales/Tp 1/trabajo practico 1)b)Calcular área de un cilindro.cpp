#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	int r,h,sup;
	printf("Este programa calcula el area de un cilindro\n");
	printf("A continuacion: Ingrese el radio\n");
	scanf("%d",&r);
	printf("Ingrese la altura\n");
	scanf("%d",&h);
	sup=2*3.14*r*(h+r);
	printf("el area es de :%d\n",sup);
	printf("fin del programa\n");
	system("PAUSE");	
	return 0;
}

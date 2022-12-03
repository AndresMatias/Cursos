#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	int r,h,vol;
	printf("este programa calcula el volumen de un cilindro\n");
	printf("A continuacion :Ingrese el radio\n");
	scanf("%d",&r);
	printf("ingrese la altura\n");
	scanf("%d",&h);
	vol=3.14*r*r*h;
	printf("el volumen es de :%d\n",vol);
	printf("fin del programa");
	system("PAUSE");	
	return 0;
}

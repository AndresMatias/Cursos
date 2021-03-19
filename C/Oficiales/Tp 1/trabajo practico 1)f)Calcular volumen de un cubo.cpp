#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	int a,vol;
	printf("este programa calcula el volumen de un cubo\n");
	printf("por favor ingrese el valor de la arista\n");
	scanf("%d",&a);
	vol=a*a*a;
	printf("el volumen del cubo es de :%d\n",vol);
	system("PAUSE");	
	return 0;
}

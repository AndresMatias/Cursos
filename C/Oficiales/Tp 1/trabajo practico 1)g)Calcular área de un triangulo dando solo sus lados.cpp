#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(int argc, char *argv[])
{
	int l1,l2,l3;
	float sup,p;
	printf("este programa calcula la superficie de un triangulo a partir de sus 3 lados\n");
		{printf("Por favor ingrese el valor de los 3 lados\n");
		scanf("%d%d%d",&l1,&l2,&l3);
	if((l1<l2+l3)&&(l2<l1+l3)&&(l3<l1+l2))
	{
		p=(l1+l2+l3)/2;
		sup=sqrt(p*(p-l1)*(p-l2)*(p-l3));
		printf("La superficie del triangulo es de :%.2f\n",sup);
	}
	else
		{printf("\nLos datos no corresponden a un triangulo");
	}
	}
system("PAUSE");
return 0;
}


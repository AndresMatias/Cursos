#include <stdio.h>
#include <stdlib.h>
#define tam 10


int main(int argc, char *argv[]) 
	{
	int econt=0,clave=0,i=0,a[tam],pos=0,j=0,b=0;
	for(j=0;j<tam;j++)
		{
			b=b+1;
			printf("Ingrese elemento %d de la matriz: ",b);
			scanf("%d",&a[j]);
		}
	printf("Ingrese la clave que quiere buscar: ");
	scanf("%d",&clave);
	while((i<tam)&&(econt==0))
		{
			if(a[i]==clave)
				{
					pos=i;
					econt=1;
					printf("La posicion en la matriz donde se encutra clave es: %d",pos+1);
				}
			i++;
		}
	if(econt==0)
	{
			printf("La clave que busca no se encuentra en este banco de datos");
	}
	return 0;
}


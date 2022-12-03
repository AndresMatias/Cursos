#include <stdio.h>
#define tam 20
int main(int argc, char *argv[]) 
{
	int a[tam],p=0,u=tam-1,c=0,i=0,f=0,encont=0,clave=0,pos=0;
	for(i=0;i<tam;i++)
		{
			pos++;
			printf("Ingrese un numero en la posicion %d: ",pos);
			scanf("%d",&a[i]);
			while((a[i]<=a[i-1])&&(i>0))
				{
					printf("Error, ingrese un numero mayor que el numero que haya ingresado anteriormente");
					scanf("%d",&a[i]);
				}
		}
	printf("Ingrese un numero que desea encontrar: ");
	scanf("%d",&clave);
	while((p<u)&&(encont==f))
		{
			c=((p+u)/2);
			if(clave==a[c])
				{
					f=1;
					printf("La posicion del valor que se buscaba en el arreglo es: %d",c);
				}
			else
				{
					if(clave>a[c])
						{
							p=c+1;
						}
					else
						{
							u=c-1;
						}
				}
		}
		if(encont!=f)
			{
				p=c;
			}
		else
			{
				printf("No se encontro el numero que se buscaba en este arreglo");
			}
	return 0;
}


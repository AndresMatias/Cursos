#include<stdlib.h>
#include<stdio.h>
#include<malloc.h>
struct nodo
	{
		char dato;
		struct nodo *psig;            
	};
int main(int argc, char *argv[]) 
{
	int a=0;
	char dato;
	struct nodo *base,*memoria,*memoriaaux;
	base=NULL;
	memoria=NULL;
	printf("Mientras no ingrese la letra 's' seguira ingresando letras\n");
	while((dato=getchar())!='s')
	{
		a++;
		if(a==1)
		{
			memoriaaux=(struct nodo *)malloc(sizeof(*memoriaaux));
			(*memoriaaux).dato=dato;
			(*memoriaaux).psig=NULL;
			base=memoriaaux;			
		}
		if(a!=1)
		{
			memoria=(struct nodo *)malloc(sizeof(*memoria));
			(*memoria).dato=dato;
			(*memoria).psig=NULL;
			(*memoriaaux).psig=memoria;
			memoriaaux=memoria;			
		}			
	}
	memoriaaux=base;
	while(memoriaaux!=NULL)
	{
		printf("%c",(*memoriaaux).dato);
		memoriaaux=(*memoriaaux).psig;
	}
	return 0;
}

//rid preorden
//ird inorden
//idr postorden

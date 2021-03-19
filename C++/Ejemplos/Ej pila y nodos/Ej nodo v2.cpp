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
	char dato;
	struct nodo *base,*memoria;
		base=NULL;
		while((dato=getchar())!='s')
			{
				memoria=(struct nodo *)malloc(sizeof(*memoria));
				(*memoria).dato=dato;
				(*memoria).psig=base;
				base=memoria;
			}
		while(memoria!=NULL)
		{
			printf("%c",(*memoria).dato);
			memoria=(*memoria).psig;
		}
	return 0;
}


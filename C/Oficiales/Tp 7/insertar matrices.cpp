#include <stdio.h>
#define tam 3

int main(int argc, char *argv[]) {
	int Ma[tam][tam],i,j;
	printf("este programa permite escribir matrices\n\n");
	for (i=0;i<tam;i++)
	{	
		for(j=0;j<tam;j++)
		{
			
			printf("ingrese matriz [%d][%d]\n",i+1,j+1);
			scanf("%d",&Ma[i][j]);
			printf("\n");
		}
	}
	for (i=0;i<tam;i++)                 /*para mostrar resultado como matris*/
	{	
		for(j=0;j<tam;j++)
		{
			
			printf("%d\t",Ma[i][j]);
			
		}
		printf("\n");
	}
	
	
	return 0;
}


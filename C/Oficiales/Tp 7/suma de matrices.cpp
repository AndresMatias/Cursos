#include <stdio.h>
#define tam 3

int main(int argc, char *argv[]) {
	int A[tam][tam],B[tam][tam],C[tam][tam],i,j;
	printf("Este programa permite escribir matrices\n\n");
	for (i=0;i<tam;i++)			/*matriz a*/
	{	
		for(j=0;j<tam;j++)
		{
			printf("ingrese matriz A[%d][%d]\n",i,j);
			scanf("%d",&A[i][j]);
			printf("\n");
		}
	}
	for (i=0;i<tam;i++)					/*matriz b*/
	{	
		for(j=0;j<tam;j++)
		{
			printf("ingrese matriz B[%d][%d]\n",i,j);
			scanf("%d",&B[i][j]);
			printf("\n");
		}
	}
	for (i=0;i<tam;i++)					/*suma matriz A y B*/
	{	
		for(j=0;j<tam;j++)
		{
			C[i][j]=A[i][j]+B[i][j];
		}
	}
	printf("Matriz C:\n\n");
	for (i=0;i<tam;i++)                 /*para mostrar resultado como matriz*/
	{	
		for(j=0;j<tam;j++)
		{
			
			printf("%d\t",C[i][j]);
			
		}
		printf("\n");
	}
	
	
	return 0;
}



#include<stdio.h>
#define tam 3
int main(int argc, char *argv[]) {
	int mat[tam][tam],i,j;
	printf("programa para ver los elementos de una matriz de 3x3\n");
	for(i=0;i<tam;i++)
	{
		for(j=0;j<tam;j++)
		{
			printf("\nIngrese el elemento [%d][%d] de la matriz\n",i+1,j+1);
			scanf("%d",&mat[i][j]);
		}
	}
	printf("\nEsta es su matriz\n");
	for(i=0;i<tam;i++)
	{
		for(j=0;j<tam;j++)
		{
			printf("%d\t",mat[i][j]);
		}
		printf("\n");
	}
	
	
return 0;
}


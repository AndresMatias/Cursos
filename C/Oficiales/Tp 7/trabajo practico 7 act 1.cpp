#define tam 3
#include <conio.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) 
{
	int m,j,k,i,vec1[tam]={};
	char vec2[tam][10]={' '};
	
	printf("este programa guarda info\n");
	for (i=0;i<tam;i++)
	{
		printf("¿Cual es su nombre?\n");
		scanf("%s",&vec2[i][0]);
		
		for(m=0;m<1;m++)
			{	
				printf("¿Que edad tiene?\n");
				scanf("%d",&vec1[m]);
			}
	}
for(k=0;k<tam;k++)
	{
		for(j=0;j<10;j++)
		printf("%c",vec2[k][j]);
		printf("\n");
		printf("edad %d\n",vec1[m]);
	}	

	return 0;
}
	

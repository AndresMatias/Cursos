#include <stdio.h>
int arbol(int);
int tronco(int);
int main(int argc, char *argv[]) 
{
	int a;
	scanf("%d",&a);
	arbol(a);
	tronco(a);
	return 0;
}
int arbol(int a)
{
	int j,k,i,m=1;
	for(j=0;j<a;j++)
	{
		for(k=0;k<(a-j);k++)
		{
			printf(" ");
		}
		for(i=0;i<m;i++)
		{
			printf("*");
		}
		m=m+2;
		printf("\n");
	}
	return(0);
}
int tronco(int a)
{
	int j,k,i,m;
	m=a/3;
	for(j=0;j<m;j++)
	{
		for(k=0;k<(a-(m/2));k++)
		{
			printf(" ");
		}
		for(i=0;i<m;i++)
		{
			printf("*");6
		}
		printf("\n");
	}
	return(0);
}


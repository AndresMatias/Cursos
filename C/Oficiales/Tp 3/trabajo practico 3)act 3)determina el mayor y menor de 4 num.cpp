#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	int n,i,may=0,men=9999;
	printf("este programa determina el mayor y menor de 4 num\n");
	for(i=1;i<=4;i++)
	{
		printf("ingrese el numero %d\n",i); 
		scanf("%d",&n);       
		if(n>may)
		{
			may=n;         
		}        
		if(n<men)
		{
			men=n;         
		}
	}
	printf("el menor es: %d\n",men);
	printf("el mayor es: %d\n",may);
	system("PAUSE");	
	return 0;
}

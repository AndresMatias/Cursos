#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) 
{
	int Arreglo[10]={2,-3,30,-1,-1,50,22,100,0,5},i=0;
	for(i=0;i<10;i++)
	{
		if(Arreglo[i]>=0)
		{
			printf("\n%d",Arreglo[i]);
		}
	}
	return 0;
}


#include <stdio.h>
int calc();	

int main(int argc, char *argv[]) 
{

	calc();
	return 0;
}
int calc()
{
	int i=0,j=0,k=4,l=1;	
	for(i=0;i<4;i++)
	{
		
		for(j=0;j<k;j++)
		{
			printf(" ");
		}
		j=0;
		k=k-1;
		for(j=0;j<l;j++)
		{
			printf("*");
		}
		l=l+2;
		printf("\n");
}
	i=0;
	j=0;
	for(i=0;i<3;i++)
	{
		for(j=0;j<4;j++)
		{
			printf(" ");
		}
		printf("*");
		printf("\n");
	}
}

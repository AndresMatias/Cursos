#include <stdio.h>
long factorialI(int n);
long factorialR(int n);
int main(int argc, char *argv[]) 
{
	int num=0;
	printf("Ingrese el numero factorial\n");
	scanf("%d",&num);
	printf("\nEl resultado por interacion es :%ld y por recursividad es:%ld",factorialI(num),factorialR(num));
	return 0;
}
long factorialI(int n)
{
	int i=1,f=1;
	for(i=1;i<n+1;i++)
	{
		f=f*i;
	}
	return(f);
}

long factorialR(int n)
{
	if(n==0)
		{
			return(1);
		}
	else
		{
			return(factorialR(n-1)*n);
		}
}


#include <stdio.h>
#include<conio.h>
	int cubovalor(int)
	void cuboreferencia(int*)
	main(int argc, char *argv[]) 
	{
	printf("ingrese un mumero entero\n");
	scanf ("%d",&num);
	cubo = cubovalor(num);/*llamada por valor*/
	printf("num =%d y  su cubo es %d\n",num,cubo);
	cuboreferencia(&num);
	
	int cubovalor(int n)
	{
	return(n*n*n);
	}
		void cuboreferencia(int*puntnum)
		{
			*puntnum=*puntnum**puntnum**puntnum
		}	
		return 0;
	}


#include <stdio.h>
#define tam 4

int main(int argc, char *argv[]) {
	int aux=0,vect[tam],i=0,j=0;
	for(i=0;i<tam;i++)
	{
		printf("Ingrese la matriz");
		scanf("%d",&vect[i]);
	}
	i=0;
	for(i=0;i<tam-1;i++)      
		{      
			for(j=0;j<tam-1-i;j++)           /*Si en este for saco el -i se convierte en un metodo de burbuja comun la i sirve para que de menos vueltas*/
				{           
					if (vect[j]>vect[j+1])              
						{              
							aux=vect[j];             
							vect[j]=vect[j+1];            
							vect[j+1]=aux;
						}
				}
		}
	i=0;
	for(i=0;i<tam;i++)
	{
		printf("\n %d",vect[i]);
		
	}
	
	return 0;
}


#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) 
{
	int i=0,j=0,Tam_1=5,k=0,l=0,Bandera=0;
	int Vector_1[Tam_1],Vector_Aux[Tam_1];
	for(j=0;j<Tam_1;j++)
	{
		printf("\nIngrese el valor de la posicion Nro %d: ",j+1);
		scanf("%d",&Vector_1[j]);
		Vector_Aux[j]=0;
	}
	j=0;
	//Determino el Tamaño de la matriz y paso los datos sin repetir a la matriz Vector_Aux
	for(i=0;i<Tam_1;i++)
	{
		for(j=0;j<Tam_1;j++)
		{
			if(Vector_1[i]==Vector_1[j])
			{
				k=0;
				for(k=0;k<Tam_1;k++)
				{
					Bandera=1;	//Bandera es verdadero(1) hasta que se demeustre lo contrario(0)
					if(Vector_1[i]==Vector_Aux[k])	//El dato esta repetido por lo tanto sale de este for
					{
						k=Tam_1;
						j=Tam_1;
						Bandera=0;
					}
				}
				if(Bandera==1)
				{
					Vector_Aux[l]=Vector_1[i];
					l++; //Tamaño de la matriz sin la repeticion de datos
					j=Tam_1; //Salta al siguiente numero
					Bandera=0;
				}
			}
		}
	}
	printf("\nTamaño: %d\n",l);
	i=0;
	for(i=0;i<l;i++)
	{
		printf("\nDato[%d]: %d ",i+1,Vector_Aux[i]);
	}
	return 0;
}


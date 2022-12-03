#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#define tam 5
int main(int argc, char *argv[]) {
	int j,i=0,al,mer,cons,medida,cod[tam];
	float m1,m2,m3;
	char calidad[tam],tapas[tam];
	for(j=0;j<tam;j++)
	{
		i++;
		printf("Ingrese el codigo de la pieza %d\n",i);
		scanf("%d",&cod[j]);
		printf("ingrese la medida de la tapa %d\n",i);
		scanf("%d",&medida);
		switch(cod[j])
		{
		case 11:mer++;
			{
				tapas[j]='M';
			m1=(((medida*100)/10)-100);
				if((-3<m1)||(3>m1))
				{
					calidad[j]='m';
				}
				else
				{
					calidad[j]='b';
				}
			}
			break;
		case 12:al++;
			{
				tapas[j]='A';
				m2=(((medida*100)/12)-100);
					if((-3<m2)||(3>m2))
					{
						calidad[j]='m';
					}
					else
					{
						calidad[j]='b';
					}
			}
			break;
		case 13:cons++;
			{
				tapas[j]='C';
				m3=(((medida*100)/8)-100);
					if((-3<m3)||(3>m3))
					{
						calidad[j]='m';
					}
					else
					{
						calidad[j]='b';
					}
			}
		}
	}
	for(j=0;j<tam;j++)
	{
		printf("%c\t%d\t%c\n",tapas[j],cod[j],calidad[j]);
	}
	return 0;
}


#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#define tam 58

int main(int argc, char *argv[]) 
{
	int i=0,j=0,con=0,con1=0,con2=0;
	float SD[tam][tam],lu=0,ma=0,mi=0,ju=0,vi=0,sa=0,d=0,sem=0;
	printf("Este programa calcula la potencia de una central a lo largo de un año\n,debera ingresar la potencia consumida cada dia,si quiere finalizar\nel estudio antes debera poner el numero -1 en los dias lunes,\nde lo contrario el programa seguira, que tenga buen dia\n");
		for(i=0;i<tam;i++)
		{	
			printf("\nSemana %d\n\n\n",i+1);
			for(j=0;j<7;j++)
				{
					printf("Dia:");
					if(j==0)
						{
							printf("Lunes");		
						}	
					if(j==1)
						{
							printf("Martes");
						}
					if(j==2)
						{
							printf("Miercoles");;
						}
					if(j==3)
						{
							printf("Jueves");
						}
					if(j==4)
						{
							printf("Viernes");
						}
					if(j==5)
						{
							printf("Sabado");
						}
					if(j==6)
						{	
							printf("Domingo");
							con++;
						}
					printf("\nIngrese la potencia: ");
					scanf("%f",&SD[i][j]);
					printf("\n\n");					
					if((j==0)&&(SD[i][j]==(-1)))
						{
							i=58;
							j=7;
							SD[i][j]=0;
							con1--;
						}
					con1++;
					sem=(SD[i][j]+sem);
				}
			lu=(SD[i][0]+lu);
			ma=(SD[i][1]+ma);
			mi=(SD[i][2]+mi);
			ju=(SD[i][3]+ju);
			vi=(SD[i][4]+vi);
			sa=(SD[i][5]+sa);
			d=(SD[i][6]+d);			
		}
	sem=(sem/con1);
	lu=(lu/con);
	ma=(ma/con);
	mi=(mi/con);
	ju=(ju/con);
	vi=(vi/con);
	sa=(sa/con);
	d=(d/con);
	printf("\n");
	printf("Ustede ha terminado el estudio,los resultados son\n");
	printf("\tDias\tLunes\tMartes\tMiercoles\tJueves\tViernes\tSabado\tDomingo\nPotencia\t%.2f\t%.2f\t%.2f\t\t%.2f\t%.2f\t%.2f\t%.2f\n",lu,ma,mi,ju,vi,sa,d);
	printf("media\n\n");
	if((lu>ma)&&(mi<lu))								
	{
		if((ju<lu)&&(vi<lu))
		{
			if((sa<lu)&&(d<lu))
			{
				printf("El dia de mayor consumo es el dia lunes\n\n");
			}
		}
	}
	if((lu<ma)&&(mi<ma))                                
	{
		if((ju<ma)&&(vi<ma))
		{
			if((sa<ma)&&(d<ma))
			{
				printf("El dia de mayor consumo es el dia martes\n\n");
			}
		}
	}
	if((lu<mi)&&(mi>ma))								
	{
		if((ju<mi)&&(vi<mi))
		{
			if((sa<mi)&&(d<mi))
			{
				printf("El dia de mayor consumo es el dia miercoles\n\n");
			}
		}
	}
	if((lu<ju)&&(ma<ju))								
	{
		if((ju<ma)&&(vi<ma))
		{
			if((sa<ma)&&(d<ma))
			{
				printf("El dia de mayor consumo es el dia Jueves\n\n");
			}
		}
	}
	if((lu<vi)&&(ma<vi))							
	{
		if((mi<vi)&&(vi>ju))
		{
			if((sa<vi)&&(d<vi))
			{
				printf("El dia de mayor consumo es el dia viernes\n\n");
			}
		}
	}
	if((lu<sa)&&(ma<sa))								
	{
		if((mi<sa)&&(sa>ju))
		{
			if((sa>vi)&&(d<sa))
			{
				printf("El dia de mayor consumo es el dia sabado\n\n");
			}
		}
	}
	if((lu<d)&&(ma<d))								
	{
		if((mi<d)&&(d>ju))
		{
			if((sa<d)&&(d>vi))
			{
				printf("El dia de mayor consumo es el dia domingo\n\n");
			}
		}
	}
	printf("El consumo promedio del periodo es %.2f\n\n",sem);
	for(i=0;i<con1;i++)
	{	
		for(j=0;j<7;j++)
		{
			if(SD[i][j]>sem)
			{
				con2++;
			}
		}
	}
	printf("La cantidad de dias que superan el consumo promedio es %d",con2);
		
	return 0;
}


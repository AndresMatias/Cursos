#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#define tam 15

void ingresar_datos(void);
void imprimir(void);

struct alumno 
	{ 
	char nombre[20]; 
	char apellido [20]; 
	int edad; 
	int anio; 
	int nota[2]; 
	float prom; 
	char estado;
	}r[tam]; 

int main() 
{
int i,j;
	
	ingresar_datos();
	system("cls");
	imprimir();
system ("PAUSE");

return 0;
}

void ingresar_datos(void)
{
	int i;
for(i=0;i<tam;i++)
    {
		printf("\t\tALUMNO %d\n", i+1);
		printf("\nIngrese el Nombre.....: ");
		scanf("%s", &r[i].nombre);
		printf("\nIngrese el Apellido...: ");
		scanf("%s", &r[i].apellido);
		printf("\nIngrese la edad.......: ");
		scanf("%d", &r[i].edad);
		printf("\nIngrese el anio.......: ");
		scanf("%d", &r[i].anio);
		printf("\nIngrese nota 1........: ");
		scanf("%d", &r[i].nota[0]);
		printf("\nIngrese nota 2........: ");
		scanf("%d", &r[i].nota[1]);
		r[i].prom=(float)(r[i].nota[0]+r[i].nota[1])/2;
		
		if((r[i].nota[0]<4)&&(r[i].nota[1]<4))
        {
				r[i].estado='L';
		}
		else
            if((r[i].nota[0]>=8)&&(r[i].nota[1]>=8))
            {
				r[i].estado='P';
		    }
		    else 
		    {
                r[i].estado='R';
                }
		
		system("cls");
	}

}

void imprimir(void)
{
	int i;
	printf("Nro\tNombre\t\tApellido\tN1\tN2\tProm.\tEstado\n");
	for(i=0;i<tam;i++)
    {
		printf("%d\t", i+1);
		printf("%s\t", r[i].nombre);
		printf("%s\t\t", r[i].apellido);
		printf("%d\t", r[i].nota[0]);
		printf("%d\t", r[i].nota[1]);
		printf("%.2f\t", r[i].prom);
		printf("%c\n", r[i].estado);
	}
}

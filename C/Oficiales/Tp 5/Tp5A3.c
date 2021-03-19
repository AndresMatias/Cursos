#include <stdio.h>
 
int main(int argc, char *argv[]) {
	int nl,nota,a,r,p;
	printf("Ingrese el numero de legajo del alumno,\npara salir ingrese un numero menor a cero\n");
	scanf("%d",&nl);
	printf("\n");
	while(nl>=0)
	{
		printf("Ingrese la nota del alumno\n");
		scanf("%d",&nota);
		printf("\n");
		while((nota<=0)||(nota>10))
		{
			printf("Ingrese nuevamente la nota del alumno pero correctamente\n");
			scanf("%d",&nota);
			printf("\n");
		}
		if(nota<6)
		{
			printf("Legajo %d R\n",nl);
			r++;
			
		}
		if((nota>=6)&&(nota<7))
		{
			printf("Legajo %d A\n",nl);
			a++;
		}
		if(nota>=7)
		{
			printf("Legajo %d P\n",nl);
			p++;
		}
		printf("\n");
		printf("La cantidad de alumnos reprobados son %d\n",r);
		printf("La cantidad de alumnos aprobados son %d\n",a);
		printf("La cantidad de alumnos promocionados son %d\n",p);
		printf("\n");
		printf("Ingrese el numero de legajo del alumno,\npara salir ingrese un numero menor a cero\n");
		scanf("%d",&nl);
	}
	return 0;
}


#include <stdio.h>
#define tam 6
int main(int argc, char *argv[]) 
{
	int leg[tam],nota[tam],leg2[tam],i=0,j=0,clave; 
		for(i=0;i<tam;i++)
		{
			j++;
			printf("Ingrese el legajo del alumno %d: ",j);
			scanf("%d",&leg[i]);
			printf("Ingrese la nota del alumno %d: ",j);
			scanf("%d",&nota[i]);
			printf("\n");
		}
	printf("Ingrese la nota que quiere buscar: ");
	scanf("%d",&clave);
	j=0;
	i=0;
	for(i=0;i<tam;i++)
		{
			if(nota[i]==clave)
				{
					leg2[j]=leg[i];
					j++;
				}
		}
	printf("Los alumnos con la nota %d , los de que proceden\na a tener los siguiente legajos:\n",clave);
	i=0;
	for(i=0;i<j;i++)
		{
			printf("%d\n",leg2[i]);
		}
	return 0;
}

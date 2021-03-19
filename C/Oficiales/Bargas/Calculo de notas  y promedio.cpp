#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
main()
{int acumN, Nmay, Nmen, i, Nota;
 float prom;
 acumN=0; Nmay=0; Nmen=10;
 printf("Este Programa calcula la nota promedio de 30 alumnos\nen el parcial de Bargas\n");
 for(i=1;i<=30; i++)
 {
	 printf("\nIngrese nota %d\n",i);
 scanf("%d", &Nota);
 while((Nota<0)||(Nota>10))
 {
 printf("\nIngrese la nota nuevamente\n");
 scanf("%d", &Nota);
 }
 acumN=acumN+Nota;
 if(Nota>Nmay)
 	Nmay=Nota;
 if(Nota<Nmen)
 	Nmen=Nota;	
 }
prom=(float)acumN/30;
printf("El promedio es %.2f\n", prom);
printf("\nLa nota mayor es %d\n", Nmay);
printf("\nLa nota menor es %d\n", Nmen); 
return(0);
}

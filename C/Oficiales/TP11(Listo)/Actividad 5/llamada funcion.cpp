#include <stdio.h>
#include <stdlib.h>

void llamada(void);

int main()
{
    int a, flag=0;
printf("\tPROGRAMA QUE LLEVA CUENTA DE CUANTAS VECES ES LLAMADA UNA FUNCION\n\n");
printf("Llamar funcion?\n\nSI\t\t1\n\nSalir\t\t2\n\n");
while(flag==0)
{
 scanf("%d", &a);
 switch(a)
      {   
      case 1:
           llamada();
           break;
      case 2:
           flag=1;
           break;
      }
}
system ("PAUSE");
return 0;
}    

void llamada ()
{
     static int cont=0;
     cont++;
     printf("Funcion Llamada %d veces\n", cont);
}

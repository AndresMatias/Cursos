#include <stdio.h>
#include <stdlib.h>


int mayor( int a, int b, int c);
int main ()
{
   int a, b, c;
   printf("\t\t\tINGRESE TRES NUMEROS\n\n");
   scanf("%d%d%d", &a, &b, &c);
   printf("\n\nEl mayor es %d\n\n", mayor (a, b, c));

system ("PAUSE");
return 0;
}

int mayor ( int a, int b, int c)
{
    int max;
    max=a;
    if(b>a)
    {
       max=b;
    }
    if (c>b)
    {
       max=c;
    }
return(max);
}

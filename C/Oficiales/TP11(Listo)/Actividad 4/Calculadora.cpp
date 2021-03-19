#include <stdio.h>
#include <stdlib.h>

int suma(int a, int b);
int rest(int a, int b);
int mult(int a, int b);
float division(int a, int b);

int main ()
{
    int x, y, c, flag=0;
    while(flag==0)
    {
       printf("\n\t\t\tCALCULADORA\n\n\nSuma\t\t1\n\nResta\t\t2\n\nMutiplicacion\t3\n\nDivision\t4\n\n\nSalir\t\t5\n");
       scanf("%d", &c);
         switch(c)
         {
               case 1:
                    system("cls");
                    printf("SUMA\nIntroduzca numeros a operar\n");
                    scanf("%d%d", &x, &y);
                    printf("El resultado es %d", suma(x, y));
                    break;
               case 2:
                    system("cls");
                    printf("RESTA\nIntroduzca numeros a operar\n");
                    scanf("%d%d", &x, &y);
                    printf("El resultado es %d", rest(x, y));
                    break;
               case 3:
                    system("cls");
                    printf("MULTIPLICACION\nIntroduzca numeros a operar\n");
                    scanf("%d%d", &x, &y);
                    printf("El resultado es %d", mult(x, y));
                    break;
              case 4:
                    system("cls");
                    printf("DIVISION\nIntroduzca numeros a operar\n");
                    scanf("%d%d", &x, &y);
                    while(y==0)
                    {
                        printf("No se puede dividir por cero. Reingrese divisor");
                        scanf("%d", &y);
                    }
                    printf("El resultado es %2.2f", division(x, y));
                    break;
               case 5:
                    flag=1;
                    break;
         }
    }
system("PAUSE");
return 0;
}

int suma(int a, int b)
{
    int res;
    res=a+b;
    return res;
}

int rest(int a, int b)
{
    int res;
    res=a-b;
    return res;
}

int mult(int a, int b)
{
    int res;
    res=a*b;
    return res;
}

float division(int a, int b)
{
    float res;
    res=(float)a/b;
    return res;
}


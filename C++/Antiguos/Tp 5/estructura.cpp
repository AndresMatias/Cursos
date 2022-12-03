#include<stdlib.h>
#include<stdio.h>
#include<conio.h>
void suma(int a,int b,int c,int d);
struct nc
{
 int real;
 int imaginario;   
}ident,ident2,ident3;
main()
{
    Printf("Ingrese el primer numero complejo");
    scanf("%d""%d",&ident.real,&ident.imaginario);
    Printf("Ingrese el segundo numero complejo");
    scanf("%d""%d",&ident2.real,&ident2.imaginario);
    suma(ident.real,ident.imaginario,ident2.real,ident2.imaginario);
    system("pause");
    return 0;
}
void suma(int a,int b,int c,int d)
{
    ident3.real=a+c;
    ident3.imaginario=b+d;
    printf("%d + %di\n",ident3.real,ident3.imaginario);
    system("pause");
}

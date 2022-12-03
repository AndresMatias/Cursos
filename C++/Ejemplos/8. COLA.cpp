/*diseñar un programa que oermita crear una cola dinámica con nº enteros 
ingresados por teclado. Recorrerlo y mostrar por pantalla*/

#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>
struct cola
{
    int n;
    struct cola *psig;
};

int main()
{
    struct cola *p, *q, *base;
    char op;
    base=NULL;
    q=NULL;
    p=(struct cola *)malloc(sizeof(*p));
    if (p!=NULL)  /*CONTROLAR QUE EL PUNTERO HALLA AGARRADO UN ESPACIO DE MEMORIA, DE LO CONTRARIO SE TERMINA EL PROGRAMA*/
    {
        printf("ingrese numero");
        scanf("%d",&(*p).n);
        (*p).psig=NULL;
        base=p;
        q=p;
        printf("para ingrasar otro nodo ingrese s");
        scanf("%s",&op);
    }
    else
    {
        printf("no hay lugar de memoria\n");
    }
     while(op=='s')
            {
                printf("ingrese numero");
                q=(struct cola *)malloc(sizeof(*q));
                scanf("%d",&(*q).n);
                (*p).psig=q;
				(*q).psig=NULL;
                p=q;                   
                printf("para ingrasar otro nodo ingrese s");
                scanf("%s",&op);   
            }
            /*IMPRIMIR*/
            p=base;
            while(p!=NULL)
            {
                printf("%d",(*p).n);
                p=(*p).psig;
            }
            system ("pause");
}

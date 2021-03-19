#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <malloc.h>



struct arbol
{
    int dato;
    struct arbol *izq,*der;
};

void in_orden(struct arbol *);
void pre_orden(struct arbol *);
void post_orden(struct arbol *);

int main()
{
    struct arbol *q=NULL,*marca=NULL,*actual=NULL,*raiz=NULL;
    int num,bandera,impresion;
    
    printf("introducir dato:\t");
    q=new arbol();
    scanf("%d",&q->dato);
    q->izq=NULL;
    q->der=NULL;
    raiz=q;
    printf("\nPara ingresar otro ingrese 1\t");
    scanf("%d",&num);
    while(num==1)
    {
        printf("introducir dato:\t");
        q=new arbol();
        scanf("%d",&q->dato);
        q->izq=NULL;
        q->der=NULL;
        actual=raiz;
        
        while(actual!=NULL)
        {
            if(q->dato<actual->dato)
            {
                marca=actual;
                actual=actual->izq;
                bandera=0;
            }
            else
            {
                marca=actual;
                actual=actual->der;
                bandera=1;
            }
        }
        if(bandera==0)
        {
            marca->izq=q;
        }
        else
        {
            marca->der=q;
        }
        printf("\nPara ingresar otro ingrese 1:\t");
        scanf("%d",&num);            
    }
do{
    printf("\nOPCIONES DE IMPRESION:\n1.-\tIn-orden\n2.-\tPre-orden\n3.-\tPost-orden\n cualquier otro para salir");
    scanf("%d",&impresion);
     printf("\n");
    switch(impresion)
        {
            case 1: 
                    in_orden(raiz);
                         printf("\n");
                    break;
            case 2: 
                    pre_orden(raiz);
                         printf("\n");
                    break;
            case 3: 
                    post_orden(raiz);
                         printf("\n");
                    break;
            default:return 0;            
        
        }
}while((impresion>0) && (impresion<4));
    
    system("PAUSE");    
    return 0;

}

void pre_orden(struct arbol *p)
{
    if ( p != NULL ) 
        { 
            printf ( "%d\t", p->dato);
            pre_orden ( p->izq);
            pre_orden (  p->der);
        }

}

void in_orden(struct arbol *p)
{
    if(p!=NULL)
    {
        in_orden(p->izq);
        printf("%d\t",p->dato);
        in_orden(p->der);
    }
}

void post_orden(struct arbol *p)
{
    if(p!=NULL)
    {
        post_orden ( p->izq);
        post_orden (  p->der);
        printf ( "%d\t", p->dato);
    }
}

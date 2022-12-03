/*12) crear una pila dinamica con numeros enteros tomados del teclado.
 luego crear una cola dinamica con los datos almacenados en la pila 
 que sean positivos. mostrar las estructura por pantalla.*/
 
 #include <stdio.h>
 #include <malloc.h>
 struct nodo
    {
        int a;
        struct nodo *psig;            
    };


main()
{
    int i;
    char op;
    struct nodo *base,*p,*ultimo,*primero,*q;
    p=(struct nodo *)malloc(sizeof(*p));
    base=NULL;
    if(p!=NULL)
    {
        printf("ingrese numeros. si desea dejar de ingresar oprima 's'\n");
        scanf("%d",(*p).a);
        (*p).psig=NULL;
        printf("ingrese 's' para continuar cargando numeros. De lo contrario, ingrese otra letra\n");
        scanf("%s",&op);
    }
     else
     {
        printf("no hay memoria");  
        exit (0);
     }
     while(op=='s')
     {
            printf("ingrese dato\n");
            scanf("%d",(*p).a);
            (*p).psig=base;
            base=p;
            printf("ingrese 's' para cargar o cualquier otra letra para salir\n");
            scanf("%s",&op);
     }
     p=base;
     ultimo=NULL;
     primero=NULL;
     while(p!=NULL)
     {
            if((*p).a>=0)
            {
                q=(struct nodo *)malloc(sizeof(*q));
                (*q).a=(*p).a;
                (*q).psig=NULL;
                if(primero==NULL)
                {
                    primero=q;
                }
                else
                {
                    (*ultimo).psig=q;
                }
            }
            p=(*p).psig;
            printf("PILA:");
            p=base;
            while(p!=NULL)
            {
                printf("%d\t",(*p).a);
                p=(*p).psig;
            }
            printf("COLA:");
            q=primero;
            while(q!=NULL)
            {
                printf("%d\t",(*q).a);
                q=(*q).psig;
            }
            return 0;
}
}

#include<stdlib.h>
#include<stdio.h>
void nc(int *p);
main()
{
    int c[10],i=0,*p;
    for(i=0;i<10;i++)
    {
        scanf("%d",&c[i]);
    }
    p=c;
    nc(p);
    system("pause");
    return 0;
}
void nc(int *p)
{  
    int i;
    for(i=0;i<10;i++)
    {
        printf("Valor: %d\n", *(p+i));
    }      
}

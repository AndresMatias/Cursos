#include<stdlib.h>
#include<stdio.h>
#include<malloc.h>

struct autoref
{
    char c;
    struct autoref *psig;
};

main()
{
    char c;   
    struct autoref *base,*p;
    base=NULL;
    while((c=getchar())!='s')
        {
            p=(struct autoref *)malloc(sizeof(*p));
            (*p).c=c;
            (*p).psig=base;
            base=p;
        }
    while(p!=NULL)
        {
            printf("%c",(*p).c);
            p=(*p).psig;
            
        }
        system("PAUSE");
    return 0;    
}

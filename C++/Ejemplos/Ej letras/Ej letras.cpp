#include<stdlib.h>
#include<stdio.h>
void nc(char *p);
int main()
{
    char c[10],*p;
    int i=0;
    for(i=0;i<10;i++)
    {
        scanf("%s",&c[i]);
    }
    p=c;
    nc(p);
    system("pause");
    return 0;
}
void nc(char *p)
{  
    int i;
    for(i=0;i<10;i++)
    {
        printf("Valor: %s\n",p);
    }      
}

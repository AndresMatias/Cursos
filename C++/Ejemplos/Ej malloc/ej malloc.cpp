#include<stdio.h>
#include<stdlib.h>
int main()
{
    int i=0,*p,n=0;
    printf("Ingrese n \n"); 
    scanf("%d",&n);
    p=(int*)malloc(n*sizeof(int));
    for(i=0;i<n;i++)
    {
        scanf("%d",&p);
        printf("\n%d",p);    
    }
    free(p);
    printf("\n %d",p);
    system("pause");   
    return(0);
}


#include <stdio.h>
#include <stdlib.h>
int n(int a); 
void origen(char [],char [],int i,int j,int k); 
void destino(char [],int); 
void pantalla(char [],int); 
                                
main()
{
    int n=0,i=0;
    char o[20],d[20];
    n=n(i);
    origen(o,d,n);
        
    
}    
int n()
{
    int a;
    printf("Ingrese el tamaño de n");
    scanf("%d",&a);
    return(a);
}
void origen(char o[20],char d[20],int i,int j,int n) 
{
    printf("Ingrese los datos");
    for(i=0;i<n;i++)
    {
        scanf("%s",&o[i]);
        if(((o[i]>='A')&&(o[i]<='Z'))&&((o[i]>='A')&&(o[i]<='Z')))
        {
            d[i]=o[j];
            j=j+1;
        }
    }   
}       

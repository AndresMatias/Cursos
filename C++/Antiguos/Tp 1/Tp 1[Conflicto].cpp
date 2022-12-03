//1)Implementar un programa c/c++ que permita crear un arreglo de caracteres de tamaño n,//
// el tamaño y los elementos se ingresan por teclado. "Se desea" reconocer el arreglo origen //
// y copiar en otro arreglo "destino", los elementos que sean letras. Mostrar los dos arreglos//
// por pantalla. Ademas se pide implementar metodos(funciones o procedimientos)para://
 //-Ingresar n//
 //-cargar arreglo origen//
 //-copiar arreglo destino//
 //-mostrar por pantalla//
#include<stdlib.h>
#include<stdio.h>
#include<conio.h>
int n(int n);                       //-Ingresar n//
char *cargarao(int n1,char *p);              //-cargar arreglo origen//
char *copiarad(int b,char *p1);            //-copiar arreglo destino//  
void mostrar(char *p3);             //-mostrar por pantalla//
int main()
{ 
    int a,i=0;
    char *p2,*p3;
    a=n(a);
    p2=new char[a];                          //Ingresar n//
    p2=cargarao(a,p2);               //arreglo origen//                  
    for(i=0;i<a;i++)
    {
        printf("%c",*(p2+i));
    }
    system("PAUSE");
    p3=new char[a];
    p3=copiarad(a,p2); 
    
}
int n(int n)                        //Ingresar n//
{
    printf("Ingrese el el tamaño de su arreglo");
    scanf("%d",&n);
    return n;
}
char *cargarao(int n1,char *p)      //arreglo origen//
{
    int i=0;  
    p=new char[n1];
    printf("%d\nIngrese los datos\n",n1);
    for(i=0;i<n1;i++)
    {
        scanf("%s",&*(p+i));
    }
    return(p);            
}
char *copiarad(int b,char *p1)
{
    int i1=0,c=0;
    char *p4;
    p4=new char[b];   
    for(i1=0;i1<b;i1++)
    {
        printf("%c",*(p1+i1));
    }
    printf("\n%d",b);
    system("PAUSE"); 
    for(i1=0;i1<b;i1++)    //El problema comienza desde aca//
    {
        if((*(p1+i1)>='A')&&(*(p1+i1)<='Z'))
        {        
            *(p4+c)=*(p1+i1);
            c++;
        }
          if((*(p1+i1)>='a')&&(*(p1+i1)<='z'))
        {
            *(p4+c)=*(p1+i1);
            c++;            
        }  
    }  
    i1=0;
    for(i1=0;i1<c;i1++)
    {
        printf("\n%c\n",*(p4+i1));
    }
    system("PAUSE");         
}

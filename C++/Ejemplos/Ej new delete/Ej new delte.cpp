#include<stdlib.h>
#include<stdio.h>
main() 
{
    int *p;
    p=new int[50]; // en vez de 50 reemplazo con una variable "n" ingresado el tamaño que quiero ponerle a tarvez de un scanf
    delete []p; //libero a p de los 50 y/o "n"espacios que reserve
	//Si uso new [] libero con delete []
}

#include<stdio.h>
#include<stdlib.h>
#include<conio.h>


int main(int argc, char *argv[]) 
{
	int i=0;				
	char a[60];
	for(i=0;i<60;i++)
	{
		a[i]=0;
	}
	printf("Escribe tu nombre: ");
	gets(a);
	printf("%s",a);
	return 0;
}


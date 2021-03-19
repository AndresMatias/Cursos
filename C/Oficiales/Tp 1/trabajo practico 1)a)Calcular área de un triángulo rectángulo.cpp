#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
	int b,h,sup;
	printf("este programa calcula el area de un triangulo rectangulo\n");
	printf("ingrese la base\n");
	scanf("%d",&b);
	printf("ingrese la altura\n");
	scanf("%d",&h);
	sup=((b*h)/2);
	printf("el area es de :%d\n",sup);
	printf("fin del programa");
	system("PAUSE");	
	return 0;
}

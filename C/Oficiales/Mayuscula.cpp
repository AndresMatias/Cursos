#include <stdio.h>
#include <stdlib.h>
void Ma(char *b);

int main(int argc, char *argv[]) 
{
	char a;
	printf("Ingrese una letra minuscula ");
	scanf("%c",&a);
	Ma(&a);
	return 0;
}
void Ma(char *b)
{
	*b=*b-32;
	printf("La letra es %c",*b);
}



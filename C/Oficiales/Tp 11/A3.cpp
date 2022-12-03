#include <stdio.h>
void func();
int main(int argc, char *argv[]) 
{
	int i=0;
	while(i==0)
		{
			func();
			printf("Si desea salir presione un numero distinto de cero");
			scanf("%d",&i);
		}
	return 0;
}
void func()
{
	static int a=0;
	a++;
	printf("\nEsta funcion fue llamada %d veses\n",a);
}


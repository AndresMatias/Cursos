#include <stdio.h>

void cubo(int *puntero);

int main(int argc, char *argv[]) 
	{
	int numero = 5,punt;
	printf("el valor del del numero %d y la direccion es %x",numero,&numero);
	cubo(&numero);
	printf("\nnuevo valor %d, y la direccion del puntero es %x",punt,&punt);

		return 0;
}

void cubo(int *puntero)
{
	*puntero = *puntero * *puntero * *puntero;

}

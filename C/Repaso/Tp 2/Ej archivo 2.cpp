#include <conio.h>
#include <stdio.h>
#include <stdlib.h>
int main(int argc, char *argv[]) 
{
	{
		FILE *archivo;
		
		char caracteres[100];
		
		archivo = fopen("fichero.txt","r");
		
		if (archivo == NULL)
			exit(1);
		
		printf("\nEl contenido del archivo de prueba es \n\n");
		while (feof(archivo) == 0)
		{
			fgets(caracteres,100,archivo);
			printf("%s",caracteres);
		}
		system("PAUSE");
		
		fclose(archivo);
		return 0;
	}
}

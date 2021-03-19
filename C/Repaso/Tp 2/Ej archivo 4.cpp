#include <conio.h>
#include <stdio.h>
#include <stdlib.h>
int main(int argc, char *argv[]) 
{
	FILE *fp;
	
	char cadena[] = "Mostrando el uso de fputs en un fichero.\n";
	
	fflush(stdin);
	fgets(cadena,100,stdin);
	fp = fopen ( "fichero.txt", "r+" );
	
	fputs( cadena, fp );
	
	fclose ( fp );
	
	return 0;
}

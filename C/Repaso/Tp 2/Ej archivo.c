#include<stdio.h>					
#include<stdlib.h>
#include<conio.h>

int main(int argc, char *argv[]) 
{
	FILE *fp;
	char buffer[100] = "Esto es un texto dentro del fichero.";
	fp = fopen ( "fichero.txt", "w+" );
	fflush(stdin);	
	fgets(buffer,100,fp);
	printf("%s",buffer);
	fprintf(fp, "%s", "\nH.");
	fclose ( fp );
	return 0;
}


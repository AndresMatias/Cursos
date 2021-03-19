#include <stdio.h>

int main(int argc, char *argv[]) 
{
	char *a;
	int b=0;
	*a='c';
	b=*a;
	*a=b+1;
	printf("%d",b);
	printf("%c",*a);
	return 0;
}


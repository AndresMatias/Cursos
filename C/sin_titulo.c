#include <stdio.h>
float func(int,float);
int main(int argc, char *argv[]) 
{
	int a=4;
	float v=5.33,d;
	printf("suma 'a' mas 'v'\n");
	d=func(a,v);
	printf("el res es %.2f",d);

	return 0;
}
float func(int s,float k)
{
	float n;
	n=s+k;
	return(n);
}

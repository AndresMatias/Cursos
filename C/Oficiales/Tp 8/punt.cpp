#include <stdio.h>
int main(int argc, char *argv[]) 
	{
	int v1,v2,*punt1,*punt2;
	printf("ingrese dos numeros enteros\n");
	scanf("%d%d",&v1,&v2);
	printf("v1=%d y v2=%d estan almacenados en %x y %x\n",v1,v2,&v1,&v2);
	punt1=&v1;
	punt2=&v2;
	*punt1=*punt1+10;
	*punt2=*punt2-2;
	printf("v1=%d y v2=%d estan almacenados en %x y %x\n",v1,v2,&v1,&v2);
	printf("ahora con los punteros");
	printf("*punt1=%d y *punt2=%d y  esta almacenado en %p y  %p\n",*punt1,*punt2,punt1,punt2);
	printf("conclusiones:\n");
	return 0;
}

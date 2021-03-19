#include <stdio.h>
#define tam 2
int main(int argc, char *argv[]) {
	float vi,vf,d[tam][tam],a[tam][tam],t[tam][tam];
	int i,k;
	printf("Ingrese la velocidad inicial en km/h\n");
	scanf("%f",&vi);
	printf("ingrese la velocidad final en km/h\n");
	scanf("%f",&vf);
	
	for(i=0;i<tam;i++)
	{
		for(k=0;k<tam;k++)
		{
		printf("ahora ingrese el tiempo %d en hora\n",i+1);
		scanf("%f",&t[i][k]);
		a[i][k]=(vf-vi)/t[i][k];
		d[i][k]=(vi*t[i][k])+(a[i][k]*(1/2)*t[i][k]);
		}
	}	
	
	for(i=0;i<tam;i++)
	{
		
		for(k=0;k<5;k++)
		{
		if((k==0)&&(i==0))
		{
			printf("tiempo\t");
		}
		if((k==1)&&(i==0))
		{
			printf("aceleracion\t");
		}
		if((k==2)&&(i==0))
		{
			printf("velocidad\t");
		}
		if((k==3)&&(i==0))
		{
			printf("espacio\t\n");
		}
		if((k==0)&&(i!=0))
		{
			printf("%d) %.2f\t",i+1,t[i][k]);
		}
		if((k==1)&&(i!=0))
		{
			printf("%d) %.2f\t",i+1,a[i][k]);	
		
		}
		if((k==2)&&(i!=0))
		{
			printf("%d) %.2f\t",i+1,(vf-vi));
			
		}
		if((k==3)&&(i!=0))
		{
			printf("%d) %.2f\t",i+1,d[i][k]);
		}
		}
	}
	return 0;
}
	


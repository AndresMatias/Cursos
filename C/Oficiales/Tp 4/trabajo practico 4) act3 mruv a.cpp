#include <stdio.h>
#define tam 3
int main(int argc, char *argv[]) {
	float vi,vf,d[tam],a[tam],t[tam];
	int i,k;
	printf("Ingrese la velocidad inicial en km/h\n");
	scanf("%f",&vi);
	printf("ingrese la velocidad final en km/h\n");
	scanf("%f",&vf);
		for(k=0;k<tam;k++)
		{
		i++;
		printf("ahora ingrese el tiempo %d en horas\n",i);
		scanf("%f",&t[k]);
		a[k]=((vf-vi)/t[k]);
		d[k]=(vi*t[k])+(a[k]*(1/2)*t[k]);
		}
		printf("distancia\n");
		for(k=0;k<tam;k++)
		{
		printf("%.2f\t\n",d[k]);
		}
	return 0;
}
	


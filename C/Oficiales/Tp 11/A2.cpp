#include <stdio.h>
#define tam 3
float calc(float a,float b,float h);

int main(int argc, char *argv[]) 
{ 	
	float f=0,g=0,c=0;
	int d=0;
	char s[tam]={' '};
	while(d!=2)
	{	
		f=0;
		g=0;
		c=0;
		d=0;
		printf("Para sumar presione 1\nPara restar presione 2\nPara multiplicar presione 3\nPara dividir presione 4\nPara potenciar numeros enteros presione 5\n");
		scanf("%f",&c);
		while((c<1)||(c>5)) /* Este while sirve para determinar si los numeros ingresados entan dentro del rango para elegir las operaciones mencionadas arriba*/
		{
			printf("Elija nuevamente la operacion que desea pero con los numeros enteros del 1 al 5\n");
			scanf("%f",&c);
		}
		if((c>=1)&&(c<=4))    
		{
			printf("Ingrese el primer numero\n");
			scanf("%f",&f);
			printf("Ingrese el segundo numero\n");
			scanf("%f",&g);
		}
		if(c==5)
		{
			printf("Ingrese la base de la potencia\n");
			scanf("%f",&f);
			printf("Ingrese la potencia\n");
			scanf("%f",&g);
		}
		printf("El resultado es %.2f\n",calc(f,g,c));
		printf("Si desea salir del programa presione la letra ""s""\npara seguir presione la letra ""n""\n");
		scanf("%s",&s[tam]);
		if(s[tam]=='s')
		{
			d=2;
		}
	}
	return 0;
}

float calc(float a,float b,float h)
{
	float op=0,e=0;
	int h1;
	h1=h;
	switch(h1)
	{
	case 1:
		op=a+b;
		break;
	case 2:
		op=a-b;
		break;
	case 3:
		op=a*b;		
		break;
	case 4:
		op=a/b;
		break;
	case 5:				
		op=1;
		while(b!=e)  /* Este while sirve para determinar la pontecia sin necesidad de usar la funcion de exp solo para numeros enteros*/
		{	
			op=op*a;
			if(b>0)
			{
				e++;						
			}
			if(b<0)
			{
				e--;					
			}
			if((b<0)&&(b==e))
			{
				op=(1/op);								
			}
		}
	}
 return op;
}

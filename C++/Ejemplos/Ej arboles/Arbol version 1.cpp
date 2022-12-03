#include <stdio.h>
#include <stdlib.h>
void in_orden(struct nodo *p);
void pre_orden(struct nodo *p);
void post_orden(struct nodo *p);
struct nodo
{
	int dato;
	struct nodo *izq,*der;
};
int main(int argc, char *argv[]) 		//Cuerpo del programa
{
	struct nodo *mem,*memaux,*base;			//mem:struct dodne creo el nodo he ingreso el dato, memaux:struct que me sirve para pasar de un nodo a otro, base:struct doden guardo el nodo raiz(el primer nodo creado)
	int b1=0,b2=0,b3=0,b4=0,dato=0;			//b1:bandera del while, b2:bandera del if del primer nodo creado, dato:Ingreso del dato
	while(b1!=1)
		{
			if(b2==0)	//Se crea el primer nodo
				{
					mem=new nodo();
					printf("\nIngrese un numero:");
					scanf("%d",&dato);
					mem->dato=dato;		//Guardo el dato en un struct
					mem->izq=NULL;		//Igualo los puntero del 1er nodo al null
					mem->der=NULL;		
					memaux=mem;			//Para ir pasando entre un nodo y otro asi puedo volver a usar el struct "mem"
					base=mem;			//Guardo la DIRECCION del primer nodo para tener una referencia
				}
			b2++;				//Para que no vuelva a entrar en el if
			if(b2>2)
				{
					if(b2==12)	//Menu que da la opcion de salir luego de ingresar 10 valores
						{
							printf("\nPara salir presione 1 sino otro numero");
							scanf("%d",&b1);
							b2=2;	//Para que no exeda el limite de su valor en el espacio que tiene reservado en memoria en caso de que se ingresen varios nodos
						}
					if(b1!=1)	//En caso de que el usuario decida salir no entrara al if y saldra directamente a las opciones de impresion
						{
							mem=new nodo();		//Esta parte es igual que cuando ingreso el primer dato(nodo raiz) salvo por el menu de salida y el menu que comprueba que el dato ingresado sea menor o mayor al nodo raiz
							printf("\nIngrese un numero mayor o menor que %d:",base->dato);
							scanf("%d",&dato);
							while(dato==base->dato) //Para evitar que el dato ingresado sea igual al dato almacenado en el atenrior nodo
								{
									printf("\nIngrese un numero mayor o menor que %d:",base->dato);
									scanf("%d",&dato);
								}
							mem->dato=dato;		
							mem->izq=NULL;		
							mem->der=NULL;
							memaux=base;
							b3=0;
							while(b3!=1)	//Metodo para comparar valores y saber doden se vaa guardar el dato ingreado		
								{
									if((dato<memaux->dato))		//Si el dato es menor que el dato en el nodo actual	y el nodo raiz(subarbol izquierdo)
										{
											if(memaux->izq!=NULL)	//Si el struct izquierdo es distinto de NULL pasa al siguiente nodo izquierdo
												{
													memaux=memaux->izq;
												}
											if((memaux->izq==NULL)&&(dato<memaux->dato))	//Si es igual a NULL y el dato es menor dato actual
												{											//debido a que en el if de arriba paso al siguiente nodo
													memaux->izq=mem;						//y el dato en el siguiente nodo puede ser menor al dato 
													mem=NULL;								//ingresado por lo cual el dato actual se tendria que almacenar
													b3=1;									//en el nodo derecho del nodo al que acaba de pasar memaux
												}
										}
									if((dato>memaux->dato))		//Igual que	if((dato<memaux->dato)) pero el dato ingresado es mayor del nodo raiz(subarbol derecho)
										{
											if(memaux->der!=NULL)
												{
													memaux=memaux->der;
												}
											if((memaux->der==NULL)&&(dato>memaux->dato))
												{
													memaux->der=mem;
													mem=NULL;
													b3=1;
												}
										}										
								}
						}
				}
		}
	while(b4!=4)	//Menu para selecionar el metodo de impresion(pre_orden,in_orden o post_orden)
		{
			printf("\nSi desea imprimir en pre orden presione 1\nSi desea imprimir en in orden presione 2\nSi desea imprimir en post orden presione 3\nSi desea salir presione 4:");
			scanf("%d",&b4);
			printf("\n\n\n");
			if(b4==1)	//Selecciones el metodo de pre_orden
				{
					pre_orden(base);
				}
			if(b4==2)	//Selecciones el metodo de in_orden
				{
					in_orden(base);
				}
			if(b4==3)	//Selecciones el metodo de post_orden
				{
					post_orden(base);
				}
			printf("\n\n\n");
		}
	return 0;
}
void pre_orden(struct nodo *p)			//Imprime en pre_orden(raiz,izquierda,derecha)
{
	if (p!=NULL) 
		{ 
			printf ("%d\t",p->dato);	
			pre_orden(p->izq);
			pre_orden(p->der);
		}
	
}
void in_orden(struct nodo *p)			//Imprime en in_orden(izqquierda,raiz,derecha)
	{
	if(p!=NULL)
		{
			in_orden(p->izq);
			printf("%d\t",p->dato);
			in_orden(p->der);
		}
}
void post_orden(struct nodo *p)			//Imprime en post_orden(izquierda,derecha,raiz)
{
	if(p!=NULL)
		{
			post_orden(p->izq);
			post_orden(p->der);
			printf("%d\t", p->dato);
		}
}

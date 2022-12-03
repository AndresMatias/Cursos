#include <iostream>
using namespace std;
//Estructura del nodo
struct Nodo
{
	int Dato;
	Nodo *N_I=NULL,*N_D=NULL;
};
//Funciones de Impresion
void in_orden(Nodo *p);
void pre_orden(Nodo *p);
void post_orden(Nodo *p);

int main(int argc, char *argv[])
{
	Nodo *Base=NULL,*Mem=NULL,*Mem_Aux=NULL;
	int Bandera_1=0,Dato_Aux=0;
	cout<<"Este programa almacena datos en un arbol para salir de la carga de datos ingrese un -1"<<endl<<endl;
	while(Bandera_1!=1)
	{
		cout<<"Ingrese el dato:";
		cin>>Dato_Aux;
		cout<<endl;
		while((Base!=NULL)&&(Dato_Aux==Base->Dato)) //Para evitar que el dato ingresado sea igual al dato almacenado en el atenrior nodo
		{
			cout<<"Ingrese el dato:";
			cin>>Dato_Aux;
			cout<<endl;
		}
		if(Dato_Aux==-1)
		{
			Bandera_1=1;
			
		}
		if((Base!=NULL)&&(Dato_Aux!=-1))
		{
			Bandera_1=2;
		}
		if(Bandera_1==0)	//Creo el Nodo Base
		{
			Mem=new Nodo();
			Mem->Dato=Dato_Aux;
			Base=Mem;
			Mem_Aux=Mem;
			Mem=NULL;
		}
		if(Bandera_1==2)	//Creo el resto de los Nodos
		{
			Mem=new Nodo();
			Mem->Dato=Dato_Aux;
			Mem_Aux=Base;
			while(Bandera_1!=3)
			{
				if(Dato_Aux<Mem_Aux->Dato) //Nodo Izquierdo
				{
					if(Mem_Aux->N_I!=NULL)
					{
						Mem_Aux=Mem_Aux->N_I;
					}
					if((Mem_Aux->N_I==NULL)&&(Dato_Aux<Mem_Aux->Dato))
					{
						Mem_Aux->N_I=Mem;
						Bandera_1=3;
					}
				}
				if(Dato_Aux>Mem_Aux->Dato) //Nodo Derecho
				{
					if(Mem_Aux->N_D!=NULL)
					{
						Mem_Aux=Mem_Aux->N_D;
					}
					if((Mem_Aux->N_D==NULL)&&(Dato_Aux>Mem_Aux->Dato))
					{
						Mem_Aux->N_D=Mem;
						Bandera_1=3;
					}
				}
				if(Dato_Aux==Mem_Aux->Dato)
				{
					Bandera_1=3;
				}
			}
			Mem=NULL;
			Mem_Aux=NULL;
		}
	}
	Bandera_1=0;
	while((Bandera_1!=4)||((Bandera_1<1)||(Bandera_1>4)))
	{
		cout<<"A)Presione 1 para imprimir el arbol en In_Orden"<<endl;
		cout<<"B)Presione 2 para imprimir el arbol en Pre_Orden"<<endl;
		cout<<"C)Presione 3 para imprimir el arbol en Post_orden"<<endl;
		cout<<"D)Presione 4 para Salir del Programa"<<endl<<endl;
		cout<<"Seleccione una opcion:"<<ends;
		cin>>Bandera_1;
		if(Bandera_1==1)	//Selecciones el metodo de in_orden
		{
			in_orden(Base);
		}
		if(Bandera_1==2)	//Selecciones el metodo de pre_orden
		{
			pre_orden(Base);
		}
		if(Bandera_1==3)	//Selecciones el metodo de post_orden
		{
			post_orden(Base);
		}
		cout<<endl<<endl;
	}
	return 0;
}

void pre_orden(Nodo *p)			//Imprime en pre_orden(raiz,izquierda,derecha)
{
	if (p!=NULL) 
	{ 
		cout<<p->Dato<<endl;	
		pre_orden(p->N_I);
		pre_orden(p->N_D);
	}
	
}
void in_orden(Nodo *p)			//Imprime en in_orden(izqquierda,raiz,derecha)
{
	if(p!=NULL)
	{
		in_orden(p->N_I);
		cout<<p->Dato<<endl;
		in_orden(p->N_D);
	}
}
void post_orden(Nodo *p)			//Imprime en post_orden(izquierda,derecha,raiz)
{
	if(p!=NULL)
	{
		post_orden(p->N_I);
		post_orden(p->N_D);
		cout<<p->Dato<<endl;
	}
}


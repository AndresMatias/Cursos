#include <stdio.h>
#include <stdlib.h>
#include <iostream>
using namespace std;

struct Nodo
{
	int Dato;
	Nodo *Siguiente=NULL;
};

//Variables Globales
int Posicion=0,Bandera_1=1,i=0,j=0;
Nodo *Inicio=NULL,*Fin=NULL,*Actual=NULL,*Auxiliar_1=NULL,*Auxiliar_2=NULL;
												
//Funciones para trabajar cn la lista simple
int Crear_Nodo();
int Destruir_Nodo();
int Imprimir_Lista();

int main(int argc, char *argv[]) 
{
	
	int Bandera_2=0;
	while(Bandera_2!=4)
	{
		fflush(stdin);
		//Menu principal o de presentacion
		cout<<"Menu Principal:"<<endl<<ends;
		cout<<"A)Presione 1 para crear un nodo"<<endl<<ends;
		cout<<"B)Presione 2 para destruir un nodo"<<endl<<ends;
		cout<<"C)Presione 3 para mostrar la lista o un nodo especifico"<<endl;
		cout<<ends<<"D)Presione 4 para salir"<<endl<<ends;
		cout<<endl<<ends<<"Seleccione una opcion: ";
		cin>>Bandera_2;
		cout<<endl<<endl;
		if(Bandera_2==1) //Creo un nodo en forma secuencial o en un lugar especifico de la lista
		{
			Bandera_2=Crear_Nodo();
		}
		if(Bandera_2==2) //Borro un nodo en forma secuencial o en un lugar especifico de la lista
		{
			Bandera_2=Destruir_Nodo();
		}
		if(Bandera_2==3) //Muestro un nodo especifico o toda la lista
		{
			Bandera_2=Imprimir_Lista();
		}
	}
}

int Crear_Nodo()
{
	int Dato_Aux=0;
	Bandera_1=1;	
	while((Bandera_1!=0)&&(Bandera_1!=4))
	{
		Posicion=0;
		i=0;
		Bandera_1=0;
		//Menu para la creacion del nodo
		cout<<endl;
		cout<<endl<<ends<<"A)Presione 1 para insertar un nodo en una Posicion especifica"<<endl<<ends;
		cout<<"B)Presione 2 para insertar un nodo al principio de la lista "<<endl<<ends;
		cout<<"C)Presione 3 para insertar un nodo al final de la lista "<<endl<<ends;
		cout<<"D)Presione 4 para terminar el programa"<<endl<<ends;
		cout<<"E)Presione 0 para salir al menu principal"<<endl<<ends;
		cout<<endl<<ends<<"Seleccione una opcion: ";
		cin>>Bandera_1;
		cout<<endl<<endl<<endl;
		while((Bandera_1!=0)&&(Bandera_1!=4)&&(Bandera_1!=-1))
		{
			cout<<"Ingrese el Dato:"<<ends;
			cin>>Dato_Aux;
			cout<<endl;
			if(Dato_Aux==(-1))
			{
				Bandera_1=-1;
			}
			j++;
			if(j>=2)
			{
				j=2;
			}
			if((Inicio==NULL)&&(Bandera_1!=-1))
			{
				Auxiliar_1=new Nodo();
				Auxiliar_1->Dato=Dato_Aux;
				Auxiliar_1->Siguiente=Fin;
				Inicio=Auxiliar_1;
				Auxiliar_1=NULL;
			}
			if((Inicio!=NULL)&&(j==2)&&(Bandera_1!=-1))
			{
				Auxiliar_1=new Nodo();
				Auxiliar_1->Dato=Dato_Aux;
				if(Bandera_1==1) //Se crean nodos en una Posicion especifica
				{
					Actual=Inicio;
					while(Actual!=NULL)
					{
						i++;
						Actual=Actual->Siguiente;
					}
					while(((Posicion<1)||(Posicion>i))&&(Posicion!=-1))
					{
						cout<<ends<<"Existen "<<i<<" nodos, ingrese la posicion en la cual quiere ingresar el nodo(para salir inserte -1): ";
						cin>>Posicion;
						Actual=Inicio;
						i=0;
						while(((Posicion<1)||(Posicion>i))&&(Posicion!=-1))
						{
							i++;
							if(i!=1)
							{
								Actual=Actual->Siguiente;
							}
							if((i==Posicion-1)&&(i!=1))
							{
								Auxiliar_2=Actual;
							}
							if(Posicion==i)
							{
								if(Posicion!=1)
								{
									Auxiliar_1->Siguiente=Actual;
									Auxiliar_2->Siguiente=Auxiliar_1;
								}
								if(Posicion==1)	//Es para el inicio de la lista ya que atras del primer nodo no hay nada
								{
									Auxiliar_1->Siguiente=Actual;
									Inicio=Auxiliar_1;
								}
								Auxiliar_1=NULL;
								Auxiliar_2=NULL;
								Actual=NULL;
								Posicion=-1;
								Bandera_1=-1;
							}
						}
					}
					cout<<endl<<ends;
				}
				if(Bandera_1==2)
				{
					Auxiliar_1->Siguiente=Inicio;
					Inicio=Auxiliar_1;
					Auxiliar_1=NULL;
					Bandera_1=-1;
				}
				if(Bandera_1==3)
				{
					Actual=Inicio;
					while(Actual!=NULL)
					{
						if(Actual->Siguiente==NULL)
						{
							Actual->Siguiente=Auxiliar_1;
							Actual=NULL;
						}
						if(Actual!=NULL)
						{
							Actual=Actual->Siguiente;
						}
					}
				}
			}
		}
	}
	return(Bandera_1);
}
int Destruir_Nodo()
{
	Bandera_1=1;
	Posicion=0;
	i=0;
	while(Bandera_1!=0)
	{
		Actual=Inicio;
		while(Actual!=NULL)
		{
			i++;
			Actual=Actual->Siguiente;
		}
		while(((Posicion<1)||(Posicion>i))&&(Posicion!=-1))
		{
			cout<<ends<<"Existen "<<i<<" nodos, ingrese la posicion del nodo a borrar(para salir inserte -1): ";
			cin>>Posicion;
			Actual=Inicio;
			i=0;
			while(Bandera_1!=0)
			{
				i++;
				if(i!=1)
				{
					Actual=Actual->Siguiente;
				}
				if((i==Posicion-1)&&(Posicion!=1))
				{
					Auxiliar_2=Actual;
				}
				if(Posicion==i)
				{
					if(Posicion!=1)
					{
						if(Actual->Siguiente!=NULL)
						{
							Auxiliar_2->Siguiente=Actual->Siguiente;
						}
						else
						{
							Auxiliar_2->Siguiente=NULL;
						}
						delete (Actual);
					}
					if(Posicion==1)	//Es para el inicio de la lista ya que atras del primer nodo no hay nada
					{
						Inicio=Actual->Siguiente;
						delete (Actual);
					}
					Auxiliar_2=NULL;
					Bandera_1=0;
					Posicion=-1;
				}
				
				
			}
		}
	}
	return(Bandera_1);
}
int Imprimir_Lista() //En Construccion
{
	Actual=NULL;
	Posicion=0;
	Actual=Inicio;
	cout<<ends<<"A)Presione 1 para ver toda la lista"<<endl<<ends;
	cout<<"B)Presione 2 para ver solo un nodo"<<endl<<ends;
	cout<<"C)Presione 4 para salir del programa"<<endl;
	cout<<ends<<"D)Presione 0 para salir al menu principal"<<endl<<ends;
	cout<<endl<<ends<<"Seleccione una opcion: ";
	cin>>Bandera_1;
	cout<<endl<<endl;
	if(Bandera_1==1)
	{
		while(Actual!=NULL)
		{
			cout<<"Dato:"<<Actual->Dato<<endl;
			Actual=Actual->Siguiente;
		}
	}
	if(Bandera_1==2)
	{
		i=0;
		while(Actual!=NULL)
		{
			i++;
			Actual=Actual->Siguiente;
		}
		while((Posicion<1)||(Posicion>i))
		{
			cout<<ends<<"Existen "<<i<<" nodos, ingrese la posicion del nodo que desea ver: ";
			cin>>Posicion;
			cout<<endl;
			Actual=Inicio;
			i=0;
			while(i!=Posicion)
			{
				i++;
				if(i==Posicion)
				{
					cout<<"Dato:"<<Actual->Dato<<endl;
				}
				Actual=Actual->Siguiente;
			}
		}
	}	
	cout<<endl<<endl;
	return(Bandera_1);
}


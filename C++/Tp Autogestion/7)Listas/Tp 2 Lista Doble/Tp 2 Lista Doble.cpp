#include <iostream>
#include <stdlib.h>
#include <stdio.h>
using namespace std;

//Estructura del Nodo
struct Nodo
{
	char Dato;
	Nodo *Siguiente=NULL,*Anterior=NULL;
};

//Funciones
int Crear_Nodo();
int	Borrar_Nodo();
int Imprimir_Lista();
int	Amplitud_Lista(); 
char Ingresar_Datos();
void Datos_Repetidos();
int Menu(int);

//Variables Globales
int Posicion_1=0,Bandera_1=1,i=0,j=0;
Nodo *Inicio=NULL,*Fin=NULL,*Actual=NULL,*Auxiliar_1=NULL,*Auxiliar_2=NULL;

int main(int argc, char *argv[]) 
{
	int Bandera_2=1;
	cout<<"Si esta ingresando nodos secuencialmente y quiere salir ingrese el Nro 1"<<endl<<endl;
	while(Bandera_2!=4)
	{
		Bandera_2=Menu(1);
		switch(Bandera_2)
		{
			case 1:
				Bandera_2=Crear_Nodo();
				break;
			case 2:
				Bandera_2=Borrar_Nodo();
				break;
			case 3:
				Bandera_2=Imprimir_Lista();
				break;
			case 4:
				break;
		}
	}
	return 0;
}
int Crear_Nodo()
{
	char Dato_Aux='1';
	int Posicion_3=0;
	Bandera_1=1;
	Posicion_1=1;
	i=0;
	
	while((Bandera_1!=0)&&(Bandera_1!=4))
	{
		if(Dato_Aux=='1')
		{
			Bandera_1=Menu(2);
		}
		if((Bandera_1>0)&&(Bandera_1<4)) //Si Bandera esta comprendida entre 1 y 3, este if sirve para la creacion pura del nodo
		{								 //esto quiere decir que solo creamos el nodo no lo insertamos a la lista
			Dato_Aux=Ingresar_Datos();
			if(Dato_Aux=='1')
			{
				Bandera_1=Menu(2);
			}
			if(Inicio!=NULL)
			{
				Actual=NULL;
				Actual=new Nodo();
				Actual->Dato=Dato_Aux;
			}
			if(Inicio==NULL) //Creo el primer Nodo
			{
				Actual=new Nodo();
				Actual->Dato=Dato_Aux;
				Inicio=Actual;
				Fin=Actual;
			}
		}
		switch(Bandera_1)
		{			
			//Crea un nodo en un lugar especifico
			case 0:
				break;
			case 1:
				Auxiliar_1=Inicio;
				while(Bandera_1==1)
				{
					Posicion_3++;
					Posicion_3=Menu(3);
					if(Posicion_3==Posicion_1)
					{
						if(Auxiliar_1==Inicio)
						{
							Auxiliar_1->Anterior=Actual;
							Actual->Siguiente=Auxiliar_1;
							Inicio=Actual;
						}
						if(Auxiliar_1!=Inicio)
						{
							Auxiliar_2=Auxiliar_1->Anterior;
							Actual->Siguiente=Auxiliar_1;
							Actual->Anterior=Auxiliar_2;
							Auxiliar_2->Siguiente=Actual;
							Auxiliar_1->Anterior=Actual;
						}
						Bandera_1=6; //Para salir del bucle while
					}
					Auxiliar_2=Auxiliar_2->Siguiente; //Avanza al siguiente nodo //Problema
				}
				Actual=NULL;
				Auxiliar_1=NULL;
				Auxiliar_2=NULL;
				Dato_Aux='1';
				break;
			//Crea un nodo al principio de la lista	
			case 2:
				Auxiliar_1=Inicio;
				Actual->Siguiente=Auxiliar_1;
				Auxiliar_1->Anterior=Actual;
				Inicio=Actual; //Referencio mi punto de origen
				break;
			//Crea un nodo secuencialmente	
			case 3:
				Auxiliar_1=Fin;
				Fin=Actual;
				if(Inicio!=Fin)
				{
					Fin->Anterior=Auxiliar_1;
					Auxiliar_1->Siguiente=Fin;
				}
				break;
			case 4:
				break;
		}
	}
	return (Bandera_1);
}
int Borrar_Nodo()
{
	int Posicion_5=0;
	Bandera_1=1;
	while((Bandera_1!=0)&&(Bandera_1!=4))
	{
		Bandera_1=Menu(5);
		Posicion_5=0;
		switch(Bandera_1)
		{
		
			case 0:
				break;
			case 1:		//Borrar un nodo especifico
				Posicion_5=0;
				Actual=NULL;
				Posicion_1=Menu(3);
				i=Amplitud_Lista();
				Actual=Inicio;
				while(Posicion_5!=Posicion_1)
				{
					Posicion_5++;
					if(Posicion_5==Posicion_1)
					{
						if(Actual==Inicio)
						{
							if(Actual->Siguiente!=NULL)
							{
								Auxiliar_1=Actual->Siguiente;
								Auxiliar_1->Anterior=NULL;
								Inicio=Auxiliar_1;
							}
							delete(Actual);
							Actual=NULL;
						}
						if((Actual==Fin)&&(Actual!=Inicio)&&(Actual!=NULL)) 
						{
							Auxiliar_1=Actual->Anterior;
							Auxiliar_1->Siguiente=NULL;
							Fin=Auxiliar_1;
							delete(Actual);
							Actual=NULL;
						}
						if((Actual!=Inicio)&&(Actual!=Fin)&&(Actual!=NULL))
						{
							Auxiliar_1=Actual->Anterior;
							Auxiliar_2=Actual->Siguiente;
							Auxiliar_1->Siguiente=Auxiliar_2;
							Auxiliar_2->Anterior=Auxiliar_1;
							delete(Actual);
							Actual=NULL;
						}
					}
					if(Actual!=NULL)
					{
						Actual=Actual->Siguiente;
					}
				}
				Bandera_1=5;
				break;
			case 2: //Borrar un nodo al principio de la lista
				Actual=Inicio;
				Inicio=Actual->Siguiente;
				Inicio->Anterior=NULL;
				delete(Actual);
				break;
			case 3: //Borrar un nodo al final de la lista
				Actual=Fin;
				Fin=Actual->Anterior;
				Fin->Siguiente=NULL;
				delete(Actual);
				break;
			case 4:
				break;
		}
	}
	return (Bandera_1);
}
int Imprimir_Lista()
{
	int Posicion_4=0;
	Bandera_1=1;
	while((Bandera_1!=0)&&(Bandera_1!=4))
	{
		Bandera_1=1;
		Bandera_1=Menu(4);
		cout<<endl<<endl;
		switch(Bandera_1)
		{
			case 0:
				break;
			case 1:
				Actual=Inicio;
				i=Amplitud_Lista();
				Posicion_1=Menu(3);
				Posicion_4=0;
				while(Posicion_4!=Posicion_1)
				{
					Posicion_4++;
					if(Posicion_4==Posicion_1)
					{
						cout<<"Dato: "<<Actual->Dato<<endl;
						Bandera_1=5;
					}
					else
					{
						Actual=Actual->Siguiente;
					}
				}
				break;
			case 2:
				Actual=Inicio;
				while(Actual!=NULL)
				{
					cout<<"Dato: "<<Actual->Dato<<endl;
					Actual=Actual->Siguiente;
				}
				break;
			case 3:
				Actual=Fin;
				while(Actual!=NULL)
				{
					cout<<"Dato: "<<Actual->Dato<<endl;
					Actual=Actual->Anterior;
				}
				break;
			case 4:
				Datos_Repetidos();
				break;
			case 5:
				Bandera_1=4;
				break;
		}
	}
	return (Bandera_1);
}
int Amplitud_Lista()
{
	i=0;
	Auxiliar_1=Inicio;
	while(Auxiliar_1!=NULL)
	{
		i++;
		Auxiliar_1=Auxiliar_1->Siguiente;
	}
	return(i);
}
char Ingresar_Datos()
{
	char Letra;
	int Bandera_3=0;
	while(Bandera_3==0)
	{
		cout<<"Ingrese una letra:"<<endl;
		cin>>Letra;
		if(((Letra>='A')&&(Letra<='Z'))||((Letra>='a')&&(Letra<='z'))||(Letra=='1'))
		{
			Bandera_3=1;
		}
	}
	return(Letra);
}
void Datos_Repetidos()
{
	char *Vector_Auxiliar=NULL;
	int Contador=0,Contador_Aux=0;
	i=Amplitud_Lista();
	Vector_Auxiliar=new char(i);
	Actual=Inicio;
	Auxiliar_1=Inicio;
	Bandera_1=0;
	for(Contador_Aux=0;Contador_Aux<i;Contador_Aux++)
	{
		Vector_Auxiliar[Contador_Aux]='2';
	}
	fflush(stdin);
	Contador_Aux=0;
	while(Bandera_1!=3)
	{
		if((Actual->Dato==Auxiliar_1->Dato)&&(Actual!=Auxiliar_1))
		{
			Contador=0;
			Bandera_1=0;
			while(Bandera_1==0)
			{
				//cout<<"Dato aux:"<<Vector_Auxiliar[Contador]<<endl;
				if(Actual->Dato==Vector_Auxiliar[Contador])
				{
					Bandera_1=1;
					//cout<<"Dato 1:"<<Actual->Dato<<endl;
					//cout<<"Dato aux2:"<<Vector_Auxiliar[Contador]<<endl;
				}
				if(Vector_Auxiliar[Contador]=='2')
				{
					Vector_Auxiliar[Contador]=Actual->Dato;
					cout<<"Dato Repetido: "<<Actual->Dato<<endl;
					Bandera_1=2;
					//cout<<"hola 2"<<endl;
				}
				Contador++;
				if(Contador==i)
				{
					Bandera_1=1;
				}
			}
		}	
		Auxiliar_1=Auxiliar_1->Siguiente;
		//cout<<"hola n"<<endl;
		if(Auxiliar_1==NULL)
		{
			Auxiliar_1=Inicio;
			Actual=Actual->Siguiente;
			//cout<<"hola 3"<<endl;
		}
		if(Actual==NULL)
		{
			Bandera_1=3;
			//cout<<"hola 4"<<endl;
		}
	}
	//cout<<"hola 5"<<endl;
}
int Menu(int Posicion_2)
{
	Bandera_1=0;
	i=0;
	while(Posicion_2==1) //Menu Principal
	{
		cout<<"A)Presione 1 para crear un nodo"<<endl;
		cout<<"B)Presione 2 para borrar un nodo"<<endl;
		cout<<"C)Presione 3 para imprimir la lista o un nodo"<<endl;
		cout<<"D)Presione 4 para salir del programa"<<endl;
		cout<<"Seleccione una opcion:";
		cin>>Bandera_1;
		cout<<endl<<endl;
		
		if((Bandera_1>0)&&(Bandera_1<5))
		{
			Posicion_2=10;
		}
	}
	while(Posicion_2==2) //Menu de creacion de nodos
	{
		cout<<endl<<endl<<ends<<"A)Presione 1 para crear un nodo en un lugar especifico"<<endl;
		cout<<ends<<"B)Presione 2 para crear un nodo al principio de la lista"<<endl;
		cout<<ends<<"C)Presione 3 para crear secuencialmente los nodos(al final de la lista)"<<endl;
		cout<<ends<<"D)Presione 4 para salir del programa"<<endl;
		cout<<ends<<"D)Presione 0 para salir al menu principal"<<endl;
		cout<<ends<<"Seleccione una opcion:";
		cin>>Bandera_1;
		cout<<endl;
		if((Bandera_1>=0)&&(Bandera_1<5))
		{
			Posicion_2=10;
		}
	}
	while(Posicion_2==3)
	{
		i=Amplitud_Lista(); //No hace falta igualar a i porque i es global pero para que no haya confusiones lo igualo
		cout<<"Hay "<<i<<" nodos, ingrese la posicion deseada:";
		cin>>Bandera_1;
		if((Bandera_1<=i)&&(Bandera_1>0))
		{
			Posicion_2=10;
		}
	}
	while(Posicion_2==4) //Menu de impresion de nodos;
	{
		cout<<endl<<endl<<ends<<"A)Presione 1 para imprimir un nodo especifico"<<endl;
		cout<<ends<<"B)Presione 2 para imprimir desde el principio de la lista"<<endl;
		cout<<ends<<"C)Presione 3 para imprimir desde el final de la lista"<<endl;
		cout<<ends<<"D)Presione 4 para imprimir daatos repetidos"<<endl;
		cout<<ends<<"D)Presione 5 para salir del programa"<<endl;
		cout<<ends<<"D)Presione 0 para salir al menu principal"<<endl;
		cout<<ends<<"Seleccione una opcion:";
		cin>>Bandera_1;
		cout<<endl;
		if((Bandera_1>=0)&&(Bandera_1<6))
		{
			Posicion_2=10;
		}
	}
	while(Posicion_2==5) //Menu para borrar nodos
	{
		cout<<endl<<endl<<ends<<"A)Presione 1 para borrar un nodo en un lugar especifico"<<endl;
		cout<<ends<<"B)Presione 2 para borrar un nodo al principio de la lista"<<endl;
		cout<<ends<<"C)Presione 3 para borrar secuencialmente los nodos(desde el final)"<<endl;
		cout<<ends<<"D)Presione 4 para salir del programa"<<endl;
		cout<<ends<<"D)Presione 0 para salir al menu principal"<<endl;
		cout<<ends<<"Seleccione una opcion:";
		cin>>Bandera_1;
		cout<<endl;
		if((Bandera_1>=0)&&(Bandera_1<5))
		{
			Posicion_2=10;
		}
	}
	return(Bandera_1);
}

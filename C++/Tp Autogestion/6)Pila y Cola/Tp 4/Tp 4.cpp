#include <string.h> //Para usar strcpy uso la libreria string.h
#include <iostream>
using namespace std;

struct Nodo
{
	char Apellido[25];
	int	Edad;
	struct Nodo *Siguiente;
	
};
int main(int argc, char *argv[]) 
{
	char Apellido_Aux[25];
	int Edad_Aux=0;
	Nodo *N_1=NULL,*N_2=NULL,*Base_1=NULL,*Base_2=NULL;
	while(Edad_Aux!=999)		//Cargo los Datos
	{
		cout<<"Ingrese la edad:";
		cin>>Edad_Aux;
		if(Edad_Aux!=999)
		{
			cout<<endl<<"Ingrese el apellido:";
			cin>>Apellido_Aux;
			cout<<endl;
			N_1=new Nodo();
			N_1->Edad=Edad_Aux;
			strcpy(N_1->Apellido,Apellido_Aux);
			N_1->Siguiente=Base_1;
			Base_1=N_1;
			if(Edad_Aux>20)	//Personas mayores de 20 años
			{
				N_2=new Nodo();
				N_2->Edad=Edad_Aux;
				strcpy(N_2->Apellido,Apellido_Aux);
				N_2->Siguiente=Base_2;
				Base_2=N_2;
			}
		}
	}
	cout<<endl<<endl;
	while((N_1!=NULL)||(N_2!=NULL)) //Muestro los Datos
	{
		if(N_1!=NULL)
		{
			cout<<endl<<"Apellido:"<<N_1->Apellido<<ends<<"Edad"<<N_1->Edad<<endl<<endl;
			N_1=N_1->Siguiente;
		}
		if((N_1==NULL)&&(N_2!=NULL))
		{
			if(Edad_Aux==999)
			{
				Edad_Aux=0;
				cout<<"Pila de personas mayores de 20 años"<<endl;
			}
			cout<<"Apellido:"<<N_2->Apellido<<ends<<"Edad:"<<N_2->Edad<<endl;
			N_2=N_2->Siguiente;
		}
		
	}
	return 0;
}

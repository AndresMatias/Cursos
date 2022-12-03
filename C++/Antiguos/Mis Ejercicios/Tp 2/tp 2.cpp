#include <iostream>
using namespace std;
	
class persona
{
	protected:
		int	datos[3];	//datos[0]=dni, datos[1]=edad, datos[2]=fecha de nacimiento
		char sexo[1];
	public:
		persona();		//Constructor
};
class profesion:public persona
{
	protected:
		char ocupacion[20];
		
	public:
		profesion();	//Constructor
};
class ocio:public profesion
{
	protected:
		char actividad[20][20];	//actividadades favoritas
	public:
		ocio();		//Constructor
};
class estadocivil:public ocio
	{
	protected:
		char civil[20][20];	//actividadades favoritas
		friend void ingresodatos(estadocivil &);
		friend void modificaciondedatos(estadocivil &,int);
		friend void imprimir(estadocivil &);
	public:
		estadocivil();		//Constructor
};	
void ingresodatos(estadocivil &);			//Con estas tres funciones voy a manejar todas las variables de las clases anteriores
void modificaciondedatos(estadocivil &,int);
void imprimir(estadocivil &);
int main(int argc, char *argv[]) 
{
	int tam,i,dni;
	class estadocivil e[10];
	for(i=0;i<10;i++)
	{
		ingresodatos(e[i]);
	}
	cout<<"Si desea modificar algun dato ingrese el dni de la persona sino presione 0:";
	cin>>dni;
	if(dni>0)
	{
		for(i=0;i<tam;i++)
		{
			modificaciondedatos(e[i],dni);
		}
	}
	
	return 0;
}
persona::persona()
{
	int i;
	for(i=0;i<4;i++)
	{
		datos[i]=0;
	}
}
profesion::profesion()
{
	int i;
	for(i=0;i<20;i++)
	{
		ocupacion[i]=0;
	}
}
ocio::ocio()
{
	int i,j;
	for(j=0;j<20;j++)
	{
		for(i=0;i<20;i++)
		{
			actividad[i][j]='\0';
		}
	}
}
estadocivil::estadocivil()
{
	int i,j;
	for(j=0;j<20;j++)
	{
		for(i=0;i<20;i++)
		{
			civil[i][j]='\0';
		}
	}
}
void ingresodatos(estadocivil &pa)		
{
	cout<<"\nIngrese el dni de la persona:";
	cin>>pa.datos[0];
	cout<<"\nIngrese la edad de la persona:";
	cin>>pa.datos[1];
	cout<<"\nIngrese la fecha de nacimiento de la persona:";
	cin>>pa.datos[2];
	cout<<"\nIngrese el sexo de la persona,'m' para masculino y 'f' para femenino:";
	cin>>pa.sexo[0];
		
}
void modificaciondedatos(estadocivil &pa,int dni)
{
	int aux=0;
	aux=pa.datos[0];
	if(dni==aux)
		{
			
		}
}
void imprimir(estadocivil &pa)
{
	
}

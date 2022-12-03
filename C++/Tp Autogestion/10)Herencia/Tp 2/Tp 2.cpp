#include <iostream>
#include <stdio.h>
using namespace std;
class Persona //Los atributos y metodos de una misma clase se llaman miembros
{
	private: //Atributos, Private:No puedo acceder directamente a los atributos desde una clase derivada, uso Ingreso_Datos_1 si estoy en una clase derivada
		int Edad;
		char Nombre[15],Apellido[15],Estado_Civil[15],Sexo;
	public: //Metodos
		void Ingreso_Datos_1();
		int Imprimo_Datos_1(int);
};
class Empleado:public Persona
{
	private: //Atributos
		int Antiguedad,Remuneracion;
		char Categoria;
	public: //Metodos
		void Ingreso_Datos_2();
		int Imprimo_Datos_2(int,int );
};
int main(int argc, char *argv[]) 
{
	int Bandera=0,i=0,j=0,Vector_Aux_1[5],Dato_Aux_1;
	Empleado Vector[5];
	for(i=0;i<5;i++)
	{
		Vector[i].Ingreso_Datos_2();
		cout<<endl<<endl;;
	}
	while(Bandera!=4)
	{
		while((Bandera<1)||(Bandera>4))
		{
			cout<<"A)Presione 1 para imprimir el personal por antiguedad";
			cout<<endl<<"B)Presione 2 para imprimir el personal por remuneracion";
			cout<<endl<<"C)Presione 3 para imprimir el personal por categoria dentro del genero femenino";
			cout<<endl<<"C)Presione 4 para salir";
			cout<<endl<<"Seleccione una opcion:";
			cin>>Bandera;
			cout<<endl;
			
		}
		switch(Bandera)
		{
		case 1:
			for(i=0;i<5;i++) //Inicializo a un cierto valor
			{
				Vector_Aux_1[i]=-1;
			}
			for(i=0;i<5;i++) //Copio los datos de la clase en un vector
			{
				Vector_Aux_1[i]=Vector[i].Imprimo_Datos_2(Bandera,Vector_Aux_1[i]);
			}
			for(i=0;i<4;i++) //Metodo Burbuja
			{
				for(j=0;j<4;j++) //El "4" representa la posicion 5
				{
					if(Vector_Aux_1[j]>Vector_Aux_1[j+1])
					{
						Dato_Aux_1=Vector_Aux_1[j+1];
						Vector_Aux_1[j+1]=Vector_Aux_1[j];
						Vector_Aux_1[j]=Dato_Aux_1;
						
					}
				}
			}
			cout<<"Personal por antiguedad:"<<endl;
			for(i=0;i<5;i++) //Imprimo los datos
			{
				for(j=0;j<5;j++) //Imprimo los datos
				{
					Vector[j].Imprimo_Datos_2(Bandera,Vector_Aux_1[i]);
				}
			}
			Bandera=0;
			break;
		case 2:
			for(i=0;i<5;i++) //Inicializo a un cierto valor
			{
				Vector_Aux_1[i]=-1;
			}
			for(i=0;i<5;i++) //Copio los datos de la clase en un vector
			{
				Vector_Aux_1[i]=Vector[i].Imprimo_Datos_2(Bandera,Vector_Aux_1[i]);
			}
			for(i=0;i<4;i++) //Metodo Burbuja
			{
				for(j=0;j<4;j++)
				{
					if(Vector_Aux_1[j]>Vector_Aux_1[j+1])
					{
						Dato_Aux_1=Vector_Aux_1[j+1];
						Vector_Aux_1[j+1]=Vector_Aux_1[j];
						Vector_Aux_1[j]=Dato_Aux_1;
					}
				}
			}
			cout<<"Personal por remuneracion:"<<endl;
			for(i=0;i<5;i++) //Imprimo los datos
			{
				for(j=0;j<5;j++) //Imprimo los datos
				{
					Vector[j].Imprimo_Datos_2(Bandera,Vector_Aux_1[i]);
				}
			}
			Bandera=0;
			break;
		case 3:
			for(i=0;i<5;i++) //Imprimo los datos
			{
				Vector[i].Imprimo_Datos_2(3,i);
			}
			Bandera=0;
			break;
		case 4:
			Bandera=5;
		}
	}
	return 0;
}
void Persona::Ingreso_Datos_1()
{
	cout<<"Ingrese el nombre:";
	cin.getline(Nombre,15); //cin.getline:Leo una cadena completa de caracteres incluyendo espacios
	cout<<"Ingrese el apellido:";
	cin.getline(Apellido,15);
	cout<<"Ingrese el genero('H'o'M'):";
	cin>>Sexo;
	cout<<"Ingrese la edad:";
	cin>>Edad;
	
}
int Persona::Imprimo_Datos_1(int Bandera_Aux)
{
	
	if(Bandera_Aux==1)
	{
		cout<<ends<<"Nombre:"<<Nombre<<endl;
		cout<<ends<<"Apellido:"<<Apellido<<endl;
		cout<<ends<<"Genero:"<<Sexo<<endl;
		cout<<ends<<"Edad:"<<Edad<<endl;
	}
	if(((Sexo=='M')||(Sexo=='m'))&&(Bandera_Aux==0))
	{
		return(4);
	}
	return(0);
}
void Empleado::Ingreso_Datos_2()
{
	Ingreso_Datos_1();
	cin.ignore(15,'\n');  //Limpio el buffer(ver como se usa), similar a //fflush(stdin);
	cout<<"Ingrese la categoria('B'(Baja),'M'(Media),'A'(Alta)):";
	cin>>Categoria;
	cout<<"Ingrese la antiguedad:";
	cin>>Antiguedad;
	cout<<"Ingrese la remuneracion:";
	cin>>Remuneracion;
	cin.ignore(15,'\n');
}
int Empleado::Imprimo_Datos_2(int Bandera_Aux_1,int Variable_Aux)
{
	if(Bandera_Aux_1==1)
	{
		if(Variable_Aux==-1)
		{
			return(Antiguedad);
		}
		if(Variable_Aux==Antiguedad)
		{
			Imprimo_Datos_1(1);
			cout<<ends<<"Categoria:"<<Categoria<<endl;
			cout<<ends<<"Antiguedad:"<<Antiguedad<<endl;
			cout<<ends<<"Remuneracion:"<<Remuneracion<<endl;
			cout<<endl<<endl<<endl;
		}
		
	}
	if(Bandera_Aux_1==2)
	{
		
		if(Variable_Aux==-1)
		{
			return(Remuneracion);
		}
		if(Variable_Aux==Remuneracion)
		{
			Imprimo_Datos_1(1);
			cout<<ends<<"Categoria:"<<Categoria<<endl;
			cout<<ends<<"Antiguedad:"<<Antiguedad<<endl;
			cout<<ends<<"Remuneracion:"<<Remuneracion<<endl;
			cout<<endl<<endl<<endl;
		}
	}
	if(Bandera_Aux_1==3)
	{
		Bandera_Aux_1=Imprimo_Datos_1(0);
		if((Bandera_Aux_1==4)&&((Categoria=='M')||(Categoria=='m')||(Categoria=='A')||(Categoria=='a')))
		{
			Imprimo_Datos_1(1);
			cout<<ends<<"Categoria:"<<Categoria<<endl;
			cout<<ends<<"Antiguedad:"<<Antiguedad<<endl;
			cout<<ends<<"Remuneracion:"<<Remuneracion<<endl;
			cout<<endl<<endl<<endl;
		}
	}
	return(0);
}

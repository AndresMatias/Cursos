#include<stdio.h>					
#include<stdlib.h>
#include<conio.h>
#define tam 180
/*Matematica 1
Lengua 2
Fisica 3
Quimica 4
Historia 5
Geografia 6
Educacion Fisica 7*/

void Registrodeingrsantes();		/*Registro de ingresantes al colegio*/
void Ingresodenotas();				/*Registro de notas y promedios*/
void informacion();					/*Permite ver al usuario informacion(legajos, notas, promedios, etc)*/
int cursos(int);					/*Determino el nro inicial dodne comienza cada curso ej:en el 1 es el curso uno,31 curso 2 cada curso posee 30 vacantes*/
int Matriznotas(int ,int ,int ,int );			/*Matriz para el registro de las notas y calculos etc*/	
struct alumno						/*Estructura que contine los datos de los alumnos*/	
	{
		char nombreyapellido[25];  
		int	inicio;					/*Año de ingreso*/
		int curso;						
		int	documento;
		int	legajo;
		int notas[7][4];     		/*Una matriz de 7x4 representa 7 materias y 4 notas en cada uno 2 notas de las cuales sirven para recuperatorio*/
		float promedio[4];
		float promediogral;		
	}Nrodealumno[tam];				/*Vector en el cual se guarda cada lista para cada alumno*/

int main(int argc, char *argv[])  /*A*/
{
	int iA1=0,iA2=0,jA1=0,selector=0,salida=0;
	fflush(stdin);
	for(iA1=0;iA1<tam;iA1++)			
	{
		Nrodealumno[iA1].legajo=(77001+iA1);	/*Genero los lejagos para 180 estudiantes 30 estudiantes pro cada curso son seis cursos*/
		Nrodealumno[iA1].inicio=0;			/*Igualo a cero todas las variables de las 180 listas en la cual se iran reemplazando los valores*/
		Nrodealumno[iA1].curso=0;
		Nrodealumno[iA1].documento=0;
		for(iA2=0;iA2<7;iA2++)
		{
			Nrodealumno[iA1].promedio[jA1]=0;
			for(jA1=0;jA1<4;jA1++)
			{
				Nrodealumno[iA1].notas[iA2][jA1]=0;
			}
		}
		Nrodealumno[iA1].promediogral=0;
	}
	while(salida==0)
	{
		selector=0;
		while((selector<1)||(selector>4))
		{
			system("cls");
			printf("\n\nSi desea registrar nuevos ingresantes presione \"1\"\n\nSi desea cargar notas presione \"2\"\n\nSi desea Ver informacion en sobre de notas, alumnos, etc presione \"3\"\n\nSi desea salir presione \"4\"\n\nIntrodusca el Nro de la opcion deseada:");
			scanf("%d",&selector);
		}
		switch(selector)
		{
			case 1:							/*Ingreso al a funcion para el registro de nuevos alumos*/
					Registrodeingrsantes();												
					break;
			case 2:
					Ingresodenotas();		/*Ingreso de notas de los alumnos*/
					break;
			case 3:
					informacion();
					break;
			case 4:
					salida=1;
		}
	}
	return 0;	
}

void Registrodeingrsantes()		/*B*/
{
	int iB1=0,iB2=0,iB1aux=0,salir=0,cursoref1=0,ingresantes=0;
	printf("\n\nIngrese el Nro de ingresantes:");
	scanf("%d",&ingresantes);	
	for(iB2=0;iB2<ingresantes+1;iB2++)
	{
		cursoref1=cursos(1);
		iB1=cursos(2)-1;
		iB1aux=(iB1+29);
		while((Nrodealumno[iB1].inicio!=0)&&(iB1<=iB1aux))
		{
			iB1++;
		}
		if(iB1>iB1aux)
		{
			printf("\n\nLo sentimos las vacantes en este curso estan llenas");
		}
		if(iB1<=iB1aux)
		{
			Nrodealumno[iB1].curso=cursoref1;
			fflush(stdin);    /*Siempre poner fflush(stdin):antes de ingresar una cadena de texto con fgets ya que sino pro alguna razon el buffer cuasa problemas y lo saltea el comando al menso en funciones*/
			printf("\n\nIngrese el nombre y apellido del alumno:"); 
			fgets(Nrodealumno[iB1].nombreyapellido,25,stdin);
			printf("\n\nIngrese el documento del alumno:");
			scanf("%d",&Nrodealumno[iB1].documento);
			printf("\n\nIngrese el año de ingreso del alumno:");
			scanf("%d",&Nrodealumno[iB1].inicio);
			printf("\nEl legajo generado para este alumno es:%d",Nrodealumno[iB1].legajo);
		}
		system("cls");
		if(iB2==ingresantes-1)
		{
		printf("\n\nSi desea salir al menu general presione la tecla \"1\"\nSi desea seguir presione cualquier tecla:");
		scanf("%d",&salir);
		}
		if(salir==1)
		{
			ingresantes=-1;
		}
	}
}

void Ingresodenotas()		/*ingreso de notas de los alumnos*/ /*C*/
{
	int selectorC2=0,iC1=0,iC2=0,legajoC1=0;
	selectorC2=0;
	while((selectorC2<1)||(selectorC2>2))			/*Selector en caso de que se ingre un nro mayor a dos o menor a uno*/
	{
		printf("\nSi desea ingresar las notas de todo un curso presione 1\nSi desea cargar notas de alumnos indiviuales presione 2\n\nIngrese su opcion:");
		scanf("%d",&selectorC2);
	}
	iC1=0;
	switch(selectorC2)
	{
		case 1:			/*Ingreso de notas a todo un curso determinado*/
				iC1=0;
				cursos(1);
				iC1=cursos(2);
				Matriznotas(iC1,30,0,4);
				break;
		case 2:			/*Ingreso de notas a alumnos induviduales*/
				while(iC2==0)
				{
					iC1=0;
					printf("\n\nIngrese el legajo del alumno:");
					scanf("%d",&legajoC1);
					for(iC1=0;iC1<180;iC1++)
					{
						if(legajoC1==Nrodealumno[iC1].legajo)
						{
							iC2=Matriznotas(iC1,1,0,4);
						}
						if(Nrodealumno[iC1].legajo==0)
						{
							printf("\n\nLo sentimos este legajo no se encutra dentro de nuestra informacion");
							iC1=180;
						}
					}
				}
	}
	
}
int cursos(int i8)			/*D*/
{
	int cursoref2=0,iD;
	cursoref2=0;
	if(i8==1)
	{
	while((cursoref2<1)||(cursoref2>6))
	{
		printf("\n\nIngrese el Nro de curso:");
		scanf("%d",&cursoref2);
	}
	}
	if(cursoref2==1)
	{
		iD=1;
	}
	if(cursoref2==2)
	{
		iD=31;
	}
	if(cursoref2==3)
	{
		iD=(30*2)+1;
	}
	if(cursoref2==4)
	{
		iD=(30*3)+1;
	}
	if(cursoref2==5)
	{
		iD=(30*4)+1;
	}
	if(cursoref2==6)
	{
		iD=(30*5)+1;
	}
	if(i8==1)
	{
		return(cursoref2);
	}
	if(i8==2)
	{
		return(iD);
	}
	return 0;
}
int Matriznotas(int auxE1,int iE2,int iE3,int jE2)	/*E*/	/*iE2 indica si son 30 alumnos(curso entero) o un solo alumno)*/
{															/*iE3 sirve para separa la carga de notas de la muestra de notas*/
	int selectorE1=0,iE1=0,jE1=0,salirE1=1,salirE2=0,iE4=0;	/*jE2 sirve para mover el primer for y si es carga de notas vale 4 y si es muestra de notas vale 7*/
	while(salirE1==1)										/*auxE1 indica donde comienza la struct alumno(Nrodealumno[auxE1])*/
	{		
		if(iE3==0)
		{
			printf("\n\nSelecciones la materia en la que desea cargar/ver las notas\n\npara ello presione un numero del 1 al 7 segun la\n\nmateria que quiera elejir en la siguiente tabla\n\nSi decide cambiar de materia una vez\n\nque esta cargando las notas ingrese el numero \"0\"\n\nluego de haber cargado las cuatro notas");
			printf("\n\nMateria\t\t\tNro \nMatematica:\t\t 1\nLengua:\t\t\t 2\nFisca:\t\t\t 3\nQuimica:\t\t 4\nHistoria:\t\t 5\nGeografica:\t\t 6\nEducacion Fisica:\t 7\n\nEliga la materia:");
		
		selectorE1=0;
		while((selectorE1<1)||(selectorE1>7))
		{
				printf("\nPorfavor indrodusca un numero entre 1 y 7:");
				scanf("%d",&selectorE1);
		}
		}
		system("cls");
		system("PAUSE");
		for(iE1=0;iE1<iE2;iE1++) /*Este for recibe el Nro 30 o el Nro 1 segun si el usurio eligi un curso entero o un solo alumno*/
		{
			if((iE3==1)&&(Nrodealumno[auxE1].documento!=0))
			{
				printf("\n\n\n\nLegajo:%d\nAlumno:%s\nDocumento:%d\nAño de ingreso:%d\n\nCalificaiones\t\t\tNota 1\tNota 2\tNota 3\tNota 4\tPromedio",Nrodealumno[auxE1].legajo,Nrodealumno[auxE1].nombreyapellido,Nrodealumno[auxE1].documento,Nrodealumno[auxE1].inicio);
			}	
			for(jE1=0;jE1<jE2;jE1++)
			{
				if((Nrodealumno[auxE1].documento!=0)&&(iE3==0))
				{
				printf("\nIngrese nota %d:",jE1+1);
				scanf("%d",&Nrodealumno[auxE1].notas[selectorE1-1][jE1]);
				}
				if((iE3==1)&&(Nrodealumno[auxE1].documento!=0))
				{
					if(jE1==0)
					{
						printf("\nMatematica:\t\t");	
					}	
					if(jE1==1)
					{
						printf("\nLengua:\t\t\t");
					}
					if(jE1==2)
					{
						printf("\nFisca:\t\t\t");
					}
					if(jE1==3)
					{
						printf("\nQuimica:\t\t");
					}
					if(jE1==4)
					{
						printf("\nHistoria:\t\t");
					}
					if(jE1==5)
					{
						printf("\nGeografia:\t\t");
					}
					if(jE1==6)
					{
						printf("\nEducacion Fisica:\t");
					}
					for(iE4=0;iE4<4;iE4++)
					{
						printf("\t%d",Nrodealumno[auxE1].notas[jE1][iE4]);
						Nrodealumno[auxE1].promedio[jE1]=(Nrodealumno[auxE1].notas[jE1][iE4]+Nrodealumno[auxE1].promedio[jE1]);
						if(iE4==3)
							{
								Nrodealumno[auxE1].promedio[jE1]=(Nrodealumno[auxE1].promedio[jE1]/4);
								printf("\t%.2f",Nrodealumno[auxE1].promedio[jE1]);
								Nrodealumno[auxE1].promediogral=Nrodealumno[auxE1].promedio[jE1]+Nrodealumno[auxE1].promediogral;
							}
					}
					if(iE4==6)
					{
						(Nrodealumno[auxE1].promediogral=Nrodealumno[auxE1].promediogral/7);
						printf("\t\t%.2f",Nrodealumno[auxE1].promediogral);
					}

				}
			}
			if(Nrodealumno[auxE1].documento==0)
			{
				printf("\n\nLo sentimos en el legajo %d no hay alumno registrado",Nrodealumno[auxE1].legajo);
			}
			if(iE2!=1)
			{
				auxE1++;
			}
			if(iE3==0)
			{
				printf("\n\nPresione \"1\" si desea cambiar de materia\n\nSi desea salir al menu principal\"2\"");
				scanf("%d",&salirE2);
			}
			if((iE3==1)&&(iE1==0))
			{
				printf("\n\nSi desea salir al menu principal\"2\"\n\nSi desea seguir presione \"3\":");
				scanf("%d",&salirE2);
			}
			if((iE1==29)||((iE1==59))||(iE1==89)||(iE1==119)||(iE1==149)||(iE1==179))
			{
				printf("\n%d\n\n",iE2);
				system("PAUSE");
				system("cls");
				if(((iE2==30)&&(iE1==29))||((iE2==180)&&(iE1==179)))
				{	
					return 0;
				}
			}
			if(salirE2==1)
			{
				salirE1=1;
				iE1=iE2;
			}
			if(salirE2==2)
			{
				iE1=iE2;
				salirE1=-1;
				return 1;
			}
			if((salirE2==3)&&(iE2==1))
			{
				iE1=iE2;
				salirE1=-1;
				return 0;
			}
		}
	}
	return 0;
}
void informacion()	/*F*/
{
	int selectorF1=0,iF1=0,iF2=0,iF3=0,legajoF1=0;
		selectorF1=0;
	while((selectorF1<1)||(selectorF1>6))
	{
		if(iF1==0)
		{
			system("cls");
			printf("\n\nSi desea ver la informacion de un curso presione \"1\"\nSi desea ver la informacion de todos los curso presiones \"2\"\nSi desea ver la informacion de un alumno especifico presione \"3\"\n\nIngrese su opcion:");		
			iF1=1;
		}
		else
		{
			printf("\nPorfavor ingrese un numero del 1 al 6");
		}
		scanf("%d",&selectorF1);
	}
	switch(selectorF1)
	{
		case 1:
				cursos(1);
				iF2=cursos(2);
				Matriznotas(iF2,30,1,7);
				break;
		case 2:
				Matriznotas(0,180,1,7);
				break;
		case 3:
				while(iF3==0)
				{
					iF2=0;
					printf("\n\nIngrese el legajo del alumno:");
					scanf("%d",&legajoF1);
					for(iF2=0;iF2<180;iF2++)
					{
						if(legajoF1==Nrodealumno[iF2].legajo)
						{
							iF3=Matriznotas(iF2,1,1,7);
						}
						if(Nrodealumno[iF2].legajo==0)
						{
							printf("\n\nLo sentimos este legajo no se encutra dentro de nuestra informacion");
							iF2=180;
						}
					}
				}
	}
}

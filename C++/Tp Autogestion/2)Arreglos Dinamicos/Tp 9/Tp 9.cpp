#include <stdio.h>
#include <stdlib.h>
#include <iostream>
using namespace std;
/*Se desea desarrollar un programa que permita declarar una tabla de N xN de números reales de simple precisión. 
Se desea desarrollar métodos para:
a)	Seleccionar el tamaño NxN
b)	Cargar la tabla desde el teclado
c)	Mostrar por pantalla los elementos de la tabla
d)	Detectar  el menor valor y generar un arreglo con los elementos que estén sobre su columna.
*/
int main(int argc, char *argv[]) 
{
	int **Matriz_Dinamica=NULL,Fila_Dinamica=0,Columna_Dinamica=0,N=0; //Elementos de la Matriz_Dinamica
	int i=0,j=0,j_aux=0,Variable_Aux=0; //Para mover los ciclos para(for) de la matriz
	int *Vector_Dinamico=NULL;
	cout<<"Ingrese el tamaño de su matriz NxN:";
	cin>>N;
	//Agrego Fila_Dinamica y Columna_Dinamica a fines de que se entienda mejor el programa como ejemplo
	//Creo Matriz_Dinamica
	Fila_Dinamica=N;
	Columna_Dinamica=N;
	Matriz_Dinamica=new int*[Fila_Dinamica];
	for(i=0;i<Fila_Dinamica;i++)
	{
		Matriz_Dinamica[i]=new int[Columna_Dinamica];
	}
	//Cargo los Datos
	for(i=0;i<Fila_Dinamica;i++)
	{
		for(j=0;j<Columna_Dinamica;j++)
		{
			cout<<"Posicion["<<i+1<<"]["<<j+1<<"]";
			cin>>Matriz_Dinamica[i][j];
		}
	}
	//Muestro la matriz por pantalla
	for(i=0;i<Fila_Dinamica;i++)
	{
		for(j=0;j<Columna_Dinamica;j++)
		{
			cout<<Matriz_Dinamica[i][j]<<ends<<ends;
		}
		cout<<endl<<endl;
	}
	//Determino el menor de los elementos
	Variable_Aux=Matriz_Dinamica[0][0]; //Comparo con el primer elemento mientrax recorro la matriz
	for(i=0;i<Fila_Dinamica;i++)		//si hay otro elemento mas chico lo alamaceno en Variable_Aux 
	{									//y asi hasta terminar el recorrido de la Matriz_Dinamica
		for(j=0;j<Columna_Dinamica;j++)
		{
			if(Variable_Aux>Matriz_Dinamica[i][j])
			{
				Variable_Aux=Matriz_Dinamica[i][j];
				j_aux=j;
			}
		}
		cout<<endl<<endl;
	}
	Vector_Dinamico=new int[Fila_Dinamica];
	cout<<endl<<endl<<"Vector_Dinamico:";
	//Determino el Vector_Dinamico de la columna con el menor valor de la matriz y la muestro en pantalla
	for(i=0;i<N;i++)
	{
		Vector_Dinamico[i]=Matriz_Dinamica[i][j_aux];
		cout<<Vector_Dinamico[i]<<ends;
	}
	delete []Matriz_Dinamica;
	delete []Vector_Dinamico;
	return 0;
}


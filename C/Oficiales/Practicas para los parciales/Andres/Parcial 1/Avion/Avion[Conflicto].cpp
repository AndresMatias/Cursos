#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#define tam 80
int main(int argc, char *argv[]) 
{
int a1[tam][tam],a2[tam][tam],a3[tam][tam],v[tam],i=0,j=0,cont,hola;
/*
v[0] variable para salir del programa
v[1] variable para salir del while en caso de que el tipo del avion ingresado sea incorrecto
v[2] variable que guarda el tipo de avion
v[3] varible que guarda la cantidad de asinetos de los aviones
"i"y"j" variable que mueven la matriz
v[6] variable que guarda el dni
v[5] variable que guarda el tipo de asiento
v[4] varible que sirve para determinar si se quiere guardar un asiento o cancelar la reserva o salir del programa
*/
while(v[0]==0)
	{
	
		while(v[1]==0)
			{
				printf("Ingrese correctamente el tipo de avion");
				scanf("%d",&v[2]);
				hola;
				printf("Ingrese el numero de asiento que desea reservar");
				scanf("%d",&v[5]);
				printf("Ingrese correctamente dni");
				scanf("%d",&v[6]);
				if((v[2]<5)||(v[2]>0))
					{
						v[1]=1;
					}
				if(v[2]==1)
				{
					v[3]=20;
				}
				if(v[2]==2)
					{
						v[3]=15;
					}
				if(v[2]==3)
					{
						v[3]=5;
					}
			}
		for(i=0,i<v[3],i++)
			{
				for(j=0,j<4,j++)
					{
						v[5]=0;
						
						cont++;
						if(v[2]==1)
							{
								if(cont==v[5])
									{
										if(a1[i][j]>0)
											{
												printf("Lo sentimos este asiento esta reservado,si desea cancelar la reserva presione 1 sino presione otra tecla");
												scanf("%d",&v[4]);												
												if(v[4]==1)
													{
														v[7]=0;
														while((a1[i][j]!=v[6])&&(v[7]==0))
															{
																printf("El dni correctamente:\n");
																scanf("%d",&v[6]);
																if(a1[i][j]==v[6];)
																	{
																		r=1;
																		a1[i][j]=0;
																		printf("Reserva cancelada");
																	}
															}
														printf("Si se equivoco de asiento presione 2");
														scanf("%d",&v[8]);
														if(v[8]==2)
															{
																	goto hola;
															}
													}
											}
										if(a1[i][j]==0)
											{
												printf("Ingrese correctamente dni;\n");
												scanf("%d",&a1[i][j]);
												printf("\nEl asiento ha sido reservado");
											}
									}
									}
						if(v[2]==2)
						{
								if(cont==v[5])
								{
									if(a2[i][j]>0)
									{
										printf("Lo sentimos este asiento esta reservado,si desea cancelar la reserva presione 1 sino presione otra tecla");
										scanf("%d",&v[4]);												
										if(v[4]==1)
										{
											v[7]=0;
											while((a2[i][j]!=v[6])&&(v[7]==0))
											{
												printf("El dni correctamente:\n");
												scanf("%d",&v[6]);
												if(a2[i][j]==v[6];)
												{
													r=1;
													a2[i][j]=0;
													printf("Reserva cancelada");
												}
											}
											printf("Si se equivoco de asiento presione 2");
											scanf("%d",&v[8]);
											if(v[8]==2)
											{
												goto hola;
											}
										}
									}
									if(a2[i][j]==0)
									{
										printf("Ingrese correctamente dni;\n");
										scanf("%d",&a2[i][j]);
										printf("\nEl asiento ha sido reservado");
									}
						}
					}
						if(v[2]==3)
						{
								if(cont==v[5])
								{
									if(a3[i][j]>0)
									{
										printf("Lo sentimos este asiento esta reservado,si desea cancelar la reserva presione 1 sino presione otra tecla");
										scanf("%d",&v[4]);												
										if(v[4]==1)
										{
											v[7]=0;
											while((a3[i][j]!=v[6])&&(v[7]==0))
											{
												printf("El dni correctamente:\n");
												scanf("%d",&v[6]);
												if(a3[i][j]==v[6];)
												{
													r=1;
													a3[i][j]=0;
													printf("Reserva cancelada");
												}
											}
											printf("Si se equivoco de asiento presione 2");
											scanf("%d",&v[8]);
											if(v[8]==2)
											{
												goto hola;
											}
										}
									}
									if(a3[i][j]==0)
									{
										printf("Ingrese correctamente dni;\n");
										scanf("%d",&a3[i][j]);
										printf("\nEl asiento ha sido reservado");
									}
						}
					}
				}
	}
		for(i=0,i<v[3],i++)
		{
			for(j=0,j<4,j++)
			{
return 0;
}
}


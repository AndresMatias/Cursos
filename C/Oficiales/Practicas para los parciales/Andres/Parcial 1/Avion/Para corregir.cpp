#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#define tam 80
/*
v[0] variable para salir del programa
v[1] variable para salir del while en caso de que el tipo del avion ingresado sea correcto
v[2] variable que guarda el tipo de avion
v[3] varible que guarda la cantidad de asinetos de los aviones
"i"y"j" variable que mueven la matriz
v[4] varible que sirve para determinar si se quiere guardar un asiento o cancelar la reserva o salir del programa
v[5] variable que guarda el tipo de asiento
v[6] variable que guarda el dni
v[7] variable bandera
v[8] variable que sirve para determinar si el usuario se equivoco de asiento o de avion
v[9] variable que sirve para terminar el programa
v[10] variable que guarda el porcentaje de asientos ocupados del avion uno
v[11] variable que guarda el porcentaje de asientos ocupados del avion dos
v[12] variable que guarda el porcentaje de asientos ocupados del avion tres
a1[tam][tam] Matriz para representar la cantidad de asientos del primer avion 
a2[tam][tam] Matriz para representar la cantidad de asientos del segundo avion
a3[tam][tam] Matriz para representar la cantidad de asientos del tercer avion
r variable para determinar cada seis vueltas del while que aparesca a opcion de si el usuario se equivoco de asiento y/o avion que lo reelija 
*/
int main(int argc, char *argv[]) {
	int v[tam]={0},a1[tam][tam]={0},a2[tam][tam]={0},a3[tam][tam]={0},i=0,j=0,r=0,cont=0;
	float a[tam]={0},b1=0,b2=0,b3=0;
while(v[0]==0)
	{	
		v[1]=0;
		v[6]=0;
			i=0;
			j=0;
			cont=0;
		while(v[1]==0)
			{	
				
				if(v[4]!=2)
					{
						printf("-Ingrese correctamente el tipo de avion: ");
						scanf("%d",&v[2]);
					}
				if((4>v[2])&&(0<v[2]))
					{
						v[1]=1;
						printf("\n-Ingrese el numero de asiento que desea reservar: ");
						scanf("%d",&v[5]);
						if(v[2]==1)
						{
							v[3]=20;
							while((v[5]>80)||(v[5]<1))
								{
								  printf("\nLo sentimos el avion tipo 1 solo dispone de 80 asientos\n,porfavor vuelva a ingresar el asiento: ");
								  scanf("%d",&v[5]);
								}
						}
						if(v[2]==2)
						{
							v[3]=15;
							while((v[5]>60)||(v[5]<1))
								{
									printf("\nLo sentimos el avion tipo 2 solo dispone de 60 asientos\n,porfavor vuelva a ingresar el asiento: ");
									scanf("%d",&v[5]);
								}
						}
						if(v[2]==3)
							{
								v[3]=5;
								while((v[5]>20)||(v[5]<1))
									{
										printf("\nLo sentimos el avion tipo 3 solo dispone de 20 asientos\n,porfavor vuelva a ingresar el asiento: ");
										scanf("%d",&v[5]);
									}
							}
						if((v[4]!=2)&&(v[4]!=3))
							{
								printf("\nIngrese correctamente el dni: ");
								scanf("%d",&v[6]);
							}
					}
			}
		for(i=0;i<v[3];i++)
			{
				for(j=0;j<4;j++)
					{								
						cont++;
						if(v[2]==1)
							{
								if(cont==v[5])
									{	
										v[4]=1;
										if(a1[i][j]==0)
											{
												a1[i][j]=v[6];
												printf("\nEl asiento ha sido reservado\n\n");
												v[4]=0;
												printf("\n-Si desea salir del programa y mostrar los datos en pantalla presione 1,para seguir presione 2: ");
												scanf("%d",&v[9]);
												if(v[9]==1)	
												{
													i=80;
													j=4;
													v[0]=1;
													v[1]=1;
												}
											}
										if((a1[i][j]>0)&&(v[4]!=0))
											{
												printf("\nLo sentimos este asiento esta reservado\n-Si desea cancelar la reserva presione 1\n-Si desea reservar otro asiento presione 2\n-Si desea reversar otro asiento en otro avion presione 3\n-Si desea salir del programa presione 4: \n");
												scanf("%d",&v[4]);
												if(v[4]==1)
													{
														v[7]=0;
														while((a1[i][j]!=v[6])&&(v[7]==0))
															{ 
																r++;
																if(r==6)
																	{
																		r=0;
																		printf("\n-Si se equivoco de asiento y/o de avion presione 2: \n");
																		scanf("%d",&v[8]);
																		v[4]=0;
																	}
																if(v[8]!=2)
																	{
																		printf("\n-Ingrese el dni correctamente del asiento reservado: \n");
																		scanf("%d",&v[6]);
																	}
																if(a1[i][j]==v[6])
																	{
																		v[7]=1;
																		a1[i][j]=0;
																		printf("Reserva cancelada\n\n");
																		v[13]=1;
																	}
																if(v[8]==2)
																	{
																		v[7]=1;
																	}
															}
									
													}
												if((v[4]==2)||(v[4]==3))
													{
														i=v[3];
														j=4;
													}
											}										
									}
							}
						if(v[2]==2)
							{
								if(cont==v[5])
									{
										v[4]=1;
										if(a2[i][j]==0)
											{
												a2[i][j]=v[6];
												printf("\nEl asiento ha sido reservado\n\n");
												v[4]=0;
												printf("\n-Si desea salir del programa y mostrar los datos en pantalla presione 1,para seguir presione 2: ");
												scanf("%d",&v[9]);
												if(v[9]==1)	
												{
													i=80;
													j=4;
													v[0]=1;
													v[1]=1;
												}
											}
										if((a2[i][j]>0)&&(v[4]!=0))
											{
												printf("\nLo sentimos este asiento esta reservado\n-Si desea cancelar la reserva presione 1\n-Si desea reservar otro asiento presione 2\n-Si desea reversar otro asiento en otro avion presione 3\n-Si desea salir del programa presione 4: \n");
												scanf("%d",&v[4]);
												if(v[4]==1)
													{
														v[7]=0;
														while((a2[i][j]!=v[6])&&(v[7]==0))
															{ 
																r++;
																if(r==6)
																	{
																		r=0;
																		printf("\n-Si se equivoco de asiento y/o de avion presione 2: \n");
																		scanf("%d",&v[8]);
																		v[4]=0;
																	}
																if(v[8]!=2)
																	{
																		printf("\n-Ingrese el dni correctamente del asiento reservado: \n");
																		scanf("%d",&v[6]);
																	}
																if(a2[i][j]==v[6])
																	{
																		v[7]=1;
																		a2[i][j]=0;
																		printf("Reserva cancelada\n\n");
																	}
																if(v[8]==2)
																	{
																		v[7]=1;
																	}
																v[13]=1;
															}
														
													}
												if((v[4]==2)||(v[4]==3))
												{
													i=v[3];
													j=4;
												}
											}										
									}
							}
						if(v[2]==3)
							{
								if(cont==v[5])
									{
										v[4]=1;
										if(a3[i][j]==0)
											{
												a3[i][j]=v[6];
												printf("\nEl asiento ha sido reservado\n\n");
												v[4]=0;
												printf("\n-Si desea salir del programa y mostrar los datos en pantalla presione 1,para seguir presione 2: ");
												scanf("%d",&v[9]);
												if(v[9]==1)	
												{
													i=80;
													j=4;
													v[0]=1;
													v[1]=1;
												}
											}
										if((a3[i][j]>0)&&(v[4]!=0))
											{
												printf("\nLo sentimos este asiento esta reservado\n-Si desea cancelar la reserva presione 1\n-Si desea reservar otro asiento presione 2\n-Si desea reversar otro asiento en otro avion presione 3\n-Si desea salir del programa presione 4: \n");
												scanf("%d",&v[4]);
												if(v[4]==1)
													{
														v[7]=0;
														while((a3[i][j]!=v[6])&&(v[7]==0))
															{ 
																r++;
																if(r==6)
																	{
																		r=0;
																		printf("\n-Si se equivoco de asiento y/o de avion presione 2: \n");
																		scanf("%d",&v[8]);
																		v[4]=0;
																	}
																if(v[8]!=2)
																	{
																		printf("\n-Ingrese el dni correctamente del asiento reservado: \n");
																		scanf("%d",&v[6]);
																	}
																if(a3[i][j]==v[6])
																	{
																		v[7]=1;
																		a3[i][j]=0;
																		printf("Reserva cancelada\n\n");
																	}
																if(v[8]==2)
																	{
																		v[7]=1;
																	}
															}
														
													}
												if((v[4]==2)||(v[4]==3))
													{
														i=v[3];
														j=4;
													}
											}										
									}
							}
						if(v[4]==4)
						{
							i=v[3];
							j=4;
							v[0]=1;
						}
					}
				
			}
	}
printf("Avion 1\n\n");
cont=0;
i=0;
j=0;	
for(i=0;i<20;i++)
	{	
		printf("\n");
		for(j=0;j<4;j++)
			{
				if(a1[i][j]>0)
					{
						b1++;
					}
				cont++;
				printf("A%d:%d\t",cont,a1[i][j]);
			}
	}
printf("\n\nAvion 2\n\n");
cont=0;
i=0;
j=0;
for(i=0;i<15;i++)
	{
		printf("\n");
		for(j=0;j<4;j++)
			{
				if(a2[i][j]>0)
					{
						b2++;
					}
				cont++;
				printf("A%d:%d\t",cont,a2[i][j]);
			}
	}
printf("\n\nAvion 3\n\n");
cont=0;
i=0;
j=0;
for(i=0;i<5;i++)
	{
		printf("\n");
		for(j=0;j<4;j++)
			{
				if(a3[i][j]>0)
					{
						b3++;
					}
				cont++;
				printf("A%d:%d\t",cont,a3[i][j]);
			}
	}
a[0]=((b1*100)/80);
a[1]=((b2*100)/60);
a[2]=((b3*100)/20);
printf("\nEl porcentaje de asientos ocupados en los aviones son:\n\tAvion 1\tAvion 2\tAvion 3\n\t%.2f\t%.2f\t%.2f\n",a[0],a[1],a[2]);
printf("La cantidad de asientos ocupados en los aviones son:\n\tAvion 1\tAvion 2\tAvion 3\n\t%.0f\t%.0f\t%.0f",b1,b2,b3);
return 0;
}
	

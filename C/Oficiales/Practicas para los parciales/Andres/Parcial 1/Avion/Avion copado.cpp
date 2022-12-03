#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	int j=0,i=0,k=0,l=0,m=0,o=0;
	int dni1[20][4]={{0},{0}};
	int dni2[15][4]={{0},{0}};
	int dni3[10][4]={{0},{0}};
	float prom1, prom2, prom3;
	int cont1=0,cont2=0,cont3=0;
	int v,w,q,p;
	int c1,c2,c3;
	
	
	printf("Bienvenido este programa de aerolineas argentinas\n");
	do{
		printf("Seleccione una opcion\n");
		do{
			printf("1-reserva\n2-cancelacion\n3-salir\n");
			scanf("%d", &v);
		}while((v!=1)&&(v!=2)&&(v!=3));
		switch (v)
		{
		case 1:
			printf("Seleccione una opcion\n");
			do{
				printf("lea bien:\n 1-avion grande\n2-avion mediano\n3-avion chico\n");
				scanf("%d", &w);
			}while((w!=1)&&(w!=2)&&(w!=3));
			switch (w)
				{
			case 1:	
				do{
					printf("Seleccione fila entre 0 y 19 \t");
					scanf("%d", &i);
				}while((i<0)||(i>19));
				
				do{
					printf("Seleccione columna entre 0 y 3\t");
					scanf("%d", &j);
				}while((j<0)||(j>3));
				
				if(dni1[i][j]!=0)
				{ printf("Asiento ocupado\n"); }
				while(dni1[i][j]==0)
				{
					printf("Ingrese DNI\t");	
					scanf("%d", &dni1[i][j]);
					cont1++;
					
				}
				
				break;
			case 2:	
				do{
					printf("Seleccione fila entre 0 y 14 \t");
					scanf("%d", &k);
				}while((k<0)||(k>14));
				do{
					printf("Seleccione columna entre 0 y 3\t");
					scanf("%d", &l);
				}while((l<0)||(l>3));
				if(dni2[k][l]!=0)
				{ printf("Asiento ocupado\n"); }
				while(dni2[k][l]==0){
					printf("Ingrese DNI\t");	
					scanf("%d", &dni2[k][l]);
					cont2++;
					
				}
				
				break;
			case 3:	
				do{
					printf("Seleccione fila entre 0 y 9 \t");
					scanf("%d", &m);
				  }
				while((m<0)||(m>9));
				do
					{
					printf("Seleccione columna entre 0 y 3\t");
					scanf("%d", &o);
				   }
				   while((o<0)||(o>3));
				if(dni3[m][o]!=0)
				{ 
					printf("Asiento ocupado\n"); 
				}
				while(dni3[m][o]==0)
					{
					printf("Ingrese DNI\t");	
					scanf("%d", &dni3[m][o]);
					cont3++;
					
				    }
				
				break;
				
			}
			system("cls");
			break;
		case 2:
			printf("Seleccione una opcion\n");
			do{
				printf("1-avion grande 80 asientos\n2-avion mediano 60 asientos\n3-avion chico 40 asientos\n");
				scanf("%d", &w);
			}while((w!=1)&&(w!=2)&&(w!=3));
			switch (w)
				{
			case 1:	
				printf("Ingrese DNI\t");	
				scanf("%d", &c1);
				for(p=0;p<20;p++)
				{
					for(q=0;q<4;q++)
					{
						if(dni1[p][q]==c1)
						{
							dni1[p][q]=0;
							cont1--;
						}
					}
				}	
				
				printf("El asiento ha sido cancelado exitosamente\t");
				system("pause");
				break;
			case 2:	
				printf("Ingrese DNI\t");	
				scanf("%d", &c2);
				for(p=0;p<15;p++)
				{
					for(q=0;q<4;q++)
					{
						if(dni2[p][q]==c2)
						{
							dni2[p][q]=0;
							cont2--;
						}
					}
				}	
				
				printf("El asiento ha sido cancelado exitosamente\t");
				system("pause");
				break;
			case 3:	
				printf("Ingrese DNI\t");	
				scanf("%d", &c3);
				for(p=0;p<10;p++){
					for(q=0;q<4;q++){
						if(dni3[p][q]==c3){
							dni3[p][q]=0;
							cont3--;
						}
					}
				}	
				
				printf("El asiento ha sido cancelado exitosamente\t");
				system("pause");
				break;
			}
			system("cls");
			break;
		case 3:
			system("cls");
			printf("Cantidad de asientos reservados\n");
			printf("1-avion grande:%d\n", cont1);
			printf("1-avion mediano:%d\n",cont2);
			printf("1-avion chico:%d\n",cont3);
			
			printf("\nPromedio de asientos ocupados\n");
			prom1=cont1*1.25;
			prom2=cont2*1.66;
			prom3=cont3*2.5;
			printf("1-avion grande:%.2f\n", prom1);
			printf("1-avion mediano:%.2f\n",prom2);
			printf("1-avion chico:%.2f\n",prom3);
			
			printf("\nGraficas\n");
			printf("\navion (grande 80)\n");
			for(p=0;p<20;p++)
				{
				printf("\n");
				for(q=0;q<4;q++)
					{
							printf("%d\t", dni1[p][q]);
			
					}
				}
			
			printf("\navion mediano (60 asientos)\n");
			for(p=0;p<15;p++){
				printf("\n");
				for(q=0;q<4;q++){
					printf("%d\t", dni2[p][q]);
				}
			}
			printf("\navion chico (40 asientos)\n");
			for(p=0;p<10;p++){
				printf("\n");
				for(q=0;q<4;q++){
					printf("%d\t", dni3[p][q]);
				}
			}
			break;
		}
	}while(v!=3);
	return 0;
} 


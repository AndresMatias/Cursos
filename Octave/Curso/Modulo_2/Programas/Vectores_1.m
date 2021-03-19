#Vetor Fila
fprintf("Vector Fila\n")
V_1=[3 4 5 6 7 8 9 10] 
V_2=[10,11,12,13,14,15,16,17]

#Vetor Columna
fprintf("Vector Columna\n")
V_3=[1;2;3;4]
V_10=[5;6;7;8]

#Incrementos(Valor_Inicial:Incremento:Valor_Final)
fprintf("Incrementos\n")
V_4=0:2:10  #Incremento positivo
V_5=10:-2:0 #Incremento negativo
V_6=1:2:10  #El valor en consola sera 9 porque no puede sobrepasar el valor final

#Omision de Incremento
fprintf("Omitiendo incrementos\n")
V_7=4:8 #Solo valor inicial y final, la consola sobreentiende que el incremento es 1

#Funcion para generar vectores V=linspace(Valor_Inicial,Valor_Final,Numeros_Elementos)
#Esta funcion calcula el incremento necesario para pasar al proximo elemnto
fprintf("Funcion linspace()\n")
V_8=linspace(0,10,11)
V_9=linspace(0,10,7)

#Para crear un vector uso [] para consultar valor de una posicion uso (), no existe la posicion 0 es a partir de la posicion 1
fprintf("Consulto valor de la posicion 4 del vector\n")
V_1(4)

fprintf("Consulto valores de las posiciones 2 y 4 de vector V_1\n")
V_1([2,4])

fprintf("Consulto los valores de la posicion 2 a la 8 de V_1\n")
V_1(2:8) 

fprintf("Consulto valor final\n")
V_1(end)

#Matrices
fprintf("Creo matriz de 3x3\n")
M_1=[1 2 3;4 5 6;7 8 9] #Creo matriz 3x3
fprintf("Creo matriz de a partir de vectores filas V_1 y V_2\n")
M_2=[V_1;V_2]   #Creo matriz a partir de V_1 y V_2, se separa con ";"[;] porque son vectores filas
fprintf("Creo matriz de a partir de vectores columnas V_10 y V_3\n")
M_3=[V_3,V_10]  #Creo matriz a partir de V_3 y V_10,se separa con ","[,] porque son vectores columnas
#Para consultar numeros de posiciones es igual que en vectores
fprintf("Consulto valores de M_1 posicion 2 2\n")
M_1(2,2) 
fprintf("Consulto valores de M_1 varias posiciones\n")
M_1([1 2],[2 3])  #Devuelve submatriz formada por las filas y columnas de los subindices
                  #Intercecion de fila 1 y 2 con columnas 2 y 3
fprintf("Los "":"" indican toda la fila o columna de esa pantalla\n")
M_1(1,:)  #Devuelve todos los elementos de la fila 1
M_1(:,2)  #Devuelve todos los elementos de la columna 2

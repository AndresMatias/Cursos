#Funcion eye(m): Devuelve una matriz identidad de m dimesiones (mxm)
fprintf("Matriz identidad de m filas y m columnas con eye(m)\n")
eye(3)

#Funcion eye(m,n): Devuelve una matriz identidad de m dimesiones (mxn)
fprintf("Matriz identidad de m filas y n columnas con eye(m,n)\n")
eye(3,4)

#Funcion zeros(m): Devuelve una matriz de ceros de m dimesiones (mxm)
fprintf("Matriz de zeros de m x m con zeros(m)\n")
zeros(4)

#Funcion zeros(mxn): Devuelve una matriz de ceros de m dimesiones (mxn)
fprintf("Matriz de ceros de m x n con zeros(m,n)\n")
zeros(4,5)

#Funcion ones(m): Devuelve una matriz de unos de m dimesiones (mxm)
fprintf("Matriz de unos de m x m con ones(m)\n")
ones(4)

#Funcion ones(mxn): Devuelve una matriz de unos de m dimesiones (mxn)
fprintf("Matriz de unos de m x n con ones(m,n)\n")
ones(4,3)

#Eliminando elementos de una matriz
V_1=[1 2 3 4 5 6]
fprintf("Eliminando la posicion 3 del vector V_1 mediante V_1(3)=[]\n")
V_1(3)=[]
M_1=[1 2 3 4;4 5 6 7]
fprintf("Eliminando la toda la columna 2 de la matriz M_1 mediante M_1(: , 2)=[]\n")
M_1(: , 2)=[]

#Aplico operadores tipo logical y el resultado sera un vector o matriz de las misma dimensiones con valores logical, estos operadores operan elemento a elemento
V_1=[1 2 3 4 5 6]
fprintf("Aplicando V_1<4\n")
V_1<4
M_1=[1 2 3 4;4 5 6 7]
fprintf("Aplicando M_1<4\n")
M_1<4
fprintf("Solo aplique dos operadores pero hay mas<4\n")

#Creo subvector de otro existente
V_1
fprintf("Creo subvector a partir de V_1 meditante V_1(V_1<n)\n")
V_1(V_1<4)

#rand(): Genera numeros aleatorios del 0 al 1
fprintf("Numeros aleatorios con rand()\n")
rand()

#rand(m): Genera matriz de mxm de numeros aleatorios del 0 al 1
fprintf("Matriz mxm de numeros aleatorios con rand(m)\n")
rand(3)

#rand(mxn): Genera matriz de mxn de numeros aleatorios del 0 al 1
fprintf("Matriz mxn de numeros aleatorios con rand(m,n)\n")
rand(3,4)

#Nota sin programacion: A*rand():Devuelve numero entre 0 y A
#Nota sin programacion: A+rand():Devuelve numero entre A y A+1
#Nota sin programacion: A + (B-A)rand():Devuelve numero entre A y B

#Funcion round(n):Devuelve un numero entero mas proximo a n siendo n un numero decimal
fprintf("Funcion round() aplicado a 7,2 y 7,6\n")
fprintf("Para 7,2: ")
round(7.2)
fprintf("Para 7,6: ")
round(7.6)

#Nota sin programacion: Si combino round y rand puedo conseguir un intervalo de numeros enteros para el intervalo A y B de la siguiente forma round(A + (B-A)rand())

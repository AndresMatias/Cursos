M_1=[1 2 3;4 5 6] #Matriz de 3x3
M_2=[1 2 3;4 5 6] #Matriz de 3x3
M_3=[1;2;3]   #Matriz de 3x1
M_4=[6 5 3;2 4 1] #Matriz de 3x3
M_5=[6 5 ;2 4 ] #Matriz de 2x2
V_1=[1 2 3 4 5]
V_2=[5 2 4 3 1]
V_3=[1 2 3]
V_4=[5 2 4]
#Suman de Matrices
#Para que se puedan sumar deben de tener las mismas dimensiones, la operacion se realiza elemento a elemento
fprintf("Suma\n")
M_1+M_2

#Suma 7 a toda cada elemento, valido para resta multiplicacion y divisin
fprintf("Suma de un numero entero M_1+7\n")
M_1+7
fprintf("Multiplicacion\n")
#El numero de columnas de la primera matriz debe ser igual al numero de filas de la segunda matriz, repasar propiedades de matrizces etc
#M_1(mxn)*M_3(nxc)=M(mxc) Condicion n=n
M_1*M_3

#Multiplicacion y Division elemento a elemento solo para matrices de dimensiones iguales, valido para elevar a un exponente dado
fprintf("Multiplicacion elemento a elemento\n")
M_1.*M_2
fprintf("Division elemento a elemento\n")
M_1./M_2
fprintf("Exponente elemento a elemento\n")
M_1.^2

#Funcion length():Devuelve numero de componentes de un vector
fprintf("Funcion lenght para vectores\n")
length(V_1)

#Funcion [fil,col]=size(M_1) devuelve numero de filas y columnas de una matriz
fprintf("Numero de filas y columnas de M_1\n")
[fil,col]=size(M_1)

#Numero de filas de M_1
fprintf("Numero de filas de M_1\n")
size(M_1,1)
#Numero de columnas de M_1
fprintf("Numero de columnas de M_1\n")
size(M_1,2)

#Funciones max() y min()
fprintf("Componente con mayor valor del vector V_1\n")
max(V_1)
fprintf("Componente con menor valor del vector V_1\n")
min(V_1)

#max(M_1) y min(M_1)
fprintf("Devuelve un vector con las componentes de mayor valor de cada columna\n")
max(M_1)
fprintf("Devuelve un vector con las componentes de menor valor de cada columna\n")
min(M_1)

#max(max(M_1)) y min(min(M_1),revisar si se puede combinar
fprintf("Componente con mayor valor de la matriz M_1\n")
max(max(M_1))
fprintf("Componente con menor valor de la matriz M_1\n")
min(min(M_1))

#Funciones sum() y prod()
fprintf("Suma de las componentes del vector V_1\n")
sum(V_1)
fprintf("Producto de las componentes del vector V_1\n")
prod(V_1)
fprintf("Devuelve un vector de la suma de cada columna de la matriz M_1\n")
sum(M_1)
fprintf("Devuelve un vector del producto de cada columna de la matriz M_1\n")
prod(M_1)
fprintf("Suma de todas las componentes de la matriz M_1\n")
sum(sum(M_1))
fprintf("Producto de todas las componentes de la matriz M_1\n")
prod(prod(M_1))

#Funcion sort()
V_2
fprintf("Ordeno a V_2 con funcion sort\n")
sort(V_2)
M_4
fprintf("Devuelve un vector con los elementosde las columnas ordenados de M_4 \n")
sort(M_4)
sort(M_4)

#Producto Vectorial solo para dimensiones de 3
fprintf("Productor Vectorial de dos vectores de igual dimensiones(3)\n")
cross(V_3, V_4)

#Producto Escalar solo para dimensiones de 3
fprintf("Productor Escalar de dos vectores de igual dimensiones(3)\n")
dot(V_3, V_4)

#Modulo de un vector solo para dimensiones de 3
fprintf("Modulo de V_1\n")
norm(V_3)

#Inversa, Determinante, Traza y Traspuesta para matrices cuadradas
fprintf("Inversa\n")
inv(M_5)
fprintf("Determinante\n")
det(M_5)
fprintf("Traza\n")
trace(M_5)
fprintf("Traspuesta\n")
transpose(M_5)




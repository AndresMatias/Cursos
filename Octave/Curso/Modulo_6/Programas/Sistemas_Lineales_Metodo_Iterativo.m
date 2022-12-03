#Metodo Iterativo x=C*x+d Eficiente para un numero elevadode incognitas
#Algunos metodos directos:
  #Metodo Gauss
  #Metodos de factorizacion de LU
  #Metodo de Choleski
#Inconvenientes de metodos directos:
  #Mucho tiempo de computo para un sistema de muchas variables
  #Errores grandes
  #Modifica matriz del sistema se pierden los ceros
  #No hay Soluciones Intermedias
  #Nececitan almacenar grandes matrices
#Metodos Iterativos:
  #Se comienza descomponiendo la matris A=P-Q
#Ventajas:
  #No modifica la matriz del sistema
  #Estables frente a errores de redondeo
  #Permite disponer en cada etapa de una aproximacion de la solucion
#Algunos metodos iterativos:
  #Metodo Jacobi(Creo que no es lo mismo de matriz jacobiana) A=D+L+U (suma de tres matrices) 
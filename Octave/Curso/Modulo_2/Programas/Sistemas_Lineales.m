# A*X = B A:Matriz formada por los coeficientes de las ecuaciones B:Matriz Formada por el lado izquierdo de las ecuaciones X:Matriz de Variables
# inv(A)*A X =inv(A)*B 
# inv(A)*A=Identidad
#X=inv(A)*B Solucion de un Sistema de ecuaciones lineales
#Ejemplo
fprintf("Resolucion de sistemas lineales por matrices\nSistema de Ecuaciones:\n")
fprintf(" x*3 + y*4 + z*2 = 2\n x*1 + y*2 + z*2 = 4\n x*8 + y*2 + z*6 = 12\Armos las matrices A*X=B\n")
A=[3 4 2;1 2 2;8 2 6]
B=[2;4;12]
fprintf("Aplicando las operaciones que estan en los comentarios del programa: X=inv(A)*B\n")
inv(A)*B
fprintf("Tambien sistemas grandes se usa A/B porque no le exije tanto al computador debido a que invertir la matriz requiere mucho computo\n")
A\B #Usar barra invertida \ , no la barra comun /
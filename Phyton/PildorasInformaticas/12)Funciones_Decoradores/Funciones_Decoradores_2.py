#Video 74 y 74b terminar de ver kwwards
def funcion_decoradora(funcion_parametro):
	def funcion_interior(*arg): #*arg: La funcion recibe un nuero indefinido de argumentos
		#Acciones adicionales que decoran
		print("Vamos a realizar un calculo")
		funcion_parametro(*arg)
		#Acciones adicionales que decoran
		print("Hemos terminado el calculo")

	return funcion_interior

@funcion_decoradora #Decoro solo la funcion suma
def suma(num1,num2):
	print(num1+num2)
	
@funcion_decoradora #Decoro solo la funcion resta
def resta(num1,num2):
	print(num1-num2)


suma(5,5)
resta(5,5)	
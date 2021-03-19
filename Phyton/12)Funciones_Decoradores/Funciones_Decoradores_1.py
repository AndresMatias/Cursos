#Video 73
def funcion_decoradora(funcion_parametro):
	def funcion_interior():
		#Acciones adicionales que decoran
		print("Vamos a realizar un calculo")
		funcion_parametro()
		#Acciones adicionales que decoran
		print("Hemos terminado el calculo")

	return funcion_interior

@funcion_decoradora #Decoro solo la funcion suma
def suma():
	print(15+12)
	
@funcion_decoradora #Decoro solo la funcion resta
def resta():
	print(10-5)


suma()
resta()		
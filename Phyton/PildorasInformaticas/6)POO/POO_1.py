#Video 26 y 27
class Coche():
	def __init__(self): #Constructor 
		self.__largoChasis=250 #Los dos guiones sirven para que la variable solo sea accedida solo por la clase y no por fuera de esta, tambien en donde la use en la clase tengo que agregar los guiones
		self.__anchoChasis=120
		self.__ruedas=4
		self.__enmarcha=False
	def arrancar(self,arrancamos): #Funcion no es lo mismo que metodo, metodo pertenece a la clase la funcion no pertenece a nada
		self.__enmarcha=arrancamos			#self hace referencia a la instancia perteneciente a la clase
		if(self.__enmarcha):
			chequeo=self.__chequeo_interno() 
		if (self.__enmarcha and chequeo): #si ambas son True
			return "En marcha"
		elif(self.__enmarcha==True and chequeo==False):
			return "Error durante el chequeo"	
		else:
			return "Parado"	
	def estado(self):
		print("Largo: ",self.__largoChasis,
			"\nAncho: ",self.__anchoChasis,
			"\nRuedas: ",self.__ruedas)
	def __chequeo_interno(self): #Metodo encapsulado para ser usado solo por la clase 
		print("Chequeo interno")
		self.gasolina="ok"
		self.aceite="mal"
		self.puertas="ok"
		if (self.gasolina=="ok" and self.puertas=="ok" and self.aceite=="ok"):
			return True
		else:
			return False	


miCoche=Coche() #Creo objeto
print(miCoche.arrancar(True))
miCoche.estado()

print("\nCreo 2do Objeto\n")
miCoche2=Coche() #Creo objeto
print(miCoche2.arrancar(False))
miCoche2.estado()
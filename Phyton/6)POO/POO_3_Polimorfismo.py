#Video 32
class Coche():
	def desplazamiento(self):
		print("Uso 4 ruedas")

class Moto():
	def desplazamiento(self):
		print("Uso 2 ruedas")

class Camion():
	def desplazamiento(self):
		print("Uso 8 ruedas")

def desplazamiento(vehiculo): #Este objeto cambia de forma
	vehiculo.desplazamiento()

miVehiculo=Camion()
desplazamiento(miVehiculo)	
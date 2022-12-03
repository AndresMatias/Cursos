#Video 29
class Vehiculos():
	def __init__(self,marca,modelo):
		self.marca=marca
		self.modelo=modelo
		self.enmarcha=False
		self.acelera=False
		self.frena=False
	def arranca(self):
		self.enmarcha=True
	def acelera(self):
		self.acelera=True
	def frena(self):
		self.frena=True
	def estado(self):
		print("Marca: ",self.marca,"\nModelo: ",self.modelo,"\nEn marcha: ",self.enmarcha,
			"\nAcelerando: ",self.acelera,"\nFrenando: ",self.frena)
class Furgoneta(Vehiculos):
	def Carga(self,carga):
		self.cargado=carga
		if (self.cargado):
			return "La furgoneta esta cargada"
		else:
			return "La furgoneta no esta cargada"	
class Moto(Vehiculos): #Herencia
	hcaballito=""
	def caballito(self):
		self.hcaballito="Haciendo caballito"
	def estado(self): #Sobreescribo el metodo estado
		# super().estado() #asi llamo al metodo estado de la clase vehiculos
		print("Marca: ",self.marca,"\nModelo: ",self.modelo,"\nEn marcha: ",self.enmarcha,
			"\nAcelerando: ",self.acelera,"\nFrenando: ",self.frena,"\n",self.hcaballito)	

class VeElectricos(Vehiculos):
	def __init__(self,marca,modelo):
		super().__init__(marca,modelo) #llamo al constructor de la clase padre vehiculos
		self.autonomia=100
	def CargarEnergia(self):
			self.cargando=True
	def estado(self):
		super().estado()		

miMoto=Moto("Honda","CBR")
miMoto.caballito()
miMoto.estado()

miFurgoneta=Furgoneta("Renault","Kangoo")
miFurgoneta.arranca()
miFurgoneta.estado()
print(miFurgoneta.Carga(True))

class BiciElectrica(VeElectricos,Vehiculos):#herencia multiple, se da preferencia a la primera clase en el parentesis para el constructor
	
	def estado(self):
		super().estado()

miBici=BiciElectrica("Tesla","hrc")	
miBici.estado()
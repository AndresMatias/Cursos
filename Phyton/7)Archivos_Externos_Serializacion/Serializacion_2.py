#Video 40
import pickle
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

choche1=Vehiculos("tesla","rx")
choche2=Vehiculos("te","r")
choche3=Vehiculos("tes","x")		
coches=[choche1,choche2,choche3]
fichero=open("fichero_clase","wb") #wb:escritura binaria
pickle.dump(coches,fichero)
fichero.close()
del(fichero) #borro de la memoria

#lectura de un archivo serializado
fichero=open("fichero_clase","rb") #rb:lectura binaria
misCoches=pickle.load(fichero)
fichero.close()
del(fichero) #borro de la memoria
for c in misCoches:
	print("\n",c.estado())

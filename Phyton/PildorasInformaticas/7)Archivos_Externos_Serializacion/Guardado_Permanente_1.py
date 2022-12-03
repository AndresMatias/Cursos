#Video 41
import pickle

class Persona:
	def __init__(self,nombre,genero,edad):
		self.nombre=nombre
		self.genero=genero
		self.edad=edad
		print("Se ha creado una persona nueva con el nombre: ",self.nombre)
	def __str__(self): #Metodo espcial que convierte  en cadena de texto la info de entrada
		return "{} {} {}".format(self.nombre,self.genero,self.edad)

class ListaPersonas(object):
	Personas=[]
	def __init__(self):
		try:
			listaDePersonas=open("Fichero Externo","ab+") #ab+:abre el archivo para agregar info binaria
			listaDePersonas.seek(0)
			self.Personas=pickle.load(listaDePersonas) #Aca se guardan las personas del fichero
			print("Se cargaron {} personas".format(len(self.listaDePersonas)))
		except Exception as e:
			print("Fichero vacio")
		finally:
			listaDePersonas.close()
			del(listaDePersonas)
		
	def agregarPersonas(self, p):
		self.Personas.append(p)
		self.GuardarPersonasFichero()

	def mostrarPersonas(self):
		for p in self.Personas:
			print(p)

	def GuardarPersonasFichero(self):
		listaDePersonas=open("Fichero Externo","wb")
		pickle.dump(self.Personas,listaDePersonas)
		del(listaDePersonas)
	def infoFicheroExterno(self):
		print("La Informacion es la siguiente: \n")
		for p in self.Personas:
			print(p)

miLista=ListaPersonas()		
p=Persona("Sandra","Femenino",25)
miLista.agregarPersonas(p)
miLista.mostrarPersonas()
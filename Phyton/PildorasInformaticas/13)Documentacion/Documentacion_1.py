class  area:
	"""Esta clase calcula las areas"""		
	def areaCuadrado(lado):
		"""Funcion que calcula
			el area de un cuadrado"""
		return "El area del cuadrado es: "+str(lado*lado)

	def areaTriangulo(base,altura):
		"""Funcion que calcula
			el area de un triangulo"""
		return "El area del triangulo es: "+str((base*altura)/2)

#print(area.areaCuadrado.__doc__)#imprime documentacion(comentarios) de la funcion
help(area.areaCuadrado)#imprime documentacion(comentarios) de la funcion
#help(area)	
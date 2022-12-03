def devuelve_ciudades(*ciudades): #el * indica que va a recibir un nro indeterminado de argumentos y en forma de tuplas
	for elementos in ciudades:
		# for subElementos in elementos:
		# 	yield subElementos
		yield from elementos #Codigo simplicado del for de arriva como si trabajara con un vector de dos dimensiones

ciudades_devueltas=devuelve_ciudades("madrid","cordoba","BsAs")
print(next(ciudades_devueltas))
print(next(ciudades_devueltas))			
import re
#Video 70 y 71
lista_nombres=["Ana María",
			   "María Martín",
			   "Sandra López",
			   "Sandra Fernandez",
			   "Santiago Martín",
			   "Martín Andres"]

for elemento in lista_nombres:
	if re.findall('^Sandra',elemento):  #Metacaracter: ^ todo lo q empiza pro esa palabra
		print(elemento)
print("\n\n")
for elemento in lista_nombres:
	if re.findall('Martín$',elemento):  #Metacaracter: $ todo lo que termina con esa palabra, por ej Martin Andres no va a aparecer
		print(elemento)
print("\n\n")
for elemento in lista_nombres:
	if re.findall('Martí[nñ]',elemento):  #Metacaracter: [] Busca caracter en una palabra y si quito la palabra muestra todas las palabras q tienen ese caracter, el [nñ] palabras q tengan o n o ñ
		print(elemento)
print("\n\n")
for elemento in lista_nombres:
	if re.findall('[o-t]]',elemento):  #Metacaracter: [] Busca caracter en un rango de caracteres peudo combinar con ^[]: todos lso nombres que empiecen con, y con []$:los nombres que terminan
		print(elemento)
print("\n\n")
# for elemento in lista_nombres:
# 	if re.findall('[^o-t]]',elemento):  #Metacaracter: [^] escluye lo que hay en el corchete 


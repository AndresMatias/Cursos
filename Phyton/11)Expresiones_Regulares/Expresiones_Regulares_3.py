import re
#Video 72

nombre1="Sandra López"
nombre2="Antonio Gómez"
nombre3="María López"
cadena1="a1561654"
cadena2="asdfdsfgdfgsd asdqwerkojlkjh asdasd71asdasd dsfgdfgdfsadfsdf"
#match:Busca patrones al principio de la cadena y admite 3er parametro y distingue entre mayuscula y minuscula
if re.match("Sandra",nombre2,re.IGNORECASE): #IGNORECASE:Ignora diferencia entre mayuscula y minuscula
	print("Nombre Encontrado")
else:
	print("Nombre No Encontrado")
print("\n")
if re.match(".andra",nombre2,re.IGNORECASE): #.:Comodin reemplaza pro cualquier letra en caso de nombre parecidos
	print("Nombre Encontrado")
else:
	print("Nombre No Encontrado")
print("\n")
if re.match("\d",cadena1): #\d:si empienza por un numero
	print("Numero Encontrado")
else:
	print("Numero No Encontrado")
print("\n")

#---------------------------------------search-----------------------------------------------
#search:Busca en toda la cadena
if re.search("López",nombre1): #\d:si empienza por un numero
	print("Nombre Encontrado")
else:
	print("Nombre No Encontrado")
print("\n")
if re.search("71",cadena2): #\d:si empienza por un numero
	print("Numero Encontrado")
else:
	print("Numero No Encontrado")					

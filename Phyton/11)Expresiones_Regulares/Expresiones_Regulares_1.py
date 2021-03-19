import re

cadena="vamos a aprender de expresiones regulares en Phyton. Phyton es un lenguaje sencillo"
print(re.search("aprender",cadena))
print(re.search("aprenderrrrr",cadena)) #none

#otra forma de acerlo es
textoBuscar="aprender"
if re.search(textoBuscar,cadena) is not None:
	print("Texto encontrado")
else:
	print("Texto no encontra	do")

#Tambien 
textoEncontrado=re.search(textoBuscar,cadena)
print(textoEncontrado.start())
print(textoEncontrado.end())
print(textoEncontrado.span())

print(re.findall("Phyton",cadena))
print(len(re.findall("Phyton",cadena))) #longitud de la lista


#video 14 al 16
for i in [1,2,3]:
	print("Hola")

for i in [1,"chau","verano"]:
	print(i)

for i in [1,2,3]:
	print("Hola", end=" ")	#Impresion todo en una linea
print("")

for i in "Impresion caracter @ a caracter": #Sin corchetes
	print("Hola", end=" ")	#Impresion todo en una linea
	if i=="@":
		print("Aparece el Arroba")
print("")

# caracter=False
# contador=0
# mail=input("Ingrese su email: ")
# for i in mail: #Sin corchetes
# 	if(i=="@" or i=="."):
# 		contador=contador+1
# if contador==2:
# 	print("Direccion correcta")
# print("")

for i in range(5,11,2): #cuenta desde el 5 hasta el 10 de 2 en 2 tambien puede ser solo con 5 y 11 sin tercer argumento
	print(f"valor de la variable i: {i}") #f: concatena texto con valor

print(len("Juan")) #Nro de caracteres	
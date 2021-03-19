print("Programa Becas")
distancia_escuela=int(input("Introduce la distancia en km: "))
print(distancia_escuela)

numero_hermanos=int(input("Introduce el numero de hermanos: "))
print(numero_hermanos)

salario=int(input("Introduce el salario familiar: "))
print(salario)

#Utilizo operador and
if distancia_escuela>40 and numero_hermanos>2 and salario<=20000:
	print("Tienes derecho")
else:
	print("No tienes derecho")

if distancia_escuela>40 and numero_hermanos>2 or salario<=20000:  #Ejemplo de or
	print("Tienes derecho")
else:
	print("No tienes derecho")	

print("Asignatura optativa")
print("Aplicada v - Digitales v - Teleinformatica")
Asignatura=input("Introdusca asignatura: ")

opcion=Asignatura.lower() #tranformo todo a minuscula
if opcion in ("aplicada v", "digitales v", "teleinformatica"): #Ejemplo de in
	print("Asignatura elegida "+Asignatura)
else:
	print("No escogio asignatura")	
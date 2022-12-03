print("Programa para ejercitar condicionales")
nota_alumno=input("Ingrese la nota del alumno: ") #Ingreso por teclado
def evaluacion(nota):
	valoracion="aprobado"
	if nota<6:
		valoracion="suspendido"
	return valoracion
print(evaluacion(int(nota_alumno))) #el int es para convertir a tipo numerico		
	
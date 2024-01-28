import math
# def evaluaEdad(edad):
# 	if edad < 0:
# 		raise MiPropioError("Error en la edad")
# 	if edad < 20:
# 		print("Muy joven")
# 	elif edad < 40:
# 		print("Joven")
# 	elif edad < 60:
# 		print("Cuidado")
# 	elif edad < 80:
# 		print("Mucho cuidado")			

# evaluaEdad(18)
# evaluaEdad(-18)
def calculadora(num1):
	if num1<0:
		raise ValueError("No puede ser negativo")
	else:
		return math.sqrt(num1)
try:
	print(calculadora(-20))
except ValueError as ErrorNroNegativo:
			print(ErrorNroNegativo) #ErrorNroNegativo corresponde con la linea nro 18
			

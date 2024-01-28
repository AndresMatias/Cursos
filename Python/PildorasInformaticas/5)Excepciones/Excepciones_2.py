def divide():
	try:
		op1=(float(input("Introduce el primer numero: ")))
		op2=(float(input("Introduce el segundo numero: ")))
		print("El resultado es: "+str(op1/op2))
	except ValueError:
		print("Error en los valores introducidos")
	except ZeroDivisionError:
		print("No se puede dividir por 0")
	# except: #Capturar de manera general pero no se recomienda
	# 	print("Ha ocurrido error")
	finally: #Siempre se ejecuta 
		print("Programa finalizado")	


divide()	
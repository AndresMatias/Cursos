import random

def numeroAleatorio(intentos):
	numAleatorio=random.randint(0,100)
	print(numAleatorio)
	aux=intentos
	while True:
		numIngresado=int(input("Ingresar un número del 1 al 100: "))
		intentos=intentos-1
		if numIngresado == numAleatorio:
			print ("Adivinaste! El numero era ",numAleatorio)
			print ("Acertaste en ",aux-intentos,"intento/s")
			break	
		elif intentos==0:
			print("No te quedan mas intentos")
			print("El número era " ,numAleatorio)
			break
		else:
			print("Ese no era el número, te quedan ", intentos ,"intentos.", end=' ')
			if numIngresado > numAleatorio:
				print("El numero ingresado es mayor al aleatorio.\n")
			else: print("El numero ingresado es menor al aleatorio.\n") 


	return None
print("Bienvenido")
intentos=5
numeroAleatorio(intentos)

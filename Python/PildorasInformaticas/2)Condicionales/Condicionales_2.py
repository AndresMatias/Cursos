#Video 11
print("Verificacion de acceso")
edad_usuario=int(input("Ingrese su edad: "))

if edad_usuario<18 : 
	print("Menor de edad")
elif edad_usuario>100 :         #si utilizo elif el programa va a entrar en else cuando NADA de lo anterior se ha cumplido y lo mismo si hay varios elif
	print("Edad incorrecta")
else:
	print("Mayor de edad")

print("Verificacion de acceso")
nota=int(input("Ingrese su nota: "))

if nota<5:
	print("Muy mal") #con elif funciona todo como un bloque si se cumple una condicion el resto no se cumple
elif nota<6:
	print("mal")	
elif nota<7:
	print("bien")	
elif nota<8:
	print("muy bien")
elif nota<9:
	print("Genial")	
else: #Poner los puntitos pegados
	print("Excelente")	

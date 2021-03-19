def generarPares(limites):
	num=1

	while num<limites:
		yield num*2 #Contruyo generador y devuelvo de uno en uno
		num=num+1 

devuelveObjeto=generarPares(10)

# for i in devuelveObjeto:
# 	print(i)
#Los generadores son mas eficientes a la hora de trabajar con espacios en memoria ver video 19 minuto 16 mas o menos
print(next(devuelveObjeto)) #vuelve a la linea 8
print("Mas Codigo...")
print(next(devuelveObjeto)) #vuelve a la linea 8
print("Mas Codigo...")
print(next(devuelveObjeto)) #vuelve a la linea 8
'''def area_triangulo(base,altura):
	return (base*altura)/2

triangulo1= area_triangulo(2,2)
triangulo2= area_triangulo(9,6)

print(triangulo1)
print(triangulo2)'''

area_triangulo=lambda base,altura:(base*altura)/2 #Funcion lambda codigo de arriba resumido
#cubo=lambda numero:pow(numero,3)
cubo=lambda numero:numero**3
destacar_valor=lambda comision:"¡{} $!".format(comision)
print(area_triangulo(8,2))
print(area_triangulo(2,2))
print(cubo(3))
print(destacar_valor(15000))

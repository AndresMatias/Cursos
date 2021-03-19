'''def numero_par(num):
	if num%2==0:
		return True'''

numero=[14,2,9,8,5,3,6]

print(list(filter(lambda numero_par:numero_par%2==0,numero)))

class Empleado:
	def __init__(self,nombre,cargo,salario):
		self.nombre=nombre
		self.cargo=cargo
		self.salario=salario
	def __str__(self):
		return "{} que trabaja como {} y tiene un salario de {} $".format(self.nombre, self.cargo, self.salario)

listaEmpleados=[Empleado("Juan","Director",4000),
				Empleado("Ana","Presidenta",5000),
				Empleado("Antonio","Administrativo",3000),
				Empleado("Sara","Secretaria",2000),
				Empleado("Mario","Botones",1000),]

salarios_altos=filter(lambda Empleado:Empleado.salario>3000,listaEmpleados)

for empleado_salario in salarios_altos:
	print(empleado_salario)									
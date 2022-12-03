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

def calculo_comision(empleado):
	empleado.salario=empleado.salario*1.03 #salario + el 3% del salario
	return empleado

listaEmpleadosComision=map(calculo_comision,listaEmpleados)	#map a diferencia de filter en vez de pasar un lambda pasa una funcion en su 1er argumento

for empleado in listaEmpleadosComision:
	print(empleado)
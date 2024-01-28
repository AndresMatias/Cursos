import sys, re
from PyQt5.QtWidgets import QApplication, QDialog, QMessageBox
from PyQt5 import uic

class Dialogo(QDialog):
	def __init__(self):
		QDialog.__init__(self)
		uic.loadUi("validacion.ui", self)
		self.nombre.textChanged.connect(self.validar_nombre) #Cuando cambia el texto
		self.email.textChanged.connect(self.validar_email) #Cuando cambia el texto
		self.boton.clicked.connect(self.validar_formulario) #Cuando cambia el texto
		
	def validar_nombre(self):
		nombre = self.nombre.text()
		validar = re.match('^[a-z\sáéíóúàèìòùäëïöüñ]+$', nombre, re.I) #filtro para permitir a letras a-z espacios vocales y creo que ignora mayusculas
		if nombre == "":
			self.nombre.setStyleSheet("border: 1px solid yellow;")
			return False
		elif not validar:
			self.nombre.setStyleSheet("border: 1px solid red;")
			return False
		else:
			self.nombre.setStyleSheet("border: 1px solid green;")
			return True
			
	def validar_email(self):
		email = self.email.text()
		validar = re.match('^[a-zA-Z0-9\._-]+@[a-zA-Z0-9-]{2,}[.][a-zA-Z]{2,4}$', email, re.I) #valores que admite y que si o si tiene que tener como por ejemplo el @
		if email == "":
			self.email.setStyleSheet("border: 1px solid yellow;")
			return False
		elif not validar:
			self.email.setStyleSheet("border: 1px solid red;")
			return False
		else:
			self.email.setStyleSheet("border: 1px solid green;")
			return True
		
	def validar_formulario(self):
		if self.validar_nombre() and self.validar_email():
			QMessageBox.information(self, "Formulario correcto", "Validación correcta", QMessageBox.Discard)
		else:
			QMessageBox.warning(self, "Formulario incorrecto", "Validación incorrecta", QMessageBox.Discard)
		
		
app = QApplication(sys.argv)
dialogo = Dialogo()
dialogo.show()
app.exec_()
import sys
from PyQt5.QtWidgets import QApplication, QMainWindow
from PyQt5 import uic
from PyQt5.QtGui import QFont
from PyQt5.QtCore import Qt
import ctypes #GetSystemMetrics

#Clase heredada de QMainWindow (Constructor de ventanas)
class Ventana(QMainWindow):
    #Método constructor de la clase
    def __init__(self):
        #Iniciar el objeto QMainWindow
        QMainWindow.__init__(self)
        #Cargar la configuración del archivo .ui en el objeto
        uic.loadUi("MainWindow.ui", self)
        self.setWindowTitle("Cambiando el título de la ventana")
        #Mostrar la ventana maximizada
        self.showMaximized()
        #Fijar el tamaño de la ventana
        #Fijar el tamaño mínimo
        #self.setMinimumSize(500, 500)
        #Fijar el tamaño máximo
        #self.setMaximumSize(500, 500)
        #Mover la ventana y centrarla en el escritorio
        resolucion = ctypes.windll.user32 #Resolucion del monitor
        resolucion_ancho = resolucion.GetSystemMetrics(0)
        resolucion_alto = resolucion.GetSystemMetrics(1)
        left = (resolucion_ancho / 2) - (self.frameSize().width() / 2)
        top = (resolucion_alto / 2) - (self.frameSize().height() / 2)
        self.move(left, top)
        #Desactivar la ventana
        #self.setEnabled(False)
        #Asignar un tipo de fuente
        qfont = QFont("Arial", 12, QFont.Bold)
        self.setFont(qfont)
        #Asignar un tipo de cursor
        self.setCursor(Qt.SizeAllCursor)
        #Asignar estilos CSS
        #self.setStyleSheet("background-color: #000; color: #fff;")
        #Modificar estilos de uno de los elementos de la ventana
        #self.boton.setStyleSheet("background-color: #000; color: #fff; font-size: 14px;")
  
  
#Instancia para iniciar una aplicación
app = QApplication(sys.argv)
#Crear un objeto de la clase
_ventana = Ventana()
#Mostra la ventana
_ventana.show()
#Ejecutar la aplicación
app.exec_()
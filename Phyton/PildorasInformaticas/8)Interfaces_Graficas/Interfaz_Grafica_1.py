#Video 42 y 43
from tkinter import *

#Creando RAIZ
raiz=Tk()
raiz.title("Mi Primera Ventana") #Titulo de ventana
raiz.resizable(True,True)#Ancho alto con 0 es false y 1 es true son variables boolean esto sirve para poder modificar tamaño o no con el raton como una ventana normal
#raiz.icobitmap("Ingrese nombre aqui") #Para poner icono
#raiz.geometry("650x350")#la raiz se adapta al color del frame
raiz.config(bg="blue")#Color de fondo 

#Construyendo FRAME
miFrame=Frame()
#miFrame.pack(fill='both',expand='True') #Expande con el tamaño de raiz
miFrame.pack() #Lo pongo sobre la raiz
miFrame.config(bg='red')
miFrame.config(width="650", height="350")
miFrame.config(bd='25') #ancho de borde
miFrame.config(relief='groove') #Tipo de borde
miFrame.config(cursor='pirate') #Tipo de cursor pero solo dentro de miFrame aplica a raiz si mas arriva pongo la misma instruccion y cambia miFrame por raiz
raiz.mainloop()#Para que pueda estar en funcionamiento debe estar en un bucle infinito

#cambiar extensio ndel archivo a .pyw para que abra solo la interfaz sin la consola
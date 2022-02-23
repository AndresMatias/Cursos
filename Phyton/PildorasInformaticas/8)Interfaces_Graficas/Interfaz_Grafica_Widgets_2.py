#Video 45 y 46
from tkinter import *

raiz=Tk()
miFrame=Frame(raiz,width=1100,height=600)
miFrame.pack()

minombre=StringVar() #Cadena de Caracteres

cuadroTexto=Entry(miFrame,textvariable=minombre)#Asocio minombre a cuadro de texto
cuadroTexto.grid(row=0,column=1,padx=20,pady=20)
cuadroTexto.config(fg="Red",justify="center") #Cambia color cuando escribo escribe a partr del centro de la casilla

cuadroPass=Entry(miFrame)
cuadroPass.grid(row=1,column=1,padx=20,pady=20)
cuadroPass.config(show="*") #Para constraseñas

cuadroApellido=Entry(miFrame)
cuadroApellido.grid(row=2,column=1,padx=20,pady=20)

cuadroDireccion=Entry(miFrame)
cuadroDireccion.grid(row=3,column=1,padx=20,pady=20)

################Cuadro de texto con barra de Scroll##############################
ComentariosTexto=Text(miFrame,width=16,height=5)
ComentariosTexto.grid(row=4,column=1,padx=20,pady=20)

ScrollVert=Scrollbar(miFrame,command=ComentariosTexto.yview)
ScrollVert.grid(row=4,column=2,sticky="nsew") #sticky="nsew": Se adapta al tamaño del cuadro de texto
ComentariosTexto.config(yscrollcommand=ScrollVert.set) #Para que se pueda mover la barra de scroll a donde yo quiera y no vuelva al inicio
#################################################################################
nombreLabel=Label(miFrame,text="Nombre: ")
nombreLabel.grid(row=0,column=0,sticky="e",padx=20,pady=20) #,sticky="e" para alinear los texto a mi derecha se trabaja con puntos cardinales , padx:para poner mas pixeles a los costados

passLabel=Label(miFrame,text="Contraseña: ")
passLabel.grid(row=1,column=0,sticky="e",padx=20,pady=20)

ApellidoLabel=Label(miFrame,text="Apellido: ")
ApellidoLabel.grid(row=2,column=0,sticky="e",padx=20,pady=20)

DireccionLabel=Label(miFrame,text="Direccion Casa: ")
DireccionLabel.grid(row=3,column=0,sticky="e",padx=20,pady=20)

Comentarios=Label(miFrame,text="Comentarios: ")
Comentarios.grid(row=4,column=0,sticky="e",padx=20,pady=20) 

###############################Boton############################
def codigoBoton():
	minombre.set("Andres") #Cuando pulso boton este llama a esta funcion y escribe "Andres" en cuadro texto

botonEnvio=Button(raiz,text="Enviar",command=codigoBoton)#command=codigoBoton: llama a la funcion codigo boton
botonEnvio.pack()   
################################################################ 
raiz.mainloop()
from tkinter import *
from tkinter import messagebox

def InfoAdicional():
	messagebox.showinfo("Ventana Emergente","Esta es una ventana emergente")
def Licencia():
	messagebox.showwarning("Licencia","Producto bajo licencia")	
def SalirAplicacion():
	#valor=messagebox.askquestion("Salir","¿Desea Salir?") #Boton si o no
	valor=messagebox.askokcancel("Salir","¿Desea Salir?")  #Boton aceptar o cancelar
	# if valor=="yes":
	# 	root.destroy()
	if valor==True:
		root.destroy()	
def CerrarDocumento():
	valor=messagebox.askretrycancel("Reintentar","No es posible cerrar")	
	if valor==False:
		root.destroy()	
root=Tk()
barraMenu=Menu(root)#Creo mi menu
root.config(menu=barraMenu)#Construye menu
#----------------------------Pestañas del Menu -----------------------
		#----Creo Pestañas y sub menus----#
principalMenu=Menu(barraMenu,tearoff=0) #tearoff sirve para quitar barra de lineas
principalMenu.add_command(label="Nuevo")
principalMenu.add_command(label="Guardar")
principalMenu.add_command(label="Guardar Como")
principalMenu.add_separator()
principalMenu.add_command(label="Cerrar",command=CerrarDocumento)
principalMenu.add_command(label="Salir",command=SalirAplicacion)

edicionMenu=Menu(barraMenu,tearoff=0)
edicionMenu.add_command(label="Copiar")
edicionMenu.add_command(label="Cortar")
edicionMenu.add_command(label="Pegar")

herramientasMenu=Menu(barraMenu,tearoff=0)

ayudaMenu=Menu(barraMenu,tearoff=0)
ayudaMenu.add_command(label="Licencia",command=Licencia)
ayudaMenu.add_command(label="Acerca de",command=InfoAdicional)

		#----Añado al menu----#
barraMenu.add_cascade(label="Archivo",menu=principalMenu)
barraMenu.add_cascade(label="Edicion",menu=edicionMenu)
barraMenu.add_cascade(label="Herramientas",menu=herramientasMenu)
barraMenu.add_cascade(label="Ayuda",menu=ayudaMenu)
#---------------------------------------------------------------------
root.mainloop()
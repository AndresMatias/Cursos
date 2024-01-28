from tkinter import *

root=Tk()

varOpcion=IntVar() #Para seleccionar el boton

def imprimir():
	if varOpcion.get()==1:
		etiqueta.config(text="Elejiste masculino")
	elif varOpcion.get()==2:
		etiqueta.config(text="Elejiste femenino")
	else:
		etiqueta.config(text="Has elejido otros")	

Label(root,text="Genero:").pack()
Radiobutton(root,text="Masculino",variable=varOpcion,value=1,command=imprimir).pack()
Radiobutton(root,text="Femenino",variable=varOpcion,value=2,command=imprimir).pack()
Radiobutton(root,text="Otros",variable=varOpcion,value=3,command=imprimir).pack()

etiqueta=Label(root)
etiqueta.pack()

root.mainloop()
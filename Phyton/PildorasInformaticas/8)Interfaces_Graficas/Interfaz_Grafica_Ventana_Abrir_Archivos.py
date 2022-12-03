from tkinter import *
from tkinter import filedialog

root=Tk()
def abrirFichero():
	fichero=filedialog.askopenfilename(title="Abrir",initialdir="C:",filetypes=(("Ficheros de Exel","*.xlsx"),
																				("Ficheros de texto","*.txt"),
																				("Todos los archivos","*.*")))
	print(fichero)

Button(root,text="Abrir Fichero",command=abrirFichero).pack()

root.mainloop()
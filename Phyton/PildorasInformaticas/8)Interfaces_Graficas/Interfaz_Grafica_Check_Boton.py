from tkinter import *

root=Tk()
root.title("Ejemplo")
frame=Frame(root)
frame.pack()
playa=IntVar()
montagna=IntVar()
turismo=IntVar()

def OpcionesViajes():
	opcionEscogida=""
	if(playa.get()==1):
		opcionEscogida+=" playa "
	if(montagna.get()==1):
		opcionEscogida+=" montaña "
	if(turismo.get()==1):
		opcionEscogida+=" Turismo Rural "		
	TextoFinal.config(text=opcionEscogida)
Label(frame,text="Elegi Destinos", width=50).pack()	

Checkbutton(frame,text="Playa",variable=playa,onvalue=1,offvalue=0,command=OpcionesViajes).pack()
Checkbutton(frame,text="Montaña",variable=montagna,onvalue=1,offvalue=0,command=OpcionesViajes).pack()
Checkbutton(frame,text="Turismo Rural",variable=turismo,onvalue=1,offvalue=0,command=OpcionesViajes).pack()
TextoFinal=Label(frame)
TextoFinal.pack()
root.mainloop()
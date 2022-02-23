#Video 44
from tkinter import *

raiz=Tk()
miFrame=Frame(raiz,width='650',height='350')
miFrame.pack()

#Para poner imagenes
#miImagen=PhotoImage(file="Insertar nombre.gif") para poner imagen
# miLabel=Label(miFrame,image=miImagen)
# miLabel.place(x=100,y=200)

#Para poner label
miLabel=Label(miFrame,text='Mi primer texto',fg='red',font=("Comic Sans MS",18))
miLabel.place(x=100,y=200) #Empaqueto, lo pongo en el frame
#Label(miFrame,text='Mi primer texto').place(x=100,y=200) #Abreviado
raiz.mainloop()
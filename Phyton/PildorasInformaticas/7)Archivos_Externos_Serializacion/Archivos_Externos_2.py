#Video 38
from io import open
archivo_texto=open("Archivo 1.txt","r") #
#archivo_texto=open("Archivo 1.txt","r+") #el r+ se posiciona el principio del archivo y lo abre en modo lectura y escritura cuidado porq reemplaza lo que hay
print(archivo_texto.read()) 
archivo_texto.seek(0) #me posiciono al principio
print(archivo_texto.read())

archivo_texto.seek(0) #me posiciono al principio
archivo_texto.seek(len(archivo_texto.read())/2) #me posiciono a la mitad
print(archivo_texto.read())

archivo_texto.seek(0) #me posiciono al principio
archivo_texto.seek(len(archivo_texto.readline())) #me posiciono al final de la 1ra linea
print(archivo_texto.read())

archivo_texto.close() #cierro
#archivo_texto.writelines() #escribe por lineas ver minuto 13
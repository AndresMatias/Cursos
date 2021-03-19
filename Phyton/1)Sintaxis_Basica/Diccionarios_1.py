midiccionario={"Alemania":"Berlin","Francia":"Paris","España":"Madrid",23:"Jordan","Australia":25}#Entre llaves para diccionarios midiccionario={Clave : Valor}
print(midiccionario["Alemania"])
print(midiccionario)

midiccionario["Italia"]="Lisboa" #Error de capital a proposito, agrego elemento
print(midiccionario)
midiccionario["Italia"]="Roma" #Corrijo error se sobreescribe
print(midiccionario)

del midiccionario["Francia"] #Elimino un elemento
print(midiccionario)

mitupla=["España","Francia","Alemania","Italia"]
midiccionario_2={mitupla[0]:"Madrid",mitupla[1]:"Paris",mitupla[2]:"Berlin",mitupla[3]:"Roma"} #Asigno valores con tupla
print(midiccionario_2)

midiccionario_3={"Alemania":"Berlin","Francia":"Paris","España":[23,25,26,25,28,24,10,15]} #Guardo una tupla
print(midiccionario_3["España"])

midiccionario_4={"Alemania":"Berlin","Francia":"Paris","España":{"Temporadas":[23,25,26,25,28,24,10,15]}} #Guardo un diccionario dentro de otro
print(midiccionario_4["España"])
print(midiccionario_4.keys()) #Devuleve las claves
print(midiccionario_4.values()) #Devuleve los valores de las claves
print(len(midiccionario_4)) #Devuleve el tamaño del diccionario
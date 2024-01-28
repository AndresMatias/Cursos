mi_lista=["hola","chau","que tal",5,"maria","juan"] #lista de varios tipos de datos
mi_lista_2=[5,3,6,8,7] #lista de varios tipos de datos
print(mi_lista[1]) #imprimo un elemento especifico de la lista
print(mi_lista[-2]) #imprimo un elemento especifico de la lista,empieza a contar desde el final con indice negativo
print(mi_lista[:]) #imprimo la lista completa
print(mi_lista[0:3]) #imprimo uno porcion de la lista de la posicion 0 a la 2 sin incluir la 3
print(mi_lista[:3]) #imprimo uno porcion de la lista de la posicion 0 a la 2 sin incluir la 3 y al no poner 0 python entiende que por defecto es la posicion 0
print(mi_lista[3:]) #imprimo uno porcion de la lista de la posicion 3 hasta el final

mi_lista.append("Sandra") #agrego un elemento al final de la lista
print(mi_lista[:])
mi_lista.insert(2,"bebe") #agrego un elemento en la posicion 2
print(mi_lista[:])

mi_lista.extend(["nana","lider","batman","hola"]) #agrego una lista a mi lista ya creada
print(mi_lista[:])
print(mi_lista.index("lider")) #Veo el indice de lider
print(mi_lista.index("hola")) #Veo el indice de hola como esta repetido devuelve el que mas cerca este de 0
print("pepe" in mi_lista) #imprime true si se encutra en mi lista

mi_lista.remove("que tal") #Elimino el elemneto "que tal"
mi_lista.pop() #Elimino el elemento en ultima posicion
print(mi_lista[:])

mi_lista_3=mi_lista+mi_lista_2 #sumo la listas y creo nuevas listas
print(mi_lista_3[:])


mi_lista_3=mi_lista_3*3 #repite los elementos tres veces
print(mi_lista_3[:])

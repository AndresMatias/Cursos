#simular a las listas, son inmutables despues de su creacion pero permiten extraer porciones, no permiten realizar busquedas
#Ventajas:mas rapidas,menos espacios,formatean string,pueden utilizarce como claves en un diccionario
#las duplas van entre parentesis opcionales, las listas entre corchetes
mituplas=("juan",5,9,8)
milista=list(mituplas) #Convierto tupla a lista
print(mituplas[2])
print(milista)
print(mituplas)

milista_2=["jorge",5,6,8]
mituplas_2=tuple(milista_2) #Convierto lista a tupla
print(milista_2)
print(mituplas_2)
print("jorge" in milista_2)
print(mituplas_2.count(8)) #me dice cuantas veces esta el 8 en la tupla
print(len(mituplas_2)) #Cuantos elementos hay

nombre,num1,num2,num3=mituplas_2 #para desempaquetar en varias variables
print(nombre)
print(num1)
print(num2)
print(num3)
# Programa que crea lista y opera con ella

# Crea la lista
lista = [[2,2,5,6],[0,3,7,4],[8,8,5,2],[1,5,6,1]]

# Selecciona el subarray [8 8 5 2]

print('Subarray', lista[2])

# Poner la diagonal de la matriz en cero

for i in range(0,4):
    for j in range(0,4):
        if i == j:
            lista[i][j] = 0

print('La nueva lista con diagonal cero es', lista)

# Sumar todos los elementos del array

suma = 0

for i in range(0,4):
    for j in range(0,4):
        suma = suma + lista[i][j]

print('La suma de todos los elementos es', suma)

# Setear los valores pares en 0 y los impares en 1

for i in range(0,4):
    for j in range(0,4):
        if (lista[i][j] % 2) == 0:
            lista[i][j] = 0
        else:
            lista[i][j] = 1

print(' La nueva lista luego de par/impar es', lista)


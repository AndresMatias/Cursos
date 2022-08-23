# UTN-FRC. Ing. Electrónica.
# Práctico 1: Función en Python
# Visión por computadora
# Francisco Gabriel Rainero. Legajo 71967.

def adivinar(intentos=5):                       #Intentos por defecto vale 5

    import random

    numero = random.randint(0,100)              #Número random entre 0 y 100
    ciclos = 0

    print('\n\nBienvenido!\nDebe adivinar un número entre 0 y 100\nPosee',intentos,'intentos.')
    
    while True:

        x = int(input('\n\nIngrese un número: '))
        
        if x == numero:
            print('\nFelicitaciones, adivinaste. Utilizaste',ciclos + 1,'intentos.\n\n')
            break

        elif x > numero:
            print('\nNúmero incorrecto. Pista: el número es menor al ingresado.')

        else:
            print('\nNúmero incorrecto. Pista: el número es mayor al ingresado.')
        
        ciclos = ciclos + 1

        if ciclos == intentos:
            print('\nTe quedaste sin intentos. GAME OVER.\n\n')
            break

        else:
            print('\nTe queda/n',intentos-ciclos,'intento/s.')

N = int(input("¿Cuántos intentos quiere?: "))
adivinar(N)


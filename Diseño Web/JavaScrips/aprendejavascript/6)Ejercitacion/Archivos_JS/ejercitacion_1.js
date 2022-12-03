/*----Ejercicios Video 35----
1) Programa una función que cuente el número de caracteres de una cadena de texto, 
    pe. miFuncion("Hola Mundo") devolverá 10.

2) Programa una función que te devuelva el texto recortado según el número de caracteres indicados, 
    pe. miFuncion("Hola Mundo", 4) devolverá "Hola".

3) Programa una función que dada una String te devuelva un Array de textos separados por cierto caracter, 
    pe. miFuncion('hola que tal', ' ') devolverá ['hola', 'que', 'tal'].

4) Programa una función que repita un texto X veces, pe. miFuncion('Hola Mundo', 3) 
    devolverá Hola Mundo Hola Mundo Hola Mundo. 
*/

//--Ejercicio 1--
export function nroCaracteres(cadena){
    let valor=null;
    if (typeof cadena=='string'){ //Compruebo que es un string
        valor=cadena.length;
    }
    else{
        valor='Esto no es una cadena de texto';
    }
    return valor;
}

//--Ejercicio 2--
export function cadenaRecortada(cadena,num){
    let valor=null;
    if (typeof cadena=='string'){ //Compruebo que es un string
        valor=cadena.slice(0,num)
    }
    else{
        valor='Esto no es una cadena de texto';
    }
    return valor;
}

//--Ejercicio 3--
export function cadenaSeparada(cadena){
    let valor=null;
    if (typeof cadena=='string'){ //Compruebo que es un string
        valor=cadena.split(' '); //Separo por un Espacio
    }
    else{
        valor='Esto no es una cadena de texto';
    }
    return valor;
}

//--Ejercicio 4--
export function cadenaRepetida(cadena){
    let valor=null;
    if (typeof cadena=='string'){ //Compruebo que es un string
        valor=cadena.repeat(3); //Repito Cadena 3 veces
    }
    else{
        valor='Esto no es una cadena de texto';
    }
    return valor;
}
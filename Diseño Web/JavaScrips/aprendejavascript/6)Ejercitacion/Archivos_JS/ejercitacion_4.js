/*----Ejercitacion Video 38----
12) Programa una función que determine si un número es primo (aquel que solo 
    es divisible por sí mismo y 1) o no, pe. miFuncion(7) devolverá true.

13) Programa una función que determine si un número es par o impar, 
    pe. miFuncion(29) devolverá Impar.

14) Programa una función para convertir grados Celsius a Fahrenheit y viceversa, 
    pe. miFuncion(0,"C") devolverá 32°F.
*/

//--Ejercicio 12--
export const nroPrimo=(nro=null)=>{
    let valor=1;
    if(typeof nro!='number'){
        valor='No se ingreso nada o no se ingreso un numero' // Si no se ingreso cadena
    }else if(typeof nro=='number'){
        if (nro == 0 || nro == 1 || nro == 4){ //Casos Especiales
            valor='Caso especial'
        }else{
            for (let x = 2; x < nro / 2; x++) {
                if (nro % x == 0){
                    valor='No es primo';
                }else{
                    valor='Es primo';
                    break; //Para salir del for asi no trabaja demas el programa
                }
            }
        }
    }
    else{
        valor='Sucedio un error desconocido'
    }
    return valor;
};

//--Ejercicio 13--
export const nroParImpar=(nro=null)=>{
    let valor=1;
    if(typeof nro!='number'){
        valor='No se ingreso nada o no se ingreso un numero' // Si no se ingreso cadena
    }else if(typeof nro=='number'){
        if (nro%2==0) {
            valor="El numero introducido es par";
        }else{
            valor="El numero introducido es impar";
        }
    }
    else{
        valor='Sucedio un error desconocido'
    }
    return valor;
};

//--Ejercicio 14--
export const conversionBilateralCelciusFahrenheit=(temp=null,unidad='')=>{
    let valor=1;
    if(typeof temp!='number'){
        valor='No se ingreso nada o no se ingreso un numero' // Si no se ingreso cadena
    }else if(typeof temp=='number' && typeof unidad=='string'){
        if(unidad=='C' || unidad=='c'){ //Determino que se ingreso en celcius
            valor=(temp*1.8)+32; //Se convierte de celcius a fahrenheit
        }else if(unidad=='F' || unidad=='f'){ //Determino que se ingreso en fahrenheit
            valor=(temp-32)/1.8; //Se convierte de fahrenheit a celcius
        }else{
            valor='Introdusca si es Celcius o Fahrenheit'
        }
    }
    else{
        valor='Sucedio un error desconocido'
    }
    return valor;
};
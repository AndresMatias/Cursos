/*----Ejercitacion Video 40----
Adicional: https://www.youtube.com/watch?v=cB6QFCd6RQI&ab_channel=JohnOrtizOrdo%C3%B1ez

18) Programa una función que dada una cadena de texto cuente el número de vocales y consonantes, 
    pe. miFuncion("Hola Mundo") devuelva Vocales: 4, Consonantes: 5.

19) Programa una función que valide que un texto sea un nombre válido, 
    pe. miFuncion("Jonathan MirCha") devolverá verdadero.

20) Programa una función que valide que un texto sea un email válido, 
    pe. miFuncion("jonmircha@gmail.com") devolverá verdadero.
*/

//--Ejercicio 18--
export const cuentaVocalConsonante=(cadena="")=>{
    let valor=null,consonantes=0,vocales=0;
    const filtroConsonantes=/[BCDFGHJKLMNÑPQRSTVXZWY]/i,filtroVocales=/[aeiouáéíóúAEIOUÁÉÍÓÚ]/;
    if(!cadena){
        valor='No ingresaste una cadena de texto' // Si no se ingreso cadena
    }else if(typeof cadena=='string'){
        console.log(cadena);
        for(let letra of cadena){
            if(filtroVocales.test(letra)){
                vocales++;
            }else if(filtroConsonantes.test(letra)){
                consonantes++;
            }
        }
        valor=`El numero de consonantes es: ${consonantes}\nEl numero de vocales es: ${vocales}`;
    }else{
        valor='Esto no es una cadena de texto'; //Si no es un string
    }
    return valor;
};

//--Ejercicio 19--
export const validarNombre=(cadena="")=>{
    let valor=null;
    const expReg=/^[A-Za-zÑñÁáÉéÍíÓóÚú\s]+$/ //^:no puede haber nada antes, $no puede haber nada depsues, \s acepta espacios en blanco 
    if(!cadena){
        valor='No ingresaste una cadena de texto' // Si no se ingreso cadena
    }else if(typeof cadena=='string'){
        if(expReg.test(cadena)){ //si es verdadero
            valor='Nombre Valido';
        }else{
            valor='Nombre No valido';
        }

    }else{
        valor='Esto no es una cadena de texto'; //Si no es un string
    }
    return valor;
};

//--Ejercicio 20--
export const validarEmail=(cadena="")=>{
    let valor=null;
    const expReg=/[a-z0-9]+(\.[_a-z0-9]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,15})/i //Exp regular para mail
    if(!cadena){
        valor='No ingresaste una cadena de texto' // Si no se ingreso cadena
    }else if(typeof cadena=='string'){
        if(expReg.test(cadena)){ //si es verdadero
            valor='Mail Valido';
        }else{
            valor='Mail No valido';
        }
    }else{
        valor='Esto no es una cadena de texto'; //Si no es un string
    }
    return valor;
};
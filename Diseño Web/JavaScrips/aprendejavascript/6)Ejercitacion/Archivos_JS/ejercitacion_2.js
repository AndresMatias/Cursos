/*----Ejercitacion Video 36----
5) Programa una función que invierta las palabras de una cadena de texto, 
    pe. miFuncion("Hola Mundo") devolverá "odnuM aloH".

6) Programa una función para contar el número de veces que se repite una palabra en un texto largo, 
    pe. miFuncion("hola mundo adios mundo", "mundo") devolverá 2.

7) Programa una función que valide si una palabra o frase dada, es un palíndromo 
    (que se lee igual en un sentido que en otro), pe. mifuncion("Salas") devolverá true.

8) Programa una función que elimine cierto patrón de caracteres de un texto dado, 
    pe. miFuncion("xyz1, xyz2, xyz3, xyz4 y xyz5", "xyz") devolverá  "1, 2, 3, 4 y 5.
*/

//--Ejercicio 5--
 export const invertirCadena=(cadena="")=>{
    if(!cadena){
        console.warn('No ingresaste una cadena de texto'); // Si no se ingreso cadena
    }else{  
        console.info(cadena.split("").reverse().join("")); //Else en caso de que si se haya ingresado cadena
    }
};
//--Ejercicio 6--
export const palabraRepetida=(cadena="",texto="")=>{
    let valor=null;
    if(!cadena || !texto){
        valor='No ingresaste una cadena de texto' // Si no se ingreso cadena
    }else if(typeof cadena=='string' && typeof texto=='string'){
        let i=0,contador=0;
        while(i!==-1){
            i=cadena.indexOf(texto,i);
            if(i!=-1){
                console.log(i);
                i++;
                contador++;
            }
            valor=contador;
        }    
    }else{
        valor='Esto no es una cadena de texto'; //Si no es un string
    }
    return valor;
};

//--Ejercicio 7--
export const palabraPalindromo=(cadena="")=>{
    let valor=null;
    if(!cadena){
        valor='No ingresaste una cadena de texto' // Si no se ingreso cadena
    }else if(typeof cadena=='string'){
       let palabra=cadena.toLowerCase(); //Convierto todo a minuscula
       let alReves=palabra.split("").reverse().join(""); //Separo en arrays por palabras, luego invierto cada palabra y vuelvo a unir todo en un mismo string
       if(palabra===alReves){
           valor='Si es palindromo';
       }else{
           valor='No es palindromo'
       }
    }else{
        valor='Esto no es una cadena de texto'; //Si no es un string
    }
    return valor;
};


//--Ejercicio 8--
export const eliminarPatron=(cadena="",patron='')=>{
    let valor=null;
    if(!cadena || !patron){
        valor='No ingresaste una cadena de texto' // Si no se ingreso cadena
    }else if(typeof cadena=='string' && typeof patron=='string'){
        valor=cadena.replace(new RegExp(patron,"ig"),"")
    }else{
        valor='Esto no es una cadena de texto'; //Si no es un string
    }
    return valor;
};
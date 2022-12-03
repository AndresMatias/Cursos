/*----Ejercitacion Video 37----
9) Programa una función que obtenga un numero aleatorio entre 501 y 600.

10) Programa una función que reciba un número y evalúe si es capicúa o no 
    (que se lee igual en un sentido que en otro), pe. miFuncion(2002) devolverá true.

11) Programa una función que calcule el factorial de un número 
    (El factorial de un entero positivo n, se define como el producto de todos los números enteros positivos desde 1 hasta n), pe. miFuncion(5) devolverá 120.
*/

//--Ejercicio 9--
export const nroAletorio=()=>{
    let valor=null;
    valor=501+(Math.random()*99);
    return valor;
};

//--Ejercicio 10--
export const nroCapicua=(nro=null)=>{
    let valor=null;
    if(typeof nro!='number'){
        valor='No se ingreso nada o no se ingreso un numero' // Si no se ingreso cadena
    }else if(typeof nro=='number'){
        let nroStringReverso=nro.toString().split("").reverse().join("");
        if(nro==nroStringReverso){ //Recordar que puedo comparar string con int 
            valor="Es capicua";
        }else{
            valor="No es capicua"
        }
    }else{
        valor='Sucedio un error desconocido'
    }
    return valor;
};

//--Ejercicio 11--
export const nroFactorial=(nro=null)=>{
    let valor=1;
    if(typeof nro!='number'){
        valor='No se ingreso nada o no se ingreso un numero' // Si no se ingreso cadena
    }else if(typeof nro=='number'){
        for(let i=1;i<=nro;i++){
            valor=valor*i;
        }
        valor='El factorial de '+String(nro)+' es '+String(valor);
    }
    else{
        valor='Sucedio un error desconocido'
    }
    return valor;
};
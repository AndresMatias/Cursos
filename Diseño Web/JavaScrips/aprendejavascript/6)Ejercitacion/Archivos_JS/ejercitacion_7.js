/*----Ejercitacion Video 41----
21) Programa una función que dado un array numérico devuelve otro array 
    con los números elevados al cuadrado, pe. mi_funcion([1, 4, 5]) devolverá [1, 16, 25].

22) Programa una función que dado un array devuelva el número mas alto y 
    el más bajo de dicho array, pe. miFuncion([1, 4, 5, 99, -60]) devolverá [99, -60].

23) Programa una función que dado un array de números devuelva un objeto 
    con 2 arreglos en el primero almacena los números pares y en el segundo los impares, pe. miFuncion([1,2,3,4,5,6,7,8,9,0]) devolverá {pares: [2,4,6,8,0], impares: [1,3,5,7,9]}.
*/

//--Ejercicio 21--
export const arregloElevadoCuadrado=(nro=undefined)=>{
    let valor=undefined;
    if(!(nro instanceof Array)){ //Uso instanceof pq con typeof lo determina como objeto solamente y se puede confundir con otros tipos
        return('No se ingreso un arreglo'); // Si no se ingreso cadena
    }else if(nro.length===0){
        return('Arreglo Vacio');
    }else if(nro.length!=0){
        for(let num of nro){
            if(typeof num!='number') return('No se ingreso un nro');
        }
        valor=nro.map(el => el*el);
    }else{
        return('Sucedio un error desconocido');
    }
    return valor;
};

//--Ejercicio 22--
export const nroMasAltoBajo=(nro=undefined)=>{
    let valor=undefined;
    if(!(nro instanceof Array)){ //Uso instanceof pq con typeof lo determina como objeto solamente y se puede confundir con otros tipos
        return('No se ingreso un arreglo'); // Si no se ingreso cadena
    }else if(nro.length===0){
        return('Arreglo Vacio');
    }else if(nro.length!=0){
        for(let num of nro){
            if(typeof num!='number') return('No se ingreso un nro');
        }
        valor={Alto:Math.max(...nro),Bajo:Math.min(...nro)}; //Ver que significa los ...nro(spread operator) clase 20
    }else{
        return('Sucedio un error desconocido');
    }
    return valor;
};

//--Ejercicio 23--
export const nrosParesImparesSeparados=(nro=undefined)=>{
    let objeto=undefined;
    if(!(nro instanceof Array)){ //Uso instanceof pq con typeof lo determina como objeto solamente y se puede confundir con otros tipos
        return('No se ingreso un arreglo'); // Si no se ingreso cadena
    }else if(nro.length===0){
        return('Arreglo Vacio');
    }else if(nro.length!=0){
        for(let num of nro){
            if(typeof num!='number') return('No se ingreso un nro');
        }
        //Separo en par e impar
        objeto={pares:nro.filter(num => num%2===0),impares:nro.filter(num => num%2===1)};
    }else{
        return('Sucedio un error desconocido');
    }
    return(objeto);
};
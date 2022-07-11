/*----Ejercitacion Video 42----
24) Programa una función que dado un arreglo de números devuelva un objeto con dos arreglos, 
    el primero tendrá los numeros ordenados en forma ascendente y el segundo de forma descendiente, 
    pe. miFuncion([7, 5,7,8,6]) devolverá { asc: [5,6,7,7,8], desc: [8,7,7,6,5] }.

25) Programa una función que dado un arreglo de elementos, elimine los duplicados, 
    pe. miFuncion(["x", 10, "x", 2, "10", 10, true, true]) devolverá ["x", 10, 2, "10", true].

26) Programa una función que dado un arreglo de números obtenga el promedio, 
    pe. promedio([9,8,7,6,5,4,3,2,1,0]) devolverá 4.5.
*/

//--Ejercicio 24--
export const arregloOrdenadoAscDesc=(nro=undefined)=>{
    let valor=undefined;
    if(!(nro instanceof Array)){ //Uso instanceof pq con typeof lo determina como objeto solamente y se puede confundir con otros tipos
        return('No se ingreso un arreglo'); // Si no se ingreso cadena
    }else if(nro.length===0){
        return('Arreglo Vacio');
    }else if(nro.length!=0){
        for(let num of nro){ //Determino que todos los elementos del arreglo son tipo number
            if(typeof num!='number') return('No se ingreso un nro');
        }
        //Creo Objeto con los valroes ascendentes y descendentes
        valor={Ascendente:nro.map(el => el).sort(),Descendente:nro.map(el => el).sort().reverse()};
    }else{
        return('Sucedio un error desconocido');
    }
    return valor;
};

//--Ejercicio 25--
export const arregloEliminaDuplicados=(nro=undefined)=>{
    let valor=undefined;
    if(!(nro instanceof Array)){ //Uso instanceof pq con typeof lo determina como objeto solamente y se puede confundir con otros tipos
        return('No se ingreso un arreglo'); // Si no se ingreso cadena
    }else if(nro.length===0){
        return('Arreglo Vacio');
    }else if(nro.length!=0){
        for(let num of nro){ //Determino que todos los elementos del arreglo son tipo number
            if(typeof num!='number') return('No se ingreso un nro');
        }
        //Creo Objeto con los valroes ascendentes y descendentes
        valor={Original:nro,Sin_Duplicados:nro.filter((value,index,self) => self.indexOf(value)===index)};
    }else{
        return('Sucedio un error desconocido');
    }
    return valor;
};

//--Ejercicio 26--
export const arregloPromedio=(nro=undefined)=>{
    let valor=undefined;
    if(!(nro instanceof Array)){ //Uso instanceof pq con typeof lo determina como objeto solamente y se puede confundir con otros tipos
        return('No se ingreso un arreglo'); // Si no se ingreso cadena
    }else if(nro.length===0){
        return('Arreglo Vacio');
    }else if(nro.length!=0){
        for(let num of nro){ //Determino que todos los elementos del arreglo son tipo number
            if(typeof num!='number') return('No se ingreso un nro');
        }
        //Creo Objeto con los valroes ascendentes y descendentes
        valor={Original:nro,Promedio:nro.reduce((total,num,index,arr) => {total+=num;
                                                                        if(index===nro.length-1){
                                                                            return `Promedio:${total/nro.length}`;
                                                                        }else{
                                                                            return total;
                                                                        }})};
    }else{
        return('Sucedio un error desconocido');
    }
    return valor;
};
/*----Ejercitacion Video 39----
15) Programa una función para convertir números de base binaria a decimal y viceversa, 
    pe. miFuncion(100,2) devolverá 4 base 10.
16) Programa una función que devuelva el monto final después de aplicar un descuento a una cantidad dada, 
    pe. miFuncion(1000, 20) devolverá 800.
17) Programa una función que dada una fecha válida determine cuantos años han pasado hasta el día de hoy, 
    pe. miFuncion(new Date(1984,4,23)) devolverá 35 años (en 2020).
*/

//--Ejercicio 15--
export const conversionBilateralBinarioDecimal=(nro=undefined,base=undefined)=>{
    let valor=null;
    if(typeof nro!='number' || typeof base!='number'){ //Si ambos son number entonces ignora este if
        valor='No se ingreso nada o no se ingreso un numero en la numero y/o base' // Si no se ingreso cadena
    }else if(base===2){ //el if de arriva ya da por hecho que nro y base son del tipo number 
        valor=`${nro} base ${base}=${parseInt(nro,10)} base 10`;
    }else if(base===10){
        valor=`${nro} base ${base}=${nro.toString(2)} base 2`;
    }else if(typeof base=='number'){
        valor='La base ingresada no es decimal ni binario '
    }
    else{
        valor='Sucedio un error desconocido'
    }
    return valor;
};

//--Ejercicio 16--
export const descuento=(monto=undefined,descuento=undefined)=>{
    let valor=null;
    if(typeof monto!='number' || typeof descuento!='number'){
        valor='No se ingreso nada o no se ingreso un numero de precio y/o descuento' // Si no se ingreso cadena
    }else if(monto>=0 && descuento>=0){
        valor=`${monto}-${descuento}% = ${monto-((monto*descuento)/100)}`;
    }
    else{
        valor='No puede ingresar un monto y/o descuento negativo'
    }
    return valor;
};

//--Ejercicio 17--
export const determinarYear=(fecha)=>{
    let valor=null,conversionMsYear=1000*60*60*24*365,fechaActual=new Date(); //conversionMsYear: cte para convertir misiseg a años
    if(!fecha instanceof Date){
        valor='No se ingreso nada o no se ingreso la fecha' // Si no se ingreso cadena
    }else if(fecha<=fechaActual){
        valor=Math.floor((fechaActual-fecha.getTime())/conversionMsYear);
    }else if(fecha>fechaActual){
        valor='Fecha ingresada supera a la fecha actual'
    }
    else{
        valor='Sucedio un error desconocido'
    }
    return valor;
};
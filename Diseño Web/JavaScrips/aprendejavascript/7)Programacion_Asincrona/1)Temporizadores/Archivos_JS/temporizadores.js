export const temporizador=(ms=undefined)=>{
    /*
    //setTimeout: Ejecuta una funcion luego de un tiempo determinado en milisegundos
    setTimeout(()=>{
        console.log('Ejecutando un setTimeout')
    },ms);
    //setInterval: Se ejecuta cada cierto tiempo repetitivamente
    setInterval(()=>{
        console.log('Ejecutando un setInterval')
    },ms);
    setInterval(()=>{
        console.log(new Date().toLocaleTimeString());
    },ms);
    */
   //----Funciones Canceladoras----
    let temp=setTimeout(()=>{
        console.log('Ejecutando un setTimeout');
    },ms);
    //clearTimeout: funcion que cancela a un setTimeout que fue guardado en una variable
    clearTimeout(temp);
    //clearInterval: funcion que cancela a un setInterval que fue guardado en una variable
    let temp2=setInterval(()=>{
        console.log('Ejecutando un setInterval');
    },ms);
    clearInterval(temp2);
}
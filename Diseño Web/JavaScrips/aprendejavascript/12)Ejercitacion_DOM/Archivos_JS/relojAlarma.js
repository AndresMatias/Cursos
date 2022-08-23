const d=document;

/**
 * Metodo para iniciar o detener el reloj, dicho metodo esta escrito para evitar la propagacion de eventos y que solo ejecute el evento al boton correspondiente
 * recordar pasar los id con #
 * @param {*} idReloj   string del id del reloj
 * @param {string} idIniciar string del id del boton para iniciar el reloj
 * @param {string} idDetener string del id del boton para detener el reloj
 */
export function reloj(idReloj,idIniciar,idDetener){
    /*Para enteneder lo de detener la progragacion ver clase nro 76 de mricha
        https://www.youtube.com/watch?v=j2fWSgOrxRs&t=411s&ab_channel=jonmircha
    */
    let clockTempo;
    d.addEventListener("click",e=>{
        if(e.target.matches(idIniciar)){ //Detecto si el boton de iniciar se presiono
            clockTempo=setInterval(()=>{
                let clockHour=new Date().toLocaleTimeString();
                d.querySelector(idReloj).innerHTML=`<h3>${clockHour}</h3>`;
            },1000);
            e.target.disabled=true; //desactivo el boton de iniciar
        }
        if(e.target.matches(idDetener)){ //Detecto si el boton de detener se presiono
            clearInterval(clockTempo); //Limpio el setInterval
            d.querySelector(idReloj).innerHTML=null;
            d.querySelector(idIniciar).disabled=false //activo el boton de iniciar, no uso el e.disabled pq e en este caso hace referencia al boton de desactivar
        }
    });
}

/**
 * 
 * @param {*} Tono  ruta al tono de la alarma
 * @param {string} idIniciar id del boton para iniciar la alarma
 * @param {string} idDetener id del boton para detener la alarma
 */
export function alarma(Tono,idIniciar,idDetener){
    let alarmaTempo;
    const $alarm=d.createElement('audio'); 
    $alarm.src=Tono;
    d.addEventListener("click",e=>{
        if(e.target.matches(idIniciar)){ //Detecto si el boton de iniciar se presiono
            alarmaTempo=setTimeout(()=>{
                $alarm.play();
            },2000)
            e.target.disabled=true; //desactivo el boton de iniciar
        }
        if(e.target.matches(idDetener)){ //Detecto si el boton de detener se presiono
            clearTimeout(alarmaTempo); //Limpio el setTimeOut
            $alarm.pause();//pauso alarma
            $alarm.currentTime=0; //vuelvo a cero en el audio
            d.querySelector(idIniciar).disabled=false //activo el boton de iniciar, no uso el e.disabled pq e en este caso hace referencia al boton de desactivar
        }
    });
}
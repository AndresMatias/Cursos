const d=document;
/**
 * Metodo para la logica del la cuenta regresuva
 * @param {*} id id de ka div de para la cuenta regresiva
 * @param {*} limitDate fecha limite 
 * @param {*} finalMessage mensaje cuando se cumple dicha fecha
 */
export function countDown(id,limitDate,finalMessage){
    const $countdown=d.getElementById(id),
          countdowntime=new Date(limitDate).getTime();
    let countdowntiempo=setInterval(()=>{
        let now=new Date().getTime(),
            limittime=countdowntime-now,
            days=Math.floor(limittime/(1000*60*60*24)),
            hours=('0'+Math.floor(limittime%(1000*60*60*24)/(1000*60*60))).slice(-2), //Con % obtengo residuo  que son las horas de los dias
            minutes=('0'+Math.floor(limittime%(1000*60*60*24)/(1000*60))).slice(-2),
            seconds=('0'+Math.floor(limittime%(1000*60*60*24)/(1000))).slice(-2); //Cuanto Falta
        $countdown.innerHTML=`<h3>Faltan ${days} Dias ${hours} Horas ${minutes} Minutos ${seconds} Segundos</h3>`
        if(limittime<0){
            clearInterval(countdowntime);
            $countdown.innerHTML=`<h3>${finalMessage}</h3>`
        }
    },1000);   
}
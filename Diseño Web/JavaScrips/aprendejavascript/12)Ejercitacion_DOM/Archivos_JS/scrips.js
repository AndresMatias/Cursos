import { countDown } from "./cuentaRegresiva.js";
import { botonMenu } from "./eventosMenu.js";
import { moveBall, shortcuts } from "./eventosTeclado.js";
import { alarma, reloj } from "./relojAlarma.js";
const d=document;

d.addEventListener('DOMContentLoaded',(e)=>{ //Uso DOMContentLoaded para una cargar mas a rapida por q empeiza a funcionar cuando ya se cargo solo el HTML, no espera el css etc
    botonMenu(document.querySelector(".panel-btn"),document.querySelector(".panel"),document.querySelector(".menu")); //Evento boton menu para su cambio de forma
    reloj('#reloj','#activar-reloj','#detener-reloj'); //recordar poner el # pero q el mismo no esta en el id
    alarma("tonos/tictac.mp3",'#activar-alarma','#detener-alarma');
    countDown('countdown','May 23,2023 03:23:19','Este es un mensaje')
})

d.addEventListener("keydown",e=>{ //Los eventos de teclado no se asignas en DOMContentLoaded
    shortcuts(e);
    moveBall(e,'.ball','.stage')
});
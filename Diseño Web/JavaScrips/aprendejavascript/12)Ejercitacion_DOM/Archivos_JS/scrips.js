import slider from "./carrusel.js";
import { countDown } from "./cuentaRegresiva.js";
import { userDeviceInfo } from "./deteccionDispositivos.js";
import { networkStatus } from "./deteccionRed.js";
import { deteccionWebCam } from "./deteccionWebCam.js";
import { botonMenu } from "./eventosMenu.js";
import { moveBall, shortcuts } from "./eventosTeclado.js";
import { filtroBusqueda } from "./filtroBusqueda.js";
import { getGeoLocation } from "./geolocalizacion.js";
import { responsiveMedia } from "./objetoResonsive.js";
import { alarma, reloj } from "./relojAlarma.js";
import { responsiveTester } from "./responsiveTester.js";
import { scrollTopBottom } from "./scroll.js";
import scrollSpy from "./scrollSpy.js";
import sorteo from "./sorteo.js";
import temaOscuro from "./temaOscuro.js";
import smartVideo from "./videoInteligente.js";

const d=document;

d.addEventListener('DOMContentLoaded',(e)=>{ //Uso DOMContentLoaded para una cargar mas a rapida por q empeiza a funcionar cuando ya se cargo solo el HTML, no espera el css etc
    botonMenu(document.querySelector(".panel-btn"),document.querySelector(".panel"),document.querySelector(".menu")); //Evento boton menu para su cambio de forma
    reloj('#reloj','#activar-reloj','#detener-reloj'); //recordar poner el # pero q el mismo no esta en el id
    alarma('tonos/tictac.mp3','#activar-alarma','#detener-alarma');
    countDown('countdown','May 23,2023 03:23:19','Este es un mensaje');
    scrollTopBottom('.scroll-top-btn');
    responsiveMedia('youtube','(min-width: 1024px)',
    `<a href="https://www.youtube.com/watch?v=6IwUl-4pAzc&list=PLvq-jIkSeTUZ6QgYYO3MwG9EMqC-KoLXA&index=91&ab_channel=jonmircha">Ver Video</a>`,  //Contenido Mobile
    `<iframe width="560" height="315" src="https://www.youtube.com/embed/6IwUl-4pAzc" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>`); //Contenido Escritorio
    responsiveMedia('gmaps','(min-width: 1024px)','Contenido Mobil','Contienido Escritorio');
    responsiveTester('responsive-tester');
    userDeviceInfo("user-device");
    deteccionWebCam('webcam');
    getGeoLocation('geolocation');
    filtroBusqueda('.card-filter','.card');
    sorteo('#winner-btn','.player');
    slider();
    scrollSpy();
    smartVideo();
});

d.addEventListener("keydown",e=>{ //Los eventos de teclado no se asignas en DOMContentLoaded
    shortcuts(e);
    moveBall(e,'.ball','.stage')
});

temaOscuro('.dark-theme-btn','dark-mode'); //Afuera de DOMContentLoaded pq
networkStatus(); //Afuera de DOMContentLoaded pq solo me indica si hay o no conexion
/*
    Archivo que desencadena toda la programacion

    Curso JavaScript: 145. SPA: Estructura de Proyecto (assets, helpers y components) 
    https://www.youtube.com/watch?v=jLMyWvZIhB4&list=PLvq-jIkSeTUZ6QgYYO3MwG9EMqC-KoLXA&index=146&ab_channel=jonmircha

    
 */

import { App } from "./App.js";

const d=document;

/*No hace falta ponerle parentesis a "App" en d.addEventListener("DOMContentLoaded",App); porque sino seria una ejecucion inmediata y lo que yo quiero es que se ejecute 
cuando suceda el evento "DOMContentLoaded" y no que se ejecute inmediatametne apenas el programa pase por la linea de abajo*/
d.addEventListener("DOMContentLoaded",App); 

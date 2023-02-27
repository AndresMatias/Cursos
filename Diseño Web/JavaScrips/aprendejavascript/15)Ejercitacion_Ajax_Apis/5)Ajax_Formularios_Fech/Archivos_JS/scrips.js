
import contactFormulario from "./validar_formulario.js";
const d=document;

d.addEventListener('DOMContentLoaded',(e)=>{ //Uso DOMContentLoaded para una cargar mas a rapida por q empieza a funcionar cuando ya se cargo solo el HTML, no espera el css etc
    contactFormulario();
});
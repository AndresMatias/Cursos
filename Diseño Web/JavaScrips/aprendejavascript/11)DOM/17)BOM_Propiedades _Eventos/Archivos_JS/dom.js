/*
El evento DOMContentLoaded es disparado cuando el documento HTML ha sido completamente cargado y parseado, sin esperar hojas de estilo, imágenes y subtramas para finalizar la carga.
El evento load se dispara cuando se ha detectado la carga completa de la página.
Es un error frecuente usar load cuando DOMContentLoaded es mucho más apropiado.
Peticiones asíncronas pausan el parseo del DOM.
*/
window.addEventListener("resize", (e) => {
  console.clear();
  console.log("********** Evento Resize **********");
  console.log(window.innerWidth); //Tamaño del ancho del wiopor(nose q es) de la ventana
  console.log(window.innerHeight); //Tamaño del alto del wiopor(nose q es) de la ventana
  console.log(window.outerWidth); //Tamaño del ancho de la ventana del navegador
  console.log(window.outerHeight); //Tamaño del alto de la ventana del navegador
  console.log(e);
});
window.addEventListener("scroll", (e) => {
  console.clear();
  console.log("********** Evento Scroll **********");
  console.log(window.scrollX);
  console.log(window.scrollY);
  console.log(e);
});
window.addEventListener("load", (e) => {
  console.log("********** Evento Load **********");
  console.log(window.screenX);
  console.log(window.screenY);
  console.log(e);
});
document.addEventListener("DOMContentLoaded", (e) => { /*Esta carga de evento es mas apropiada que load en la linea 23 pq es mas rapido y por la explicacion de arriva */
  console.log("********** Evento DOMContentLoaded **********");
  console.log(window.screenX);
  console.log(window.screenY);
  console.log(e);
}); 
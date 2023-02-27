/**
 * Scrip para cargar html de foma modular en vez de estar escribiendo todo el codigo html en la pagina, lo modularizo y lo cargo de esta forma
 */
document.addEventListener("DOMContentLoaded", (e) => {
    const includeHTML = (el, url) => {
      const xhr = new XMLHttpRequest();
  
      xhr.addEventListener("readystatechange", (e) => { //Pongo evento a la escucha
        if (xhr.readyState !== 4) return;
  
        if (xhr.status >= 200 && xhr.status < 300) {
          el.outerHTML = xhr.responseText;
          console.log(url);
        } else {
          let message =
            xhr.statusText ||
            "Error loading the file, verify that you are making the request by http or https";
          el.outerHTML = `<div><p>Error ${xhr.status}: ${message}</p></div>`; //Utilizo outer para reemplazar la etique div con el atributo "data-include" y de esa forma agrego todo
        }
      });
  
      xhr.open("GET", url); //Abro conexion
      xhr.setRequestHeader("Content-type", "text/html; charset=utf-8"); //Configuro cabecera
      xhr.send(); //Realizo peticion
    };
  
    document 
      .querySelectorAll("[data-include]") //Traer TODOS los elementos que tenga los elementos "data-include"
      .forEach((el) => includeHTML(el, el.getAttribute("data-include"))); //Por cada elemento que traiga un "data-include" ejecuta la funcion "includeHTML"
  });
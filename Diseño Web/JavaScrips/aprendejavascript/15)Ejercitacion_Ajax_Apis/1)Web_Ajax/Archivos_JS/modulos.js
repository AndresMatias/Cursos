const d = document,
  $main = d.querySelector("main");

/**
 * Funcion para poner a la escucha evento de readystatechange y obtener html
 * @param {*} options Estructura que contiene 3 parametros:     url: link del html que va a cargar
 *                                                          success: funcion que va cargar el html 
 *                                                            error:Funcion que va a cargar mensage de error
 */
const getHMTL = (options) => {
    let {url,success,error}=options;
    const xhr=new XMLHttpRequest();
    xhr.addEventListener("readystatechange",e => { //Pongo a la escucha el evento: Creo que xhr esto solo funciona dentro del evento
        if(xhr.readyState !== 4){ //En caso de error pero no me acuerdo que ver clase inicial
            return;
        }
        if(xhr.status >= 200 && xhr.status < 300){ //Si es caso de exito
            let html=xhr.responseText; //No hace falta parsear nada
            success(html); //Agrego HTML a la pagina
        } 
        else{ //Si ocurrio un error
            let message= xhr.statusText||"Ocurrio un error";
            error(`Error ${xhr.status}:${message}`);
        }
    });

    xhr.open("GET",url); //Abro la conexion
    xhr.setRequestHeader("Content-type","text/html; charset=utf-8"); //Html codigicado en utf-8
    xhr.send(); //No es que envio sino que obtengo en este caso
}

d.addEventListener("DOMContentLoaded", e => { //Carga por default a penas carga el html inicial
    getHMTL({
        url:"assets/home.html", //Contenido por default
        success:(html) => $main.innerHTML=html, //Caso exitoso arrow function que es llamada en xhr.addEventListener mas arriba
        error:(err) => $main.innerHTML = `<h1>${err}</h1>` //caso de error
    });
});

d.addEventListener("click", e => { //Carga htmls de los links del menu
    if(e.target.matches(".menu__item")){
        e.preventDefault(); //Desactivo comportamiento por defecto
        getHMTL({
            url:e.target.href, //Contenido del href del menu
            success:(html) => $main.innerHTML=html, //Caso exitoso arrow function que es llamada en xhr.addEventListener mas arriba
            error:(err) => $main.innerHTML = `<h1>${err}</h1>` //caso de error
        });
    }
});
//----Variables y Constantes----
const d=document,
      w=window;

/**
 * Metodo que maneja si aparece o no un boton en funcion del scroll, en el margen inferior derecho para enviar al usurio
 * al inicio de la pagina
 * @param {*} btn string del selector css del boton para volver al inicio de la pagina
 */
export function scrollTopBottom(btn){
    //----Variables y Constantes----
    const $scrollBtn=d.querySelector(btn);
    w.addEventListener('scroll',e=>{ //Evento scroll de la ventana window
        let scrollTop=w.scrollY||d.documentElement.scrollTop;
        if(scrollTop>600){
            $scrollBtn.classList.remove('hidden');
        }
        else{
            $scrollBtn.classList.add('hidden');
        }
    });
    d.addEventListener('click',e=>{ //evento click del document
        if(e.target.matches(btn)){ //si el evento click se origino en el boton que maneja el evento que quiero ejecutar
            w.scrollTo({
                behavior:'smooth', //No me funciona el efecto
                top:0,
            });
        }
    });
}
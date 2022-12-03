//----Variables y Constantes----
const d=document,
      ls=localStorage;

/**
 * Metodo que maneja el cambio de tema de la pagina, se indican en las etiquetas html mediante un dataAtributte(data-dark)
 * aquellos elementos que quieran ser cambiados de tema 
 * @param {*} btn selector del boton para cambio de tema
 * @param {*} classDark clase que se le agrega a los elementos html identificados con un dataatributte(data-dark) para que se le apliquen el estilo css para su cambio de tema
 */
export default function temaOscuro(btn,classDark){ //ver lo de default
    //----Variables y Constantes----
    const $themeBtn=d.querySelector(btn),
          $selector=d.querySelectorAll('[data-dark]'); //Me devuelve todos los selectores con esas palabras
    let luna='🌙',sol='🌞';
    /**
     * Funcion flecha para cambiar a modo luminoso
     */
    const lightMode=()=>{
        $selector.forEach(el=>el.classList.remove(classDark)); //Quito Modo Dark
        $themeBtn.textContent=luna;
        ls.setItem('theme','light');
    }
    /**
     * Funcion flecha para cambiar a modo oscuro
     */
    const darkMode=()=>{
        $selector.forEach(el=>el.classList.add(classDark)); //Agrego modo dark
        $themeBtn.textContent=sol;
        ls.setItem('theme','dark');
    }
    d.addEventListener('click',e=>{
        if(e.target.matches(btn)){
            if($themeBtn.textContent===luna){
                darkMode();
            }else{
                lightMode();
            }
        }
    });

    d.addEventListener('DOMContentLoaded',e=>{ //Apenas se carga completamente el html determino en que tema esta
        if(ls.getItem('theme')===null)ls.setItem('theme','light'); //Si no existe creo la varaible
        if(ls.getItem('theme')==='light')lightMode();
        if(ls.getItem('theme')==='dark')darkMode();
    });
}
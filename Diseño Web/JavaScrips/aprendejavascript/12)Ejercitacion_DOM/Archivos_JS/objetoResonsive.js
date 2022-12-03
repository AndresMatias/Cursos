//----Variables y Constantes----
const d=document,
      w=window;
    
/**
 * Metodo para controlar el contenido que aparece en pantalla si es para celular o escritorio para ahorrar datos(responsive)
 * @param {*} id id(de la div en este caso) que va a estar modificando
 * @param {*} mq Media Query
 * @param {*} mobileContent Contenido para mobile
 * @param {*} desktopContent  Contenido para Escritorio
 */
export function responsiveMedia(id,mq,mobileContent,desktopContent){
    let breakPoint=w.matchMedia(mq);

    /**
     * Funcion flecha para determinar si la pantalla es para mobile o escritorio
     * @param {*} e 
     */
    const responsive=e=>{
        if(e.matches){
            d.getElementById(id).innerHTML=desktopContent;
              
        }else{
            d.getElementById(id).innerHTML=mobileContent;
        }
    }

    breakPoint.addEventListener('change',e=>{
        responsive(e);
    });

    responsive(breakPoint); //Esta linea es pq apenas carga el html no se ejecuta el evento change de la linea 24(ya que solo se ejecuta cuando hay un cambio) entonces lo ejecuto de esta forma inicialmente 
}
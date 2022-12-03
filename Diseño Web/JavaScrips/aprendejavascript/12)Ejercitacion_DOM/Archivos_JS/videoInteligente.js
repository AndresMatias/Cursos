//----Variables y Constantes----
const d=document,
      w=window;

export default function smartVideo(){
    const $video=d.querySelectorAll("video[data-smart-video]");
    const cb=(entries)=>{
        entries.forEach(element => {
            if(element.isIntersecting){ //Si se da la interccion que aparece en pantalla con {threshold: 0.5}, en el observador se peude cambiar el valor de threshold
                element.target.play(); //play si esta dentro de la interccecion
            }else{ //Si sale fuera de la interseccion pauso el video
                element.target.pause();
            }

            /*
            Este evento(visibilitychange) es para que en el momento que la pagina pierda la visibildiad 
            el video se pause ya que de las lineas 8 a 13 gestiona si se pone en pausa o sigue 
            el video pero solo si detecta la interseccion estando en la pagina
            */
            w.addEventListener("visibilitychange",e=> 
                d.visibilityState==="visible"
                    ? element.target.play()
                    : element.target.pause()
            );
        });
    };
    const observer=new IntersectionObserver(cb, {threshold: 0.5});
    $video.forEach(el=>observer.observe(el)); //Pongo a la observacion a todo lo que sea un video
}
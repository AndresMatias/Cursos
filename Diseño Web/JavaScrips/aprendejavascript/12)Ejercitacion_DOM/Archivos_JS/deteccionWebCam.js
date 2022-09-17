//----Variables y Constantes----
const d=document,
      n=navigator;

/**
 * Metodo para detectar la webcam
 * @param {id} id id de la etiqueta video para la webcam 
 */
export function deteccionWebCam(id){
    const $video=d.getElementById(id);
    if(n.mediaDevices.getUserMedia){ //Validacion que si el navegador es mas o menos moderno no es necesaria
        n.mediaDevices.getUserMedia({video:true,audio:false}) //Activo video pero no audio ademas esto es una promesa(repasar promesas)
        .then(strem=>{
            console.log(strem);
            $video.srcObject=strem;
            $video.play();
        })
        .catch((err)=>{
            $video.insertAdjacentHTML('beforebegin',`<p><mark>Sucedio el siguiente error: ${err}</mark></p>`);
        });      
    }
}
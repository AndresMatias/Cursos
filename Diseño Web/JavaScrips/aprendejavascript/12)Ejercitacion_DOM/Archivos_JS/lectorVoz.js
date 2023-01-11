//----Variables y Constantes----
const d=document,
      w=window;
/**
 * Metodo para implementar voces en el navegador en la seccion 15 del html
 */
export default function speechReader(){
    const $speechSelect   = d.getElementById("speech-select"),
          $speechTextarea = d.getElementById("speech-text"),
          $speechBtn      = d.getElementById("speech-btn"),
          speechMessage   = new SpeechSynthesisUtterance(); //Para Interactuar con las voces del sistema operativo
    
    let voices=[];
    console.log("HOla");
    d.addEventListener("DOMContentLoaded", e=>{ //Todo evento que nececite ser llamado desde DOMContentLoaded no puede ser puesto directamente en el DOMContentLoaded en el archiv scrips en este caso sino que se pone fuera y se programa la funcionalidad fuera como es este caso
        w.speechSynthesis.addEventListener("voiceschanged", e=>{ 
            voices=w.speechSynthesis.getVoices(); //Tengo que ejecutar esta linea dentro de este evento(voicechange) si o si para obtener las voces, nose pq pero asi es
            voices.forEach(voice=>{ //Cargo los elementos de voces
                const $option=d.createElement("option");
                $option.value=voice.name;
                $option.textContent=`${voice.name}-${voice.lang}`;
                $speechSelect.appendChild($option);
            });
        });
    });
    d.addEventListener("change", e=>{ //Detecto el cambio de voice
        if(e.target===$speechSelect){
            speechMessage.voice=voices.find(voice=>voice.name===e.target.value); //asigno la voz detectada al driver de voz
        }
    });
    d.addEventListener("click", e=>{
        if(e.target===$speechBtn){
            speechMessage.text=$speechTextarea.value; //Aisgno el texto del area al texto de la voz para leer
            w.speechSynthesis.speak(speechMessage); //Leo 
        }
    })
}
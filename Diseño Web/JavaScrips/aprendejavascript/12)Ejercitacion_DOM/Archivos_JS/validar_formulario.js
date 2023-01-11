//Curso JavaScript: 102. DOM: Ejercicios Prácticos | Validación de Formularios
//https://www.youtube.com/watch?v=AGPalf1C8Ms&list=PLvq-jIkSeTUZ6QgYYO3MwG9EMqC-KoLXA&index=114&ab_channel=jonmircha
//--Variables--
const d=document;

/**
 * Metodo para implementar validaciones de formulario
 */
export default function contactFormulario(){
    const $form  = d.querySelector(".contact-form"),
          $inputs = d.querySelectorAll(".contact-form [required]");    
    $inputs.forEach(input =>{ //Creo agrego Span despues de cada elemento de contac form 
        const $span=d.createElement("span");
        $span.id=input.name;
        $span.textContent=input.title;
        $span.classList.add("contact-form-error","none");
        input.insertAdjacentElement("afterend",$span); //todo elemento que vaya en el dom se recomienda que lleve signo dolar, buenas practicas
    });      
    d.addEventListener("keyup",(e)=>{
        if(e.target.matches(".contact-form [required]")){
            let $input=e.target,
                pattern=$input.pattern || $input.dataset.pattern; //operador de corto circuito clase 29 lo uso pq el text area no acepta pattern
            if(pattern){
                let regrex= new RegExp(pattern); //Expresion regular
                return !regrex.exec($input.value) //valida texto
                    ? d.getElementById($input.name).classList.add("is-active")
                    : d.getElementById($input.name).classList.remove("is-active");
            }
            if(!pattern){ // no uso else pq puede confundir al usuario apenas aperece el cuadro si uso else daria el mensaje de error cunado el usuario ni siquiera toco los campos a ingresar datos
                return $input.value==="" //valida texto
                    ? d.getElementById($input.name).classList.add("is-active")
                    : d.getElementById($input.name).classList.remove("is-active");
            }
        }
    });

    d.addEventListener("submit",(e)=>{
        //e.preventDefault(); //Desactivo comportamiento por defecto del evento submit del boton enviar porque sino procesa los datos
        alert("Enviando formulario");
        const $loader=d.querySelector(".contact-form-loader"),
            $response=d.querySelector(".contact-form-response");
        
        $loader.classList.remove("none"); //Muestro la animacion para esperar
        setTimeout(() => {
            $loader.classList.add("none");
            $response.classList.remove("none");
            $form.reset();
            setTimeout(()=>$response.classList.add("none"));
        }, 3000);
    });
}
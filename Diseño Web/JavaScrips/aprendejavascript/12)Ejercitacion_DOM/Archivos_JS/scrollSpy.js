//----Variables y Constantes----
const d=document;

//Video 99 creo

/**
 * Metodo para el manejo del menu del costado que se subrayen las sencciones en las que estoy parado
 */
export default function scrollSpy(){
    const $sections=d.querySelectorAll('section[data-scroll-spy]');
    
    const cb=(entries)=>{
        entries.forEach(entry=>{
            const id=entry.target.getAttribute("id");
            if(entry.isIntersecting){ //Si se dio la interccion es decir si se detecda que aparecio en pantalla con los valores de threshold:  [0.5,0.75] en la linea 25
                d.querySelector(`a[data-scroll-spy][href="#${id}"`).classList.add("active");
            }else{
                d.querySelector(`a[data-scroll-spy][href="#${id}"`).classList.remove("active");
            }
        });   
    }
    const observer=new IntersectionObserver(cb,{
        //root
        //rootMargin: "-250px" //para que se marque una sola opcion en el menu
        threshold:  [0.5,0.75], //se ilumina el menu entre 50% al 75% de altura  
    });
    $sections.forEach(el=>observer.observe(el));
}
//----Variables y Constantes----
const d=document;

/**
 * Metodo que gestiona la logica de manejo del filtro de busqueda
 * @param {*} input input de busqueda
 * @param {*} selector selector con el que coincide la busqueda
 */
export function filtroBusqueda(input,selector){
    d.addEventListener('keyup',e=>{
        if(e.key==='Esc'){
            e.target.value='';
        }
        if(e.target.matches(input)){
            d.querySelectorAll(selector).forEach(el=>{
                el.textContent.toLowerCase().includes(e.target.value)//toLowerCase() convierto todo a minuscula, includes(e.target.value) true o false si concide
                ? el.classList.remove('filter') //true
                : el.classList.add('filter') //false
                
            });
        }
    });
}
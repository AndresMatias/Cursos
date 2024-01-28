import api from "./helpers/wp_api.js"

/**
 * Metodo que crea el COMPONENTE titulo en un nodo h1 y retorna dicho nodo
 * @returns Retorna un nodo de tipo h1 que incluye api.DOMAIN y api.NAME
 */
export function Title(){
    const  $h1=document.createElement('h1');
    $h1.innerHTML=`
    <a href="${api.DOMAIN}" target="_blank" rel="noopener">
        ${api.NAME.toUpperCase()}  
    </a>`;

    return $h1
}
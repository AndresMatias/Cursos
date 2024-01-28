/**
 * Metodo para crear el COMPONENTE de carga
 * @returns Retorna un elemento tipo img para representar un loader
 */
export function Loader(){
    const $loader=document.createElement("img"); //Creo un elemento de tipo imagen
    $loader.src="app/assets/loader.svg" //Cargo imagen de loader
    $loader.alt="Cargando..."
    $loader.classList.add("loader"); //Agrego clase para su modificacion
    return $loader
}
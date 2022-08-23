/**
 * Metodo que pone a la escucha el evento para el cambio de forma del boton de menu, el despligue del menu y si se selecciona un item del menu
 * @param {querySelector} selectorBoton Selector del boton del menu
 * @param {querySelector} selectorPanel Selector del panel que contiene al menu a desplegar
 * @param {querySelector} selectorMenu Menu que contiene las secciones a donde uno quiere ir
 */
export function botonMenu(selectorBoton,selectorPanel,selectorMenu){
    // Evetno On click del boton panel-btn
    selectorBoton.addEventListener("click", function() { //Enlazo evento con boton
        //Cambio a class "is-active"
        selectorBoton.classList.toggle("is-active"); //Cambio boton panel
        selectorPanel.classList.toggle("is-active"); //Despliego panel
    });
    // Evetno On click de los item del menu para remover menu y volver a la forma original al boton
    selectorMenu.addEventListener("click", function() { //Enlazo evento con boton
        selectorBoton.classList.remove("is-active"); 
        selectorPanel.classList.remove("is-active");
    });
}
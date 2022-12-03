//----Variables y Constantes----
const d=document;

/**
 * Metodo para abrir o cerrar una ventana para responsive tester
 * @param {string} form string del id del formulario
 */
export function responsiveTester(form){
    const $form=d.getElementById(form);
    let tester;
    d.addEventListener('submit',e=>{ //Si se sube el formulario
        if(e.target===$form){
            e.preventDefault(); //Evito que se autoprocese la pagina
            //alert("Formulario enviado");
            tester=window.open($form.direccion.value,"tester",`innerWidth=${$form.ancho.value},innerHeight=${$form.alto.value}`); //Abro ventana nueva con los datos cargados en el formulario
        }
    });
    d.addEventListener('click',e=>{ //Ciero ventana que abri previamiente desde el formulario
        if(e.target===$form.cerrar){
            tester.close();
        }
    });
}
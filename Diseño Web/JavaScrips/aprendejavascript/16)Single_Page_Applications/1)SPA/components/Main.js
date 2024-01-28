/**
*Metodo para generar una estructura grid acomodar todos los post card
*/
export function Main(){
	const $main=document.createElement("main");
	$main.id="main";
	if(!location.hash.includes("#/search"))$main.classList.add("grid-fluid");	//Si el hash no es una busqueda agrega la clase que grid-fluid video 155
	return $main;
}

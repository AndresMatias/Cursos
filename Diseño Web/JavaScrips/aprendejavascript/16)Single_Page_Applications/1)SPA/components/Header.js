import { Title } from "./Title.js"
import { Menu } from "./Menu.js"
import { SearchForm } from "./SearchForm.js"

/**
*Metodo para construir el header de la pagina web
*return Este metodo retorna el header construido
*/
export function Header(){
	const  $header=document.createElement("header");
	$header.classList.add("header");
	
	//--Agrego Elementos al Header--
	$header.appendChild(Title());
	$header.appendChild(Menu());
	$header.appendChild(SearchForm());

	return $header;
}

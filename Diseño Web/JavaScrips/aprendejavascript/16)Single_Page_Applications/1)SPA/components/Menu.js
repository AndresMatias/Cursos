/**
*Metodo para crear menu
*/
export function Menu(){
	const $menu=document.createElement("nav");
	$menu.classList.add("menu");
	//Por mas que este en la misma pagina html, para identificar "distintas" paginas uso el href="#/" siendo "#/" equivalente a estar en el home
	//noopener: para no tener ninguna dependencia con  la ventana que se abre
	$menu.innerHTML=`
	<a href="#/">Home</a>
	<span>-</span>
	<a href="#/search">Busqueda</a>
	<span>-</span>
	<a href="#/contacto">Contacto</a>
	<span>-</span>
	<a href="https://aprendejavascript.org" target="_blank" rel="noopener">Aprende Js</a>
	`;
	return $menu;
}

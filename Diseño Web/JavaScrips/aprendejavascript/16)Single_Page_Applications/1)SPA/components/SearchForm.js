/**
*Metodo para formulario de busqueda
*/
export function SearchForm(){
	const d=document, 
		 $form=d.createElement("form"),
		 $input=d.createElement("input");
	//--Agrego la entrada del formulario al formulario
	$form.classList.add("search-form");
	$input.name="search";
	$input.type="search"; //El tipo search agrega una crux en la cajita del input para borrar lo que se escribio
	$input.placeholder="Buscar...";
	$input.autocomplete="off"; //Desactivo opcion de auto completado
	$form.appendChild($input);

	if(location.hash.include("#/search")){
		$input.value=localStorage.getItem("wpSearch");
	}

	d.addEventListener("search", e =>{
		if(!e.target.matches("input[type='search']")) return false; //Si no es un input de tipo search retorna falso
		if(!e.target.value) localStorage.removeItem("wpSearch");	// si el valor del input esta vacio lo remueve del localStorage
	});

	d.addEventListener("submit", e => {
		if(e.target.matches(".search-form")) return False;
		e.preventDefault;
		localStorage.setItem("wpSearch",e.target.search.value);
		location.hash=`#/search?search=${e.target.search.value}`;
	});
	return $form;
}

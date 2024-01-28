export function ContactForm(){
	const d=document,
		$form=d.createElement("form");
		$styles=d.getElementById("dynamic-styles");
	$form.classList.add("contact-form");
	
	//--Agrego Estilos Dinamicos--
	$styles.innerHTML=`Incluir el css del video 127`;

	//--Agrego Html--
	$form.innerHTML=`Incluir el html del video 127`;
	return form
}

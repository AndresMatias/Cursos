import  api from "./helpers/wp_api.js"
import { ajax } from "./helpers/ajax.js"
import { PostCard } from "./PostCard.js"
import { Post } from "./Post.js"
import { SearchCard } from "./SearchCard.js"
import { ContactForm } from "./ContactForm.js"

/**
*Metodo para pegar el html correspondiente de la consulta ajax de los posts
*/
export async function Router(){ /*Al ser asincrona la funciona puedo aplicar await en el ajax de abajo, esto me permite que no avance la funcion hasta que termine el ajax, esto lo hago asi porque sino
									el loader desaparece mientras sigue ejecutandose el ajax(dado que es asincrono) y el loader debe desaparecer una vez que tenga todos los datos para cargar en el html*/
	let d=document,
		w=window
		$posts=d.getElementById("posts");
	let { hash }=location;

	$posts.innerHTML=null; //Me aseguro que el elemento que cargue lo haga limpiamente sin tener nada previamente

	if(!hash || hash ==="#/"){ //Cuando carga por primera vez la aplicacion puede ser que no existe el hash o esta en la parte donde #/
		//$posts.innerHTML="<h2> Seccion del Home </h2>";
		await ajax{[
		url: api.POSTS,
		cbSuccess: (posts)=> {
			let html="";		
			posts.forEach(post => html+=PostCard(post));
			d.getElementById("posts").innerHTML=html;	
		}
	]};
	}
	else if(hash.include("#/search")){	//hash.include nuevo metodo para compara porque cuando busque algo el usuario la url va a cambiar y no va a ser solo "#/search" por lo cual no conviene comparar con ===
		let query=localStorage.getItem("wpSearch");
		if(!query){ //Si no hay nada en query
			d.querySelector(".loader").style.display="none";
			return false;
		}
		await ajax{[
		url: `${api.SEARCH}${query}`,
		cbSuccess: (search)=> {
			let html="";
			if(search.lenght===0){ //Si no hay resultados de busqueda
				html=`
					<p class="error">
						No existe resultados de busqueda
						<mark>${query}</mark>					
					</p>				
				`;
			}
			else{ //Si hay resultados de busquedas pego el contenido de las card encontradas
				search.forEach((post) => (html += SearchCard(post)));
			}
			$main.innerHTML=html;
			
		}
	}
	else if(hash("#/contacto")){
		$main.appendChild(ContactForm()); //Agrego como nodo 		
	}
	else{ //En caso de el hash no sea de la estructura que vengo manejando
		await ajax{[
		url: `${api.POST}/${localStorage.getItem("wpPostId")}`, //revisar video 153 por lo de "api.POST" porque lo tengo que cambiar
		cbSuccess: (post)=> {
			/*let html="";		
			posts.forEach(post => html+=PostCard(post));
			d.getElementById("posts").innerHTML=html;*/	
			$main.innerHTML= Post(post);
		}		
	}
	d.querySelector(".loader").style.display="none"; //Quito el loader una vez que pegue el html
}


import api from "./wp_api.js"
import {SearchCard} from "./components/SearchCard.js"
import {PostCard} from "./components/PostCard.js"

/**
*Metodo para implementar un scroll infinito en la pagina de busqueda y en el home(#/) de esa forma trae mas resultados de busqueda y no solo un numero limitado
*/
export async function InfinityScroll(){
	const d=document,
		  w=window;
	let query=localStorage.getItem("wpSearch"),
		apiURL,
		Component; //HOC: funcionalidad con vanilla js pero se puede extrapolar a react

	w.addEventListener("", async e => {
		/*
			scrollTop: Distancia de la barra scroll al margen de arriva
			clientHeight: altura del contenido
			scrollHeight anchura del contenido
		*/
		let { scrollTop,clientHeight,scrollHeight }=d.documentElement,
			{ hash }=w.location;
	
		if((scrollTop+clientHeight)>=scrollHeight){ //si esto se cumple significa que ya llegue al final del scroll
			api.page++;		
		}
		
		if(!hash||hash==="#/"){ //Si no hay hash o estoy en el home
			apiURL=`${api.POSTS}&page=${api.page}`;
			Component=PostCard; //Ver porque no pone los parentesis de la funciona creo que es para que no se ejecute en el momento
		}
		else if(hash.include("#/search")){
			apiURL=`${api.SEARCH}${query}&page=${api.page}`;	
			Component=SearchCard; //Ver porque no pone los parentesis de la funciona creo que es para que no se ejecute en el momento
		}
		else{
			return false;
		}
		
		d.querySelector(".loader").style.display="block"; //Activo el loader

		await ajax({
			url:apiURL,
			cbSuccess: (posts) => {
				let html="";
				posts.forEach(post => html+= Component(post));
				d.getElementById("main").insertAdjacentHTML("before",html); //Agregoel contenido al final del html
				d.querySelector(".loader").style.display="none"; //Descativo el loader			
			}
		});
	});
}

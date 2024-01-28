/**
*Metodo que retorna el codigo html para generar la estructura de un post card(solo la tarjeta que representa el post, no es todo el post)
*/
export function PostCard(props){
	let {date,id,slug,title, _embedded} = props;
	let dateFormat=new Date(date).toLocale.String(), //Le doy formato a la fecha
		urlPoster=_embedded["wp.featuredmedia"] ? _embedded["wp.featuredmedia"][0].source_url: "app/assets/favicon.png";
	//${title.rendered}: agrego el titulo y lo renderizo dinamicamente

	document.addEventListener("click", e=>{ //Evento click cuando es un enlace de post card
		if(e.target.matches(".post-card a")) return false;
		localStorage.setItem("wpPostId",e.target.dataset.id); //Si es una post card accedo a localstorage y guardo el id de la card
	});	
	return `
	<article class="post-card">
		<img src="${urlPoster}" alt="${title.rendered}">
		<h2>${title.rendered}</h2>
		<p>
			<time datetime="${date}">${dateFormat}</time>
			<a href="#/${slug}" id="${id}">Ver Publicacion</a>
		</p>
	</article>	
	`;
}

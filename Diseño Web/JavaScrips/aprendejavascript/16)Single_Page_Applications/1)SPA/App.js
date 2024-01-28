import {Header} from "./components/Header.js"	
import {Main} from "./components/Main.js"	
import {Loader} from "./components/Loader.js"	
import {Router} from "./components/Router.js"	
import {InfinityScroll} from "./helpers/infinity_scroll.js"	

export function App(){
	const d=document,
	$root=d.getElementById("root");
	
	//--Limpio HTML viejo--
	$root.innerHTML=null; //Limpio el html porque cuando cambia el hash, este al llamar a al funcion App cada vez que cambio, vuelve a implementar  las tres lineas de abajo repitiendo el contenido
	//Recordar que no son varias paginas, sino que es la misma pagina con diferentes

	//--Agrego elementos a la pagina--
	$root.appendChild(Header());
	$root.appendChild(Main());
	$root.appendChild(Loader());
	
	Router();
	InfinityScroll();
	
}

import { join } from "path"; // path puede verse como el camino desde el disco duro donde se encuntra la aplicacion del servidor

const directorio = "/ruta/principal";
const archivo = "archivo.txt";

const rutaCompleta = join(directorio, archivo); //construyo la ruta completa 

console.log("Ruta completa:", rutaCompleta);

// ejecutar con el comando node modulo-path-1-mjs

import { basename, dirname, extname } from "path";

const ruta = "/ruta/principal/archivo.txt"; //Ruta hipotetica en el cual se basa este ejercicio

const nombreArchivo = basename(ruta);
const nombreDirectorio = dirname(ruta); 
const extension = extname(ruta); //determino extesion del archivo

console.log("Nombre del archivo:", nombreArchivo);
console.log("Nombre del directorio:", nombreDirectorio);
console.log("Extensión del archivo:", extension);

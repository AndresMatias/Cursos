import { resolve } from "path";
// Ejemplo de ruta relativa
const rutaRelativa = "../carpeta/archivo.txt"; // el ../ significa que suba una carpeta arriva de la carpeta padre

const rutaAbsoluta = resolve(rutaRelativa); // con resolve contruyo una ruta absoluta uniendo la ruta relativa

console.log("Ruta absoluta:", rutaAbsoluta);

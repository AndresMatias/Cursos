import { parse } from "url"; //Utilizo parse para convertir una cadena en objeto de js

/**
 * un "?" en la url indico que le paso un valor
 * el "&" indica otro valor
 */
const urlString =
  "https://www.ejemplo.com:8080/ruta?parametro1=valor1&parametro2=valor2";

const parsedUrl = parse(urlString, true);

//--Partes Basicas de una URL--
console.log("Protocolo:", parsedUrl.protocol);
console.log("Hostname:", parsedUrl.hostname);
console.log("Pathname:", parsedUrl.pathname); //Ruta en particular
console.log("Parámetros de consulta:", parsedUrl.query); //Contiene las variables que pase en la url

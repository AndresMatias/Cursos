import { format } from "url"; //A la inversa que parse, contruye una url string a partir del objeto dado en js

const urlObj = {
  protocol: "https",
  hostname: "www.ejemplo.com",
  pathname: "/ruta",
  query: { parametro1: "valor1", parametro2: "valor2" },
};

const urlString = format(urlObj);

console.log("URL completa:", urlString);

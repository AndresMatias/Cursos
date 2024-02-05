import { createServer } from "http"; //Modulo http para crear servidores y/o clientes http

const server = createServer((req, res) => { //req: peticion - res:respeusta
  //res.writeHead(200, { "Content-Type": "text/plain" });
  res.writeHead(200, { "Content-Type": "text/html; charset=utf-8" });
  //res.end("¡Hola Mundo 😉!");
  res.end("<h1>¡Hola Mundo 😉!</h1>");
});

server.listen(3000, "127.0.0.1", () => { //Se recomienda usar del puerto 3000 en adelante porque por debajo los mucho la pc
  console.log("Servidor web en ejecución en http://127.0.0.1:3000");
});

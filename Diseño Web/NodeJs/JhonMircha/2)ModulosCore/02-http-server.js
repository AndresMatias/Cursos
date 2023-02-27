/**
 * El modulo http me permite CREAR un servidor con node.js
 */
/*
'use strict'

var http = require('http')

http.createServer(function (request, response) { //request: peticion del usuario, reponse: respuesta del servidor
	response.writeHead(200, {'Content-Type':'text/plain'}) //digo que voy a enviar texto plano
	response.end('Hello World\n')
}).listen(1337, "127.0.0.1") //Digo porque puerto va estar escuchando mi aplicacion, NO USAR PUERTO 80 porque por ese puerte escucha toda la web

console.log('Server running at http://127.0.0.1:1337/')
*/
'use strict'

var http = require('http')

function webServer(req, res)
{
	res.writeHead(200, {'Content-Type':'text/html'})
	res.end('<h1>Hola Node.js</h1>')
}

http
	.createServer(webServer)
	.listen(3000, 'localhost')

console.log('Servidor corriendo en http://localhost:3000/')
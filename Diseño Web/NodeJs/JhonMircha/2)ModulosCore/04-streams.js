/*
Streams
	'Chorros' de información que se transmiten en 'Pedazos' (Chunks)
	3 tipos: Lectura / Escritura / Duplex
	Instancias de EventEmitter
	Acceso asíncrono
	Es raro crear streams directamente
	Pero muchos recursos nos ofrecen este interfaz
	Detrás de muchos mecanismos de Node.JS
		stdin/stdout
		request de HTTP
		Sockets
		Manipulación de ficheros/imágenes
*/

'use strict'

var fs = require('fs'), //Requiero el modulo file system de node.js
	readStream = fs.createReadStream('assets/nombres.txt'), //Creo un chorro de informacion leible de un archivo que se encuentra en assets
	writeStream = fs.createWriteStream('assets/nombres_copia.txt') //Creo un stream y lo guardo en assets

/*
readStream.pipe(writeStream)

readStream.on('data', function (chunk){
	console.log(
		'He leído:',
		chunk.length,
		'caracteres'
	)
})

readStream.on('end', function (){
	console.log('Terminé de leer el archivo')
})
*/

readStream.pipe(writeStream) //leo el archivo readStream, copio y pego sun contenido en writeStream

readStream
	.on('data', function (chunk){ //evento: mientras haya datos ejecuta esta funcion - chunk: pedazo de datos que lee readStream
		console.log(
			'He leído:',
			chunk.length,
			'caracteres'
		)
	})
	.on('end', function (){ //Evento: Cuando termina de leer el archivo ejectua esta funcion
		console.log('Terminé de leer el archivo')
	})
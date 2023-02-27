/*
Buffers
	Una tira de bytes (datos binarios)
	Similar a un array de enteros
	Tamaño fijo
	Manipular datos directamente
		Sockets
		Streams
		Implementar protocolos complejos
		Manipulación de ficheros/imágenes
		Criptografía
*/
'use strict'

var buf = new Buffer(100),
	buf2 = new Buffer(26),
	str = '\u00bd + \u00bc = \u00be' //Codificado en ascii: 1/2 +/1/4= 3/4, tiene 9 posiciones "\u00be" cuenta como un solo caracter en ascii

buf.write('abcd', 0, 4, 'ascii')

console.log(
	buf,
	buf.toString('ascii'),
	str, //Miro lo que signifca convirtiendo la condificacion ascii
	str.length + 'caracteres', //9 caracteres
	Buffer.byteLength(str, 'utf8') + 'bytes', //A nivel de meoria de servidor ocupan 12 BYTES
	buf2.length
)

for ( var i = 0; i < buf2.length; i++ )
{
	// 97 en ASCII es a
	buf2[i] = i + 97 //Asigno abecedario
}

console.log( buf2.toString('ascii') ) //Convierto a ascii y muestro en pantalla
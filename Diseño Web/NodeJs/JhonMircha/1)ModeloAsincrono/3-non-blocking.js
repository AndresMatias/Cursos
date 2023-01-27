/**
 * Codigo NO-bloqueante al igual que php y tarda un poquito menos, 
 */
var fs = require('fs')
console.log('\nAbriendo Archivo...')
 
var content = fs.readFile('archivo.txt', 'utf8', function (error, content){ //Mientras ejecuta la funcion del tercer parametro puede ejecutar otra tarea como el consolo.log("Haciendo otra cosa"), esto es posible porque el tercer parametro que se pasa es una callback
	console.log(content)
})

console.log('\nHaciendo otra cosa\n')

console.log( process.uptime() )
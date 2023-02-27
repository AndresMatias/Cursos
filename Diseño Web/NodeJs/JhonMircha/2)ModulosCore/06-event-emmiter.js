//https://es.wikipedia.org/wiki/Observer_(patr%C3%B3n_de_dise%C3%B1o)

'use strict'

var EventEmitter = require('events').EventEmitter,
	pub = new EventEmitter()

pub //Publico eventos
	.on('myevent', function (message){ //Publico mi propio evento, "on" se ejecuta cada vez que se llama al evento
		console.log(message)
	})

	.once('myevent', function (message){ //La primera vez que se ejecute mi propio evento se va a ejectuar esta funcion
		console.log('Se emite la primera vez:' + message)
	})

//--Emito eventos--
pub.emit('myevent', 'Soy un emisor de eventos') 
pub.emit('myevent', 'Volviendo a emitir')
pub.removeAllListeners('myevent')
pub.emit('myevent', 'Volviendo a emitir por tercera vez')
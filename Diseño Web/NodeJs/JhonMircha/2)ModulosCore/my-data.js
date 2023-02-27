'use strict'

var name = 'Jonathan',
	email = 'jonmircha@bextlan.com',
	_phone = '5215518388261' //el guion bajo es para indicar que esta variable DEBERIA ser inaccesible por externos y digo DEBERIA porque es una buena practica de programacion pero el compilador  no detecta que es inaccesible con el guion bajo, el "_" es solo para que uno mismo u otros programadores sepan que esa variable no debe exportarse como modulo 

//--Exporto como modulos--
module.exports.name = name
module.exports.email = email
//module.exports.phone = _phone //Si quisiera podria exportarlo como modulo pero no deberia ya que al tener un "_" me indica que dicha variable deberia ser inaccesible por archivos externos, se considera como buena practica de programacion
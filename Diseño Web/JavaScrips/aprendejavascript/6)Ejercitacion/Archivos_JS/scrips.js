import { nroCaracteres, cadenaRecortada, cadenaSeparada, cadenaRepetida } from "./ejercitacion_1.js";
import { invertirCadena, palabraRepetida, palabraPalindromo, eliminarPatron } from "./ejercitacion_2.js";
import { nroAletorio, nroCapicua, nroFactorial } from "./ejercitacion_3.js";
import { conversionBilateralCelciusFahrenheit, nroParImpar, nroPrimo } from "./ejercitacion_4.js";
import { conversionBilateralBinarioDecimal, descuento, determinarYear } from "./ejercitacion_5.js";
import { cuentaVocalConsonante, validarEmail, validarNombre } from "./ejercitacion_6.js";
import { arregloElevadoCuadrado, nroMasAltoBajo, nrosParesImparesSeparados } from "./ejercitacion_7.js";
import { arregloEliminaDuplicados, arregloOrdenadoAscDesc, arregloPromedio } from "./ejercitacion_8.js";

/*----Ejercicios video 35----*/
console.log('-------Ejercicios Video 34-------');

//--Ejercicio 1--
console.log('----Ejercicio 1----');
class andres{}
console.log(nroCaracteres('hola'));
console.log(nroCaracteres(123));
console.log(nroCaracteres(andres));

//--Ejercicio 2--
console.log('\n\n----Ejercicio 2----');
console.log(cadenaRecortada('Hola Mundo',4));
console.log(cadenaRecortada(123,4));


//--Ejercicio 3--
console.log('\n\n----Ejercicio 3----');
console.log(cadenaSeparada('Hola Mundo'));
console.log(cadenaSeparada(123));

//--Ejercicio 4--
console.log('\n\n----Ejercicio 4----');
console.log(cadenaRepetida(' Hola Mundo'));
console.log(cadenaRepetida(123));

/*----Ejercicios video 36----*/
console.log('\n\n\n\n-------Ejercicios Video 35-------');

//--Ejercicio 5--
console.log('----Ejercicio 5----');
console.log(invertirCadena('Hola Mundo'));
console.log(invertirCadena(''));

//--Ejercicio 6--
console.log('\n\n----Ejercicio 6----');
console.log(palabraRepetida('Hola Mundo','Mundo'));
console.log(palabraRepetida(1234,""));

//--Ejercicio 7--
console.log('\n\n----Ejercicio 7----');
console.log(palabraPalindromo('SaLas'));
console.log(palabraPalindromo('Hola Mundo'));
console.log(palabraPalindromo(1234));

//--Ejercicio 8--
console.log('\n\n----Ejercicio 8----');
console.log(eliminarPatron('SaLas',""));
console.log(eliminarPatron('Hola Mundo chau mundo','mUndo'));
console.log(eliminarPatron(1234));

/*----Ejercicios video 37----*/
console.log('\n\n\n\n-------Ejercicios Video 36-------');

//--Ejercicio 9--
console.log('----Ejercicio 9----');
console.log(nroAletorio());

//--Ejercicio 10--
console.log('\n\n----Ejercicio 10----');
console.log(nroCapicua(202));
console.log(nroCapicua(20));
console.log(nroCapicua('202'));
console.log(nroCapicua());
console.log(nroCapicua('12'));

//--Ejercicio 11--
console.log('\n\n----Ejercicio 11----');
console.log(nroFactorial(3));
console.log(nroFactorial(4));
console.log(nroFactorial());
console.log(nroFactorial('3'));

/*----Ejercicios video 38----*/
console.log('\n\n\n\n-------Ejercicios Video 38-------');
//--Ejercicio 12--
console.log('----Ejercicio 12----');
console.log(nroPrimo(20));
console.log(nroFactorial('3'));

//--Ejercicio 13--
console.log('\n\n----Ejercicio 13----');
console.log(nroParImpar(2));
console.log(nroFactorial('3'));

//--Ejercicio 14--
console.log('\n\n----Ejercicio 14----');
console.log(conversionBilateralCelciusFahrenheit(200,'c'));
console.log(conversionBilateralCelciusFahrenheit(200,'f'));

/*----Ejercicios video 39----*/
console.log('\n\n\n\n-------Ejercicios Video 39-------');
//--Ejercicio 15--
console.log('----Ejercicio 15----');
console.log(conversionBilateralBinarioDecimal(10,2));
console.log(conversionBilateralBinarioDecimal(10,10));
console.log(conversionBilateralBinarioDecimal(2));
console.log(conversionBilateralBinarioDecimal('10',2));

//--Ejercicio 16--
console.log('\n\n----Ejercicio 16----');
console.log(descuento(100,20));
console.log(descuento(100,-20));
console.log(descuento(100,0));
console.log(descuento(100,'20'));
console.log(descuento('100',20));

//--Ejercicio 17--
console.log('\n\n----Ejercicio 17----');
console.log(determinarYear(new Date(2000,12,12)));
console.log(determinarYear(new Date(2023,12,12)));
console.log(determinarYear('new Date(2000,12,12)'));

/*----Ejercicios video 40----*/
console.log('\n\n\n\n-------Ejercicios Video 40-------');
//--Ejercicio 18--
console.log('----Ejercicio 18----');
console.log(cuentaVocalConsonante('a'));
console.log(cuentaVocalConsonante('A'));
console.log(cuentaVocalConsonante('Hola Mundo'));
console.log(cuentaVocalConsonante(123));
console.log(cuentaVocalConsonante("aeIbB"));
console.log(cuentaVocalConsonante('bBtU'));

//--Ejercicio 19--
console.log('\n\n----Ejercicio 19----');
console.log(validarNombre(123));
console.log(validarNombre('Andres Singls'));
console.log(validarNombre('AndreS SiNgls'));
console.log(validarNombre('aNdres siNgls'));
console.log(validarNombre('Andres Singls Matias'));
console.log(validarNombre('Andres Singls 123'));
console.log(validarNombre('123'));

//--Ejercicio 20--
console.log('\n\n----Ejercicio 20----');
console.log(validarEmail('hola@gmail.com'));
console.log(validarEmail('hola@gmailcom'));

/*----Ejercicios video 40----*/
console.log('\n\n\n\n-------Ejercicios Video 41-------');
//--Ejercicio 21--
console.log('----Ejercicio 21----');
console.log(arregloElevadoCuadrado([7,2,3]));
//--Ejercicio 22--
console.log('----Ejercicio 22----');
console.log(nroMasAltoBajo([13,12,15,11]));
//--Ejercicio 23--
console.log('----Ejercicio 23----');
console.log(nrosParesImparesSeparados([1,2,3,4,5,6,7]));

/*----Ejercicios video 40----*/
console.log('\n\n\n\n-------Ejercicios Video 42-------');
//--Ejercicio 24--
console.log('----Ejercicio 24----');
console.log(arregloOrdenadoAscDesc([7,2,3]));
//--Ejercicio 25--
console.log('----Ejercicio 25----');
console.log(arregloEliminaDuplicados([13,12,15,11,15]));
//--Ejercicio 26--
console.log('----Ejercicio 26----');
console.log(arregloPromedio([1,2,3,4,5,6,7]));

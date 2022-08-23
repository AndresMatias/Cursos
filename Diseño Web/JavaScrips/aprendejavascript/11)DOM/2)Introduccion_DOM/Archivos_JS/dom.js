/*console.log(window);
console.log(document);

let texto='Hola mundo estoy hablando';
const hablar=(texto)=>
    speechSynthesis.speak(new SpeechSynthesisUtterance(texto));
hablar(texto);*/
console.log('-------------Elementos del Documento-------------');
console.log(window.document);
console.log(document);
console.log(document.head); //etiqueta dentro de head
console.log(document.body); //el cuerpo
console.log(document.documentElement);
console.log(document.doctype); //Tipo de documento
console.log(document.charset); //En desuso
console.log(document.title); //Titulo
console.log(document.links); //Cantidad de links
console.log(document.images); //Cantidad de imagenes
console.log(document.forms); //Cantidad de formularios
console.log(document.styleSheets); // Cantidad de Hojas de estilos
console.log(document.scripts); //Cantidad de Scrips
console.log(document.getSelection().toString()); //Muestra si seleccione algo en la pagina
//document.write('<h2>Hola Mundo desde el DOM</h2>'); //No se recomiendo usar write
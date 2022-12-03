const $figure = document.createElement("figure"), //Creo un elemento dentro de figure
  $img = document.createElement("img"), // elemento img que nececita figure
  $figcaption = document.createElement("figcaption"), //elemento figcaption que nececita figure
  $figcaptionText = document.createTextNode("Animals"), //Nodo de texto para figcaption
  $cards = document.querySelector(".cards"), //Obtengo la card
  $figure2 = document.createElement("figure"); //Creo un elemento dentro de figure

//Seteo atributos de imagen
$img.setAttribute("src", "https://placeimg.com/200/200/animals");
$img.setAttribute("alt", "Animals");
//agregi la clase card a figure
$figure.classList.add("card");
//--Agrego los elementos al arbol del DOM--
$figcaption.appendChild($figcaptionText);
$figure.appendChild($img);
$figure.appendChild($figcaption);
$cards.appendChild($figure);
//agrego figure2 dinamicamente
$figure2.innerHTML = `
<img src="https://placeimg.com/200/200/people" alt="People">
<figcaption>People</figcaption>
`;
$figure2.classList.add("card"); //agregi a la ckase
$cards.appendChild($figure2); //agreo como hijo
//Forma 1 de agregar dinamicamente de uno en uno
const estaciones = ["Primavera", "Verano", "Otoño", "Invierno"],
  $ul = document.createElement("ul"); //creo estiqueta ul
document.write("<h3>Estaciones del Año</h3>"); //no es buena practica usar write
document.body.appendChild($ul); //agrego como hijo a body
estaciones.forEach((el) => { //agrego dinamicamente
  const $li = document.createElement("li"); //creo li
  $li.textContent = el; //seteo lo q va a tener li
  $ul.appendChild($li);//agrego como hijo
});

//Forma 2 de agregar dinamicamente concatenando(tecnica .innerHTML)
const continentes = ["África", "América", "Asia", "Europa", "Oceanía"],
  $ul2 = document.createElement("ul");
document.write("<h3>Continentes del Mundo</h3>");
document.body.appendChild($ul2);
$ul2.innerHTML = "";//importante inicilizar de esta forma para gregar dinamicamente a algo que ya este
continentes.forEach((el) => ($ul2.innerHTML += `<li>${el}</li>`));

//Forma 3 para agregar y renderizar varios elementos, 
//CREO FRAGMENTOS DINAMICOS que estan en memoria pero no directametne en el DOM y
//esto permite evitar a cada interacion pegar en el dom directamente, 
//sino q una vez terminado el fragmento se pega en el dom con UNA SOLA  INSERSION
const meses = [
    "Enero",
    "Febrero",
    "Marzo",
    "Abril",
    "Mayo",
    "Junio",
    "Julio",
    "Agosto",
    "Septiembre",
    "Octubre",
    "Noviembre",
    "Diciembre",
  ],
  $ul3 = document.createElement("ul"), //creo el ul para contener a los il
  $fragment = document.createDocumentFragment(); //CREO EL FRAGMENTO
meses.forEach((el) => {
  const $li = document.createElement("li"); //creo elemento il
  $li.textContent = el;
  $fragment.appendChild($li);//Agrego al fragmento
});
document.write("<h3>Meses del Año</h3>");
$ul3.appendChild($fragment); //AGREGO EL FRAGMETO AL DOM DIRECTAMENTE EN UNA SOLA INSERCION
document.body.appendChild($ul3); //agrego a body a ul3
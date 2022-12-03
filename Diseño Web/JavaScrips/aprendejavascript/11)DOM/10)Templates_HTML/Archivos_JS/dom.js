//Los Template no se RENDERIZAN en la pagina
/*Entonces para cuando quiera pintar en el DOM información DINAMICA debo hacer lo siguiente:
  1.Crear el template en Html
  2.Crear el Template en js
  3.Crear el fragme en js
  4.Ejecutar la función y/o el proceso y llevar al template y luego al fragme para después 
  pintarlo en el HTML.
*/
const $cards = document.querySelector(".cards"), //apunta a card
  $template = document.getElementById("template-card").content, //apunta a template(solo su contenido)
  $fragment = document.createDocumentFragment(),
  cardsContent = [
    {
      title: "Tecnología",
      img: "https://placeimg.com/200/200/tech",
    },
    {
      title: "Animales",
      img: "https://placeimg.com/200/200/animals",
    },
    {
      title: "Arquitectura",
      img: "https://placeimg.com/200/200/arch",
    },
    {
      title: "Gente",
      img: "https://placeimg.com/200/200/people",
    },
    {
      title: "Naturaleza",
      img: "https://placeimg.com/200/200/nature",
    },
  ];
cardsContent.forEach((el) => {
  $template.querySelector("img").setAttribute("src", el.img);
  $template.querySelector("img").setAttribute("alt", el.title);
  $template.querySelector("figcaption").textContent = el.title;
  let $clone = document.importNode($template, true); //clono nodo del template en el documento
  $fragment.appendChild($clone); //agrego al fragmento el template
});
$cards.appendChild($fragment);
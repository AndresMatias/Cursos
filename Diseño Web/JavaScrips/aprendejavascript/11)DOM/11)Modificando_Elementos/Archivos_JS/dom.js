const $cards = document.querySelector(".cards"),
  $newCard = document.createElement("figure"),
  $cloneCards = $cards.cloneNode(true);// true para clonar todo el contenido y no solo la estructura
$newCard.innerHTML = `
  <img src="https://placeimg.com/200/200/any" alt="Any">
  <figcaption>Any</figcaption>
`;
$newCard.classList.add("card");
//$cards.replaceChild($newCard, $cards.children[2]); //Reemplaza el elemento que se especifica en el segundo parametro por el elemento que se especifica en el primer parametro
//$cards.removeChild($cards.lastElementChild);
$cards.insertBefore($newCard, $cards.firstElementChild); //inserta el nuevo elemento antes del elemento que se espesifica en el 2do parametro
document.body.appendChild($cloneCards); 
//No es lo mismo nodos que elementos
const $cards = document.querySelector(".cards");
console.log($cards);
console.log($cards.children); //HIjos
console.log($cards.children[2]);
console.log($cards.parentElement); //Padre
console.log($cards.firstElementChild); //Primer hijo
console.log($cards.lastElementChild); //Ultimo hijo
console.log($cards.previousElementSibling); //hermano anterior
console.log($cards.nextElementSibling); //Hermano Posterior
console.log($cards.closest("div")); //busca el padre mas cercano del tipo de selector que le de
console.log($cards.closest("body"));
console.log($cards.children[3].closest("section"));
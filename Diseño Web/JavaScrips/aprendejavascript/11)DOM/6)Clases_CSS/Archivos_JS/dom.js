const $card = document.querySelector(".card"); //accedo a la clases card de css
console.log($card);
console.log($card.className); //devuelve nombre de la clase
console.log($card.classList);
console.log($card.classList.contains("rotate-45")); //devuelve true o false si contiene o no la clase
$card.classList.add("rotate-45"); //agergo la clases
console.log($card.classList.contains("rotate-45"));
console.log($card.className);
console.log($card.classList);
$card.classList.remove("rotate-45"); //remuevo la clase 
console.log($card.classList.contains("rotate-45"));
//classList.toggle()con el conjunto de argumentos de fuerza devuelve truecuando una clase se agrega con éxito
$card.classList.toggle("rotate-45"); //similar a agregar o quitar la clase
console.log($card.classList.contains("rotate-45"));
$card.classList.toggle("rotate-45");
console.log($card.classList.contains("rotate-45"));
$card.classList.toggle("rotate-45"); //similar a agregar o quitar la clase
$card.classList.replace("rotate-45", "rotate-135"); //reemplaza la clase rotate-45 por la rotate-135
$card.classList.add("opacity-80", "sepia"); //agrega a mas de una clase al mismo tiempo
$card.classList.remove("opacity-80", "sepia"); //idem pero quitar mas de una
$card.classList.toggle("opacity-80", "sepia"); //idem para mas de una clase
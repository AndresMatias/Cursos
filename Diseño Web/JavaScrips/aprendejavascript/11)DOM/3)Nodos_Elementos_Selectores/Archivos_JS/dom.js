//https://developer.mozilla.org/en-US/docs/Web/API/Node/nodeType
console.log(document.getElementsByTagName("li")); //Obtengo elementos con tag li
console.log(document.getElementsByClassName("card")); //obtengo elementos por nombr de clases
console.log(document.getElementsByName("nombre")); //Obtengo elmento por el nombre
console.log(document.getElementById("menu")); //obtengo por id
console.log(document.querySelector("#menu"));  //querySelector(consulta de selector) Recibe un selector valido de css, este metodo reemplaza a los primeros tres de la linea 2 a la 4 pero es mas lento
console.log(document.querySelector("a")); //busco por enlace
console.log(document.querySelectorAll("a")); //busco todos los selectores de este tipo
console.log(document.querySelectorAll("a").length); //busco el tamaño de todos los selectores de este tipo
document.querySelectorAll("a").forEach((el) => console.log(el)); //imprimo cada enlace 
console.log(document.querySelector(".card"));//trae la primer card
console.log(document.querySelectorAll(".card")); //todas las card
console.log(document.querySelectorAll(".card")[2]); //solo la 3er tarjeta
console.log(document.querySelector("#menu li"));
console.log(document.querySelectorAll("#menu li"));
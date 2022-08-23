console.log(document.documentElement.lang); //accedo a la propiedad de lenguaje
console.log(document.documentElement.getAttribute("lang")); //accedo a la propiedad de lenguaje aunque no siempre es asi
console.log(document.querySelector(".link-dom").href); //accedo a la propiedad de href pero aca me trae toda la url
console.log(document.querySelector(".link-dom").getAttribute("href")); //accedo a la propiedad de href aca solo me trae el atributo sin al url asi me cersioro
document.documentElement.lang = "en"; //cambio languaje
console.log(document.documentElement.lang);
document.documentElement.setAttribute("lang", "es-MX");
console.log(document.documentElement.lang);
const $linkDOM = document.querySelector(".link-dom"); //el signo de dolar no ahce referecia a jquery sino a q esa constante guarda elementos del dom
$linkDOM.setAttribute("target", "_blank");
$linkDOM.setAttribute("rel", "noopener"); //para seguridad de q no hay relacion entra la ventana q abro y la origen
$linkDOM.setAttribute("href", "https://youtube.com/jonmircha"); //seteo para q abra esta pagina el link de doom
console.log($linkDOM.hasAttribute("rel"));
$linkDOM.removeAttribute("rel");
console.log($linkDOM.hasAttribute("rel"));

//----Data-Attributes---- para estandar html5
console.log($linkDOM.getAttribute("data-description"));
console.log($linkDOM.dataset);
console.log($linkDOM.dataset.description);
$linkDOM.setAttribute("data-description", "Modelo de Objeto del Documento"); //modifico data-description
console.log($linkDOM.dataset.description);
$linkDOM.dataset.description = "Suscríbete a mi canal y comparte"; //modifico data-description
console.log($linkDOM.dataset.description);
console.log($linkDOM.hasAttribute("data-id")); //determino si existe el atributo data-id
$linkDOM.removeAttribute("data-id");
console.log($linkDOM.hasAttribute("data-id"));
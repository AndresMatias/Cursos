const $divsEventos = document.querySelectorAll(".eventos-flujo div"),
  $linkEventos = document.querySelector(".eventos-flujo a");
function flujoEventos(e) {
  console.log(
    `Hola te saluda ${this.className}, el click lo originó ${e.target.className}`
  );
  e.stopPropagation(); //detengo la propagacion
}
console.log($divsEventos);
$divsEventos.forEach((div) => {
  //Fase de burbuja
  div.addEventListener("click", flujoEventos);
  //div.addEventListener("click", flujoEventos, false);
  //Fase de captura
  //div.addEventListener("click", flujoEventos, true);
  //div.addEventListener("click", flujoEventos, {
    //capture: false,
    //once: true,
  //});
});
$linkEventos.addEventListener("click", (e) => {
  alert("Hola soy tu amigo y docente digital... Jonathan MirCha");
  e.preventDefault(); //cancela la accion por defecto que tenga el elemento
  e.stopPropagation();
});
/*
Si no se especifica el parámetro boolean, el valor por defecto es false.
  Si el boolean es falso se ejecuta la fase de burbuja (ir del elemento más interno al más externo <body>)
  Si el boolean es verdadero se ejecuta la fase de captura (ir del elemento más externo <body> al más interno)
*/
const $divsEventos = document.querySelectorAll(".eventos-flujo div");
function flujoEventos(e) {
  console.log(
    `Hola te saluda ${this.className}, el click lo originó ${e.target.className}`
  );
}
console.log($divsEventos);
$divsEventos.forEach((div) => {
  //--Fase de burbuja--
  //div.addEventListener("click", flujoEventos);
  //div.addEventListener("click", flujoEventos, false);

  //--Fase de captura--
  //div.addEventListener("click", flujoEventos, true);
  div.addEventListener("click", flujoEventos, {
    capture: false,
    once: true, //el evento solo que ejecuta una sola vez
  });
});
function flujoEventos(e) {
  console.log(
    `Hola te saluda ${this} el click lo originó ${e.target.className}`
  );
  //e.stopPropagation();
}
//De esta forma evito el tema de la propagacion
document.addEventListener("click", (e) => { //asigno el evento al documento  y con if determino a quien le hice click
  if (e.target.matches(".eventos-flujo div")) {
    flujoEventos(e);
  }
  if (e.target.matches(".eventos-flujo a")) {
    alert("Hola soy tu amigo y docente digital... Jonathan MirCha");
    e.preventDefault(); //esta linea evita el stoppropagation
    //e.stopPropagation();
  }
}); 
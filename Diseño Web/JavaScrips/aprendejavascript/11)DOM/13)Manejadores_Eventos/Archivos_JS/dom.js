/*
Los eventos son los mecanismos que tenemos en JavaScript para controlar las acciones del usuario y definir el comportamiento del documento en cierto momento o cuando se cumplan ciertas condiciones.
Las funciones que se ejecutan en un evento se llaman Event Handler (Manejador de Eventos).
https://developer.mozilla.org/en-US/docs/Web/Events
*/
function holaMundo() {
  alert("Hola Mundo");
  //console.log(event); //event ya no se usa
}
function saludar(nombre = "Desconocid@") {
  alert(`Hola ${nombre}`);
  //console.log(event);//event ya no se usa
}
const $eventoSemantico = document.getElementById("evento-semantico"),
  $eventoMultiple = document.getElementById("evento-multiple"),
  $eventoRemover = document.getElementById("evento-remover");
$eventoSemantico.onclick = holaMundo; //Sin parentesis pq en el momento si los pongo en el momento que se cargue esta linea se va a ejecutar la funcion
$eventoSemantico.onclick = function (e) { //arrown function pero reemplaza la funcion del evento de la linea anterior
  alert("Hola Mundo Manejador de Eventos Semántico");
  console.log(e);
  console.log(event);
};
 //addeventolistener me permite asignar multiples funciones al mismo evento sin reemplazarse entre si
$eventoMultiple.addEventListener("click", holaMundo);
$eventoMultiple.addEventListener("click", (e) => {
  alert("Hola Mundo Manejador de Eventos Múltiple");
  console.log(e);
  console.log(e.type);
  console.log(e.target);
  console.log(event);
});

//--Forma de pasar argumentos indirectamente a un evento ya que directamente no puedo hacerlo--
$eventoMultiple.addEventListener("click", () => { 
  saludar();
  saludar("Jon");
});

//--Remuevo el evento asociado--
const removerDobleClick = (e) => { 
  alert(`Removiendo el evento de tipo ${e.type}`);
  console.log(e);
  $eventoRemover.removeEventListener("dblclick", removerDobleClick); //no recibe arrow function, tiene que estar previamente declarada
  $eventoRemover.disabled = true; //desabilita el boton aparte del evento
};
$eventoRemover.addEventListener("dblclick", removerDobleClick);

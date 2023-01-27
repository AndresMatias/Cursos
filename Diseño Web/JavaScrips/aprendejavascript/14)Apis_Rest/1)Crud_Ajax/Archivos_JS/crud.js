/* **********     Curso JavaScript: 115. APIs REST: CRUD con AJAX (1/2) - #jonmircha     ********** */
/* **********     Curso JavaScript: 116. APIs REST: CRUD con AJAX (2/2) - #jonmircha     ********** */

const d = document,
  $table = d.querySelector(".crud-table"),
  $form = d.querySelector(".crud-form"),
  $title = d.querySelector(".crud-title"),
  $template = d.getElementById("crud-template").content, 
  $fragment = d.createDocumentFragment(); //Recordar que lo ideal es insertar por fragmentos

  /**
   * Metodo para incluir a ajax
   * @param {} options 
   */
const ajax = (options) => {
  let { url, method, success, error, data } = options; //Desestructuro Options en varias objetos(como si pasara por parametros un struct)
  const xhr = new XMLHttpRequest();

  xhr.addEventListener("readystatechange", e => {
    if (xhr.readyState !== 4) return;

    if (xhr.status >= 200 && xhr.status < 300) {
      let json = JSON.parse(xhr.responseText);
      success(json); //Esta funcion represeta la forma de agregar las cosas al html como en los primeros videos de ajax pero no se bien que hace o si es propio de js
    } else { //Si ocurre un error
      let message = xhr.statusText || "Ocurrió un error";
      error(`Error ${xhr.status}: ${message}`);
    }
  });

  xhr.open(method || "GET", url); //Lo que quiero decir es con el operador de cortocircuito: Si el parametro method viene vacio seguramente el usuario quiere acceder al metodo GET
  xhr.setRequestHeader("Content-type", "application/json; charset=utf-8"); //Agrego cabecera para indicar el tipo de contenido que va a tener la peticion, sin esto JSON SERVER  NO VA A FUNCIONAR
  xhr.send(JSON.stringify(data)); //Convierto a cadena de texto
}

/**
 * Metodo para obtener todos los datos de la bbdd de db.json en assests incluyendo la funcion ajax programada arriva
 */
const getAll = () => {
  ajax({
    url: "http://localhost:3000/santos",
    success: (res) => {
      console.log(res);

      res.forEach(el => {
        $template.querySelector(".name").textContent = el.nombre;
        $template.querySelector(".constellation").textContent = el.constelacion;
        $template.querySelector(".edit").dataset.id = el.id;
        $template.querySelector(".edit").dataset.name = el.nombre;
        $template.querySelector(".edit").dataset.constellation = el.constelacion;
        $template.querySelector(".delete").dataset.id = el.id;

        let $clone = d.importNode($template, true);
        $fragment.appendChild($clone); //Agrego todo al fragmento
      });

      $table.querySelector("tbody").appendChild($fragment); //Agrego el fragmento al html
    },
    error: (err) => { //Si hay un error
      console.log(err);
      $table.insertAdjacentHTML("afterend", `<p><b>${err}</b></p>`);
    }
  })
}

d.addEventListener("DOMContentLoaded", getAll);

d.addEventListener("submit", e => {
  if (e.target === $form) {
    e.preventDefault(); //prevengo comportamiento por defecto

    if (!e.target.id.value) { //Si no existe el valor lo crea
      //Create - POST
      ajax({
        url: "http://localhost:3000/santos",
        method: "POST",
        success: (res) => location.reload(), //Si la peticion es existosa recargo el navegador
        error: (err) => $form.insertAdjacentHTML("afterend", `<p><b>${err}</b></p>`), //Si la peticion no es exitosa inserto en html el error
        data: { //No incluyo id porque se genera solo
          nombre: e.target.nombre.value,
          constelacion: e.target.constelacion.value
        }
      });
    } else { //Si existe el valor lo actualiza
      //Update - PUT
      ajax({
        url: `http://localhost:3000/santos/${e.target.id.value}`,
        method: "PUT",
        success: (res) => location.reload(),
        error: (err) => $form.insertAdjacentHTML("afterend", `<p><b>${err}</b></p>`),
        data: {
          nombre: e.target.nombre.value,
          constelacion: e.target.constelacion.value
        }
      });
    }
  }
});

d.addEventListener("click", e => {
  if (e.target.matches(".edit")) { //Presiono boton editar
    $title.textContent = "Editar Santo";
    $form.nombre.value = e.target.dataset.name;
    $form.constelacion.value = e.target.dataset.constellation;
    $form.id.value = e.target.dataset.id;
  }

  if (e.target.matches(".delete")) { //Presiono boton eliminar
    let isDelete = confirm(`¿Estás seguro de eliminar el id ${e.target.dataset.id}?`);

    if (isDelete) {
      //Delete - DELETE
      ajax({
        url: `http://localhost:3000/santos/${e.target.dataset.id}`,
        method: "DELETE",
        success: (res) => location.reload(),
        error: (err) => alert(err)
      });
    }
  }
});
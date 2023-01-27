/* **********     Curso JavaScript: 117. APIs REST: CRUD con Fetch(1/2) - #jonmircha     ********** */
/* **********     Curso JavaScript: 118. APIs REST: CRUD con Fetch(2/2) - #jonmircha     ********** */
const d = document,
  $table = d.querySelector(".crud-table"),
  $form = d.querySelector(".crud-form"),
  $title = d.querySelector(".crud-title"),
  $template = d.getElementById("crud-template").content, 
  $fragment = d.createDocumentFragment(); //Recordar que lo ideal es insertar por fragmentos

  const getAll = async () => {
    try {
      let res = await fetch("http://localhost:3000/santos"), //Consulto toda la bbdd
        json = await res.json(); //Convierto formato json

      if (!res.ok) throw { status: res.status, statusText: res.statusText }; //Excepcion en caso de error

      console.log(json);
      json.forEach((el) => {
        $template.querySelector(".name").textContent = el.nombre;
        $template.querySelector(".constellation").textContent = el.constelacion;
        $template.querySelector(".edit").dataset.id = el.id;
        $template.querySelector(".edit").dataset.name = el.nombre;
        $template.querySelector(".edit").dataset.constellation = el.constelacion;
        $template.querySelector(".delete").dataset.id = el.id;

        let $clone = d.importNode($template, true);
        $fragment.appendChild($clone);
      });

      $table.querySelector("tbody").appendChild($fragment);
    } catch (err) { //En caso de error
      let message = err.statusText || "Ocurrió un error";
      $table.insertAdjacentHTML( //inserto html del error
        "afterend",
        `<p><b>Error ${err.status}: ${message}</b></p>`
      );
    }
  };

  d.addEventListener("DOMContentLoaded", getAll); //Obtengo todos los datos en el evento DOMContentLoaded

  d.addEventListener("submit", async (e) => { //La funcion debe ser asincrona por usar await
    if (e.target === $form) {
      e.preventDefault();

      if (!e.target.id.value) { //Si el id no existe lo creo
        //Create - POST
        try {
          let options = {
              method: "POST",
              headers: { //Agrego cabecera para indicar el tipo de contenido que va a tener la peticion, sin esto JSON SERVER  NO VA A FUNCIONAR
                "Content-type": "application/json; charset=utf-8",
              },
              body: JSON.stringify({ //No incluyo id porque se genera solo
                nombre: e.target.nombre.value,
                constelacion: e.target.constelacion.value,
              }),
            },
            res = await fetch("http://localhost:3000/santos", options),
            json = await res.json();

          if (!res.ok)
            throw { status: res.status, statusText: res.statusText };

          location.reload();  //Recargo pagina html y se vuelve a ejecutar el evento DOMContentLoad
        } catch (err) {
          let message = err.statusText || "Ocurrió un error";
          $form.insertAdjacentHTML(
            "afterend",
            `<p><b>Error ${err.status}: ${message}</b></p>`
          );
        }
      } else { //Si el id existe lo actualizó
        //Update - PUT
        try {
          let options = {
              method: "PUT",
              headers: {
                "Content-type": "application/json; charset=utf-8",
              },
              body: JSON.stringify({ //el id lo incluyo en await fetch
                nombre: e.target.nombre.value,
                constelacion: e.target.constelacion.value,
              }),
            },
            res = await fetch(
              `http://localhost:3000/santos/${e.target.id.value}`,
              options
            ),
            json = await res.json();

          if (!res.ok)
            throw { status: res.status, statusText: res.statusText };

          location.reload();  //Recargo pagina html y se vuelve a ejecutar el evento DOMContentLoad
        } catch (err) {
          let message = err.statusText || "Ocurrió un error";
          $form.insertAdjacentHTML(
            "afterend",
            `<p><b>Error ${err.status}: ${message}</b></p>`
          );
        }
      }
    }
  });

  d.addEventListener("click", async (e) => {
    if (e.target.matches(".edit")) {
      $title.textContent = "Editar Santo";
      $form.nombre.value = e.target.dataset.name;
      $form.constelacion.value = e.target.dataset.constellation;
      $form.id.value = e.target.dataset.id;
    }

    if (e.target.matches(".delete")) {
      let isDelete = confirm(
        `¿Estás seguro de eliminar el id ${e.target.dataset.id}?`
      );

      if (isDelete) {
        //Delete - DELETE
        try {
          let options = {
              method: "DELETE",
              headers: {
                "Content-type": "application/json; charset=utf-8",
              },
            },
            res = await fetch(
              `http://localhost:3000/santos/${e.target.dataset.id}`,
              options
            ),
            json = await res.json();

          if (!res.ok)
            throw { status: res.status, statusText: res.statusText };

          location.reload(); //Recargo pagina html y se vuelve a ejecutar el evento DOMContentLoad
        } catch (err) {
          let message = err.statusText || "Ocurrió un error";
          alert(`Error ${err.status}: ${message}`);
        }
      }
    }
  });
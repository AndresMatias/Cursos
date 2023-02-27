/**
 * Scrip para subir archivos
 */

const d = document,
      $main = d.querySelector("main"),
      $dropZone = d.querySelector(".drop-zone");

/**
 * Metodo con ajax para subir archivos seleccionados
 * @param {file} file Archivo que seleccione para subir
 */
const uploader = (file) => {
    console.log(file);
    const xhr = new XMLHttpRequest(),
     formData = new FormData(); //Para simular formulario de envio parseado
    formData.append("file",file);
    xhr.addEventListener("readystatechange", (e) => { //Pongo evento a la escucha
        if (xhr.readyState !== 4) return;
  
        if (xhr.status >= 200 && xhr.status < 300) {
          console.log(xhr.responseText);
        } else {
          let message =
            xhr.statusText ||
            "Error loading the file, verify that you are making the request by http or https";
            console.error(`Error ${xhr.statusText}: ${message}`);
        }
      });

    xhr.open("POST","assets/uploader.php");
    xhr.setRequestHeader("enc-type","multipart/form-data"); //para detectar aparte de cabeceras que se esta enviando archivos binarios
    xhr.send(formData);
}

/**
 * Metodo para crear y manejar la barra de progreso de cada archivo
 * @param {file} file 
*/
const progressUploader = (file) => {
  const $progress = d.createElement("progress"), //Creo etiqueta tipo progress
            $span = d.createElement("span"); //Creo etiqueta span 
         
  $progress.value = 0; //Valor inicial
  $progress.max = 100; //Valor maximo 
  
  //--Inserto barra de progreso y span--
  $main.insertAdjacentElement("beforeend",$progress);
  $main.insertAdjacentElement("beforeend",$span);

  const fileReader = new FileReader(); //Objeto para saber cuantos bits tengo que cargar
  fileReader.readAsDataURL(file); //Leo cuantos bit tengo que cargar...creo revisar
  //--Evento de progreso de carga--
  fileReader.addEventListener("progress", e =>{ 
    let progress = parseInt((e.loaded*100)/e.total); //regla de tres para pasar los bit que se van cargando a porcentaje
    $progress.value = progress;
    $span.innerHTML=`<b>${file.name} - ${progress}%`;
  });
  //--Evento de fin de carga--
  fileReader.addEventListener("loadend", e =>{
    uploader(file);
    setTimeout(() => { //Remuevo barras de progreso y valor de input file, luego de 3 segundos una vez que se completo la carga
      $main.removeChild($progress);
      $main.removeChild($span);
    },3000);
  });
}

$dropZone.addEventListener("dragover",e => { //Evento que se ejecuta  mientras tenga archvios sobre la zona de drag-zone
  e.preventDefault();
  e.stopPropagation(); //Elimino el evento de propagacion, revisar anteriores clases de porque esto es conveniente
  e.target.classList.add("is-active");
});

$dropZone.addEventListener("dragleave",e => { //Evento cuando salgo de la zona arrastable y soltable en este caso es la clase drag-zone
  e.target.classList.remove("is-active");
});

$dropZone.addEventListener("drop",e => { //Evento cuando suelto el archivo
  e.preventDefault();
  e.stopPropagation(); //Elimino el evento de propagacion, revisar anteriores clases de porque esto es conveniente
  const files=Array.from(e.dataTransfer.files); //dataTrasnfer sale de dropzone
  files.forEach(el => progressUploader(el));
  e.target.classList.remove("is-active"); //Una vez que suelto el archivo luego de que se sube el cuadro de subir vuelve a su estado original graficamente
});
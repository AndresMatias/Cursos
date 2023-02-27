/**
 * Scrip para subir archivos
 */

const   d = document,
    $main = d.querySelector("main"),
   $files = d.getElementById("files");

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
      $files.value="";
    },3000);
  });
}

d.addEventListener("change", e =>{
    if(e.target === $files){
        console.log(e.target.files);
        const files=Array.from(e.target.files); //convierto a array para poder tratarlo con un foreach
        //NO utilizar foreach directamente porque no sirve para este tipo de objetos, para eso convierto con Array.from
        files.forEach(el => progressUploader(el));
    }
});
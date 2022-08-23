const $whatIsDOM = document.getElementById("que-es"); //obtengo el id
let text = `
    <p>
      El Modelo de Objetos del Documento (<b><i>DOM - Document Object Model</i></b>) es un API para documentos HTML y XML.
    </p>
    <p>
      Éste proveé una representación estructural del documento, permitiendo modificar su contenido y presentación visual mediante código JS.
    </p>
    <p>
      <mark>El DOM no es parte de la especificación de JavaScript, es una API para los navegadores.</mark>
    </p>
  `;
//$whatIsDOM.innerText = text; //no forma parte del estandar y no reconoce las etiquetas html
$whatIsDOM.textContent = text; //no respeta las etiquetas html solo lo utilizo cuando necesito insertar texto
$whatIsDOM.innerHTML = text; //Respeta las etiquetas html, lo suma al elemento del dom ver codigo html para entender mejor y comentar la linea de abajo
$whatIsDOM.outerHTML = text; //Reemplaza el elemento del dom($whatIsDOM q contiene a id) por el contenido text
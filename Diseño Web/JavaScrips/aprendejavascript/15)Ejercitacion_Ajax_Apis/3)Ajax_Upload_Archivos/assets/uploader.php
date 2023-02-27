<?php
/**
 * Script en php para emular el servidor
 */
//echo "Hola, respuesta desde el servidor";
//var_dump($_FILES);

if(isset($_FILES["file"])) {
  $name = $_FILES["file"]["name"];
  $file = $_FILES["file"]["tmp_name"];
  $error = $_FILES["file"]["error"];
  $destination = "../files/$name"; //Carpeta de destono donde va a guardar los archivos
  $upload = move_uploaded_file($file, $destination);

  if($upload) { //Todo ok, se subio el archivo
    $res = array(
      "err" => false,
      "status" => http_response_code(200),
      "statusText" => "Archivo $name subido con éxito",
      "files" => $_FILES["file"]
    );
  } else { //Error
    $res = array(
      "err" => true,
      "status" => http_response_code(400),
      "statusText" => "Error al subir el archivo $name",
      "files" => $_FILES["file"]
    );
  }

  echo json_encode($res);
}
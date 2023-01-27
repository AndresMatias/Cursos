<?php
printf('Abriendo Archivo...<br>');
$fichero_url = fopen('archivo.txt', 'r'); //Abro Archivo

$texto = '';

while ( $trozo = fgets($fichero_url) ) { //Leo texto
    $texto .= $trozo;
}

printf($texto);

printf('<br>Haciendo otra cosa'); //Paso a otra cosa
?>
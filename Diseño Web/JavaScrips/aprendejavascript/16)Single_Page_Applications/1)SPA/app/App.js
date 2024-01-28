/*
    El nombre "App.js" esta escrito en UpperCamelCase porque esta forma de programar una spa se parece a react y se peude extrapolar
    se recomienda usar esta forma para estandarizacion y que se parezca a react
    Este archivo no esta en components porque si bien es un componente, es el componente PADRE por eso se pone afuera
*/

import api from "./helpers/wp_api.js" //Cuando hago un export default puedo poner el nombre que quiero en el import
import { ajax } from "./helpers/ajax.js";
import { Title } from "./components/Title.js";
import { Loader } from "./components/Loader.js";

export function App(){
    const d=document,
        $root=d.getElementById("root");
    
    $root.appendChild(Title()); //Agrego Titulo
    $root.appendChild(Loader()); //Agrego Loader
}
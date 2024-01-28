import express from "express";
import { resolve } from "path"; //Objeto para la respuesta

const app = express();

app.get("/", (req, res) => {
  res.set({ "content-type": "text/html; charset=utf-8" });
  res.end("<h1>Hola mundo desde Express.js con el método end</h1>"); //El metodo end es para enviar lo ultimo luego no puedo enviar nada mas en cambio con send si puedo
  //res.send("<h1>Hola mundo desde Express.js con el método send</h1>");
});

app.get("/json", (req, res) => {
  res.json({ //Envio un objeto que creo
    name: "Jon",
    age: 39,
    youtube: "@jonmircha",
  });
});

app.get("/archivo", (req, res) => { //Envio un archivo 
  res.sendFile(resolve("index.html"));
});

app.get("/plantilla", (req, res) => { //Envio una plantilla
  //No funciona esta ruta porque hay que especificar el motor de plantillas a express.js
  res.render("plantilla");
});

app.get("/jonmircha", (req, res) => {
  //res.send("<h1>Bienvenidos a jonmircha.com</h1>");
  res.redirect(301, "https://jonmircha.com"); //Redireccion
});

app.listen(3000, () =>
  console.log("Iniciando Express desde http://localhost:3000")
);

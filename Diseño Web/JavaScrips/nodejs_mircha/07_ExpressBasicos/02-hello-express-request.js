//Objeto para la peticion
import express from "express";

const app = express();

app.get("/", (req, res) => {
  res.end("<h1>Hola mundo desde Express.js</h1>"); 
});

app.get("/user/:id-:name-:age", (req, res) => { //ruta de usar y DINAMICAMENTE envio el id nombre y edad
  //http://localhost:3000/user/19-jonmircha-39    Ejemplo de como pasar valor por la url
  res.set({ "content-type": "text/html; charset=utf-8" }); //metodo set similar a writeHead de http/https
  res.end(`
    <h1>
      ${req.params.name}, bienvenidos a Express.js. Tu id es ${req.params.id} y tienes ${req.params.age} años.
    </h1> 
  `);//En el objeto "param" que ya trae el objeto req, se almacenan todos los parametros que envio por la url
});

app.get("/search", (req, res) => {
  //http://localhost:3000/search?id=19&name=Jon&age=39 para cambiar el valor de la variable en la url
  res.set({ "content-type": "text/html; charset=utf-8" });
  res.end(`
    <h1>
      ${req.query.name}, bienvenidos a Express.js. Tu id es ${req.query.id} y tienes ${req.query.age} años.
    </h1>
  `);
});

app.listen(3000, () =>
  console.log("Iniciando Express desde http://localhost:3000")
);

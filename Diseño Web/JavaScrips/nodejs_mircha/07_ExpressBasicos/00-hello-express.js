import express from "express";

const app = express();

app.get("/", (req, res) => { //Similar a trabajar con modulo http, obtengo la ruta y uso una callback
  res.end("<h1>Hola mundo desde Express.js</h1>"); //Envio codigo html al cliente
  console.log(req);
  console.log(res);
});

app.listen(3000, () =>
  console.log("Iniciando Express desde http://localhost:3000")
);

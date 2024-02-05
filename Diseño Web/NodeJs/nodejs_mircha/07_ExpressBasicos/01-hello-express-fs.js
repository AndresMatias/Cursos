import express from "express";
import { resolve } from "path";

const app = express();

app.get("/", (req, res) => {
  res.sendFile(resolve("index.html")); // con resolve accedo a al ruta donde tengo el archivo y sendFile envia el archivo que obtiene resolve
});

app.listen(3000, () =>
  console.log("Iniciando Express desde http://localhost:3000")
);

import { createServer } from "http";
import { get } from "https"; //utilizo el get de https porque dirige a un servidor con https
// Un snnifer es una pieza de codigo que me permite trackear y monitorear la informacion en una red
const hostname = "localhost", //Variable que le voy a pasar al cliente y va a decir donde voy a ejecutar el sniffer(info a la que va a apuntar el snnifer)
  port = 3000,
  options = {
    host: "jonmircha.com",
    port: 443,
    path: "/cursos",
  };

let htmlCode = "";

const httpClient = (res) => { //Si el sitio responde
  console.log(
    `El sitio ${options.host} ha respondido. Código: ${res.statusCode}. Mensaje: ${res.statusMessage}.`
  );

  res.on("data", (data) => { //Evento que se va a ejecutar cuando haya datos
    htmlCode += data;
    console.log(data, data.toString());
  });
};

const httpError = (err) => { //Para manejar el error
  console.error(
    `El sitio ${options.host} no ha respondido. Código: ${err.code}. Mensaje: ${err.message}.`
  );
};

const webServer = (req, res) => { //Informacion del servidor que voy a crear
  res.statusCode = 200;
  res.setHeader("Content-Type", "text/html; charset=utf-8");
  res.end(htmlCode);
};

//instancia cliente HTTP o HTTPs
get(options, httpClient).on("error", httpError);

//instancia servidor local HTTP
createServer(webServer).listen(port, hostname, () => {
  console.log(`Servidor corriendo en http://${hostname}:${port}/`);
});

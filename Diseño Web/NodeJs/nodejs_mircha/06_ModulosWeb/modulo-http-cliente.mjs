import { get } from "https"; //con get solicito informacion

const urlSite = {
  hostname: "jonmircha.com", //pagina de mircha
  port: 443,
  path: "/cursos", //seccion de la pagina que voy a visitar
};

get(urlSite, (res) => {
  console.log(
    `El sitio ${urlSite.hostname} ha respondido. Código: ${res.statusCode}. Mensaje: ${res.statusMessage}.`
  );
}).on("error", (err) => { //En caso de error
  console.error(
    `El sitio ${urlSite.hostname} no ha respondido. Código: ${err.code}. Mensaje: ${err.message}.`
  );
});

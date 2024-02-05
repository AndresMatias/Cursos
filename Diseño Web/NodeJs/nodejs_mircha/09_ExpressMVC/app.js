import express from "express";
import path from "path";
import cors from "cors";
import helmet from "helmet";
import morgan from "morgan";
import taskController from "./controllers/taskController.js";
import errorController from "./controllers/errorController.js";
//No hago improt de pug porqe express internamente lo hace cuando le indico la ruta mas abajo

const __dirname = path.dirname(new URL(import.meta.url).pathname); //Guardo el directorio de la aplicacion, __dirname es como un estandar se recomienda usar este nombre para el directorio de trabajo de la aplicacion
const app = express();
const port = 3000;

//--Configuro a los middleware que voy a usar--
app.use(cors());
app.use(helmet());
app.use(morgan("dev"));

//--Seteo el directorio de trabajo de las vistas y el motor de vistas
app.set("views", path.join(__dirname, "views")); //Une la variable __dirname(definida arriba mas la carpeta views)
app.set("view engine", "pug");

//--Configuro todo lo que va a usar del lado del cliente--
app.use(express.static(path.join(__dirname, "public")));
app.use(express.json()); //Soporte de parseo
app.use(express.urlencoded({ extended: false })); //Codificaciond de url, no se que  es extended

//--Configuro rutas a utilizar--
app.get("/", taskController.getAllTasks);
app.get("/add", taskController.getAddTaskForm);
app.post("/add", taskController.addTask);
app.get("/edit/:id", taskController.getEditTaskForm);
app.post("/edit/:id", taskController.editTask);
app.get("/complete/:id", taskController.completeTask);
app.get("/uncomplete/:id", taskController.uncompleteTask);
app.get("/delete/:id", taskController.deleteTask);

//Determino que middleware usar para manejar error de ruta--
app.use(errorController.error404);

app.listen(port, () => {
  console.log(`La aplicación está funcionando en http://localhost:${port}`);
});

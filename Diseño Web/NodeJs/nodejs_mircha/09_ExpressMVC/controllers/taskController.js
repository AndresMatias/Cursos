let tasks = [
  { id: 1, title: "Tarea 1", completed: false },
  { id: 2, title: "Tarea 2", completed: true },
];

/**
 * Metodo que me trae una tarea
 * @param {*} req peticion
 * @param {*} res respuesta
 */
const getAllTasks = (req, res) => {
  res.render("index", { title: "Lista de Tareas", tasks }); //Le paso al archivo index.pug la variable tittle y la pila de tareas
};

/**
 * Metodo que me trae el formulario para agregar tarea cuando presiono el boton de "agregar tarea"
 * @param {*} req 
 * @param {*} res 
 */
const getAddTaskForm = (req, res) => {
  res.render("add", { title: "Agregar Tarea" }); //Renderizo a add.pug, el .pug no hace falta indicarlo
};

/**
 *  Metodo para agregar tarea en nuestra bbdd
 * @param {*} req 
 * @param {*} res 
 */
const addTask = (req, res) => {
  //console.log(req.body);
  let { title } = req.body;
  let id = tasks.length + 1;
  tasks.push({ id, title, completed: false });
  res.redirect("/");
};


const getEditTaskForm = (req, res) => {
  let id = parseInt(req.params.id);
  let task = tasks.find((task) => task.id === id); //Si el id pasado se es igual al id de alguna task dicah task se almacena en task(confuso lose)
  //console.log(task);

  if (!task) {
    res.redirect("/");
  } else {
    res.render("edit", { title: "Editar Tarea", task }); //Renderizo la vista edit.pug(no hace falta incluir el .pug) para editar tareas
  }
};


/**
 * metodo que busca el indice de una tarea y modifica la tarea
 * @param {*} req 
 * @param {*} res 
 */
const editTask = (req, res) => {
  let id = parseInt(req.params.id);
  let taskIndex = tasks.findIndex((task) => task.id === id);
  //console.log(taskIndex);

  if (taskIndex === -1) {
    res.redirect("/");
  } else {
    tasks[taskIndex].title = req.body.title; //Edito el titulo de la tarea del vector tasks
    res.redirect("/");
  }
};

/**
 * Metodo para cambiar el estado de la tarea a completada
 * @param {*} req 
 * @param {*} res 
 */
const completeTask = (req, res) => {
  let id = parseInt(req.params.id);
  let task = tasks.find((task) => task.id === id);

  if (task) {
    task.completed = true;
  }

  res.redirect("/");
};

/**
 * Metodo para cambiar el estado de la tarea a incompletada
 * @param {*} req 
 * @param {*} res 
 */
const uncompleteTask = (req, res) => {
  let id = parseInt(req.params.id);
  let task = tasks.find((task) => task.id === id);

  if (task) {
    task.completed = false;
  }

  res.redirect("/");
};
/**
 * Metodo para eliminar una tarea
 * @param {*} req 
 * @param {*} res 
 */
const deleteTask = (req, res) => {
  let id = parseInt(req.params.id);
  tasks = tasks.filter((task) => task.id !== id); //Filtro para eliminar la tarea seleccionada
  res.redirect("/");
};

export default { //Si el nombre de la llave y valor son los mismo puedo poner un solo nombre en vez de los dos ej "getAllTasks: getAllTasks" pasaria a ser solo "getAllTasks" como esta abajo
  getAllTasks,
  getAddTaskForm,
  addTask,
  getEditTaskForm,
  editTask,
  completeTask,
  uncompleteTask,
  deleteTask,
};

/*
27) Programa una clase llamada Pelicula.

La clase recibirá un objeto al momento de instanciarse con los siguentes datos: id de la película en IMDB, titulo, director, año de estreno, país o países de origen, géneros y calificación en IMBD.
  - Todos los datos del objeto son obligatorios.
  - Valida que el id IMDB tenga 9 caracteres, los primeros 2 sean letras y los 
     7 restantes números.
  - Valida que el título no rebase los 100 caracteres.
  - Valida que el director no rebase los 50 caracteres.
  - Valida que el año de estreno sea un número entero de 4 dígitos.
  - Valida que el país o paises sea introducidos en forma de arreglo.
  - Valida que los géneros sean introducidos en forma de arreglo.
  - Valida que los géneros introducidos esten dentro de los géneros 
     aceptados*.
  - Crea un método estático que devuelva los géneros aceptados*.
  - Valida que la calificación sea un número entre 0 y 10 pudiendo ser 
    decimal de una posición.
  - Crea un método que devuelva toda la ficha técnica de la película.
  - Apartir de un arreglo con la información de 3 películas genera 3 
    instancias de la clase de forma automatizada e imprime la ficha técnica 
    de cada película.
*/

class Pelicula{
  /**
   * Esta clase valida datos de una pelicula y devuelve generos aceptados mas ficha tecnica de la pelicula
   * @param {String} id ID en formato formato IMDB
   * @param {String} titulo Titulo de la pelicula hasta 100 caracteres
   * @param {String} director Director de la pelicula hasta 50 caracteres
   * @param {Number} estreno Año de estreno en formato number
   * @param {Array String} origen Arreglo con el pais/paises de origen
   * @param {String} genero Genero de la peliculo en formato de cadena de texto
   * @param {Number} clasificacion Clasificacion del 1 al 10 en formato number
   */
  //----Constructor de la clase----
  constructor(id,titulo,director,estreno,origen,genero,clasificacion){ //Constructor de la clase
    //--Variables--
    this.id=id;
    this.titulo=titulo;
    this.director=director;
    this.estreno=estreno;
    this.origen=origen;
    this.genero=genero;
    this.clasificacion=clasificacion;

    //--Validaciones--
    this.validacionId(this.id);
    this.validarTituloDirector(this.titulo,100,'Titulo');
    this.validarTituloDirector(this.director,50,'Director');
  }
  //----Metodos----

  /**
   * Metodo que valida ID en formato IMDB
   * @param {String} Id a validar
   * @returns 
   */
  validacionId(id=undefined){
    
    let valor=undefined,expReg1=/^([a-z]){2}([0-9]){7}$/;
    if(typeof id ==='string' && id.length===9 && expReg1.test(id)){
      return 'ID validado Correctamente';      
    }else{
      return `Error en la validacion compruebue los siguientes parametros:
                -El id sea una cadena de texto
                -El id sea de 9 caracteres
                -Que los dos primeros caracteres sean numeros y el resto tipo letras`
    }
    return valor;
  }
  /**
   * 
   * @param {String} cadena 
   * @param {Number} nroCaracteres 
   * @param {String} destino 
   * @returns 
   */
  validarTituloDirector(cadena=undefined,nroCaracteres=undefined,destino=undefined){
    let valor=undefined;
    //No haga una validacion para nroCaracteres pq eso es en realidad una constante pero varia dentro de la propia clase
    if(typeof cadena ==='string' && cadena.length===nroCaracteres){
      return destino+' Validado Correctametne';      
    }else{
      return `Error en la validacion del ${destino} compruebe lo siguiente:
                    -Que sea una cadena de texto
                    -Dicha cadena debe ser menor a ${nroCaracteres} caracteres`;
    }
    return valor;
  }
  validarEstreno(estreno=undefined){
    if(typeof estreno!='number'){
      return 'No se ingreso nada o no se ingreso un numero' // Si no se ingreso cadena
    }else if(typeof estreno=='number' && estreno>=1000 && estreno<=9999){
      return 'Estreno Validado'
    }else{
        return 'El estreno no es de 4 digitos';
    }
    return undefined;
  }
  validarPais(paises=undefined){
    if(!(paises instanceof Array)){ //Uso instanceof pq con typeof lo determina como objeto solamente y se puede confundir con otros tipos
      return('No se ingreso un arreglo'); // Si no se ingreso cadena
    }else if(paises.length===0){
        return('Arreglo Vacio');
    }else if(paises.length!=0){
      for(let num of paises){ //Determino que todos los elementos del arreglo son tipo number y comparo con los generos aceptados
          if(typeof num!='string') return('No se ingreso un string');
          
      }
      return "Paises Aceptado"
    }else{
        return('Sucedio un error desconocido');
    }
    return valor;
  }
  validarGenero(generos=undefined){
    if(!(generos instanceof Array)){ //Uso instanceof pq con typeof lo determina como objeto solamente y se puede confundir con otros tipos
        return('No se ingreso un arreglo'); // Si no se ingreso cadena
    }else if(generos.length===0){
        return('Arreglo Vacio');
    }else if(generos.length!=0){
        for(let num of generos){ //Determino que todos los elementos del arreglo son tipo number y comparo con los generos aceptados
            if(typeof num!='string') return('No se ingreso un string');
            this.generosAceptados.includes(generos); //INVESTIGAR INCLUDES
        }
        //Creo Objeto con los valroes ascendentes y descendentes
        valor={Ascendente:nro.map(el => el).sort(),Descendente:nro.map(el => el).sort().reverse()};
    }else{
        return('Sucedio un error desconocido');
    }
    return valor;
  }
  validarCalificacion(calificación=undefined){
    if(typeof calificación!='number'){
      return 'No se ingreso nada o no se ingreso un numero' // Si no se ingreso cadena
    }else if(typeof calificación=='number' && calificación>=1000 && calificación<=9999){
      return 'Estreno Validado'
    }else{
        return 'El estreno no es de 4 digitos';
    }
    return undefined; 
  }
  static get generosAceptados(){ //Ver metodo estaticos
    return ['Comedia', 'Accion', 'Aventura','Romantico', 'Misterio'];
  }
  get fichaTecnica(){
    return {clasificacion:this.clasificacion,genero:this.genero,estreno:this.estreno,id:this.id,origen:this.origen,titulo:this.titulo};
  }
}
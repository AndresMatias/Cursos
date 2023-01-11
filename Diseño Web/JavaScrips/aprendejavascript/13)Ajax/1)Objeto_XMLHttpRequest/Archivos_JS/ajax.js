/**
 * Ejemplo metodo API XMLHttpRequest
 */
(()=>{
    const xhr = new XMLHttpRequest(),
         $xhr = document.getElementById("xhr"),
         $fragment = document.createDocumentFragment();

    xhr.addEventListener("readystatechange",e=>{ //Asigno Evento
        if(xhr.readyState!==4){
            return;
        }
        //console.log(xhr);
        if(xhr.status>=200 && xhr.status<300){ //Si el codigo se encuentra entre los codigo 200 a 300  es caso de exito
            //console.log("exito");
            //console.log(xhr.responseText);
            //$xhr.innerHTML=xhr.responseText;
            let json=JSON.parse(xhr.responseText); //Convierto a formato json
            json.forEach(el => {  //Inserto datos de nombre, mail y telefono del archivo json
                const $li=document.createElement("li");
                $li.innerHTML=`${el.name} -- ${el.email} -- ${el.phone}`;
                $fragment.appendChild($li);
            });
            $xhr.appendChild($fragment);
        }
        else{
            console.log("error");
            let message=xhr.statusText||"Ocurrio un error";
            $xhr.innerHTML=`Error${xhr.status}: ${message}`;
        }
        console.log("Este mensaje se mostrara de cualquier forma")
    });
    //xhr.open("GET","https://jsonplaceholder.typicode.com/users");
    xhr.open("GET","assests/user.json"); //Obtengo Recurso
    xhr.send(); //Envio y/o obtengo respuesta algo asi
})();

/**
 * Ejemplo metodo API fetch(mecanismo mas optimo para peticiones asincronas)
 */
(()=>{
    const   $fetch = document.getElementById("fetch"),
         $fragment = document.createDocumentFragment();

    fetch("assests/user.json")
    .then(res => {
        return res.ok ? res.json() : Promise.reject(res);  // res.ok ? res.json() : Promise.reject(res)   ===> SI(res.ok==True){ return res.json} else{ ejecuto el catch con  Promise.reject(res)}
    })
    .then((json) =>{ //Es como que hereda o toma el return de arriba
        //console.log(json);
        json.forEach(el => {  //Inserto datos de nombre, mail y telefono del archivo json
            const $li=document.createElement("li");
            $li.innerHTML=`${el.name} -- ${el.email} -- ${el.phone}`;
            $fragment.appendChild($li); //Se utiliza funciones autonomas autoejecutadas para que este fragment no entre en conflicto con el fragment de arriba
        });
        $fetch.appendChild($fragment); //Pego info procesada
    })
    .catch((err) =>{
        let message=err.statusText||"Ocurrio un error";
        $fetch.innerHTML=`Error${err.status}: ${message}`;
    })
    .finally(() =>{
        //console.log("Se ejecutara independientemente de la respuesta de fech")); //fetch mecanismo que trabaja con promesas video 47 del curso para repaso
    })
    
})();

/**
 * Ejemplo metodo API fetch(mecanismo mas optimo para peticiones asincronas) + await
 */
(()=>{
    const   $fetchAsync = document.getElementById("fetch-async"),
              $fragment = document.createDocumentFragment();
    
    async function getData(){
        try{
            let res=await fetch("assests/user.json"),
               json=await res.json();

               if(!res.ok){ //No puedo usar linea 47 con await por eso capturo el error de esta forma, ver porque
                //throw new Error("Ocurrio un error");
                throw {statusText:res.statusText};
               }
               json.forEach(el => {  //Inserto datos de nombre, mail y telefono del archivo json
                const $li=document.createElement("li");
                $li.innerHTML=`${el.name} -- ${el.email} -- ${el.phone}`;
                $fragment.appendChild($li); //Se utiliza funciones autonomas autoejecutadas para que este fragment no entre en conflicto con el fragment de arriba
            });
            $fetchAsync.appendChild($fragment); //Pego info procesada
        }
        catch(err){
            //console.log("Ocurrio un error", err)
            let message=err.statusText||"Ocurrio un error";
            $fetchAsync.innerHTML=`Error${err.status}: ${message}`;
        }
        finally{
            console.log("Estoy en el finally");
        } 
    }
    getData(); //funcion asincrona
})();

/**
 * Ejemplo metodo API Axios(Biblioteca externa a diferencia al los codigos anteriores que son nativos del navegador, basada en promesas)
 */
(()=>{
    const   $axios = document.getElementById("axios"),
         $fragment = document.createDocumentFragment();
    
    axios  //Axios ya me evita la manipulacion de error como en la linea 80
    .get("assests/user.json")
    .then(res=>{
        console.log(res);
        let json=res.data;
        json.forEach(el => {  //Inserto datos de nombre, mail y telefono del archivo json
            const $li=document.createElement("li");
            $li.innerHTML=`${el.name} -- ${el.email} -- ${el.phone}`;
            $fragment.appendChild($li); //Se utiliza funciones autonomas autoejecutadas para que este fragment no entre en conflicto con el fragment de arriba
        });
        $axios.appendChild($fragment); //Pego info procesada
    })
    .catch(err=>{
        console.log(err);
        console.log(err.response); //para manejos de errores personalisados usar esta linea en vez de err solo, con la LIBRERIA DE AXIOS
        let message=err.response.statusText||"Ocurrio un error";
        $axios.innerHTML=`Error${err.response.status}: ${message}`;
    })
    .finally(()=>{

    });
})();
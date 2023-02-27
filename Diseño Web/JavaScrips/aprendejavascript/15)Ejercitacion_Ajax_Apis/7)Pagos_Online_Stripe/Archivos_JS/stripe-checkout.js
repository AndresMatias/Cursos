/*
 *  Curso JavaScript: 129. Ejercicios AJAX - APIs: Pagos Online con Fetch y Stripe (1/4)
        https://www.youtube.com/watch?v=1PSFSsmqxgQ&list=PLvq-jIkSeTUZ6QgYYO3MwG9EMqC-KoLXA&index=138&ab_channel=jonmircha
 
 *  Curso JavaScript: 130. Ejercicios AJAX - APIs: Pagos Online con Fetch y Stripe (2/4)
        https://www.youtube.com/watch?v=FDNLAhZS5uM&list=PLvq-jIkSeTUZ6QgYYO3MwG9EMqC-KoLXA&index=135&ab_channel=jonmircha

 *  Curso JavaScript: 131. Ejercicios AJAX - APIs: Pagos Online con Fetch y Stripe (3/4) 
        https://www.youtube.com/watch?v=-2QOxlYkIxc&list=PLvq-jIkSeTUZ6QgYYO3MwG9EMqC-KoLXA&index=132&ab_channel=jonmircha
    
 *  Curso JavaScript: 132. Ejercicios AJAX - APIs: Pagos Online con Fetch y Stripe (4/4)
        https://www.youtube.com/watch?v=SI421AGqHNo&list=PLvq-jIkSeTUZ6QgYYO3MwG9EMqC-KoLXA&index=133&ab_channel=jonmircha
*/
import stripeKeys from "./stripe-keys.js";
import STRIPE_KEYS from "./stripe-keys.js"; //Cuando exporto por defecto puedo poner el nombre que se me de la gana y solo puedo hacer un export default por cada archivo

//--Variables--
const   d = document,
        $tacos = d.getElementById("tacos"),
        $template = d.getElementById("taco-template").content, //Lo que me interesa en un template es el contenido del mismo(content) y no la referencia a la etiqueta del template
        $fragment = d.createDocumentFragment(),
        fechOptions = {
            headers:{
            Authorization:`Bearer ${STRIPE_KEYS.secret}`, //Llave secreta para acceder a la api
            },         
        };
let prices,products;
/**
 * Metodo para darle el formato correcto al numero provisto por stripe 
 * @param {*} num numero provisto por stripe
 * @returns 
 */
const moneyFormat = num => `$${num.slice(0,-2)}.${num.slice(-2)}` //num.slice(0,-2): el 0 representa la posicion y el -2 quiere decir que remueva las ultimas dos posiciones del numero, esto es para darle formato al numero dado que stripe agrega dos ceros al final del numero como decimales pero no le pone una coma - num.slice(-2): Agrega los dos ultimos digitos del numero
/**
 * Accedo a productos y precios con dos fetch en un promise
 */
Promise.all([fetch("https://api.stripe.com/v1/products",fechOptions), //Promise.all va a esperar que responda cada endpoint antes de seguir al "then" de abajo, ademas van a responder en el orden que las programe, no importa si la primera peticion tarda mas que la segunda, la respeusta siempre es el orden que se programo
         fetch("https://api.stripe.com/v1/prices",fechOptions)])
.then((responses) => Promise.all(responses.map(res => res.json()))) //Por cada respuesta creo un nuevo arreglo con map es decir que voy a tener un vector y en cada posicion del vector va a haber otro vector, uno con los precios y otros con productos
.then(json => {
    products = json[0].data; //Extraigo los productos y los guardo en una variable aparte
    prices   = json[1].data; //Extraigo los precios y los guardo en una variable aparte
    /*console.log("//---------Objeto JSON con todos los arreglos juntos---------");
    console.log(json);
    console.log("\n");
    console.log("//---------Objeto JSON con el arreglo de productos por separado---------");
    console.log(products);
    console.log("\n");
    console.log("//---------Objeto JSON con el arreglo de precios por separado---------");
    console.log(prices);
    console.log("\n");*/

    //--Inserto en HTML--
    prices.forEach(el => {
        let productData = products.filter(product => product.id===el.product) //Por cada producto que traiga el arreglo products voy a compararlo con el product del elemento price, si es verdadero devuelvo los datos del producto
        $template.querySelector(".taco").setAttribute("data-price",el.id); //Le creo un nuevo atributo a la clase taco con el valor del id del elemento precio
        $template.querySelector("img").src=productData[0].images[0]; //en el soucer(src) de la imagen del template inserto la url de la imagen del producto
        $template.querySelector("img").alt=productData[0].name[0];
        $template.querySelector("figcaption").innerHTML=`
        ${productData[0].name}
        <br>
        ${moneyFormat(el.unit_amount_decimal)} ${el.currency}`
        let clone =  d.importNode($template,true); //Copio el template que cree en el html y el true quiere decir que quiero todo el nodo con todo lo que tiene internamente
        $fragment.appendChild(clone); //Agrego todas las copias en el fragmento
    });
    $tacos.appendChild($fragment);
})
.catch(err => {
    console.log(err);
    let message=err.statusText || "Ocurrio un error al conectarse con la API de Stripe";
    $tacos.innerHTML=`<p>Error ${err.status}: ${message}</p>`;
});

/**
 * Evento click que detecta cuando se hizo click sobre alguna tarjeta que contiene los precios con el item a vender
 */
d.addEventListener("click", e => {
       if(e.target.matches(".taco *")){ //.taco * Esto hace referencia a todo lo que contiene la clase taco porque si solo hago .taco, no me va a tomar el click correctamenta min 10:23 video 4/4
              let price = e.target.parentElement.getAttribute("data-price");
              Stripe(STRIPE_KEYS.public) //libreria stripe que devuelve una promesa 
              .redirectToCheckout({ //Redirije al formulario chekout de pago
                     lineItems:[{price,quantity:1}], //Arreglo con la cantidad de precios a pagar, en este caso solo es uno
                     mode:"subscription",
                     successUrl:"http://127.0.0.1:5500/15)Ejercitacion_Ajax_Apis/7)Pagos_Online_Stripe/assets/stripe-success.html", //Pagina en caso de exito
                     cancelUrl:"http://127.0.0.1:5500/15)Ejercitacion_Ajax_Apis/7)Pagos_Online_Stripe/assets/stripe-cancel.html",    //Pagina en caso de que se cancele el pago
              }) 
              .then(res => { 
                     if(res.err){ //En caso de error
                            $tacos.insertAdjacentHTML("afterend",res.err.message); //Inserto mensaje en el html en caso de error
                     }
              }); 
       }
});
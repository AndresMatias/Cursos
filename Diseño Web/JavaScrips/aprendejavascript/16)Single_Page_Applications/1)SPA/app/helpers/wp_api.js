/*
    Curso JavaScript: 146. SPA: Helper de conexión a API REST 
    https://www.youtube.com/watch?v=VUbKdpVQKDU&list=PLvq-jIkSeTUZ6QgYYO3MwG9EMqC-KoLXA&index=147&ab_channel=jonmircha
*/

const NAME="css-tricks",
    DOMAIN=`https://${NAME}.com`,
    SITE=`${DOMAIN}/wp-json`,
    API_WP=`${SITE}/wp/v2`,
    POSTS=`${API_WP}/posts?_embed`, //?embed: para que se traiga toda la informacion y no solo id
    POST=`${API_WP}/posts`, //La diferencia con el posts de arriba es que aca trae la informacion de manera sencilla(ver clases anteriores en donde usa la api de wordpress)
    SEARCH=`${API_WP}/search?_embed&search=`; //search= : Cuando el usuario introdusca datos de busqueda, search= los va a tomar y buscar eso que puso el usuario

export default{ ////Cuando hago un export default puedo poner el nombre que quiero en el import
    NAME, //name: NAME -> puedo evitar poner el name: siempre y cuando el nombre del parametro del objeto(NAME) sea igual al nombre donde esta guardado la variable(name) sean iguales, valido para EM6
    DOMAIN,
    SITE,
    API_WP,
    POSTS,
    POST,
    SEARCH
}
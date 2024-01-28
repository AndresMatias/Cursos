/**
 * 
 * @param {*} props Objeto de tres variables
 *                                  url: link a donde hacer la peticion ajax
 *                                  cbSuccess: callback en caso de que la peticion tenga exito
 */
export function ajax(props){
    let url,cbSuccess=props;
    fetch(url)
    .then(res => res.ok ? res.json():Promise.reject(res))
    .then(json => cbSuccess(json))
    .catch(err => {
        let message =err.statusText ||"Error en la peticion ajax";
            console.error(`Error ${err.statusText}: ${message}`);
            document.getElementById("root").innerHTML=`
            <div class="error">
                <p>Error ${err.status}: ${message}</p>
            </div>
            `;
    });
}
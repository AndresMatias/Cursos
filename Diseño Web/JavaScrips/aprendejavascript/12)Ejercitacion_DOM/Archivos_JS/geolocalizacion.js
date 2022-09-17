//----Variables y Constantes----
const d=document,
      w=window,
      n=navigator;

export function getGeoLocation(id){
    const $id=d.getElementById(id),
        options={
            enableHighAccuracy:true, //para que tome las mejores lecturas posibles
            timeout:5000,
            maximumAge:0, //ver q es    
        };
    
    const succes=(position)=>{
        let coords=position.coords //obtengo coordenadas
        $id.innerHTML=`
        <p>Tu posicion actual es:</p>
        <ul>
            <li>Latitud:<b>${coords.latitude}</b></li>
            <li>Longitud:<b>${coords.longitude}</b></li>
            <li>Precision:<b>${coords.accuracy}</b> metros</li>
        </ul>
        <a href="https://www.google.com/maps/@${coords.latitude},${coords.longitude},20z" target="_blank" rel="noopener">Ver en Google Maps</a>`
    }
    const error=(err)=>{
        $id.innerHTML=`<p><mark>Error ${err.code}: ${err.message}</mark></p>`
    }

    n.geolocation.getCurrentPosition(succes,error,options);
}
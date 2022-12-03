//----Variables y Constantes----
const d=document,
      w=window,
      n=navigator;
    
/**
 * Metodo para determinar y mostrar al usuario si se perdio o reestablecio la conexion a internet
 */      
export function networkStatus(){
    /**
     * Funcion flecha para determinar si hay o no conexion y en base agrega un div en el htlml para msotrar al usuario si hay o no conexion
     */
    const isOnline=()=>{
        const $div=d.createElement('div');
        if(n.onLine){ //Conexion establecida
            $div.textContent="Conexion Reestablecida";
            $div.classList.add('online');
            $div.classList.remove('offline');
        }else{//Conexion perdida
            $div.textContent="Conexion Perdida";
            $div.classList.remove('online');
            $div.classList.add('offline');
        }
        d.body.insertAdjacentElement("afterbegin",$div); //Inserto elementos para informar al usuario y luego de un tiempo la elimino
        setTimeout(() => {
            d.body.removeChild($div);
        }, 2000);
    };
    w.addEventListener('online',e=>{ //evento de conexion a internet
        isOnline();
    })
    w.addEventListener('offline',e=>{ //evento de desconexion a internet
        isOnline();
    })
}
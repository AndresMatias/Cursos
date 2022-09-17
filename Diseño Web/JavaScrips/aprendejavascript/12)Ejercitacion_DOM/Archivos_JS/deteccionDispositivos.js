//----Variables y Constantes----
const d=document,
      n=navigator,
      ua=n.userAgent;

export function userDeviceInfo(id){
    const $id=d.getElementById(id),
          isMobile={ //si me visitan de un telefono
            //--Validaciones--
            android:()=>ua.match(/android/i), 
            ios:()=>ua.match(/iphone|ipad|ipod/i),
            windows:()=>ua.match(/windows/i),
            any:function(){ //utilizo funcion anonima para que el this de abajo haga referencia al contexto de isMobile pq con arrow funtion hace referencia al contexto donde se creo isMobile
                return this.android()||this.ios()||this.windows();
            },
          },
          isDesktop={ //si me visitan de una oc
            linux:()=>ua.match(/linux/i), 
            mac:()=>ua.match(/mac os/i),
            windows:()=>ua.match(/windows nt/i),
            any:function(){ //utilizo funcion anonima para que el this de abajo haga referencia al contexto de isMobile pq con arrow funtion hace referencia al contexto donde se creo isMobile
                return this.linux()||this.mac()||this.windows();
            },
          },
          isBrowser={ //de que navegador me visitan
            chrome:()=>ua.match(/chrome/i), 
            safari:()=>ua.match(/safari/i),
            firefox:()=>ua.match(/firefox/i),
            opera:()=>ua.match(/opera|opera mini/i),
            edge:()=>ua.match(/msie|iemobile/i),
            ie:()=>ua.match(/firefox/i),
            any:function(){ //utilizo funcion anonima para que el this de abajo haga referencia al contexto de isMobile pq con arrow funtion hace referencia al contexto donde se creo isMobile
                return this.chrome()||this.safari()||this.firefox()||this.opera()||this.edge()||this.ie();
            },
          };
    $id.innerHTML=`
    <ul>
        <li>User Agent: <b>${ua}</b></li>
        <li>Plataforma: <b>${isMobile.any()?isMobile.any():isDesktop.any()}</b></il>
        <li>Navegador: <b>${isBrowser.any()}</b></li>
    </ul>`;

    if(isDesktop.windows()){ //y asi si solo quiero determinado contenido para diferentes SO
        //Contenido solo para windows en pc
    }
}
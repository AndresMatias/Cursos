console.log("********** Objeto URL (location) **********");
console.log(location);
console.log(location.origin); //donde se origino
console.log(location.protocol); //protocolo
console.log(location.host); 
console.log(location.hostname);
console.log(location.port); //puerto
console.log(location.href); //toda al url
console.log(location.hash); //detectar el valor de la url para hacer rutas amigables
console.log(location.search); //muestra parametros que se pasan por la url
console.log(location.pathname); //archivo que estoy consultando
//location.reload();
console.log("********** Objeto Historial (history) **********");
console.log(history); //historial
console.log(history.length); //nro de paginas que he visitado
//history.forward(1); //para ir hacia adelante
//history.go(-3); //para ir adelante o atras
//history.back(2); //para ir hacia atras
console.log("********** Objeto Navegador (navigator) **********");
console.log(navigator);
console.log(navigator.connection);
console.log(navigator.geolocation);
console.log(navigator.mediaDevices); //camaras microfonos etc
console.log(navigator.mimeTypes);
console.log(navigator.onLine); //detectar eventos de conexion o desconexion
console.log(navigator.serviceWorker); //Sirve para instalar como si fuera aplicacion de escritorio
console.log(navigator.storage); //api de almacenamiento
console.log(navigator.usb);
console.log(navigator.userAgent);//sobre q esta corriendo la pagina
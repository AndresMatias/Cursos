#fid=fopen('Nombre','Modo_Acceso') Modo_Acceso: Lectura o esccritura si fid=-1 el sisitema no es capaz de realizar fopen
#Modificadores para Modo_Acceso:
    #r=read, w=wirte (si el fichero ya existia, se pierden los datos), a=append (abre un fichero para escribir, añadiendo nuevos datos a los que ya existen y si no existe el fichero lo crea)
    #Existen modo de aperturas mixto pero no se recomienda
#fclose(fid) para cerrar fichero fid: identificador primera linea de comentario
#Escritura de ficheros: fpritf(fid,'Mensaje',var1,var2) en mensaje va %f %d \t \n para variables
#frewind(fid): Para volver a posicion inicial del fichero
#st=feof(fid): Devuelve un true o false true(1) si esta en el final del fichero
#fgetl: Lee una linea completa de un fichero
#fgets(fid): Lee un numero determinado de caracteres o una linea completa almacenandolos en una cadena de caracteres
#fgets(fid,n): Numero de caracteres
#[A,cont]=fscanf(fid,'formato',size): Lee datos de diferentes tipos segun las especificaciones del programador
#Ejemplo:No funciona ver proque
f=fopen('Texto.txt','r')
n=0
while 1
  Cadena=getl(f)
  if Cadena==-1
    break
  end
  n++
end
fpritf("Nro de Lineas %d",n)
fclose(f)
import sqlite3

#6 Pasos
#1)Abrir-Crear conexion
miConexion=sqlite3.connect("Mi base de datos")
#2)Creo puntero o cursor
miCursor=miConexion.cursor()
#3)Ejecuto instruccion sql

#---------------------Crea Tabla una sola vez sino error---------------------------------
#miCursor.execute("CREATE TABLE PRODUCTOS (NOMBRE_ARTICULO VARCHAR(50),PRECIO INTEGER,SECCION VARCHAR(20))") #creo

#-----------------------------------------Ejecuta una consulta para agregar un solo articulo---------------------
#miCursor.execute("INSERT INTO PRODUCTOS VALUES('BALON',15,'DEPORTES')") #VALUES(NOMBRE_ARTICULO ,PRECIO,SECCION) #inserto

#----------------------------Ejecuta una consulta para insertar varios artiulos al mismo tiempo---------------------------
# variosProductos=[("Camiseta",10,"DEPORTES"),
# 				("Jarron",10,"CERAMICA"),
# 				("Camion",10,"JUGUETERIA")]
# miCursor.executemany("INSERT INTO PRODUCTOS VALUES (?,?,?)",variosProductos)

#-----------------------------------Consulta para saber todos los campos de una tabla-------------------------
miCursor.execute("SELECT * FROM PRODUCTOS")
variosProductos=miCursor.fetchall() #Almaceno lista
for productos in variosProductos:
	print("Nombre articulo:",productos[0],"  Seccion:",productos[2])
#----------------------------------------------------------------------------------------------------	

miConexion.commit()#para verificar que se quiere hacer el cambio
#6)Cerrar Conexion
miConexion.close()
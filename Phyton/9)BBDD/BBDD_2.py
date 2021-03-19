import sqlite3

#Video 57
miConexion=sqlite3.connect("GestionProductos")
miCursor=miConexion.cursor()

#--------------------------------------Creacion de tabla una vez creado comento codigo---------------------------------
#PRIMARY KEY:Para campo clave para no repetir AUTOINCREMENT:Para que la clave primaria se incremente sola y me despeocupo minuto 8:40
#Tambien UNIQUE para que no se repita una clave pero que el campo no sea campo clave
# miCursor.execute('''
# 				CREATE TABLE PRODUCTOS(
# 				ID INTEGER PRIMARY KEY AUTOINCREMENT,  
# 				NOMBRE_ARTICULO VARCHAR(50) UNIQUE,
# 				PRECIO INTEGER,
# 				SECCION VARCHAR(40))''')	
# productos=[
#     ("pelota", 20, "jugeteria"),
#     ("pantalón", 15, "confección"),
#     ("destornillador", 25, "ferretería"),
#     ("jarrón", 45, "cerámica"),
#     ("pantalones", 35, "confección")
# ]
# miCursor.executemany("INSERT INTO PRODUCTOS VALUES(NULL,?, ?, ?)", productos) #NUll:para que la base gestione el id automaticamente
# miCursor.execute("INSERT INTO PRODUCTOS VALUES (NULL,'tren',15,'jugueteria')")
#-----------------------------------------------------------------------------------------------------
# miCursor.execute("SELECT * FROM PRODUCTOS WHERE SECCION='confección'")
# productos=miCursor.fetchall()
# print(productos)

# miCursor.execute("UPDATE PRODUCTOS SET PRECIO=35 WHERE NOMBRE_ARTICULO='pelota'")

#miCursor.execute("DELETE FROM PRODUCTOS WHERE ID=5") #NO OLVIDAR USAR WHERE PORQUE SINO BORRO TODO
#crud:create read update delete

miConexion.commit()
miConexion.close()
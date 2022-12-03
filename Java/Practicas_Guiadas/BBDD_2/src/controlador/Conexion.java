/*
 clase creada para establecer la conexion con la bbdd
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Andres
 */
public class Conexion {
    private Connection miConexion=null;
    public Conexion(){          
    }
    public Connection dameConexion(String datos[]){
        try {
            miConexion=DriverManager.getConnection(datos[0],datos[1],datos[2]); //datos[0]:Direccion de servidor datos[1]:usuario datos[2]:contraseña
        }catch (Exception e) {
            System.out.println("No conecta clase: Conexion");
        }
        return miConexion;
    }    
}
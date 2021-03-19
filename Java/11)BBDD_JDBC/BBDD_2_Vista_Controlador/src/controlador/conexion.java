/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Andres
 */
public class conexion {
    Connection miConexion=null;
    public conexion(){
        
        
    }
    public Connection dameConexion(){
        try {
            //Creo Conexion
            miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/pruebas","root","");
        } catch (Exception e) {
            System.out.println("No conecta clase: conexion");
        }
        return miConexion;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd_jdbc_1;

import java.sql.*;
public class BBDD_JDBC_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Crear Conexion -------------------------
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/pruebas","root","");
            //Crear Statement-------------------------
            Statement miStatement=miConexion.createStatement();
            //Ejecutar sql----------------------------
            ResultSet miResulset=miStatement.executeQuery("SELECT * FROM productos");
            //Recorrer ResultSet
            while(miResulset.next()){
                System.out.println(miResulset.getString("CÓDIGOARTÍCULO")+" "+miResulset.getString("SECCIÓN")+" "+miResulset.getString("PRECIO"));     
            }
        } 
        catch(Exception e){
            System.out.println("No conecta");
            e.printStackTrace();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd_jdbc_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Andres
 */
public class BBDD_JDBC_2 {

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
            String instruccionSql;
            //instruccionSql="INSERT INTO PRODUCTOS(CÓDIGOARTÍCULO,NOMBREARTÍCULO,PRECIO) VALUES('AR77','PANTALON','25.35')";
            //instruccionSql="UPDATE PRODUCTOS SET PRECIO=PRECIO*2 WHERE CÓDIGOARTÍC='AR77'"; //Actualizar precio
            instruccionSql="DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO='AR77'"; //Eliminar Articulo
            miStatement.executeUpdate(instruccionSql); //INSERTO
            
        } 
        catch(Exception e){
            System.out.println("No conecta");
            e.printStackTrace();
        }
    }
    
}

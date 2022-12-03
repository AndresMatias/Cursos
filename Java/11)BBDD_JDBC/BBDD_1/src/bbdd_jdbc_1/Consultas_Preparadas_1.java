/*
 * Video 205
 */
package bbdd_jdbc_1;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Andres
 */
public class Consultas_Preparadas_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Crear Conexion -------------------------
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/pruebas","root","");
            //Preparo Consulta
            PreparedStatement miSentencia=miConexion.prepareStatement("SELECT NOMBREARTÍCULO,SECCIÓN,PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?");
            //Establesco parametros-------------------------
            miSentencia.setString(1,"deportes");
            miSentencia.setString(2, "USA");
            //Ejecutar y recorrer consulta
            ResultSet rs=miSentencia.executeQuery();
            while(rs.next()){ //Mientras tenga un registro
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
            }
            rs.close();
        } 
        catch(Exception e){
            System.out.println("No conecta");
            e.printStackTrace();
        }
    }
    
}

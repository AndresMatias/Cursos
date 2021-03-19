/*el procedimiento se programa en la base de datos video 218
 */
package bbdd_jdbc_1;

import java.sql.*;
/**
 *
 * @author Andres
 */
public class BBDD_JDBC_3_Procedimientos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
          Class.forName("com.mysql.jdbc.Driver");
            //Crear Conexion -------------------------
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/curso_sql","root","");
            //Preparo Consulta llamando el pocedimiento
            CallableStatement miSentencia=miConexion.prepareCall("{call MUESTRA_CLIENTES}");
            //Ejecutar sql----------------------------
            ResultSet miResulset=miSentencia.executeQuery();
            //Recorrer ResultSet
            while(miResulset.next()){
                System.out.println(miResulset.getString(1)+" "+miResulset.getString(2)+" "+miResulset.getString(3));     
            }
            miResulset.close();
        } 
        catch(Exception e){
            System.out.println("No conecta");
            e.printStackTrace();
        }
    }
    
}

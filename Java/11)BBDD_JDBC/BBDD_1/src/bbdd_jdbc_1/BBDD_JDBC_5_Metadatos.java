/*
 Video 222
 */
package bbdd_jdbc_1;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class BBDD_JDBC_5_Metadatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection miConexion=null;
        try {
            //Creo Conexion
            miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/curso_java_sql_220", "root", "");
            //Obtengo Metadatos
            DatabaseMetaData datosBBDD=miConexion.getMetaData();
            //Muestro Informacion de metadatos
            System.out.println("Gestor de BBDD: " + datosBBDD.getDatabaseProductName());
            System.out.println("Version del gestor: " + datosBBDD.getDatabaseProductVersion());
            System.out.println("Nombre del driver: " + datosBBDD.getDriverName());
            System.out.println("Version del driver: " + datosBBDD.getDriverVersion());
        } catch (Exception e) {
            
        }finally{
            try {
                miConexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(BBDD_JDBC_5_Metadatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        mostrarInfo_Tabla();//Muestro informaciond de tablas
    }
  static void mostrarInfo_Tabla(){ //static pq esta dentro del main y este es static
      Connection miConexion=null;
      ResultSet rs=null;
        try {
            //Creo Conexion
            miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/curso_java_sql_220", "root", "");
            //Obtengo Metadatos
            DatabaseMetaData datosBBDD=miConexion.getMetaData();
            //Lista de tablas
            System.out.println("\nLista de tablas: " );
            rs=datosBBDD.getTables(null, null, null, null);
            while(rs.next()){
                System.out.println(rs.getString("TABLE_NAME")); //Nombre de tablas
            }
            //Lista de columnas de CLIENTES
            System.out.println("\nLista de clientes: " );
            rs=datosBBDD.getColumns(null, null, "clientes", null); //tercer parametro tambien peudo usar p% p muestra todo lo que empieza con p y lo mismo si cambio la p por otra letra
            while(rs.next()){
                System.out.println(rs.getString("COLUMN_NAME")); //Nombre de tablas
            }
        } catch (Exception e) {
            
        }finally{
            try {
                miConexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(BBDD_JDBC_5_Metadatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
  }  
}

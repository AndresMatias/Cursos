/*
 Clase creada para cargar inicialmente todas los nombre de tablas de una base de datos
 */
package modelo;
import controlador.Carga_Tablas;
import controlador.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
/**
 *
 * @author Andres
 */
public class Obtener_Tablas {
    private ResultSet rs=null;
    private DatabaseMetaData datosBBDD;
    private final Conexion Conectar;
    private Connection miConexion=null;
    private final JComboBox Tablas;
    private final Carga_Tablas misTablas;
    public Obtener_Tablas(JComboBox Tablas) {
        Conectar=new Conexion();//Inicializo
        this.Tablas=Tablas;
        misTablas=new Carga_Tablas(Tablas);
    }
    public void Info_Tablas(String datos[])
    {
        miConexion=Conectar.dameConexion(datos); //Genero Conexion
        try {
            datosBBDD=miConexion.getMetaData(); //Obtengo Metadatos
            rs=datosBBDD.getTables(null, null, null, null); //Obtengo tablas
            //Cargo Tablas
            while(rs.next()){
                misTablas.Carga_Info(rs.getString("TABLE_NAME")); //Cargo elementos de tabla     
            }
        } catch (SQLException ex) {
            Logger.getLogger(Obtener_Tablas.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error Clase: Obtener_Tablas");
        }
    } 
}

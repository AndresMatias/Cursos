/*
 clase creada para obtener todos los campos de la tabla seleccionada en el combobox
 */
package modelo;

import controlador.Conexion;
import controlador.Muestra_Info;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Andres
 */
public class Info_Tabla {
    private final ArrayList<String> campos; //Por alguna razon si lo declaro aca el arraylist se conserva pero nose porque asiq lo elimino al final del metodo aunque me convedria usar variables dentro de la clase
    private String consulta;
    private Statement ms;
    private ResultSet rs;
    private final Conexion Conectar;
    private Connection miConexion;
    private ResultSetMetaData rsBBDD; //Resulsute metadata
    private final Muestra_Info Mostrar;
    private final JTextArea Texto_Area;
    
    public Info_Tabla(JTextArea Texto_Area){
        //Inicializo variables
        campos=new ArrayList<String>();
        this.Texto_Area=Texto_Area;
        Conectar=new Conexion();
        Mostrar=new Muestra_Info();
    }
    public void ProcesarEncapsular(String elemento,String datos[]){
        consulta="SELECT * FROM "+elemento;
        miConexion=Conectar.dameConexion(datos);
        //ArrayList<String> campos=new ArrayList<String>();
        try {
            //Creo statenemt
            ms=miConexion.createStatement();
            //Ejecuto consulta
            rs=ms.executeQuery(consulta);
            //Obtengo metadatos con resulset metadata
            rsBBDD=rs.getMetaData();
            for (int i = 1; i <= rsBBDD.getColumnCount(); i++) { //getColumnCount(): devuelve cantidad de numero de columnas
                campos.add(rsBBDD.getColumnLabel(i)); //Almaceno nombre de de las columnas, getColumnLabel(): devuelve los nombres de las columnas  
            }
            Mostrar.Mostrar(Texto_Area, campos, rs); //Imprimo los datos en el area de texto
            campos.clear(); //Elimino array list
        } catch (Exception e) {
        }finally{
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Info_Tabla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import controlador.*;
import java.sql.*;
/**
 *
 * @author Andres
 */
public class CargaMenus {
    conexion miConecxion;
    public ResultSet rs,rs2; //Por cuestion de simplicidad las pongo en public pero no deberia
    private Statement secciones,secciones2;
    public CargaMenus() {
        miConecxion=new conexion();
    }
    public void ejecutaConsulta(){
        productos miProductos=null;
        Connection accesoBBDD=miConecxion.dameConexion();
        
        try {
            secciones=accesoBBDD.createStatement();
            secciones2=accesoBBDD.createStatement();
            rs=secciones.executeQuery("SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS");
            rs2=secciones2.executeQuery("SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS");
            //----Encapsulacion de datos----  nol o uso pero en programas grandes encapsulo datos para eso es
//            miProductos=new productos();
//            miProductos.setSeccion(rs.getString(1));
            //------------------------------------
           
        } 
        catch(Exception e){
            System.out.println("No Conecta clase: CargaMenus");
            System.err.println(e);
        }
    }
}

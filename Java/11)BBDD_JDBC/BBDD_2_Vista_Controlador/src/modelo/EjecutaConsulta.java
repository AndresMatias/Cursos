/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.conexion;
import java.sql.*;

/**
 *
 * @author Andres
 */
public class EjecutaConsulta {
    private conexion miConexion;
    private PreparedStatement miStatement;
    private ResultSet rs;
    private final String ConsultaSeccion="SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=?";
    private final String ConsultaPais="SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN=?";
    private final String ConsultaTodos="SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND"
                                                                                                                +" PAÍSDEORIGEN=?";

    public EjecutaConsulta() {
        miConexion=new conexion();
    }
    public ResultSet Filtrado(String seccion,String pais){
        Connection conecta=miConexion.dameConexion();    
        rs=null;
        try {
            if(!seccion.equals("Todos") && pais.equals("Todos"))
            {
                //Preparo consulta
                miStatement=conecta.prepareStatement(ConsultaSeccion);
                miStatement.setString(1, seccion);
                //Ejecuto consulta
                rs=miStatement.executeQuery();
            }
            else if(seccion.equals("Todos") && !pais.equals("Todos"))
            {
                //Preparo consulta
                miStatement=conecta.prepareStatement(ConsultaPais);
                miStatement.setString(1, pais);
                //Ejecuto consulta
                rs=miStatement.executeQuery();
            }
            else if(!seccion.equals("Todos") && !pais.equals("Todos"))
            {
                //Preparo consulta
                miStatement=conecta.prepareStatement(ConsultaTodos);
                miStatement.setString(1, seccion);
                miStatement.setString(2, pais);
                //Ejecuto consulta
                rs=miStatement.executeQuery();     
            }
            else{
                rs=null;
            }
        } catch (Exception e) {
        }
        return(rs);
    } 
    
}

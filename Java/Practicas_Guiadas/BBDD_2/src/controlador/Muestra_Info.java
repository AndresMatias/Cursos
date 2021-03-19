/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Andres
 */
public class Muestra_Info {

    public Muestra_Info() {
       
    }
    public void Mostrar(JTextArea Texto_Area,ArrayList<String> campos,ResultSet rs){
        Texto_Area.setText("");
        try {
            while(rs.next()){
                for(String nombreCampos:campos){
                    Texto_Area.append(rs.getString(nombreCampos)+" "); //Aca el error justo en esta linea, es como si conservara el array list
                }
                Texto_Area.append("\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Muestra_Info.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error Clase: Muestra_Info");
        }finally{
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Muestra_Info.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.*;
import java.sql.ResultSet;
import modelo.CargaMenus;
import vista.*;


/**
 *
 * @author Andres
 */
public class ControladorCargaMenus{
    CargaMenus obj=new CargaMenus();
    private Lamina2 elmarco;
    private ResultSet rs;
    
    public ControladorCargaMenus(Lamina2 elmarco) {
        this.elmarco=elmarco;
        cargaSecciones();
    }
    private void cargaSecciones(){
        obj.ejecutaConsulta();
        try {
            while(obj.rs.next()){
                elmarco.Combo1.addItem(obj.rs.getString(1));
            }
            while(obj.rs2.next()){
                elmarco.Combo2.addItem(obj.rs2.getString(1));
            }
            obj.rs.close();
            obj.rs2.close();
        } 
        catch(Exception a){
            System.out.println("No conecta clase: ControladorCargaMenus");
            a.printStackTrace();
        }
    }
}

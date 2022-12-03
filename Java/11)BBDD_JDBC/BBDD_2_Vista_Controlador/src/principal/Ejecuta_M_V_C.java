/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;
import vista.*;
/**
 M_V_C:Modelo vista controlador
 */
public class Ejecuta_M_V_C {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ventana2 mimarco=new Ventana2(); //Inicio salto a vista ventana2
        mimarco.setVisible(true); //Esta linea soluciona que no aparecia al final 
    }
    
}

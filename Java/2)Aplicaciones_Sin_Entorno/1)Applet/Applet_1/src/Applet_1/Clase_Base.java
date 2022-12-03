/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Applet_1;

import javax.swing.JApplet;
import javax.swing.JLabel;

/**
 *
 * @author Andres
 */
public class Clase_Base extends JApplet
{
    //En los applets reemplazo el metodo main por init
    //Clases de applet
    public void init()
    {
        JLabel Rotulo=new JLabel("Hola alumno");
        add(Rotulo);
    }
    /*public void start()
    {
        
    }
    public void stop()
    {
        
    }
    public void destroy()
    {
        
    }*/
}

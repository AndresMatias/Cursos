/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Applet_2;

import java.applet.Applet;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Andres
 */
public class Applet_2 extends Applet 
{
    public void init() 
    {
        JLabel Rotulo=new JLabel("Hola alumno",SwingConstants.CENTER); //Centrado
        add(Rotulo);
    }
}

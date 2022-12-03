/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import modelo.EjecutaConsulta;

/**
 *
 * @author Andres
 */
public class Ventana2 extends JFrame //Creo mi ventana JFrame biblioteca para graficas
{
    Lamina2 L_1; 
    int Ancho,Alto;
    Toolkit Monitor;
    Dimension Tamaño_Monitor;
   public Ventana2()
    {
     Configuracion();
    }
    public void Configuracion()
    {
        Monitor=Toolkit.getDefaultToolkit(); //Obetengo informancion de mi pantalla
        Tamaño_Monitor=Monitor.getScreenSize(); //Obtengo el tamaño de mi pantalla
        Ancho=Tamaño_Monitor.width; //Ancho de mi pantalla
        Alto=Tamaño_Monitor.height; //Alto de mi pantalla
        setVisible(true); //Para que la ventana sea visible
        setSize(Ancho/2,Alto/2); //Tamaño de mi ventana 
        setLocation(Ancho/4,Alto/4); //Localizacion donde aparecera mi ventana
        setTitle("Ventana Centrada"); //Nombre de mi ventana       
        //addWindowListener(new ControladorCargaMenus(L_1));//Aca lo toma pero abajo de L_1 no
        /*Aca esta el problema que no me reconoce la ventana despues de pasar L_1*/
        L_1=new Lamina2(Ancho,Alto);//Creo mi clase Lamina2
        add(L_1); //Añado mi lamina L_1 sobre el mi Ventana2
        ControladorCargaMenus CargaComboBox=new ControladorCargaMenus(L_1);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le digo a mi programa que pasa cuando cierro la ventana en este caso si cierro la ventana se acaba el programa
   }
}

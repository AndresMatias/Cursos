/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disposicion_spring_1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

/**
 *
 * @author Andres
 */
public class Disposicion_Spring_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Ventana Marco=new Ventana();
        Marco.Configuracion();
    }
    
}

class Ventana extends JFrame //Creo mi ventana JFrame biblioteca para graficas
{
    int Ancho,Alto;
    Lamina L_1;
    Toolkit Monitor;
    Dimension Tamaño_Monitor;
    public void Configuracion()
    {
        Monitor=Toolkit.getDefaultToolkit(); //Obetengo informancion de mi pantalla
        Tamaño_Monitor=Monitor.getScreenSize(); //Obtengo el tamaño de mi pantalla
        Ancho=Tamaño_Monitor.width; //Ancho de mi pantalla
        Alto=Tamaño_Monitor.height; //Alto de mi pantalla        
        setSize(Ancho/2,Alto/2); //Tamaño de mi ventana 
        setLocation(Ancho/4,Alto/4); //Localizacion donde aparecera mi ventana
        setTitle("Ventana Centrada"); //Nombre de mi ventana
        L_1=new Lamina();//Creo mi clase Lamina
        L_1.Configuracion(); //Configura mi Lamina
        add(L_1); //Añado mi lamina L_1 sobre el mi Ventana
        setVisible(true); //Para que la ventana sea visible
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le digo a mi programa que pasa cuando cierro la ventana en este caso si cierro la ventana se acaba el programa
   }
}

class Lamina extends JPanel 
{       
    
   // @SuppressWarnings("empty-statement") //Ver
    public void Configuracion()
    {
       //Variables
        JButton Boton_1=new JButton("Boton 1");
        JButton Boton_2=new JButton("Boton 2");
        JButton Boton_3=new JButton("Boton 3");
        SpringLayout Mi_Layout=new SpringLayout(); //Seteo Layout
        Spring Muelle=Spring.constant(0,10,100); //Muelle que va entre componentes
        
       //Configuraciones 
        setLayout(Mi_Layout); 
        add(Boton_1);
        add(Boton_2);
        add(Boton_3);
        //Mi_Layout.putConstraint(Borde del componente 1,componente1,spring(muelle) que se usa,Borde del componente 2(ancla),componente 2(ancla));
        Mi_Layout.putConstraint(SpringLayout.WEST,Boton_1, Muelle, SpringLayout.WEST, this);  //Uno Boton_1 con borde de layout
        Mi_Layout.putConstraint(SpringLayout.WEST,Boton_2, Muelle, SpringLayout.EAST, Boton_1); //Uno Boton_2 a Boton_1
        Mi_Layout.putConstraint(SpringLayout.WEST,Boton_3, Muelle, SpringLayout.EAST, Boton_2); //Uno Boton_3 a Boton_2
        Mi_Layout.putConstraint(SpringLayout.EAST,this, Muelle, SpringLayout.EAST, Boton_3); //Uno Boton_3 con borde de layout
    }
}
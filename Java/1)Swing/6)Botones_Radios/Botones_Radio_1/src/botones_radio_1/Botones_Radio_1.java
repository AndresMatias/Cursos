/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botones_radio_1;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.GroupBuilder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Andres
 */
public class Botones_Radio_1 
{
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

class Lamina extends JPanel //Lamina que va encima de mi ventana para empezar a dibujar
{     
    
    public void Configuracion()
    {
        //Declaracion de variables que uso solo en este metodo
        ButtonGroup Grupo_1=new ButtonGroup();
        ButtonGroup Grupo_2=new ButtonGroup();
        JRadioButton B1=new JRadioButton("Azul",false);
        JRadioButton B2=new JRadioButton("Rojo",true);
        JRadioButton B3=new JRadioButton("Verde",false);
        JRadioButton B4=new JRadioButton("Masculino",true);
        JRadioButton B5=new JRadioButton("Femenino",false);
        
        //Configuraciones, lo de grupo sirver para funcionen como un grupo y solo se seleccione uno
        Grupo_1.add(B1);
        Grupo_1.add(B2);
        Grupo_1.add(B3);
        Grupo_2.add(B4);
        Grupo_2.add(B5);
        
        //Agrego componentes a la lamina
        add(B1);
        add(B2);
        add(B3);
        add(B4);
        add(B5);
        
    }
    //Clase interna
    class Mi_Evento implements ActionListener //Puedo saltearme la clase si implemento el action lisneter en la lamina y cunado pongo a la escucho referencio con respecto a la lamina con el operador this
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            
        }
        
    }
}

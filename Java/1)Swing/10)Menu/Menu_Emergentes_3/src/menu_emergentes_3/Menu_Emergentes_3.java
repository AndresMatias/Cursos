/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu_emergentes_3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author Andres
 */
public class Menu_Emergentes_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le digo a mi programa que pasa cuando cierro la ventana en este caso si cierro la ventana se acaba el programa
        setVisible(true); //Para que la ventana sea visible
   }
}

class Lamina extends JPanel 
{       
   
    public void Configuracion()
    {
        setLayout(new BorderLayout()); 
       //Variables
        JPopupMenu Menu_Emergente=new JPopupMenu();
            JMenuItem O_1=new JMenuItem("Opcion 1");
            JMenuItem O_2=new JMenuItem("Opcion 2");
            JMenuItem O_3=new JMenuItem("Opcion 3");
            
       //Configuraciones
        Menu_Emergente.add(O_1);
        Menu_Emergente.add(O_2);
        Menu_Emergente.add(O_3);
        setComponentPopupMenu(Menu_Emergente); //Agrego el menu emergente a la lamina para que se muestre
        //add(Menu_Emergente); //Esta linea no aplica proque en cuanto hago click se selecciona toda la lamina y sol odeberia aparecer la pestaña ver porque
    }
}
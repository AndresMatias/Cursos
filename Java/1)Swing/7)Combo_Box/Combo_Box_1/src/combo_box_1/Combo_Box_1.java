/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combo_box_1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Andres
 */
public class Combo_Box_1 {

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
    private JLabel Texto;
    private JComboBox Mi_Combo;
    private JPanel Lamina_Norte;
    public void Configuracion()
    {
        //Seteo de Dispocision
        setLayout(new BorderLayout());
        //Declaracion y/e inicializacion de variables
        Texto = new JLabel("Hola");
        Mi_Combo=new JComboBox();
        Lamina_Norte=new JPanel();
        Evento_Combo Mi_Evento=new Evento_Combo();
        
        //Configuraciones
        Texto.setFont(new Font("Serif",Font.PLAIN,18));
        Mi_Combo.setEditable(true);
        
        //Agrego items a Mi_Combo
        Mi_Combo.addItem("Serif");
        Mi_Combo.addItem("SansSerif");
        Mi_Combo.addItem("Monospaced");
        Mi_Combo.addItem("Dialog");
              
        //Añado y pongo elementos a la escucha    
        Lamina_Norte.add(Mi_Combo);
        Mi_Combo.addActionListener(Mi_Evento);
        add(Texto,BorderLayout.CENTER);
        add(Lamina_Norte,BorderLayout.NORTH);
    }

    class Evento_Combo implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            //Ver video de casting
            //No funciona la parte de Dialog revisar
            Texto.setFont(new Font((String)Mi_Combo.getSelectedItem(),Font.PLAIN,18));
        }
        
    }
}
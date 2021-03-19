/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casillas_verificacion_1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Andres
 */
public class Casillas_Verificacion_1 {

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
    private JLabel Texto;
    private JCheckBox Check_1,Check_2;
    public void Configuracion()
    {
        //Declaracion de Variables que uso en este metodo
        JPanel Lamina_Texto=new JPanel();
        JPanel Lamina_Checks=new JPanel();
        Font Fuente=new Font("Serif", Font.PLAIN, 24); //Configuracion de fuente para el JLabel "Texto"
        Texto=new JLabel("Mi texto es:");
        Check_1=new JCheckBox("Negrita");
        Check_2=new JCheckBox("Cursiva");
        
        //Configuraciones de laminas
        setLayout(new BorderLayout());
        Texto.setFont(Fuente);
        
        //Agrego Componentes y pongo componentes a la escucha
        Check_1.addActionListener(new Maneja_Checks());
        Check_2.addActionListener(new Maneja_Checks());
        Lamina_Texto.add(Texto);
        Lamina_Checks.add(Check_1);
        Lamina_Checks.add(Check_2);
        add(Lamina_Texto,BorderLayout.CENTER);    
        add(Lamina_Checks,BorderLayout.SOUTH);
    }
    //Clase interna
    class Maneja_Checks implements ActionListener //Puedo saltearme la clase si implemento el action lisneter en la lamina y cunado pongo a la escucho referencio con respecto a la lamina con el operador this
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
           int tipo=0;
           if(Check_1.isSelected()) //Si Check_1 esta seleccionado
           {
               tipo=Font.BOLD;
               Texto.setFont(new Font("Serif", tipo, 24));
           }
           if(Check_2.isSelected()) //Si Check_2 esta seleccionado
           {
               tipo=Font.ITALIC;
           }
           Texto.setFont(new Font("Serif", tipo, 24));
        }   
    }
}

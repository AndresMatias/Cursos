/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disposicion_box_1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Andres
 */
public class Disposicion_Box_1 
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

class Lamina extends JPanel 
{       
    
   // @SuppressWarnings("empty-statement") //Ver
    public void Configuracion()
    {
        setLayout(new BorderLayout()); //BorderLayout rellena todo
       //Variables
        //Contenedor Global
        Box Caja_Vertical=Box.createVerticalBox();
        //Contenedor 1
        Box Caja_Horizontal_1=Box.createHorizontalBox(); //Creo Caja Horiontal
            JLabel Rotulo_1=new JLabel("Nombre");
            JTextField Texto_1=new JTextField(10);
        //Contenedor 2    
        Box Caja_Horizontal_2=Box.createHorizontalBox(); //Creo Caja Horiontal
            JLabel Rotulo_2=new JLabel("Contraseña");
            JTextField Texto_2=new JTextField(10);
        //Contenedor 3    
        Box Caja_Horizontal_3=Box.createHorizontalBox(); //Creo Caja Horiontal
            JButton Boton_1=new JButton("OK");
            JButton Boton_2=new JButton("Cancelar");
       
       //Configuraciones 
        Texto_1.setMaximumSize(Texto_1.getPreferredSize()); //Tamaño maximo esto evita problema a la hora de la redimencion por la disposicion box
        Texto_2.setMaximumSize(Texto_1.getPreferredSize()); //Tamaño maximo esto evita problema a la hora de la redimencion por la disposicion box
       
       //Agrego componentes
        Caja_Vertical.add(Caja_Horizontal_1);    
            Caja_Horizontal_1.add(Rotulo_1);
            Caja_Horizontal_1.add(Box.createHorizontalStrut(10)); //Creo un espacio entre un componente y otro
            Caja_Horizontal_1.add(Texto_1);
        Caja_Vertical.add(Caja_Horizontal_2);
            Caja_Horizontal_2.add(Rotulo_2);
            Caja_Horizontal_2.add(Box.createHorizontalStrut(10)); //Creo un espacio entre un componente y otro
            Caja_Horizontal_2.add(Texto_2);
        Caja_Vertical.add(Caja_Horizontal_3);  
            Caja_Horizontal_3.add(Boton_1);
            Caja_Horizontal_3.add(Box.createGlue()); //Redimensiona cuando agrando o achico el marco
            Caja_Horizontal_3.add(Boton_2);
        add(Caja_Vertical,BorderLayout.CENTER);
    }
}
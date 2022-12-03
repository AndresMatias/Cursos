/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jslider_2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Andres
 */
public class JSlider_2 {

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
    private JSlider Barra;
    private JLabel Texto;
    private static int Contador;
    public void Configuracion()
    {
        //Variables
        Barra=new JSlider(0,100,50);
        Texto=new JLabel("Hola");
        JPanel Lamina_Slider=new JPanel();
        Evento_Slider Mi_Evento=new Evento_Slider();
        //Configuraciones
        setLayout(new BorderLayout());
        Barra.setOrientation(SwingConstants.HORIZONTAL);
        Barra.setMajorTickSpacing(25); //Marcas largas
        Barra.setMinorTickSpacing(5);  //Marcas pequeñas
        Barra.setPaintTicks(true);     //Imprimir marcas
        Barra.setPaintLabels(true);    //Imprimir valor de marcas
        Barra.setFont(new Font("Serif", Font.ITALIC, 10)); //Seteo la fuente de la letra de la barra
        Barra.setSnapToTicks(true); //Cambia el comportamiento de la barre impidiendo que se quede en valores "inestables"(fuera de las marcas)
        Texto.setFont(new Font("Serif",Font.PLAIN,Barra.getValue()));
        
        //Añadir y escuchar componentes
        Barra.addChangeListener(Mi_Evento);
        Lamina_Slider.add(Barra);
        add(Lamina_Slider,BorderLayout.NORTH);
        add(Texto,BorderLayout.CENTER);
    }
    
    private class Evento_Slider implements ChangeListener
    {

        @Override
        public void stateChanged(ChangeEvent e) 
        {
            System.out.println("Esta manipulando la barra:"+Barra.getValue());
            Texto.setFont(new Font("Serif",Font.PLAIN,Barra.getValue()));
        }
        
    }
}

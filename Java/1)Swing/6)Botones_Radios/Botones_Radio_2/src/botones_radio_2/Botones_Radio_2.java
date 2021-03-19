/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botones_radio_2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Andres
 */
public class Botones_Radio_2 {

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
    private ButtonGroup Grupo_1=new ButtonGroup();
    private  JPanel Lamina_Botones=new JPanel();
    public void Configuracion()
    {
        setLayout(new BorderLayout());
        Texto=new JLabel("Texto de prueba");  
        Texto.setFont(new Font("Serif",Font.PLAIN,10));
        Colocar_Botones("Pequeño", true, 10);
        Colocar_Botones("Mediano", false, 12);
        Colocar_Botones("Grande", false, 14);
        Colocar_Botones("Muy Grande", false, 18);
        add(Texto,BorderLayout.CENTER);
        add(Lamina_Botones,BorderLayout.NORTH);
    }   
    public void Colocar_Botones(String Nombre,boolean Selec,int Tamaño)
    {
        JRadioButton Boton=new JRadioButton(Nombre, Selec); 
        Grupo_1.add(Boton);
        Lamina_Botones.add(Boton);
        ActionListener Mi_Evento=new ActionListener() //Estudiar esta parte luego
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Texto.setFont(new Font("Serif",Font.PLAIN,Tamaño));
                 
            }
        };
        Boton.addActionListener(Mi_Evento);
    }   
}
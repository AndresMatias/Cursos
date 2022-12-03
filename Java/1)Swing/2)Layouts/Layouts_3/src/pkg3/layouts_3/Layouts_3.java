/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3.layouts_3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *
 * @author Andres
 */
public class Layouts_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   Ventana Marco=new Ventana();  
    }
     
}

class Ventana extends JFrame //Creo mi ventana JFrame biblioteca para graficas
{
    Lamina L_1; 
    int Ancho,Alto;
    Toolkit Monitor;
    Dimension Tamaño_Monitor;
    Image Icono;
    Ventana()
    {
     Configuracion();
    }
    public void Configuracion()
    {
        Monitor=Toolkit.getDefaultToolkit(); //Obetengo informancion de mi pantalla
        Tamaño_Monitor=Monitor.getScreenSize(); //Obtengo el tamaño de mi pantalla
        Icono=Monitor.getImage("src/interfaz/imag.jpg"); //Obtenego el icono que voy a usar
        Ancho=Tamaño_Monitor.width; //Ancho de mi pantalla
        Alto=Tamaño_Monitor.height; //Alto de mi pantalla
        setVisible(true); //Para que la ventana sea visible
        setSize(Ancho/2,Alto/2); //Tamaño de mi ventana 
        setLocation(Ancho/4,Alto/4); //Localizacion donde aparecera mi ventana
        setTitle("Ventana Centrada"); //Nombre de mi ventana
        L_1=new Lamina(Ancho,Alto);//Creo mi clase Lamina   
        add(L_1); //Añado mi lamina L_1 sobre el mi Ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le digo a mi programa que pasa cuando cierro la ventana en este caso si cierro la ventana se acaba el programa
   }
}

class Lamina extends JPanel //Lamina que va encima de mi ventana para empezar a dibujar
{
    int Ancho,Alto;
    //Creo Botones
        JButton Boton_Azul=new JButton("Azul");
        JButton Boton_Rojo=new JButton("Rojo"); 
        JButton Boton_Amarillo=new JButton("Amarillo"); 
        JButton Boton_Verde=new JButton("Verde"); 
        JButton Boton_Negro=new JButton("Negro"); 
    
    Lamina(int Ancho_Aux,int Alto_Aux)
    {
        Ancho=Ancho_Aux;
        Alto=Alto_Aux;
        Configuracion();
    }
    public final void Configuracion()
    {
        GridLayout Disposicion=new GridLayout(3,3,50,50); //GridLayouts()
                                                    //GridLayouts(filas,columnas)
                                                    //GridLayouts(filas,columnas,separacion horizontal, separacion vertical)
        setLayout(Disposicion); //Seteo layout en L_1
        
        //Agrego Botones a la lamina y sete para que botones se ubiquen en North,West y East
            add(Boton_Azul,BorderLayout.NORTH);
            add(Boton_Rojo,BorderLayout.WEST);
            add(Boton_Amarillo,BorderLayout.EAST);
            add(Boton_Verde,BorderLayout.CENTER);
            add(Boton_Negro,BorderLayout.SOUTH);
        
        //Defino la clase "Mi_Color" para distintos colores
            Mi_Color Azul=new Mi_Color(Color.BLUE);
            Mi_Color Amarillo=new Mi_Color(Color.YELLOW);
            Mi_Color Rojo=new Mi_Color(Color.RED);
            Mi_Color Verde=new Mi_Color(Color.GREEN);
            Mi_Color Negro=new Mi_Color(Color.BLACK);
        
        //Referencio al objeto que va a escuchar
            Boton_Azul.addActionListener(Azul);
            Boton_Rojo.addActionListener(Rojo); 
            Boton_Amarillo.addActionListener(Amarillo); 
            Boton_Verde.addActionListener(Verde);
            Boton_Negro.addActionListener(Negro);
    }
         
    
 private class Mi_Color extends AbstractAction
    {
        Color Color_Boton;
        Mi_Color(Color C_Aux)
        {
            Color_Boton=C_Aux;
            Configuracion();
        }
        
        public void Configuracion()
        {
            //Guardo Informacion del objeto nombre, icono, descripcion y color de fondo
                putValue("Color_de_Fondo", Color_Boton);
        } 
        
        @Override
        public void actionPerformed(ActionEvent Evento_Color) 
        {
            Color C=(Color)getValue("Color_de_Fondo"); //Obtengo el color
            setBackground(C); //Setea color de fondo
            System.out.println("Nombre:"+getValue("Color_de_Fondo"));
        }

        
    }
}

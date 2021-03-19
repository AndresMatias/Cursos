/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barra_herramientas_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author Andres
 */
public class Barra_Herramientas_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
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
        Icono=Monitor.getImage("src/barra_herramientas_1/imag.jpg"); //Obtenego el icono que voy a usar
        Ancho=Tamaño_Monitor.width; //Ancho de mi pantalla
        Alto=Tamaño_Monitor.height; //Alto de mi pantalla
        setIconImage(Icono); //Le pongo un icono a mi programa
        setSize(Ancho/2,Alto/2); //Tamaño de mi ventana 
        setLocation(Ancho/4,Alto/4); //Localizacion donde aparecera mi ventana
        setTitle("Ventana Centrada"); //Nombre de mi ventana
        L_1=new Lamina(Ancho,Alto);//Creo mi clase Lamina
        add(L_1); //Añado mi lamina L_1 sobre el mi Ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le digo a mi programa que pasa cuando cierro la ventana en este caso si cierro la ventana se acaba el programa
        setVisible(true); //Para que la ventana sea visible
    }
}

class Lamina extends JPanel //Lamina que va encima de mi ventana para empezar a dibujar
{
    int Ancho,Alto;
    Lamina(int Ancho_Aux,int Alto_Aux)
    {
        Ancho=Ancho_Aux;
        Alto=Alto_Aux;
        Configuracion();
    }
    public final void Configuracion()
    {
        setLayout(new BorderLayout());
       //Variables 
        Action C_1=new Mi_Color("Amarillo",new ImageIcon("src/barra_herramientas_1/colors-icon.png"), Color.yellow);
        Action C_2=new Mi_Color("Azul",new ImageIcon("src/barra_herramientas_1/colors-icon.png"), Color.blue);
        Action C_3=new Mi_Color("Rojo",new ImageIcon("src/barra_herramientas_1/colors-icon.png"), Color.red);
        Action C_4=new AbstractAction("Salir",new ImageIcon("src/barra_herramientas_1/colors-icon.png")) 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        };
        JMenuBar Menu_Bar=new JMenuBar();
        JMenu Menu=new JMenu("Menu");
        JToolBar Barra_Herramientas=new JToolBar();
        
       //Configuraciones 
        Menu_Bar.add(Menu);
        Barra_Herramientas.add(C_1); //En Borderlayout tengo que indicar donde se ubica para que pueda ser arrastrada
        Barra_Herramientas.add(C_2);
        Barra_Herramientas.add(C_3);
        Barra_Herramientas.addSeparator();
        Barra_Herramientas.add(C_4);
        Menu.add(C_1);
        Menu.add(C_2);
        Menu.add(C_3);
        //Barra_Herramientas pisa a Menu bar si la pongo a las dos como North y viceversa dependiendo de a quien agregue primero a la lamina
        add(Menu_Bar,BorderLayout.NORTH); //Si la clase hereda de JFrame debo usar setJMenuBar() porque el add para barras de menu solo funciona con JPanel
        add(Barra_Herramientas,BorderLayout.SOUTH);
        
    }
         
    
    private class Mi_Color extends AbstractAction
    {
        String Nombre;
        Icon Icono;
        Color Color_Boton;
        Mi_Color(String Nombre_Aux,Icon Icono_Aux,Color Color_Boton_Aux)
        {
            Nombre=Nombre_Aux;
            Icono=Icono_Aux;
            Color_Boton=Color_Boton_Aux;
            Configuracion_1();
        }
        
        public void Configuracion_1()
        {
            //Guardo Informacion del objeto nombre, icono, descripcion y color de fondo
            putValue(Action.NAME, Nombre); 
            putValue(Action.SMALL_ICON, Icono);
            putValue(Action.SHORT_DESCRIPTION,"Poner la lamina de color " + Nombre);
            putValue("Color_de_Fondo", Color_Boton);
        } 
        
        @Override
        public void actionPerformed(ActionEvent Evento_Color) 
        {
            Color C=(Color)getValue("Color_de_Fondo");
            setBackground(C);
            System.out.println("Nombre:"+getValue(Action.NAME));
            System.out.println("Nombre:"+getValue("Color_de_Fondo"));
            System.out.println(getValue(Action.SHORT_DESCRIPTION));
        }      
    }
}
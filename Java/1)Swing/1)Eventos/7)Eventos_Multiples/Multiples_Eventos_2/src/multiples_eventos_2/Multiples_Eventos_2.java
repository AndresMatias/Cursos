/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiples_eventos_2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author Andres
 */
public class Multiples_Eventos_2 {

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
    Image Icono;
    public void Configuracion()
    {
        Monitor=Toolkit.getDefaultToolkit(); //Obetengo informancion de mi pantalla
        Tamaño_Monitor=Monitor.getScreenSize(); //Obtengo el tamaño de mi pantalla
        Icono=Monitor.getImage("src/multiples_eventos_2/imag.jpg"); //Obtenego el icono que voy a usar
        setIconImage(Icono); //Le pongo un icono a mi programa
        Ancho=Tamaño_Monitor.width; //Ancho de mi pantalla
        Alto=Tamaño_Monitor.height; //Alto de mi pantalla
        setVisible(true); //Para que la ventana sea visible
        setSize(Ancho/2,Alto/2); //Tamaño de mi ventana 
        setLocation(Ancho/4,Alto/4); //Localizacion donde aparecera mi ventana
        setTitle("Ventana Centrada"); //Nombre de mi ventana
        L_1=new Lamina();//Creo mi clase Lamina
        L_1.Configuracion(); //Configura mi Lamina
        add(L_1); //Añado mi lamina L_1 sobre el mi Ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le digo a mi programa que pasa cuando cierro la ventana en este caso si cierro la ventana se acaba el programa
   }
}

class Lamina extends JPanel //Lamina que va encima de mi ventana para empezar a dibujar
{    
    
    public void Configuracion()
    {
        
        //Si comento de la linea 71 a 77 si aprecen los botones apenas inicio el programa
        Mi_Color C_1=new Mi_Color("Amarillo",new ImageIcon("src/multiples_eventos_2/colors-icon.png"), Color.yellow);
        Mi_Color C_2=new Mi_Color("Azul",new ImageIcon("src/multiples_eventos_2/colors-icon.png"), Color.blue);
        Mi_Color C_3=new Mi_Color("Rojo",new ImageIcon("src/multiples_eventos_2/colors-icon.png"), Color.red);
        //Configuracion
        C_1.Configuracion();
        C_2.Configuracion();
        C_3.Configuracion();
       //Agregar botones
        add(new JButton(C_1));
        add(new JButton(C_2));
        add(new JButton(C_3));
        //Agregar botones de prueba
        add(new JButton("A"));
        add(new JButton("B"));
        add(new JButton("C"));
        
        InputMap Mapa_Entrada=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);//Creo Mapa de entrada
        ActionMap Mapa_Accion=getActionMap();//Creo mapa de accion para luego asignar objeto a la accion
                //Devuelve obejto del tipo InpuMmap:Vincula un evento con una combinacion de teclas       
        //Creo combinacion de teclas
        KeyStroke Tecla_Amarrillo=KeyStroke.getKeyStroke("ctrl A");//Creo la combinacion de teclas para amarillo
        KeyStroke Tecla_Azul=KeyStroke.getKeyStroke("ctrl B");//Creo la combinacion de teclas para azul
        KeyStroke Tecla_Rojo=KeyStroke.getKeyStroke("ctrl R");//Creo la combinacion de teclas para rojo
        //Para amarillo
        Mapa_Entrada.put(Tecla_Amarrillo, "Fondo Amarillo");//Asigno combinacion de teclas al objeto que corresponde
        Mapa_Accion.put("Fondo Amarillo", C_1);//Asigno objeto a la accion
        //Para azul
        Mapa_Entrada.put(Tecla_Azul, "Fondo Azul");//Asigno combinacion de teclas al objeto que corresponde
        Mapa_Accion.put("Fondo Azul", C_2);//Asigno objeto a la accion
        //Para rojo
        Mapa_Entrada.put(Tecla_Rojo, "Fondo Rojo");//Asigno combinacion de teclas al objeto que corresponde
        Mapa_Accion.put("Fondo Rojo", C_3);//Asigno objeto a la accion
        
    }
    class Mi_Color extends AbstractAction //Clase internar setBackground hereda
    {
        private String Nombre;
        private Icon Icono;
        private Color Color_Boton;
        Mi_Color(String Nombre_Aux,Icon Icono_Aux,java.awt.Color Color_Boton_Aux)
        {
            Nombre=Nombre_Aux;
            Icono=Icono_Aux;
            Color_Boton=Color_Boton_Aux;
        }
        public void Configuracion()
        {
            //Guardo Informacion del objeto nombre, icono, descripcion y color de fondo y pongo nombre etc a los botones
            putValue(Action.NAME, Nombre); //Agrega nombre a los botones
            putValue(Action.SMALL_ICON, Icono);//Agrega icono a los botones
            putValue(Action.SHORT_DESCRIPTION,"Poner la lamina de color " + Nombre);//Agrega descripcion a los botones cuando pongo el mouse sobre ellos
            putValue("Color_de_Fondo", Color_Boton);//Asigno el color a los botones
        } 
        @Override
        public void actionPerformed(ActionEvent Evento) 
        {
            Color C=(Color)getValue("Color_de_Fondo");
            setBackground(C);
            System.out.println("Nombre:"+getValue(Action.NAME));
            System.out.println("Nombre:"+getValue("Color_de_Fondo"));
            System.out.println(getValue(Action.SHORT_DESCRIPTION));
        }
    }
}
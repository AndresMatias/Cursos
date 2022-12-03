/*
 */
package multiples_eventos_1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *
 * @author Andres
 */
public class Multiples_Eventos_1 {

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
        Ancho=Tamaño_Monitor.width; //Ancho de mi pantalla
        Alto=Tamaño_Monitor.height; //Alto de mi pantalla    
        setSize(Ancho/2,Alto/2); //Tamaño de mi ventana 
        setLocation(Ancho/4,Alto/4); //Localizacion donde aparecera mi ventana
        setTitle("Ventana Centrada"); //Nombre de mi ventana
        L_1=new Lamina();//Creo mi clase Lamina
        L_1.Configuracion(); //Configura mi Lamina
        add(L_1); //Añado mi lamina L_1 sobre el mi Ventana
        setVisible(true); //Para que la ventana sea visible, lo agrego al ultimo porque sino la lamina no aparece
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le digo a mi programa que pasa cuando cierro la ventana en este caso si cierro la ventana se acaba el programa
   }
}

class Lamina extends JPanel //Lamina que va encima de mi ventana para empezar a dibujar
{    
    
    public void Configuracion()
    {
        
        //Si comento de la linea 71 a 77 si aprecen los botones apenas inicio el programa
        Mi_Color C_1=new Mi_Color("Amarillo",new ImageIcon("src/multiples_eventos_1/colors-icon.png"), Color.yellow);
        Mi_Color C_2=new Mi_Color("Azul",new ImageIcon("src/multiples_eventos_1/colors-icon.png"), Color.blue);
        Mi_Color C_3=new Mi_Color("Rojo",new ImageIcon("src/multiples_eventos_1/colors-icon.png"), Color.red);
        //Configuracion
        C_1.Configuracion();
        C_2.Configuracion();
        C_3.Configuracion();
       //Agregar botones
        add(new JButton(C_1));
        add(new JButton(C_2));
        add(new JButton(C_3));
        
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
            //Guardo Informacion del objeto nombre, icono, descripcion y color de fondo
            putValue(Action.NAME, Nombre); 
            putValue(Action.SMALL_ICON, Icono);
            putValue(Action.SHORT_DESCRIPTION,"Poner la lamina de color " + Nombre);
            putValue("Color_de_Fondo", Color_Boton);
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


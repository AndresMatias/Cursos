/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos_12_fuentes;

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
import javax.swing.JPanel;

/**
 *
 * @author Andres
 */
public class Eventos_12_Fuentes {

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
    Lamina(int Ancho_Aux,int Alto_Aux)
    {
        Ancho=Ancho_Aux;
        Alto=Alto_Aux;
        Configuracion();
    }
    public final void Configuracion()
    {
        Mi_Color C_1=new Mi_Color("Amarillo",new ImageIcon(), Color.yellow);
        Mi_Color C_2=new Mi_Color("Azul",new ImageIcon(), Color.blue);
        Mi_Color C_3=new Mi_Color("Rojo",new ImageIcon(), Color.red);
        
        
        add(new JButton(C_1));
        add(new JButton(C_2));
        add(new JButton(C_3));
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
            Configuracion();
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
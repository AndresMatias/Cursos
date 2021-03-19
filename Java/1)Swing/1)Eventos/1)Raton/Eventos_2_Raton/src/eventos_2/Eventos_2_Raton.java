/*
    Este programa implementa sobre una lamina las acciones de tres botones 
    mediante la implementacion de ActionListener(para eventos de raton).
 */
package eventos_2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *
 * @author Andres
 */
public class Eventos_2_Raton {

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
    Lamina L_1; 
    int Ancho,Alto;
    Toolkit Monitor;
    Dimension Tamaño_Monitor;
    Image Icono;
    Ventana()
    {
        
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
        setIconImage(Icono); //Le pongo un icono a mi programa
        setBackground(Color.yellow);
        L_1=new Lamina();//Creo mi clase Lamina
        add(L_1); //Añado mi lamina L_1 sobre el mi Ventana
        L_1.Configuracion();
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le digo a mi programa que pasa cuando cierro la ventana en este caso si cierro la ventana se acaba el programa
   }
}

class Lamina extends JPanel //Lamina que va encima de mi ventana para empezar a dibujar
{
    JButton Boton_Azul=new JButton("Azul"); //Creo un boton
    JButton Boton_Rojo=new JButton("Rojo"); //Creo un boton
    JButton Boton_Amarillo=new JButton("Amarillo"); //Creo un boton
    
    Lamina()
    {
        
    }
    public void Configuracion()
    {
        add(Boton_Azul);
        add(Boton_Rojo);
        add(Boton_Amarillo);
        Color_Fondo Azul=new Color_Fondo(Color.blue);
        Color_Fondo Amarillo=new Color_Fondo(Color.yellow);
        Color_Fondo Rojo=new Color_Fondo(Color.red);
        Boton_Azul.addActionListener(Azul); //Referencio al objeto que va a escuchar
        Boton_Rojo.addActionListener(Amarillo); //Referencio al objeto que va a escuchar
        Boton_Amarillo.addActionListener(Rojo); //Referencio al objeto que va a escuchar
    }
    private class Color_Fondo implements ActionListener //Clase Interna que Lamina reconoce como un metodo
    {
        Color Color_Fondo;
        Color_Fondo(Color C_Aux)
        {
            Color_Fondo=C_Aux;
        }
        @Override
        public void actionPerformed(ActionEvent Evento) //Metodo que dice que hacer cuando se recibe un evento
        {
            setBackground(Color_Fondo);
        }
    }
}


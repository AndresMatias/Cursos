/*
    Este programa implementa la clase WindowsListener a travez de WindowAdapter 
    evitando usar todas las funciones de WindowListener
 */
package eventos_4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Andres
 */
public class Eventos_4_Ventana 
{
    public static void main(String[] args) 
    {
       Ventana Marco=new Ventana();
       Marco.Configuracion();   
    }
    
}
class Ventana extends JFrame //Creo mi ventana JFrame biblioteca para graficas
{
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
        addWindowListener(new Mi_Ventana()); //Instancio directamente mi ventana y pongo mi ventana a la escucha
        setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
}
class Mi_Ventana extends WindowAdapter //COn windows adapter utilizo solo los metodos de WindowListener que me interesan windows adapter contiene 4 metodos o clases y uno de ellos es WindowListener
{
    Mi_Ventana()
    {
        
    }
    @Override
    public void windowIconified(WindowEvent e)  //Se invoca cuando una ventana cambia de un estado normal a uno minimizado.
    {
        
        System.out.println("Ventana Minimizada");
    }
    @Override
    public void windowDeiconified(WindowEvent e) //Se invoca cuando se la ventana pasa de un estado minimizado a un estado normal
    {
       
        System.out.println("Ventana Maximizada");
    }

}
 
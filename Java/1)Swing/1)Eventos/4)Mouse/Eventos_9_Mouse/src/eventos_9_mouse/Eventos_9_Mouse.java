/*
 Este programa implementa la clase MouseMotionListener que consta de dos metodos
 uno para indicar si se esta arrastrando algo con un click y otro para indicar 
 si el mouse solo se esta moviendo
 */
package eventos_9_mouse;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Andres
 */
public class Eventos_9_Mouse {

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
        Mi_Mouse Mouse=new Mi_Mouse();
        addMouseMotionListener(Mouse);//Agrego mi mouse a la mi marco
        setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
}

class Mi_Mouse implements MouseMotionListener
{
    Mi_Mouse()
    {
        
    }

    @Override
    public void mouseDragged(MouseEvent e)  //Se invoca cuando se esta arrastrando un elemento con el click
    {
        System.out.println("Arrastrando");
    }

    @Override
    public void mouseMoved(MouseEvent e) //Se invoca cuando el mouse se esta moviendo
    {
        System.out.println("Moviendo");
    }
    
}

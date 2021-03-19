/*
Este Programa implementa los cambios de estado(sin necesidad de saber cuales son)
de una ventana mediante la clase WindowStateListener y utiliza los metodos 
getnewstate y getoldstate que pertenecen a la clase WindowEvent y devuelven el 
esta nuevo y el estado viejo o anterior de la ventana
 */
package eventos_5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Andres
 */
public class Eventos_5_Ventana {

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
        addWindowStateListener(new Mi_Ventana()); //Instancio directamente mi ventana y pongo mi ventana a la escucha
        setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
}
class Mi_Ventana extends WindowAdapter //COn windows adapter utilizo solo los metodos de WindowListener que me interesan windows adapter contiene 4 metodos o clases y uno de ellos es WindowListener
{
    Mi_Ventana()
    {
        
    }
    @Override
    public void windowStateChanged(WindowEvent e) 
    {
        System.out.println("La ventana ha cambiado de estado");
        System.out.println("Estado anterior:"+e.getOldState()); //ver en la api que significa cada numero que vuelvue
        System.out.println("Nuevo estado:"+e.getNewState());
        if(e.getNewState()==6) //Ver api de WindowEvent para ver que valores deuvleve getNewState y getOldState
        {
            System.out.println("Pantalla Completa");
        }
        if(e.getNewState()==Frame.MAXIMIZED_BOTH) //Frame.MAXIMIZED_BOTH: es para no recordar que el numero 6 indica que se maximiza la ventana hace lo mismo que el if de arriva 
        {
            System.out.println("Pantalla Completa");
        }
         if(e.getNewState()==Frame.NORMAL) //Pantalla normal
         {
            System.out.println("Pantalla Normal");
        }
          if(e.getNewState()==Frame.ICONIFIED) //Pantalla minimizada
        {
            System.out.println("Pantalla Minizada");
        }
    }
    
}
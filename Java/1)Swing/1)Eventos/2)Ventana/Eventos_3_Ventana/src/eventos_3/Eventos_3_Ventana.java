/*
 Este programa implementa la clase WindowListener directamente con todas sus 
 funciones
 */
package eventos_3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Andres
 */
public class Eventos_3_Ventana 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       Ventana Marco=new Ventana();
       Ventana Marco_2=new Ventana();
       Marco.Configuracion();
       Marco.setDefaultCloseOperation(EXIT_ON_CLOSE); //Con EXIT_ON_CLOSE cierra todas las ventana
       Marco_2.Configuracion();
       Marco_2.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //COn DISPOSE_ON_CLOSE cierra solo el Marco_2
       Marco_2.setTitle("Ventana 2"); //Nombre de mi ventana
       Marco_2.setLocation(300,300); //Localizacion donde aparecera mi ventana
       
    }
    
}
class Ventana extends JFrame //Creo mi ventana JFrame biblioteca para graficas
{
    Mi_Ventana M_1;
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
        M_1=new Mi_Ventana(); //Instancio la clase M_1 la cual es mi ventana
        addWindowListener(M_1); //Pongo mi ventana a la escucha
   }
}
class Mi_Ventana implements WindowListener
{
    Mi_Ventana()
    {
        
    }

    @Override
    public void windowOpened(WindowEvent e) //Cuando la ventana esta abierta
    {
         System.out.println("Ventana Abierta");
    }

    @Override
    public void windowClosing(WindowEvent e) //Se invoca cuando la ventana se esta cerrando
    {
        System.out.println("Cerrando Ventana"); 
    }

    @Override
    public void windowClosed(WindowEvent e) //Se invoca cuando la ventana se cerro
    {
        System.out.println("Ventana Cerrada"); 
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

    @Override
    public void windowActivated(WindowEvent e) //Se invoca cuando una ventana se activa(deja de estar en segundo plano)
    {
        
        System.out.println("Ventana Activada");
    }

    @Override
    public void windowDeactivated(WindowEvent e) //Se invoca cuando una ventana se desactiva(pasa a estar en segundo plano o se minimiza)
    {
        
    }
}
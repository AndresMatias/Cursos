/*
 Este programa implementa la clase MouseListener la cual consta de 3 metodos
 ademas este programa indica la pocision del raton cuando se presiono y se 
 solto un click y que teclas del raton se presionarion y la cantidad de clicks
 que se hicieron
 */
package eventos_8_mouse;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Andres
 */
public class Eventos_8_Mouse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        addMouseListener(Mouse);//Agrego mi mouse a la mi marco
        setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
}

class Mi_Mouse extends MouseAdapter
{
    Mi_Mouse()
    {
        
    }
    @Override
    public void mouseClicked(MouseEvent Evento_Mouse) //Se invoca cuando se presiona y se suelta un boton del mouse
    {
        System.out.println("Coordena X: "+Evento_Mouse.getX()+"\nCoordenada Y: "+Evento_Mouse.getY()); //Devuelve coordenadas del mouse
        System.out.println("Numero de Clicks Hechos: "+Evento_Mouse.getClickCount()); //Devuelve el numero de clicks hechos
    }

    @Override
    public void mousePressed(MouseEvent Evento_Mouse) 
    {
        System.out.println(Evento_Mouse.getModifiersEx()); //Me devuelve el valor del evento del click derecho izquierdo o de la rueda del raton
        if(Evento_Mouse.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK) //Evento_Mouse.BUTTON1_DOWN_MASK puedo usar esto en vez de 1024
        {
            System.out.println("Presionaste el click izquierdo");
        }
        if(Evento_Mouse.getModifiersEx()==MouseEvent.BUTTON2_DOWN_MASK) //Evento_Mouse.BUTTON2_DOWN_MASK puedo usar esto en vez de 2048
        {
            System.out.println("Presionaste la rueda del raton");
        }
        if(Evento_Mouse.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK) //Evento_Mouse.BUTTON3_DOWN_MASK puedo usar esto en vez de 4096
        {
            System.out.println("Presionaste el click derecho");
        }
    }
    
}

//ctrl+shift+c para comentar y descomentar bloques etc
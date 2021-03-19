/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos_7_mouse;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Andres
 */
public class Eventos_7_Mouse {

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
        addMouseListener(Mouse);//Agrego mi mouse a la mi marco
        setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
}

class Mi_Mouse implements MouseListener //Puedo Implementar MouseAdapter para no usar todos los metodos
{
    Mi_Mouse()
    {
        
    }
    @Override
    public void mouseClicked(MouseEvent Evento_Mouse) //Se invoca cuando se presiona y se suelta un boton del mouse
    {
        System.out.println("Hiciste y Soltaste el Click");
    }

    @Override
    public void mousePressed(MouseEvent Evento_Mouse) //Se invoca cuando se presiona un boton del mouse
    {
        System.out.println("Hiciste Click");
    }

    @Override
    public void mouseReleased(MouseEvent Evento_Mouse) //Se invoca cuando se suelta un boton del mouse
    {
        System.out.println("Soltaste el Click");
    }

    @Override
    public void mouseEntered(MouseEvent Evento_Mouse) //Se invoca cuando el mouse entra en un boton o pasa por encima de un componente
    {
        System.out.println("Pasaste por encima de un componente");
    }

    @Override
    public void mouseExited(MouseEvent Evento_Mouse) //Se invoca cuando sale fuera de un componente
    {
        System.out.println("Saliste fuera del componente");
    }
    
}
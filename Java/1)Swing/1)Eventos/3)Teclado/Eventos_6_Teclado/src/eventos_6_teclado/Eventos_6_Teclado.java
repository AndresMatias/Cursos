/*
    Este programa utilizar la clase KeyListener para captar eventos de teclado
 */
package eventos_6_teclado;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Andres
 */
public class Eventos_6_Teclado {

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
        Mi_Teclado Teclado=new Mi_Teclado(); //Instacion mi clase que detecta eventos de teclado
        addKeyListener(Teclado); //Agrego mi teclado al mi marco
        setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
}

class Mi_Teclado implements KeyListener //Puedo usar KeyAdapter para no usar todas las funciones
{
    int Codigo=0;
    char Letra;
    Mi_Teclado()
    {
        
    }

    @Override
    public void keyTyped(KeyEvent Evento_Teclado) //Cuando se presiono y se solto una tecla
    {
        Letra=Evento_Teclado.getKeyChar();
        System.out.println("Tecla que se presiono y se solto: "+Letra);
    }

    @Override
    public void keyPressed(KeyEvent Evento_Teclado) //Cuando se esta presionando una tecla
    {
        Codigo=Evento_Teclado.getKeyCode(); //Almaceno el codigo de la tecla presionada
        System.out.println("Codigo de tecla que se esta presionando: "+Codigo); //Muestra el valor del codigo de la tecla presionada
    }

    @Override
    public void keyReleased(KeyEvent Evento_Teclado) //Cuando se dejo de presionar una tecla
    {
        
    }
    
}
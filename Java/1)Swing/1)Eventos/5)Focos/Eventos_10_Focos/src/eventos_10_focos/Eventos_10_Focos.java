/*
 Ejemplo simple de ganancia o perdida de un foco por un cuadro de texto.
 */
package eventos_10_focos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Andres
 */
public class Eventos_10_Focos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       Ventana Marco=new Ventana();
       //Marco.Configuracion();   
    }
    
}
final class Ventana extends JFrame //Creo mi ventana JFrame biblioteca para graficas
{
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
        setIconImage(Icono); //Le pongo un icono a mi programa
        //setBackground(Color.WHITE);  
        Lamina L_1=new Lamina(Ancho,Alto);
        add(L_1);//Añado mi lamina      
        setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
}
class Lamina extends JPanel //Lamina que va encima de mi ventana para empezar a dibujar
{
    int Ancho,Alto;
    JTextField Cuadro_1,Cuadro_2;
    Lamina(int Ancho_Aux,int Alto_Aux)
    {
        Ancho=Ancho_Aux;
        Alto=Alto_Aux;
    }
    @Override
    protected void paintComponent(Graphics Graficos) //Metodo heredeado y sobreescrito de la clase JComponent
    {
        super.paintComponents(Graficos); //Esto es para que haga el trabajo que tiene programado en clase JComponent ademas de hacer lo que yo pido abajo
        setLayout(null); //Puedo mover mis componentes sin que esten fijos
        Cuadro_1=new JTextField();
        Cuadro_2=new JTextField();
        Cuadro_1.setBounds(120, 10, 150, 20); //Ubico y le doy tamaño ami cuadro de texto
        Cuadro_2.setBounds(120, 40, 150, 20); //Ubico y le doy tamaño ami cuadro de texto
        add(Cuadro_1); //Agrego Cuadro_1 a mi lamina
        add(Cuadro_2); //Agrego Cuadro_2 a mi lamina
        Mi_Foco Foco=new Mi_Foco();
        Cuadro_1.addFocusListener(Foco);//Agrego mi foco a la mi marco con Cuadro_1
    }
    
    private class Mi_Foco implements FocusListener
    {
        Mi_Foco()
        {

        }
        @Override
        public void focusGained(FocusEvent Evento_Foco) 
        {
             System.out.println("Ganaste el foco");
        }

        @Override
        public void focusLost(FocusEvent Evento_Foco) 
        {
            System.out.println("Perdiste el foco");
        }
    }
}

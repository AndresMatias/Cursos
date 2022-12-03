/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos_texto_1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

/**
 *
 * @author Andres
 */
public class Eventos_Texto_1 {

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
    Lamina L_1;
    Toolkit Monitor;
    Dimension Tamaño_Monitor;
    Image Icono;
    public void Configuracion()
    {
        Monitor=Toolkit.getDefaultToolkit(); //Obetengo informancion de mi pantalla
        Tamaño_Monitor=Monitor.getScreenSize(); //Obtengo el tamaño de mi pantalla
        Ancho=Tamaño_Monitor.width; //Ancho de mi pantalla
        Alto=Tamaño_Monitor.height; //Alto de mi pantalla
        setSize(Ancho/2,Alto/2); //Tamaño de mi ventana 
        setLocation(Ancho/4,Alto/4); //Localizacion donde aparecera mi ventana
        setTitle("Ventana Centrada"); //Nombre de mi ventana
        L_1=new Lamina();//Creo mi clase Lamina
        L_1.Configuracion(); //Configura mi Lamina
        add(L_1); //Añado mi lamina L_1 sobre el mi Ventana
        setVisible(true); //Para que la ventana sea visible, tengo que poenrlo al final porq sino la lamina no aparece en primera instancia
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le digo a mi programa que pasa cuando cierro la ventana en este caso si cierro la ventana se acaba el programa
   }
}

class Lamina extends JPanel //Lamina que va encima de mi ventana para empezar a dibujar
{     
    private JTextField Campo_1; //Declaro mi campo donde voy a escribir
    private JButton Boton;
    private Mi_Evento_Texto Evento_Texto;
    private JLabel Mi_Texto,Resultado; //JLabel clase que maneja "etiquetas"(texto)
    private Document Mi_Documento;
    public void Configuracion()
    {
        Campo_1=new JTextField("",20);
        Evento_Texto=new Mi_Evento_Texto();//Creo clase
        Mi_Documento=Campo_1.getDocument();//Creo mi documento 
        Mi_Documento.addDocumentListener(Evento_Texto);//Pongo a la escucha a mi documento
        add(Campo_1);
        
    }
    //Clase interna
    class Mi_Evento_Texto implements DocumentListener //Puedo saltearme la clase si implemento el action lisneter en la lamina y cunado pongo a la escucho referencio con respecto a la lamina con el operador this
    {

        @Override
        public void insertUpdate(DocumentEvent e) //Se dispara si se inserta texto nuevo
        {
            System.out.println("Has insertado texto");
        }

        @Override
        public void removeUpdate(DocumentEvent e) //Se dispara si se modifica texto
        {
            System.out.println("Has borrado texto");
        }

        @Override
        public void changedUpdate(DocumentEvent e) //Se dispara si modifican propiedasdes del texto(tipo de letra,fuentes, etc)
        {
            System.out.println("Has modificado alguna propiedad del texto");
        }
        
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos_texto_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Andres
 */
public class Eventos_Texto_2 {

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
    //Declaro variables que se van a usar en toda la clase
    private JPasswordField Contraseña;
    public void Configuracion()
    {
        //Declaracion de Variables que solo voy a usar en este metodo
        JPanel Lamina_Superior=new JPanel();
        JLabel Etiqueta_1=new JLabel("Usuario");
        JLabel Etiqueta_2=new JLabel("Contraseña");
        JTextField Usuario=new JTextField(15);
        Contraseña=new JPasswordField(15);
        JButton Boton=new JButton("Enviar");
        Comprueba_Contraseña Comprobar=new Comprueba_Contraseña();
        
        //Configuracion de laminas
        setLayout(new BorderLayout());//Seteo la disposicion de mi lamina principal
        Lamina_Superior.setLayout(new GridLayout(2,2));//Seteo la disposicion de mi Lamina_Superior
        add(Lamina_Superior,BorderLayout.NORTH);//Agrego Lamnina_Superior en la parte norte de la lamina principal
        
        //Agrego Componentes y pongo a la escucha componentes
        Lamina_Superior.add(Etiqueta_1);
        Lamina_Superior.add(Usuario);
        Lamina_Superior.add(Etiqueta_2);
        Lamina_Superior.add(Contraseña);
        add(Boton,BorderLayout.SOUTH);
        Contraseña.getDocument().addDocumentListener(Comprobar); //Asi evito crear un objeto tipo Documento(Document)
    }
    //Clase interna
    class Comprueba_Contraseña implements DocumentListener //Puedo saltearme la clase si implemento el action lisneter en la lamina y cunado pongo a la escucho referencio con respecto a la lamina con el operador this
    {

        @Override
        public void insertUpdate(DocumentEvent e) //Se dispara si se inserta texto nuevo
        {
            Codigo_Reciclado();
        }

        @Override
        public void removeUpdate(DocumentEvent e) //Se dispara si se modifica texto
        {
            Codigo_Reciclado();
        }

        @Override
        public void changedUpdate(DocumentEvent e) //Se dispara si modifican propiedasdes del texto(tipo de letra,fuentes, etc)
        {
            
        }
        
        public void Codigo_Reciclado()
        {
            char []Contraseña_Aux;
            Contraseña_Aux=Contraseña.getPassword();
            if(Contraseña_Aux.length<8)
            {
                Contraseña.setBackground(Color.red);
            }
            else
            {
                Contraseña.setBackground(Color.BLUE);
            }
        }
        
    }
}

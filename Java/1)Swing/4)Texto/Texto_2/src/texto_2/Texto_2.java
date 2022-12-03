/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texto_2;

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

/**
 *
 * @author Andres
 */
public class Texto_2 {

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
        setVisible(true); //Para que la ventana sea visible
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le digo a mi programa que pasa cuando cierro la ventana en este caso si cierro la ventana se acaba el programa
   }
}

class Lamina extends JPanel //Lamina que va encima de mi ventana para empezar a dibujar
{     
    private JTextField Campo_1; //Declaro mi campo donde voy a escribir
    private JButton Boton;
    private Mi_Evento Evento;
    private JLabel Mi_Texto,Resultado; //JLabel clase que maneja "etiquetas"(texto)
    public void Configuracion()
    {
        setLayout(new BorderLayout()); //Seteo a a la lamina en borderlayout
        JPanel Mi_Lamina_2=new JPanel();//Creo una segunda lamina solo para orientar componentes
        Mi_Lamina_2.setLayout(new FlowLayout());
        Campo_1=new JTextField("Texto por defecto",20); //JTextoField tiene sobrecarga de constructores
        Boton=new JButton("Mostrar en Consola");
        Evento=new Mi_Evento();
        Mi_Texto=new JLabel("Email: ");
        Resultado=new JLabel("",JLabel.CENTER); //Se alinea en el centro, sin o lo alineo aparece al costado proque la zona del costado no tiene nada y esta plegada
        Boton.addActionListener(Evento); //Pongo boton a la escucha
        Mi_Lamina_2.add(Mi_Texto);//Agrego en Mi_Lamina_2
        Mi_Lamina_2.add(Campo_1);//Agrego mi campo a la lamina
        add(Resultado,BorderLayout.CENTER);//Se ubica en el centro de L_1
        Mi_Lamina_2.add(Boton);//Agrego en Mi_Lamina_2
        add(Mi_Lamina_2,BorderLayout.NORTH);//Agrego a Mi_Lamina_2 en la lamina original(L_1) en el norte
        
    }
    //Clase interna
    class Mi_Evento implements ActionListener //Puedo saltearme la clase si implemento el action lisneter en la lamina y cunado pongo a la escucho referencio con respecto a la lamina con el operador this
    {
        int Correcto,i;
        String Email;
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            Correcto=0;
            Email=Campo_1.getText().trim();
            for(i=0;i<Email.length();i++) //Email.length() tamaño completo de email
            {
                if(Email.charAt(i)=='@') //Email.charAt(i): devuelve letra en la posicion i
                {
                    Correcto++;
                }
            }
            if(Correcto!=1)
            {
                Resultado.setText("Incorrecto");
            }
            else
            {
                Resultado.setText("Correcto");
            }
            System.out.println(Campo_1.getText().trim()); //El .trim quita los espacios adicionales
        }
        
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evento_texto_area_1;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Andres
 */
public class Evento_Texto_Area_1 {

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
    private JTextArea Texto_Area;
    public void Configuracion()
    {
        //Variables que solo uso en este metodo
        JButton Boton=new JButton("Mostrar");
        Texto_Area=new JTextArea(8,20);
        JScrollPane Barra_Scroll=new JScrollPane(Texto_Area);//Lamina para darle una barra de desplazamiento scroll al area de texto
        
        //Configuraciones
        //Texto_Area.setLineWrap(true);//Seteo para que haya o no salto de linea, evito que cresca a lo ancho,si no lo pongo aparece una barra de scroll en horizontal
        
        //Añado componentes a la lamina y componentes a la escucha
        Boton.addActionListener(new Gestion_Area());
        add(Boton);
        add(Barra_Scroll);
    }
    //Clase Interna
    class Gestion_Area implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            System.out.println(Texto_Area.getText());//Obtengo texto
        }
        
    }
    
}
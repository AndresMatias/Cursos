/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiples_eventos_3;


import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *
 * @author Andres
 */
public class Multiples_Eventos_3 {

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
    private int Ancho,Alto;
    Lamina_Principal L_1;
    Toolkit Monitor;
    Dimension Tamaño_Monitor;
    Image Icono;
    public void Configuracion()
    {
        Monitor=Toolkit.getDefaultToolkit(); //Obetengo informancion de mi pantalla
        Tamaño_Monitor=Monitor.getScreenSize(); //Obtengo el tamaño de mi pantalla
        Ancho=Tamaño_Monitor.width; //Ancho de mi pantalla
        Alto=Tamaño_Monitor.height; //Alto de mi pantalla
        setVisible(true); //Para que la ventana sea visible
        setSize(Ancho/2,Alto/2); //Tamaño de mi ventana 
        setLocation(Ancho/4,Alto/4); //Localizacion donde aparecera mi ventana
        setTitle("Ventana Centrada"); //Nombre de mi ventana
        L_1=new Lamina_Principal(Ancho,Alto);//Creo mi clase Lamina
        L_1.Configuracion(); //Configura mi Lamina
        add(L_1); //Añado mi lamina L_1 sobre el mi Ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le digo a mi programa que pasa cuando cierro la ventana en este caso si cierro la ventana se acaba el programa
   }
}

class Lamina_Principal extends JPanel //Lamina que va encima de mi ventana para empezar a dibujar
{    
    private int Ancho,Alto,Contador=0;
    private JButton Nueva_Ventana,Cerrar_Todo;
    private Oyente NV;
    public Lamina_Principal(int Ancho,int alto)
    {
        this.Ancho=Ancho; //El this hace referencia a la variable declarada en la parte private
        this.Alto=Alto;
    }
    public void Configuracion()
    {    
        Nueva_Ventana=new JButton("Ventana Nueva");
        Cerrar_Todo=new JButton("Cerrar todo");
        NV=new Oyente();       
        Nueva_Ventana.addActionListener(NV);
        add(Nueva_Ventana);
        add(Cerrar_Todo);
    }
    private class Oyente implements ActionListener //Clase interna
    {

        
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            Lamina_Secundaria Ventanas_Secundarias=new Lamina_Secundaria(Cerrar_Todo);
            Ventanas_Secundarias.Configuracion();
        }
     
    }
    
    class Lamina_Secundaria extends JFrame //Marcos emergentes clase interna
    {    
        private JButton Boton_Cerrar;
        private Cerrar CT;
        public Lamina_Secundaria(JButton Boton_Cerrar_Aux)
        {
            Boton_Cerrar=Boton_Cerrar_Aux;
        }
        public void Configuracion()
        {       
            Contador++;
            setTitle("Ventana "+Contador);
            //Utilizando setBounds me ahorro el utilizar setSize y setLocation
            setBounds(((Alto/50)*Contador), ((Ancho/50)*Contador), 300, 300);
            setVisible(true); //Para que la ventana sea visible
            CT=new Cerrar();
            Boton_Cerrar.addActionListener(CT);
            
        }
        private class Cerrar implements ActionListener //Clase interna de Lamina_Secundaria
        {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                dispose();
            }
        }
    }
}


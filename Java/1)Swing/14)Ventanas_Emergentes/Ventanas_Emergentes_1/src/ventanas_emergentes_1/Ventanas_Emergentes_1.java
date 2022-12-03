/*
 
 */
package ventanas_emergentes_1;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Andres
 */
public class Ventanas_Emergentes_1 {

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

class Lamina extends JPanel 
{       
    private JButton boton1, boton2, boton3, boton4,boton5,boton6;
   // @SuppressWarnings("empty-statement") //Ver
    public void Configuracion()
    {
        boton1=new JButton("Boton 1");
        boton2=new JButton("Boton 2");
	boton3=new JButton("Boton 3");
	boton4=new JButton("Boton 4");
        boton5=new JButton("Boton 5");
        boton6=new JButton("Boton 6");
	boton1.addActionListener(new Accion_botones());
	boton2.addActionListener(new Accion_botones());
	boton3.addActionListener(new Accion_botones());
	boton4.addActionListener(new Accion_botones());
        boton5.addActionListener(new Accion_botones());
        boton6.addActionListener(new Accion_botones());
        add(boton1);	
	add(boton2);	
	add(boton3);	
	add(boton4);
        add(boton5);
        add(boton6);
    }	
    private class Accion_botones implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getSource()==boton1)
            {
                JOptionPane.showMessageDialog(Lamina.this, "Boton 1");
                //JOptionPane.showMessageDialog(Componente padre, Objeto mensaje);
            }
            else if(e.getSource()==boton2)
            {
                JOptionPane.showMessageDialog(Lamina.this, "Boton 2", "Titulo de la Ventana", 2);
                //JOptionPane.showMessageDialog(Componente padre, Objeto mensaje, Titulo, Tipo de icono);
            }
            else if(e.getSource()==boton3)
            {
                JOptionPane.showInputDialog("Ingrese Mensaje");
            }
            else if(e.getSource()==boton4)
            {
                JOptionPane.showInputDialog(Lamina.this, "Ingrese Mensaje", "Titulo de la Ventana", 0);
            }
            else if(e.getSource()==boton5)
            {
                JOptionPane.showConfirmDialog(Lamina.this, "Elija Opcion", "Titulo", 1);
                //JOptionPane.showConfirmDialog(Componente padre, mensaje, Titulo, cambia los boton para elegir);
            }
            else if(e.getSource()==boton6)
            {
                JOptionPane.showOptionDialog(Lamina.this, "Mensaje", "Titulo de la ventana", 1, 2, null, null, EXIT_ON_CLOSE);
                //JOptionPane.showOptionDialog(Componente padre, Mensaje, Titulo, tipo de botones, Icono de ventana, icono propio, arrays de objeto sobrel cual puedo elegir, EXIT_ON_CLOSE);
            }
        }		
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disposicion_libre_2;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Andres
 */
public class Disposicion_Libre_2 {

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
    
   // @SuppressWarnings("empty-statement") //Ver
    public void Configuracion()
    {
        setLayout(new Contenedor()); //Uso mi disposicion libre
       //Variables
        JLabel Nombre=new JLabel("Nombre");
        JLabel Apellido=new JLabel("Apellido");
        JLabel Edad=new JLabel("Edad");
        JTextField C_Nombre=new JTextField();
        JTextField C_Apellido=new JTextField();
        JTextField C_Edad=new JTextField();
        
       //Agrego Componentes
        add(Nombre);
        add(C_Nombre);
        add(Apellido);      
        add(C_Apellido);
        add(Edad);
        add(C_Edad);
    }
}

class Contenedor implements LayoutManager
{
    private int x,y;
    @Override
    public void addLayoutComponent(String name, Component comp) 
    {
        
    }

    @Override
    public void removeLayoutComponent(Component comp) 
    {
      
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void layoutContainer(Container Mi_Contenedor) //Especifica Contenedor
    {
        int D=Mi_Contenedor.getWidth(); //Obtengo ancho del contenedor
        x=D/2;
        y=20;
        int Cont=0; //Contador
        int n=Mi_Contenedor.getComponentCount(); //Obtengo cantidad de componentes
        for(int i=0;i<n;i++)
        {
            Cont++;
            Component C=Mi_Contenedor.getComponent(i); //Obtengo el componente sobre el cual trabajo
            C.setBounds(x-100, y, 100, 20); //Ubico y defino dimesiones de componentes
            x+=100; //Incrementa el valor de x en 100
            if(Cont%2==0) //Si el residuo de la division de Cont/2 es igual a cero incrementa a y(cuando Cont es par)
            {
                x=D/2; //x vuelve a ser 20 para que se alinien las parejas de componentes
                y+=40; //Incremento el valor de y en 40
            }
        }
        
    }
    
}
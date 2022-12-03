/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jspinner_2;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Andres
 */
public class JSpinner_2 {

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
    private  JSpinner Spinner;
    public void Configuracion()
    {
        //Variables
        Spinner=new JSpinner(new Modelo_Spinner());//SpinnerNumberModel(valor inicial,Min,Max,Tamaño de salto)
        
        //Configuraciones
        Spinner.setPreferredSize(new Dimension(200, 20));
        
        //Agregar y escuchar componentes  
        add(Spinner);
    }
    
    private class Modelo_Spinner extends SpinnerNumberModel
    {
        public Modelo_Spinner()
        {
            super(5,0,10,1); //Llamo al constructor de SpinnerNumberModel
        }
        @Override
        public Object getNextValue() //Sobreescribo metodo
        {
            //Llamo y sobreescribo al metodo getNextValue para que me devuelva el valor anterior con respecto al valor que tengo en casilla
            return super.getPreviousValue(); //Devuelve el valor previo llamando al metodo getPreviousValue() de la clase padre
        }
        @Override
        public Object getPreviousValue() //Sobreescribo metodo
        {
            //Llamo y sobreescribo al metodo getPreviousValue para que me devuelva el valor posterior con respecto al valor que tengo en casilla
            return super.getNextValue(); //Devuelve el valor posterior llamando al metodo getNextValue() de la clase padre
        }
    }
}

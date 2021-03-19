/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Andres
 */
public class Interfaz 
{

    
    public static void main(String[] args) 
    {
       Ventana Marco=new Ventana();
       Marco.Configuracion();
       Marco.setVisible(true);
    }
    
}

class Ventana extends JFrame //Creo mi ventana JFrame biblioteca para graficas
{
    Lamina L_1; 
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
        L_1=new Lamina(Ancho,Alto);//Creo mi clase Lamina
        add(L_1); //Añado mi lamina L_1 sobre el mi Ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le digo a mi programa que pasa cuando cierro la ventana en este caso si cierro la ventana se acaba el programa
   }
}

class Lamina extends JPanel //Lamina que va encima de mi ventana para empezar a dibujar
{
    int Ancho,Alto;
    Lamina(int Ancho_Aux,int Alto_Aux)
    {
        Ancho=Ancho_Aux;
        Alto=Alto_Aux;
    }
    @Override
    protected void paintComponent(Graphics Graficos) //Metodo heredeado y sobreescrito de la clase JComponent
    {
        super.paintComponents(Graficos); //Esto es para que haga el trabajo que tiene programado en clase JComponent ademas de hacer lo que yo pido abajo
        //Graficos.drawString("Estamos aprendiendo",100,100); //Dibujo letras en mi lamina
        //Graficos.drawRect(10, 10,200,200); //Dibujo un rectangulo
        Graphics2D Graficos_2D=(Graphics2D) Graficos; //Refundicion para trabajar con la clases Graphics2D
        Rectangle2D rectangulo=new Rectangle2D.Double(100,100,200,150); //Creo rectangulo con la clase Graphics2D que tiene mas potencia
        Graficos_2D.draw(rectangulo); //Implemento con un objeto shape(rectangulo) en mi ventana
    }

    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagenes_1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import sun.java2d.pipe.DrawImage;

public class Imagenes_1 
{
    public static void main(String[] args) 
    {
        Ventana Marco=new Ventana();  
    }
     
}

class Ventana extends JFrame //Creo mi ventana JFrame biblioteca para graficas
{
    Lamina_Imagen L_1; 
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
        L_1=new Lamina_Imagen(Ancho,Alto);//Creo mi clase Lamina   
        add(L_1); //Añado mi lamina L_1 sobre el mi Ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le digo a mi programa que pasa cuando cierro la ventana en este caso si cierro la ventana se acaba el programa
   }
}
class Lamina_Imagen extends JPanel //Lamina que va encima de mi ventana para empezar a dibujar
{
    int Ancho,Alto;        
    private Image Imagen;
    File Mi_Imagen; 
    Lamina_Imagen(int Ancho_Aux,int Alto_Aux)
    {
        Ancho=Ancho_Aux;
        Alto=Alto_Aux;
    }
    @Override
    public void paintComponent(Graphics G) //Metodo sobreescrito
    {
        super.paintComponent(G);
        
        Mi_Imagen=new File("src/imagenes_1/Versiculo_1.png"); //Busco mi imagen
        try //Utilizo try y catch porque image puede producir error(no encontrar imagen)
        {
            Imagen=ImageIO.read(Mi_Imagen); //Almaceno imagen
        } catch (IOException ex) 
        {
            System.out.println("No se encontro la imagen");
        }
        G.drawImage(Imagen,5,5,null);
    } 
}
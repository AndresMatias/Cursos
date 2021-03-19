/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu_1;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Andres
 */
public class Menu_1 {

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
    public void Configuracion()
    {
        //Variables
        JMenuBar Mi_Barra=new JMenuBar(); //Creo barra de menu
        //Elementos de la Barra
        JMenu Archivo=new JMenu("Archivo"); //Componente que va sobre la barra(Mi_Barra)
            //Items que pertenece a Archivo
            JMenuItem Guardar=new JMenuItem("Guardar"); //Item que va detro del componente JMenu
            JMenuItem Guardar_Como=new JMenuItem("Guardar Como"); //Item que va detro del componente JMenu       
        JMenu Edicion=new JMenu("Edicion"); //Componente que va sobre la barra(Mi_Barra)
        //Items que pertenece a Edicion
            JMenuItem Cortar=new JMenuItem("Cortar"); 
            JMenuItem Copiar=new JMenuItem("Copiar"); 
            JMenuItem Pegar=new JMenuItem("Pegar");  
            JMenu Opciones=new JMenu("Opciones"); //Se declara como menu porque va aservir de submenu para otros items
                //Items que pertenece a Opciones que a su vez el mismo va dentro de Edicion
                JMenuItem Opcion_1=new JMenuItem("Opcion 1");
                JMenuItem Opcion_2=new JMenuItem("Opcion 2");                
        JMenu Herramientas=new JMenu("Herramientas"); //Componente que va sobre la barra(Mi_Barra)
            //Items que pertenece a Herramientas
            JMenuItem Generales=new JMenuItem("Generales"); 
        
        //Configuraciones
            //Si agrego a Archivo a la barra al final en vez de al principio, aparecera al final de la barra
            //Añadir Componentes a la barra e item a los componentes
            Mi_Barra.add(Archivo);
                //Items que pertenece a Archivo
                Archivo.add(Guardar); 
                Archivo.addSeparator(); //Separador
                Archivo.add(Guardar_Como);
            Mi_Barra.add(Edicion); 
                //Items que pertenece a Edicion(Segun en el orden que lo agregue va a aparecer en mi aplicacion)
                Edicion.add(Cortar);
                Edicion.addSeparator(); //Separador
                Edicion.add(Copiar);
                Edicion.addSeparator(); //Separador
                Edicion.add(Pegar);
                Edicion.addSeparator(); //Separador
                Edicion.add(Opciones);
                    //Items que pertenece a Opciones
                    Opciones.add(Opcion_1);
                    Opciones.addSeparator(); //Separador
                    Opciones.add(Opcion_2);     
            Mi_Barra.add(Herramientas);
                //Items que pertenece a Herramientas
                Herramientas.add(Generales);
                              
        //Añadir y escuchar componentes a la/las lamina
        add(Mi_Barra);
    }      
}

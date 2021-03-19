/*
 Video 266, cuando agrego los nodos puedo sobreescribir las variables sin que cambie el arbol, creo nodos que se agregan y no se modifican(ver luego como modificar)
 */
package jtree_1;

import java.awt.*;
import java.awt.Container;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.tree.DefaultMutableTreeNode;


/**
 *
 * @author Andres
 */
public class JTree_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Ventana Marco=new Ventana();
        Marco.setVisible(true);
    }
     
}

class Ventana extends JFrame //Creo mi ventana JFrame biblioteca para graficas
{
    private Container Contenido;
    Laminas L_1; 
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
        setTitle("JTree"); //Nombre de mi ventana
        L_1=new Laminas(Ancho,Alto);//Creo mi clase Lamina   
        //add(L_1); //Añado mi lamina L_1 sobre el mi Ventana
        
        //Agrego la lamina con un scroll
        Contenido=getContentPane(); // metodo que sirve para especificar el contenedor de los elementos del jframe
        Contenido.add(new JScrollPane(L_1));
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le digo a mi programa que pasa cuando cierro la ventana en este caso si cierro la ventana se acaba el programa
    }
}
class Laminas extends JPanel //Lamina que va encima de mi ventana para empezar a dibujar
{
    int Ancho,Alto;
    private DefaultMutableTreeNode raiz,pais,comunidad,mostoles,alcobendas; //crea un nodo raiz que no tiene padre pero puede tener hijos
    private JTree Arbol;
    Laminas(int Ancho_Aux,int Alto_Aux)
    {
        Ancho=Ancho_Aux;
        Alto=Alto_Aux;
        Configuracion();
    }
    public final void Configuracion()
    {
        setLayout(new BorderLayout()); //seteo el layout
        //Inicializo
        
        raiz=new DefaultMutableTreeNode("Mundo");
        //España
        pais=new DefaultMutableTreeNode("España");
        comunidad=new DefaultMutableTreeNode("Madrid");
        mostoles=new DefaultMutableTreeNode("Mostoles");
        alcobendas=new DefaultMutableTreeNode("Alcobendas");
        
        
        //Agrego nodos a raiz
        raiz.add(pais); //pais pasa a ser hijo de raiz
        //Agrego nodos a pais
        pais.add(comunidad);
        //Agrego nodos a comunidad
        comunidad.add(mostoles);
        comunidad.add(alcobendas);
        
        //Argentina(sobreescribo las variables)
         pais=new DefaultMutableTreeNode("Argetnina");
        comunidad=new DefaultMutableTreeNode("Cordoba");
        mostoles=new DefaultMutableTreeNode("Capital");
        alcobendas=new DefaultMutableTreeNode("Interior");
        
        //Agrego nodos a raiz
        raiz.add(pais); //pais pasa a ser hijo de raiz
        //Agrego nodos a pais
        pais.add(comunidad);
        //Agrego nodos a comunidad
        comunidad.add(mostoles);
        comunidad.add(alcobendas);
        
        //Inicializa Arbol luego de contruirlo completo
        Arbol=new JTree(raiz);
        
        add(Arbol,BorderLayout.NORTH);  
    }
}

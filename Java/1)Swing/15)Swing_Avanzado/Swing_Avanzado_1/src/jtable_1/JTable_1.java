/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtable_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.lang.model.SourceVersion;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Andres
 */
public class JTable_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ventanas Marco=new Ventanas();
        Marco.setVisible(true);
    }
     
}

class Ventanas extends JFrame //Creo mi ventana JFrame biblioteca para graficas
{
    Laminas L_1; 
    int Ancho,Alto;
    Toolkit Monitor;
    Dimension Tamaño_Monitor;
    Image Icono;
    Ventanas()
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
        setTitle("JList"); //Nombre de mi ventana
        L_1=new Laminas(Ancho,Alto);//Creo mi clase Laminas   
        //add(L_1); //Añado mi lamina L_1 sobre el mi Ventanas
        add(new JScrollPane(L_1)); //agrego barra de scroll
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le digo a mi programa que pasa cuando cierro la ventana en este caso si cierro la ventana se acaba el programa
   }
}
class Laminas extends JPanel //Lamina que va encima de mi ventana para empezar a dibujar
{
    int Ancho,Alto;
    private JTable Tabla;
    private String nombresColumnas[]={"Nombre","Radio","Luna","Gaseoso"};
    private Object datosFilas[][]={ {"Mercurio",2440,0,false},
                                    {"Urano",2440,1,false},
                                    {"Urano 2",2440,1,false},
                                    {"Urano 3",2440,1,false},
                                                            };
    private JButton imprimir;
    private JScrollPane scroll;
    Laminas(int Ancho_Aux,int Alto_Aux)
    {
        Ancho=Ancho_Aux;
        Alto=Alto_Aux;
        Configuracion();
    }
    public final void Configuracion()
    {
        setLayout(new BorderLayout());
        Tabla=new JTable(datosFilas,nombresColumnas);
        scroll=new JScrollPane(Tabla);
        imprimir=new JButton("Imprimir tabla");
        imprimir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Tabla.print(); //Imprimo por impresora tabla
                }catch(Exception e2){
                   //poner algo para indicar error
                }
            }
        });
        add(scroll,BorderLayout.NORTH); //Tengo que agregar un JScrollpane para que se vean als columnas, pq es asi: nose
        add(imprimir,BorderLayout.SOUTH);
    }
}
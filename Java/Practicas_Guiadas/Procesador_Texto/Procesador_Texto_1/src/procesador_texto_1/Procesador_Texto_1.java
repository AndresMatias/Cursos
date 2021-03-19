/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador_texto_1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 *
 * @author Andres
 */
public class Procesador_Texto_1 {

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
    private JTextPane Texto_Panel;
    private JMenu Menu[];
    private int i,j,cont,Estilo_Letra,Tamaño_Letra;
    private String Tipo_Texto;
    private Font Letra;
    @SuppressWarnings("empty-statement")
    public void Configuracion()
    {
        setLayout(new BorderLayout());
        //Variables
        String Rotulos[]={"Arial","Serif","Verdana","Negrita","Cursiva","10","16","20","26"};
        int Vector[]={Font.BOLD,Font.ITALIC};
        cont=0;
        JPanel Lamina_Menu=new JPanel();
        Texto_Panel=new JTextPane();
        JMenuBar Mi_Barra=new JMenuBar(); //Creo barra de menu
            //Elementos de la Barra
            Menu=new JMenu[3]; //Reservo tres lugares
            Menu[0]=new JMenu("Fuente"); //Componente que va sobre la barra(Mi_Barra)
            Menu[1]=new JMenu("Estilo"); //Componente que va sobre la barra(Mi_Barra)         
            Menu[2]=new JMenu("Tamaño"); //Componente que va sobre la barra(Mi_Barra)

        
      //Configuraciones
        //Menu
        for(i=0;i<3;i++)
        {
            Mi_Barra.add(Menu[i]); //Agrego Elementos a la barra
            Configurar_Menu(Rotulos[cont],0,Rotulos[cont],9,10); //Congifuracion de Fuente
            cont++;
        }
        for(i=0;i<2;i++)
        {
            Configurar_Menu(Rotulos[cont],1,"",Vector[i],10); //Congifuracion de Estilo
            cont++;
        }
        for(i=0;i<4;i++)
        {
            Configurar_Menu(Rotulos[cont],2,"",9,Integer.parseInt(Rotulos[cont])); //Congifuracion de Tamaño
            cont++;
        }
                              
      //Añadir y escuchar componentes a la/las lamina
        Lamina_Menu.add(Mi_Barra);
        add(Lamina_Menu,BorderLayout.NORTH);
        add(Texto_Panel,BorderLayout.CENTER);     
    }
    public void Configurar_Menu(String Rotulo,int k,String Tipo_Letra,int Estilo,int Tam)
    {
        JMenuItem Elemento_Menu=new JMenuItem(Rotulo);
        Menu[k].add(Elemento_Menu);
        Elemento_Menu.addActionListener(new ActionListener() //Clase interna anonima
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Letra=Texto_Panel.getFont();
                Estilo_Letra=Estilo;
                Tamaño_Letra=Tam;
                Tipo_Texto=Tipo_Letra;
                if("Arial".equals(Rotulo)||"Serif".equals(Rotulo)||"Verdana".equals(Rotulo))
                {
                    Estilo_Letra=Letra.getStyle();
                    Tamaño_Letra=Letra.getSize();
                }
                if("Negrita".equals(Rotulo)||"Cursiva".equals(Rotulo))
                {
                    if(Letra.getStyle()==1||Letra.getStyle()==2) //Esto es asi proque el metodo getstyle solo detecta el ultimo estilo aplicado, no ambos y cunado uso lso dos java suma las constantes
                    {
                        Estilo_Letra=3;
                    }
                    Tipo_Texto=Letra.getFontName();
                    Tamaño_Letra=Letra.getSize();
                }
                if("10".equals(Rotulo)||"16".equals(Rotulo)||"20".equals(Rotulo)||"26".equals(Rotulo))
                {
                    Tipo_Texto=Letra.getFontName();
                    Estilo_Letra=Letra.getStyle();
                }
                Texto_Panel.setFont(new Font(Tipo_Texto,Estilo_Letra,Tamaño_Letra));
            }
        });
    }
}
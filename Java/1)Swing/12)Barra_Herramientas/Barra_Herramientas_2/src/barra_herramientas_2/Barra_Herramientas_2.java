/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barra_herramientas_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author Andres
 */
public class Barra_Herramientas_2 {

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
    private JPopupMenu Menu_Emergente;
    private int i,j,cont,Estilo_Letra,Tamaño_Letra;
    private String Tipo_Texto;
    private Font Letra;
    private ButtonGroup Grupo_Tamaño;
    private JToolBar Barra_Herramientas;
    private JButton Negrita,Cursiva,Subrayar,C[],Alineacion[];
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
        Grupo_Tamaño=new ButtonGroup();
        Menu_Emergente=new JPopupMenu();
        Barra_Herramientas=new JToolBar();
       //Botones de la Barra de Herramientas
        Negrita=new JButton("N");
        Cursiva=new JButton("C");
        Subrayar=new JButton("S");
        C=new JButton[3];//Reservo Espacio en Memoria
        C[0]=new JButton("Az");
        C[1]=new JButton("Am");
        C[2]=new JButton("R0");
        Alineacion=new JButton[4];
        Alineacion[0]=new JButton("AI");
        Alineacion[1]=new JButton("AC");
        Alineacion[2]=new JButton("AD");
        Alineacion[3]=new JButton("AJ");
       //Barra de Menu 
        JMenuBar Mi_Barra=new JMenuBar(); //Creo barra de menu
            //Elementos de la Barra
            Menu=new JMenu[3]; //Reservo tres lugares
            Menu[0]=new JMenu("Fuente"); //Componente que va sobre la barra(Mi_Barra)
            Menu[1]=new JMenu("Estilo"); //Componente que va sobre la barra(Mi_Barra)         
            Menu[2]=new JMenu("Tamaño"); //Componente que va sobre la barra(Mi_Barra)

        
      //Configuraciones
        
       //Barra de Herramientas
        Barra_Herramientas.add(Negrita);
        Barra_Herramientas.add(Cursiva);
        Barra_Herramientas.add(Subrayar);
        Barra_Herramientas.addSeparator();
        for(i=0;i<3;i++)
        {
            Barra_Herramientas.add(C[i]);
        }
        Barra_Herramientas.addSeparator();
        for(i=0;i<4;i++)
        {
            Barra_Herramientas.add(Alineacion[i]);
        }
        Barra_Herramientas.setOrientation(1); //Orientacion Vertical de la barra
        Subrayar.addActionListener(new StyledEditorKit.UnderlineAction()); //Pongo a la escucha para subrayar
        C[0].addActionListener(new StyledEditorKit.ForegroundAction("Azul", Color.BLUE));
        C[1].addActionListener(new StyledEditorKit.ForegroundAction("Amarillo",Color.YELLOW));
        C[2].addActionListener(new StyledEditorKit.ForegroundAction("Rojo",Color.RED));
        Alineacion[0].addActionListener(new StyledEditorKit.AlignmentAction("Izquierda",0));
        Alineacion[1].addActionListener(new StyledEditorKit.AlignmentAction("Centrado",1));
        Alineacion[2].addActionListener(new StyledEditorKit.AlignmentAction("Derecha",2));
        Alineacion[3].addActionListener(new StyledEditorKit.AlignmentAction("Justificado",3));
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
        add(Barra_Herramientas,BorderLayout.WEST);
        Texto_Panel.setComponentPopupMenu(Menu_Emergente); //Asi el menu sale en el area de texto y no sobre la lamina
        add(Lamina_Menu,BorderLayout.NORTH);
        add(Texto_Panel,BorderLayout.CENTER);
    }
    public void Configurar_Menu(String Rotulo,int k,String Tipo_Letra,int Estilo,int Tam)
    {
          
        if(k==0)
        {
            JMenuItem Elemento_Menu=new JMenuItem(Rotulo);
            Menu[k].add(Elemento_Menu);
            Elemento_Menu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia Letra", Rotulo));
        }    
        if(k==1)
        {
            JCheckBoxMenuItem Elemento_Menu=new JCheckBoxMenuItem(Rotulo);
            JMenuItem Elem_Menu=new JMenuItem(Rotulo);
            Menu_Emergente.add(Elem_Menu);
            Menu[k].add(Elemento_Menu);
            if(Estilo==Font.BOLD)
            {
                Elemento_Menu.addActionListener(new StyledEditorKit.BoldAction()); //Modifica tamaño solamente del texto seleccionado
                Elem_Menu.addActionListener(new StyledEditorKit.BoldAction()); //Modifica tamaño solamente del texto seleccionado
                Elemento_Menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK)); //Tecla de acceso rapido
                Negrita.addActionListener(new StyledEditorKit.BoldAction()); //Boton de barra de herramienta
            }
            if(Estilo==Font.ITALIC)
            {
                Elemento_Menu.addActionListener(new StyledEditorKit.ItalicAction()); //Modifica tamaño solamente del texto seleccionado
                Elem_Menu.addActionListener(new StyledEditorKit.ItalicAction()); //Modifica tamaño solamente del texto seleccionado
                Elemento_Menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,InputEvent.CTRL_DOWN_MASK)); //Tecla de acceso rapido
                Cursiva.addActionListener(new StyledEditorKit.ItalicAction()); //Boton de barra de herramienta
            }
        }
        if(k==2)
        {
            JRadioButtonMenuItem Elemento_Menu=new JRadioButtonMenuItem(Rotulo);
            Grupo_Tamaño.add(Elemento_Menu);
            Menu[k].add(Elemento_Menu);
            Elemento_Menu.addActionListener(new StyledEditorKit.FontSizeAction("Cambia Tamaño", Tam)); //Modifica tamaño solamente del texto seleccionado
        }
    }
}

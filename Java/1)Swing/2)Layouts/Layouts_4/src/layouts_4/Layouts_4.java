/*
  Nota 1:Puedo poner a Lamina_Botones dentro de Lamina_Calculadora para que sea 
         mas sencillo
 */
package layouts_4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *
 * @author Andres
 */
public class Layouts_4 
{

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
    Lamina_Calculadora L_1;
    Lamina_Botones L_2;
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
        //setSize(Ancho/2,Alto/2); //Tamaño de mi ventana si uso pack no hace falta
        setLocation(Ancho/4,Alto/4); //Localizacion donde aparecera mi ventana
        setTitle("Ventana Centrada"); //Nombre de mi ventana
        L_1=new Lamina_Calculadora();//Creo mi clase Lamina
        L_2=new Lamina_Botones(L_1.Pantalla,L_1.Bandera);//Creo mi clase Lamina y accedo a pantalla directamente con public
        L_1.Configuracion();
        L_2.Configuracion();
        add(L_1,BorderLayout.NORTH); //Añado mi lamina L_1 sobre el mi Ventana, uso BorderLayout para separar de L_2
        add(L_2,BorderLayout.CENTER); //Añado mi lamina L_2 sobre el mi Ventana, uso BorderLayout para separar de L_1
        pack();//El marco se adapta a lo que lleva adentro(tamaño favorito),se debe declarar despues de añadir a las laminas
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le digo a mi programa que pasa cuando cierro la ventana en este caso si cierro la ventana se acaba el programa
   }
}

class Lamina_Calculadora extends JPanel //Lamina que va encima de mi ventana para empezar a dibujar
{
    //Creo Botones,tambien puedo declararlos adentro del add() 
    public JButton Pantalla=new JButton("0");
    public boolean Bandera;
    Lamina_Calculadora()
    {
        Bandera=false;
    }
    public final void Configuracion()
    {
        
        BorderLayout Disposicion=new BorderLayout(); //Separacion entre componentes horizontal y vertical
        setLayout(Disposicion); //Seteo layout en L_1(se maneja dentro de L_1)
        Pantalla.setEnabled(false);//Inabhilito boton para que no pueda ser presionado
        add(Pantalla,BorderLayout.NORTH);//Agrego boton a la lamina        
    }
         
 
}
class Lamina_Botones extends JPanel
{
    private int i,j,k;
    public boolean Bandera;
    GridLayout Disposicion=new GridLayout(4,4);
    Insertar_Numeros Numeros;
    Operaciones_Matematicas Calcular;
    JButton [][]Matriz_Botones=new JButton[4][4];
    JButton P;
    Lamina_Botones(JButton P_A,boolean B_A)
    {
        P=P_A; //Almaceno a pantalla
        Bandera=B_A;
    }
    void Configuracion()
    {
        Calcular=new Operaciones_Matematicas(P,Bandera);
        Numeros=new Insertar_Numeros(P,Bandera);
        setLayout(Disposicion); //Seteo mi lamina para que se organice como grilla
        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                Nombrar_Botones(k++);
                add(Matriz_Botones[i][j]);
                if((k!=4)&&(k!=8)&&(k!=12)&&(k!=16)&&(k!=15)) //En esos de k se encutran las operaciones matematicas y el igual
                {
                    Matriz_Botones[i][j].addActionListener(Numeros); //Pongo botones del 0 al 9 a la escucha
                }
                if((k==4)||(k==8)||(k==12)||(k==16)||(k==15)) //En esos de k se encutran las operaciones matematicas y el igual
                {
                    Matriz_Botones[i][j].addActionListener(Calcular); //Pongo botones del 0 al 9 a la escucha
                }
            }
        }
        
    }
    void Nombrar_Botones(int cont)
    {
        switch(cont)
        {
            case 0:
                Matriz_Botones[i][j]=new JButton("7");
                break;
            case 1:
                Matriz_Botones[i][j]=new JButton("8");
                break;
            case 2:
                Matriz_Botones[i][j]=new JButton("9");
                break;    
            case 3:
                Matriz_Botones[i][j]=new JButton("/");
                break;
            case 4:
                Matriz_Botones[i][j]=new JButton("4");
                break;
            case 5:
                Matriz_Botones[i][j]=new JButton("5");
                break;
            case 6:
                Matriz_Botones[i][j]=new JButton("6");
                break;
            case 7:
                Matriz_Botones[i][j]=new JButton("*");
                break;
            case 8:
                Matriz_Botones[i][j]=new JButton("1");
                break;
            case 9:
                Matriz_Botones[i][j]=new JButton("2");
                break;
            case 10:
                Matriz_Botones[i][j]=new JButton("3");
                break;
            case 11:
                Matriz_Botones[i][j]=new JButton("-");
                break;
            case 12:
                Matriz_Botones[i][j]=new JButton("0");
                break;
            case 13:
                Matriz_Botones[i][j]=new JButton(",");
                break;
            case 14:
                Matriz_Botones[i][j]=new JButton("=");
                break;
            case 15:
                Matriz_Botones[i][j]=new JButton("+");
                break;
        }
    }
}

class Insertar_Numeros implements ActionListener
{
    public String Entrada;
    private JButton Pantalla_IN;
    private boolean Principio;
    private boolean Bandera_IN;
    Insertar_Numeros(JButton Pantalla_Aux,boolean B_A)
    {
        Pantalla_IN=Pantalla_Aux;
        Principio=true;
        Bandera_IN=B_A;
    }

    @Override
    public void actionPerformed(ActionEvent Evento_IN) 
    {
        Entrada=Evento_IN.getActionCommand();//Obtengo nombre del boton
        if(Bandera_IN==true)
        {
            Pantalla_IN.setText("");
            Bandera_IN=false;        
        }
        if(Principio==true) //Para borrar el cero original cuando estoy recien comenzando
        {
            Pantalla_IN.setText("");
            Principio=false;
        }
        Entrada=Pantalla_IN.getText()+Entrada;//para almacenar numeros y con getText obtengo la el vlaor anterior y no desaparece
        Pantalla_IN.setText(Entrada); //Pongo en Pantalla el texto total 
    }
}

class Operaciones_Matematicas implements ActionListener
{
    private double Numero_1;
    private double Numero_2;
    private String Operacion_Matematica;
    public String Operacion_Matematica_Aux;
    private JButton Pantalla_OM; 
    private boolean  Bandera_OM;
    public Operaciones_Matematicas(JButton P_OM_Aux,boolean  B_A)
    {
        Bandera_OM=B_A;
        Pantalla_OM=P_OM_Aux;
    }
    
    @Override
    public void actionPerformed(ActionEvent Evento_OM) 
    {
         Operacion_Matematica_Aux=Operacion_Matematica;   
         Operacion_Matematica=Evento_OM.getActionCommand(); //Obtengo el texto del boton
         if("=".equals(Operacion_Matematica)) //Si Operacion_Matematica es igual a "="
         {
             Numero_2=Double.parseDouble(Pantalla_OM.getText());
             Calculadora();
         }
         else
         {
             Numero_1=Double.parseDouble(Pantalla_OM.getText());
             Pantalla_OM.setText("");
         }    
    }
    public void Calculadora()
    {
        switch(Operacion_Matematica_Aux)
         {
            case"/":
                Pantalla_OM.setText(""+(Numero_1/Numero_2));
                Bandera_OM=true;
               break;
            case"*":
                Pantalla_OM.setText(""+(Numero_1*Numero_2));
                break;
            case"-":
                Pantalla_OM.setText(""+(Numero_1-Numero_2));
                break;
            case"+":
                Pantalla_OM.setText(""+(Numero_1+Numero_2));
                break;
        }
        Operacion_Matematica=null;
        Pantalla_OM.setText("");
        Bandera_OM=true;     
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

/**
 *
 * @author Andres
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.*;
public class BBDD {

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
    Lamina L_1; 
    int Ancho,Alto;
    Toolkit Monitor;
    Dimension Tamaño_Monitor;
    Ventana()
    {
     Configuracion();
    }
    public void Configuracion()
    {
        Monitor=Toolkit.getDefaultToolkit(); //Obetengo informancion de mi pantalla
        Tamaño_Monitor=Monitor.getScreenSize(); //Obtengo el tamaño de mi pantalla
        Ancho=Tamaño_Monitor.width; //Ancho de mi pantalla
        Alto=Tamaño_Monitor.height; //Alto de mi pantalla
        setVisible(true); //Para que la ventana sea visible
        setSize(Ancho/2,Alto/2); //Tamaño de mi ventana 
        setLocation(Ancho/4,Alto/4); //Localizacion donde aparecera mi ventana
        setTitle("Ventana Centrada"); //Nombre de mi ventana
        L_1=new Lamina(Ancho,Alto);//Creo mi clase Lamina   
        add(L_1); //Añado mi lamina L_1 sobre el mi Ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le digo a mi programa que pasa cuando cierro la ventana en este caso si cierro la ventana se acaba el programa
   }
}
    
class Lamina extends JPanel //Lamina que va encima de mi ventana para empezar a dibujar
{
    int Ancho,Alto;
    private Connection miConexion;
    private JTextArea Texto_Area;
    private JComboBox Combo1,Combo2;
    private JPanel Lamina_Norte;
    private PreparedStatement enviaConsultaSeccion;
    private PreparedStatement enviaConsultaPais;
    private PreparedStatement enviaConsultaTodos;
    private final String ConsultaSeccion="SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=?";
    private final String ConsultaPais="SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN=?";
    private final String ConsultaTodos="SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND"
                                                                                                                +" PAÍSDEORIGEN=?"; 
    JButton Boton_Consulta=new JButton("Consulta");
    Lamina(int Ancho_Aux,int Alto_Aux)
    {
        Ancho=Ancho_Aux;
        Alto=Alto_Aux;
        Configuracion();
    }
    public final void Configuracion()
    {
        BorderLayout Disposicion=new BorderLayout(50,50); //Separacion entre componentes horizontal y vertical   
        setLayout(Disposicion); //Seteo layout en L_1
        Combo1=new JComboBox();
        Combo2=new JComboBox();
        
        Lamina_Norte=new JPanel();
        Lamina_Norte.setLayout(new FlowLayout());
        
        
        JButton Boton=new JButton("Mostrar");
        Texto_Area=new JTextArea(8,20);
        
        //Configuraciones
        Combo1.setEditable(false);
        Combo2.setEditable(false);
        Texto_Area.setEditable(false);
        
        //Agrego items a Combo1
        Combo1.addItem("Todos");
        
        //Agrego items a Combo2
        Combo2.addItem("Todos");
        
        //-----------------------Conexion BBDD------------------------------
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Crear Conexion -------------------------
            miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/pruebas","root","");
            //Crear Statement-------------------------
            Statement miStatement=miConexion.createStatement();
            //Ejecutar sql----------------------------
            String Consulta="SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS";
            ResultSet miResulset=miStatement.executeQuery(Consulta);
            
            //Cargo las seccione
            while(miResulset.next()){
                Combo1.addItem(miResulset.getString(1));
            }
            miResulset.close(); //libero recursos
            
            //Cargo los paises
            Consulta="SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS";
            miResulset=miStatement.executeQuery(Consulta);
            while(miResulset.next()){
                Combo2.addItem(miResulset.getString(1));
            }
            miResulset.close(); //libero recursos
        } 
        catch(Exception e){
            System.out.println("No conecta");
            e.printStackTrace();
        }
        //Pongo a la escucha al boton
        Boton_Consulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Ejecuta_Consulta();
            }
        });
        //Agrego Botones a la lamina y sete para que botones se ubiquen en North,West y East
        Lamina_Norte.add(Combo1);
        Lamina_Norte.add(Combo2);
        add(Lamina_Norte,BorderLayout.NORTH);
        add(Texto_Area,BorderLayout.CENTER);
        add(Boton_Consulta,BorderLayout.SOUTH);
    }
    private void Ejecuta_Consulta(){ //Para hacer consulta con al informacion que requiero cada vez que aprieto el boton de consulta
        ResultSet rs=null;
        Texto_Area.setText(""); //Reseto el area de texto
        try {
            String seccion=(String)Combo1.getSelectedItem();
            String pais=(String)Combo2.getSelectedItem();
            if(!seccion.equals("Todos") && pais.equals("Todos"))
            {
                //Preparo consulta
                enviaConsultaSeccion=miConexion.prepareStatement(ConsultaSeccion); 
                enviaConsultaSeccion.setString(1, seccion);
                //Ejecuto consulta
                rs=enviaConsultaSeccion.executeQuery();
            }
            else if(seccion.equals("Todos") && !pais.equals("Todos"))
            {
                //Preparo consulta
                enviaConsultaPais=miConexion.prepareStatement(ConsultaPais); 
                enviaConsultaPais.setString(1, pais);
                //Ejecuto consulta
                rs=enviaConsultaPais.executeQuery();
            }
            else if(!seccion.equals("Todos") && !pais.equals("Todos"))
            {
                //Preparo consulta
                enviaConsultaTodos=miConexion.prepareStatement(ConsultaTodos); 
                enviaConsultaTodos.setString(1, seccion);
                enviaConsultaTodos.setString(2, pais);
                //Ejecuto consulta
                rs=enviaConsultaTodos.executeQuery();
            }
            while(rs.next())
            {
                Texto_Area.append(rs.getString(1)); //Agrego texto
                Texto_Area.append(", "); //Agrego texto
                Texto_Area.append(rs.getString(2)); //Agrego texto
                Texto_Area.append(", "); //Agrego texto
                Texto_Area.append(rs.getString(3)); //Agrego texto
                Texto_Area.append(", "); //Agrego texto
                Texto_Area.append(rs.getString(4)); //Agrego texto
                Texto_Area.append("\n"); //Agrego texto
            }
        } 
        catch (Exception e) {
            System.out.println("No conecta");
            e.printStackTrace();
        }     
    }
}

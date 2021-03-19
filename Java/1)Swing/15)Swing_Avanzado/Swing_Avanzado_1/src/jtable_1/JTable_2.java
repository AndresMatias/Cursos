/*
 Video 268 trabaja con clase abtrapta en caso de no tener todso los campos
 */
package jtable_1;

import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Andres
 */
public class JTable_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Ventanass Marco=new Ventanass();
       Marco.setVisible(true);
    }
     
}

final class Ventanass extends JFrame //Creo mi ventana JFrame biblioteca para graficas
{
    Lamina L_1; 
    int Ancho,Alto;
    Toolkit Monitor;
    Dimension Tamaño_Monitor;
    Image Icono;
    private TableModel Modelo;
    private JTable Tabla;
    Ventanass()
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
        L_1=new Lamina(Ancho,Alto);//Creo mi clase Laminas   
        add(L_1); //Añado mi lamina L_1 sobre el mi Hola
        add(new JScrollPane(L_1)); //agrego barra de scroll
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le digo a mi programa que pasa cuando cierro la ventana en este caso si cierro la ventana se acaba el programa
   }
}
class Lamina extends JPanel //Lamina que va encima de mi ventana para empezar a dibujar
{
    int Ancho,Alto;
    private JTable Tabla;
    
    Lamina(int Ancho_Aux,int Alto_Aux)
    {
        Ancho=Ancho_Aux;
        Alto=Alto_Aux;
        Configuracion();
    }
    public final void Configuracion()
    {
        setLayout(new BorderLayout());
        
        TableModel Modelo=new TablaPerzonalizada();
        JTable Tabla=new JTable(Modelo);
        JScrollPane scroll=new JScrollPane(Tabla); //Tengo que agregar un JScrollpane para que se vean als columnas, pq es asi: nose
        add(scroll);
    }
}

class TablaPerzonalizada extends AbstractTableModel{
    @Override
    public int getRowCount(){ //Especifico cuantos registros va a tener la tabla
        
        return 3; //3 filas
    }

    @Override
    public int getColumnCount(){ //Especifico cuantas columnas va a tener la tabla
        return 5; //5 columnas
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex){ //Especifico informacion que va a tener la tabla
        int z=rowIndex+1;
        int y=columnIndex+2;
        return " "+z+" "+y; //Rellena los campos de la tabla de informacion
    }
  
    @Override
    public String getColumnName(int c){ //Nombro las columnas pero no aparecen y nose porque
        System.out.println("Columna " + c);
        return "Columna " + c;
    }
}



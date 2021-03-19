/*
video 256
 */
package jlist_1;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;

/**
 *
 * @author Andres
 */
public class JList_1 {

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
        setTitle("JList"); //Nombre de mi ventana
        L_1=new Laminas(Ancho,Alto);//Creo mi clase Lamina   
        add(L_1); //Añado mi lamina L_1 sobre el mi Ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le digo a mi programa que pasa cuando cierro la ventana en este caso si cierro la ventana se acaba el programa
   }
}
class Laminas extends JPanel //Lamina que va encima de mi ventana para empezar a dibujar
{
    int Ancho,Alto;
    private JPanel listas,texto;
    private JList<String> lista_meses;
    private JScrollPane barra;
    private JLabel rotulo;
   
    Laminas(int Ancho_Aux,int Alto_Aux)
    {
        Ancho=Ancho_Aux;
        Alto=Alto_Aux;
        Configuracion();
    }
    public final void Configuracion()
    {
        setLayout(new BorderLayout());
        String meses[]={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        lista_meses=new JList<>(meses);
        rotulo=new JLabel("Mes seleccionado");
        texto=new JPanel(); //lamina de texto
        listas=new JPanel();//lamina de listas
        barra=new JScrollPane(lista_meses); //Barra de desplazamiento
        lista_meses.setVisibleRowCount(4); //Seteo cuantos elementos visibles
        
        //Evento de lista
        lista_meses.addListSelectionListener(new ListSelectionListener(){ 
            @Override
            public void valueChanged(ListSelectionEvent e) {
                List<String> valores;
                valores = lista_meses.getSelectedValuesList();
                StringBuilder texto=new StringBuilder("Mes Seleccionado: ");
                for(String elemento:valores){
                    String palabra=elemento;
                    texto.append(palabra);
                    texto.append(" ");
                }
                rotulo.setText(texto.toString());
                //Dato: si aprieto ctrl y otros item de la lista me permite seleccionar multiples items
            }
        });
        texto.add(rotulo);
        listas.add(barra);
        add(texto,BorderLayout.NORTH);
        add(listas,BorderLayout.SOUTH);
    }
}

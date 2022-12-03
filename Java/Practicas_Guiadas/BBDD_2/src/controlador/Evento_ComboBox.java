/*
clase que pone a la escucha al comboBox cada vez que cambia de opcion
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import modelo.Info_Tabla;

/**
 *
 * @author Andres
 */
public class Evento_ComboBox implements ActionListener{
    private final JComboBox Tablas;
    private String Seleccion;
    private final Info_Tabla Obtener_Info;
    private final String datos[];
    
    public Evento_ComboBox( JComboBox Tablas,JTextArea Texto_Area,String datos[]) {
        //Inicializo
        this.Tablas=Tablas;
        Obtener_Info=new Info_Tabla(Texto_Area);
        this.datos=datos;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Seleccion=(String)Tablas.getSelectedItem(); //Muestro lo que uso
        Obtener_Info.ProcesarEncapsular(Seleccion,datos);
    }
}

/*
 clase que cargas las tablas obtenidas inicialmente en el combobox
 */
package controlador;

import javax.swing.JComboBox;

/**
 *
 * @author Andres
 */
public class Carga_Tablas {
    private JComboBox Tablas;
    public Carga_Tablas(JComboBox Tablas) {
        this.Tablas=Tablas;
    }
    public void Carga_Info(String Elemento){
        Tablas.addItem(Elemento);
    }
}

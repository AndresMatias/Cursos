/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import modelo.EjecutaConsulta;

/**
 *
 * @author Andres
 */
public class ControladorBotonConsulta implements ActionListener{

    
    private JComboBox seccion,pais;
    private EjecutaConsulta Consulta;
    private JTextArea Texto_Area;
    private ResultSet rs;
    public ControladorBotonConsulta(JComboBox seccion,JComboBox pais,JTextArea Texto_Area) {
        this.seccion=seccion;
        this.pais=pais;
        this.Texto_Area=Texto_Area;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Consulta=new EjecutaConsulta();
        rs=Consulta.Filtrado((String)seccion.getSelectedItem(), (String)pais.getSelectedItem()); //Inicio consulta sobre datos seleccionados
        Texto_Area.setText("");//Limpio area de texto
        try {
            //Imprimo en el area de texto los datos
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
            rs.close();
        }
        catch (Exception e1) {
        }      
    }   
}

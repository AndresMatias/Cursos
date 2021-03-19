/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorBotonConsulta;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.*;
import modelo.*;

/**
 *
 * @author Andres
 */
public class Lamina2 extends JPanel //Lamina que va encima de mi ventana para empezar a dibujar
{
    int Ancho,Alto;
    private Connection miConexion;
    private JTextArea Texto_Area;
    public JComboBox Combo1,Combo2;
    private JPanel Lamina_Norte;
    
    JButton Boton_Consulta=new JButton("Consulta");
    public Lamina2(int Ancho_Aux,int Alto_Aux)
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
        //Utilizo lamina para ubicar los ComboBox
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
        
        //Pongo a la escucho boton
        Boton_Consulta.addActionListener(new ControladorBotonConsulta(Combo1,Combo2,Texto_Area));       
        //Agrego Botones a la lamina y sete para que botones se ubiquen en North,West y East
        Lamina_Norte.add(Combo1);
        Lamina_Norte.add(Combo2);
        add(Lamina_Norte,BorderLayout.NORTH);
        add(Texto_Area,BorderLayout.CENTER);
        add(Boton_Consulta,BorderLayout.SOUTH);
        //addWindowListener(new ControladorCargaSecciones(this));
    }  
}

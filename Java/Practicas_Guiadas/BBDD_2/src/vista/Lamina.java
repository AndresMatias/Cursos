/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Evento_ComboBox;
import controlador.Obtener_Ruta;
import java.awt.BorderLayout;
import javax.swing.*;
import modelo.Obtener_Tablas;


/**
 *
 * @author Andres
 */
public class Lamina extends JPanel //Lamina que va encima de mi ventana para empezar a dibujar
{
    int Ancho,Alto;
    private JComboBox Tablas;
    private JTextArea Texto_Area;
    private Obtener_Tablas obTablas;
    private Obtener_Ruta Ruta;
    private String Datos[];
    public Lamina(int Ancho_Aux,int Alto_Aux)
    {
        Ancho=Ancho_Aux;
        Alto=Alto_Aux;
        Configuracion();
    }
    public final void Configuracion()
    {
        setLayout(new BorderLayout());
	Tablas=new JComboBox();
        Texto_Area=new JTextArea();
        Ruta=new Obtener_Ruta();
        
        Datos=Ruta.Obtener(this);
        obTablas=new Obtener_Tablas(Tablas); //Inicializo
        obTablas.Info_Tablas(Datos);//Obtengo tablas de la cualquier base de datos
	
        Tablas.addActionListener(new Evento_ComboBox(Tablas,Texto_Area,Datos)); //Pongo a la escucha
	add(Texto_Area,BorderLayout.CENTER);		
	add(Tablas, BorderLayout.NORTH);
    }		
}

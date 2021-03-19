


import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;

import javax.swing.*;


public class Barra_Herramientas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Marco_Barra mimarco=new Marco_Barra();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class Marco_Barra extends JFrame{
	
	public Marco_Barra(){
		
		setTitle("Marco con Barra");
		
		setBounds(500,300,600,450);
		
		lamina=new JPanel();
		
		add(lamina);
		
		// configuraci�n de acciones
		
		Action C_1=new AccionColor("Amarillo",new ImageIcon("src/barra_herramientas_1/colors-icon.png"), Color.yellow);
                Action C_2=new AccionColor("Azul",new ImageIcon("src/barra_herramientas_1/colors-icon.png"), Color.blue);
                Action C_3=new AccionColor("Rojo",new ImageIcon("src/barra_herramientas_1/colors-icon.png"), Color.red);
        
		JMenuBar Menu_Bar=new JMenuBar();
                JMenu Menu=new JMenu("Menu");
                JMenuItem I=new JMenuItem("Prueba");
        
                //Configuraciones 

                 Menu_Bar.add(Menu);
                 Menu.add(C_1);
                 Menu.add(C_2);
                 Menu.add(C_3);
                 Menu.add(I);
                 setJMenuBar(Menu_Bar);
		
		
		
		
	}
		
	
	private class AccionColor extends AbstractAction{
		
		public AccionColor(String nombre, Icon icono, Color c)
                {
			
			putValue(Action.NAME, nombre);
			
			putValue(Action.SMALL_ICON, icono);
			
			putValue(Action.SHORT_DESCRIPTION, "Color de fondo..." + nombre);
			
			putValue("Color", c);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) 
                {
			// TODO Auto-generated method stub
			
			Color c=(Color) getValue("Color");
			
			lamina.setBackground(c);
			
		}		
		
	}
	private JPanel lamina;
}




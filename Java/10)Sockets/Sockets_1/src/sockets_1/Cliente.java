

import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.swing.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCliente mimarco=new MarcoCliente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoCliente extends JFrame{
	
    public MarcoCliente(){
        setBounds(600,300,280,350);	
	LaminaMarcoCliente milamina=new LaminaMarcoCliente();
	add(milamina);
	setVisible(true);
    }	
	
}

class LaminaMarcoCliente extends JPanel{
    public LaminaMarcoCliente(){
        JLabel texto=new JLabel("CHAT");	
        add(texto);
        campo1=new JTextField(20);
        add(campo1);		
        miboton=new JButton("Enviar");	
        EnviarTexto mievento=new EnviarTexto();
        miboton.addActionListener(mievento);
        add(miboton);			
    }
    private class EnviarTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {   
                Socket misocket=new Socket("192.168.0.204",9999); //Creo misocket
                DataOutputStream flujo_salida=new DataOutputStream(misocket.getOutputStream()); //Le indico al flujo de datos por donde va a circular en este caso por "misocket"
                flujo_salida.writeUTF(campo1.getText()); //Que es lo va a circular por el flujo   
                flujo_salida.close(); //Cierro flujo de datos 
            }
            catch (IOException ex) {
                System.out.println("No Conecta: "+ex.getMessage());
            }
        }
        
    }
    private JTextField campo1;
    private JButton miboton;
}

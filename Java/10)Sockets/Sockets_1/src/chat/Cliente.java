package chat;



import sockets_1.*;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
        addWindowListener(new EnvioOnline());
    }	
	
}

class LaminaMarcoCliente extends JPanel implements Runnable{
    public LaminaMarcoCliente(){
        String usuario=JOptionPane.showInputDialog("Nick: ");
        JLabel n_nick=new JLabel("Nick: ");
        add(n_nick);
        nick=new JLabel();
        nick.setText(usuario);
        add(nick); 
        JLabel texto=new JLabel("CHAT");	
        add(texto);
        ip=new JComboBox();
        ip.addItem("Usuario 1");
        ip.addItem("Usuario 2");
        ip.addItem("Usuario 3");    
        add(ip);
        campochat=new JTextArea(12,20);
        add(campochat);
        campo1=new JTextField(20);
        add(campo1);		
        miboton=new JButton("Enviar");	
        EnviarTexto mievento=new EnviarTexto();
        miboton.addActionListener(mievento);
        add(miboton);	
        Thread mihilo=new Thread(this); //this porque es dentro de la propia clase
        mihilo.start();
    }

    @Override
    public void run() { //Hilo que pone a la escucha un socket para recibir mensaje
        try {
            ServerSocket servidor_cliente=new ServerSocket(9090);
            Socket cliente;
            PaqueteEnvio PaqueteRecibido;
            while (true) {                
                cliente=servidor_cliente.accept();
                ObjectInputStream flujo_entrada=new ObjectInputStream(cliente.getInputStream());
                PaqueteRecibido=(PaqueteEnvio) flujo_entrada.readObject(); //Casteo
                campochat.append("\n"+PaqueteRecibido.getNick()+": "+PaqueteRecibido.getMensaje());
            }
        } 
        catch (Exception e) {
        }
    }
    private class EnviarTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            campochat.append("\n"+campo1.getText());
            try {   
                Socket misocket=new Socket("192.168.0.204",9999); //Creo misocket
                PaqueteEnvio datos=new PaqueteEnvio();
                //Seteo ip nick y mensaje a enviar
                datos.setNick(nick.getText());
                datos.setIp(ip.getSelectedItem().toString()); //El .toString() Convierte a string
                datos.setMensaje(campo1.getText());
                ObjectOutputStream paquete_datos=new ObjectOutputStream(misocket.getOutputStream()); //Se utiliza objetOutputStream porq voy a enviar un objeto
                paquete_datos.writeObject(datos);
                misocket.close();
            }
            catch (IOException ex) {
                System.out.println("No Conecta: "+ex.getMessage());
            }
        }
        
    }
    private JTextField campo1;
    private JComboBox ip;
    private JLabel nick;
    private JTextArea campochat;
    private JButton miboton;
}

class PaqueteEnvio implements Serializable{
    private String nick,ip,mensaje;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

//----------------------------------Envio Señal Online----------------------------------
class EnvioOnline extends WindowAdapter{
    public void windowOpened(WindowEvent evento){
        try {
            Socket misocket=new Socket("192.168.0.204",9999); //Ver ese puerto en el servidor creo que esta en el hilo
            PaqueteEnvio datos=new PaqueteEnvio();
            datos.setMensaje("Online");
            ObjectOutputStream paquete_datos=new ObjectOutputStream(misocket.getOutputStream()); //Se utiliza objetOutputStream porq voy a enviar un objeto
            paquete_datos.writeObject(datos);
            misocket.close();
        } 
        catch (Exception e){
        }
    }
}
//----------------------------------------------------------------------------------------------
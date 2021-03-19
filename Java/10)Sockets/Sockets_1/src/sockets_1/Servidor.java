package sockets_1;


import javax.swing.*;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            MarcoServidor mimarco=new MarcoServidor();
            mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}	
}

class MarcoServidor extends JFrame implements Runnable{
	
	public MarcoServidor(){
		setBounds(120,300,280,350); //seteo marco
                setTitle("Servidor");
		JPanel milamina= new JPanel(); //inicializo mi lamina
		milamina.setLayout(new BorderLayout());	 //seteo config de lamina
		areatexto=new JTextArea();	//inicializo areatexto	
		milamina.add(areatexto,BorderLayout.CENTER);	//Agrego areatexto	
		add(milamina); //agrego lamina al marco
		setVisible(true); //lo hago visible
                Thread mihilo=new Thread(this);
                mihilo.start();
	}
    @Override
    public void run() {
            try {             
                ServerSocket miserver=new ServerSocket(9999);
                Socket misocket=miserver.accept(); //Acepto la conexion
                DataInputStream flujo_entrada=new DataInputStream(misocket.getInputStream()); //Le indico por donde va a circular
                String entrada=flujo_entrada.readUTF();
                areatexto.append("\n"+entrada); //agrego texto al area de texto
                misocket.close(); //cierro socket
            }   
            catch (IOException ex) {
                Logger.getLogger(MarcoServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private JTextArea areatexto;
}

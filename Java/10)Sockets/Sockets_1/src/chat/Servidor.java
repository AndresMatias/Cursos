package chat;


import sockets_1.*;
import javax.swing.*;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
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
                String nick,ip,mensaje;
                PaqueteEnvio paquete_recibido;//Esta clase estan en cliente.java
                ServerSocket miserver=new ServerSocket(9999);
                while(true){
                    Socket misocket=miserver.accept(); //Acepto la conexion
                    ObjectInputStream paquete_datos=new ObjectInputStream(misocket.getInputStream());
                    paquete_recibido=(PaqueteEnvio)paquete_datos.readObject();
                    nick=paquete_recibido.getNick();
                    ip=paquete_recibido.getIp();
                    mensaje=paquete_recibido.getMensaje();
                    if(!mensaje.equals("Online")){      
                        areatexto.append("\n"+nick+": "+mensaje+" para "+ip);
                        Socket Destinatario=new Socket(ip,9090);
                        ObjectOutputStream paquete_envio=new ObjectOutputStream(Destinatario.getOutputStream()); //Se utiliza objetOutputStream porq voy a enviar un objeto
                        paquete_envio.writeObject(paquete_recibido);
                        paquete_envio.close();
                        paquete_datos.close();
                        Destinatario.close(); //cierro socket
                        misocket.close(); //cierro socket
                    }
                    else{
                        //-------------------------Detecta Online------------------------
                        InetAddress localizacion=misocket.getInetAddress(); //Almaceno la direccion del cliente con el que acabo de conectar
                        String IpRemota=localizacion.getHostAddress(); //Almaceno ip del cliente
                        System.out.println("Online: "+IpRemota);
                        //---------------------------------------------------------------
                    }
                }        
            }   
            catch (IOException ex) {
                Logger.getLogger(MarcoServidor.class.getName()).log(Level.SEVERE, null, ex);
            }catch (ClassNotFoundException ex){ //Exepcion que pertenecia al cast de paquete recibido
                Logger.getLogger(MarcoServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private JTextArea areatexto;
}

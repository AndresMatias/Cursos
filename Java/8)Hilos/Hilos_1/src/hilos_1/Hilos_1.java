/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos_1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Andres
 */
public class Hilos_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame marco=new MarcoRebote();
		
	marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	marco.setVisible(true);
    }
    
}
//Movimiento de la pelota-----------------------------------------------------------------------------------------

class Pelota{
	
	// Mueve la pelota invirtiendo posici�n si choca con l�mites
	
	public void mueve_pelota(Rectangle2D limites){
		
		x+=dx;
		
		y+=dy;
		
		if(x<limites.getMinX()){
			
			x=limites.getMinX();
			
			dx=-dx;
		}
		
		if(x + TAMX>=limites.getMaxX()){
			
			x=limites.getMaxX() - TAMX;
			
			dx=-dx;
		}
		
		if(y<limites.getMinY()){
			
			y=limites.getMinY();
			
			dy=-dy;
		}
		
		if(y + TAMY>=limites.getMaxY()){
			
			y=limites.getMaxY()-TAMY;
			
			dy=-dy;
			
		}
		
	}
	
	//Forma de la pelota en su posici�n inicial
	
	public Ellipse2D getShape(){
		
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
		
	}	
	
	private static final int TAMX=15;
	
	private static final int TAMY=15;
	
	private double x=0;
	
	private double y=0;
	
	private double dx=1;
	
	private double dy=1;
	
	
}

// L�mina que dibuja las pelotas----------------------------------------------------------------------


class LaminaPelota extends JPanel{
	
	//A�adimos pelota a la l�mina
	
	public void add(Pelota b){
		
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		for(Pelota b: pelotas){
			
			g2.fill(b.getShape());
		}
		
	}
	
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}


//Marco con l�mina y botones------------------------------------------------------------------------------

class MarcoRebote extends JFrame{
	
	public MarcoRebote(){
		
		setBounds(600,300,400,350);
		
		setTitle ("Rebotes");
		
		lamina=new LaminaPelota();
		
		add(lamina, BorderLayout.CENTER);
		
		JPanel laminaBotones=new JPanel();
			
		add(laminaBotones, BorderLayout.SOUTH);
                a1=new JButton("Hilo1");
                a2=new JButton("Hilo2");
                a3=new JButton("Hilo3");
                a1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        comienza_el_juego(e);
                    }
                });
                a2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        comienza_el_juego(e);
                    }
                });
                a3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        comienza_el_juego(e);
                    }
                });
                laminaBotones.add(a1);
                laminaBotones.add(a2);
                laminaBotones.add(a3);
                d1=new JButton("D1");
                d2=new JButton("D2");
                d3=new JButton("D3");
                d1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        detener(e);
                    }
                });
               d2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        detener(e);
                    }
                });
                d3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        detener(e);
                    }
                });
                laminaBotones.add(d1);
                laminaBotones.add(d2);
                laminaBotones.add(d3);
	}
		
	
	//A�ade pelota y la bota 1000 veces
	
	public void comienza_el_juego (ActionEvent e){
            Pelota pelota=new Pelota();
            lamina.add(pelota);
            Runnable r=new pelotaHilos(pelota,lamina); //Interfaz Runeable
            if(e.getSource().equals(a1))
            {
                t1=new Thread(r);
                t1.start();
            }
            if(e.getSource().equals(a2))
            {
                t2=new Thread(r);
                t2.start();
            }
            if(e.getSource().equals(a3))
            {
                t3=new Thread(r);
                t3.start();
            }
	}
	public void detener(ActionEvent e)
        {
            //t.stop(); //No se usa obsoleto
            if(e.getSource().equals(d1))
            {
                t1.interrupt();
            }
            if(e.getSource().equals(d2))
            {
                t2.interrupt();
            }
            if(e.getSource().equals(d3))
            {
                t3.interrupt();
            }
        }
        Thread t1,t2,t3;
        JButton a1,a2,a3,d1,d2,d3;
	private LaminaPelota lamina;
}

class pelotaHilos implements Runnable{
    public pelotaHilos(Pelota unaPelota, Component unComponente)
    {
        pelota=unaPelota;
        Componente=unComponente;
    }
    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //while(!Thread.interrupted())
        while(!Thread.currentThread().isInterrupted())
        {
            pelota.mueve_pelota(Componente.getBounds());
            Componente.paint(Componente.getGraphics());
            try {
                Thread.sleep(4);
            } catch (InterruptedException ex) {
                System.out.println("Imposible su interrupcion");
                Thread.currentThread().interrupt();
            }
        }
    }
    private Pelota pelota;
    private Component Componente;
}
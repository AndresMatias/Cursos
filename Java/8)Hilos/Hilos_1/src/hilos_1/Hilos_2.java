/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos_1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class Hilos_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
//        HilosVarios Hilo1=new HilosVarios();
//        HilosVarios Hilo2=new HilosVarios();
//        Hilo1.start(); //Comienza Hilo 1
//        try {
//            Hilo1.join(); //Este hilo tiene que ejecurtarse por completo hasta su muerte solo se ejecuta este hilo, Hilo2 se ejecutara despues de que termine hilo1
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Hilos_2.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Hilo2.start(); //Comienza Hilo 2
//        try {
//            Hilo2.join(); //Ejecuta solo el hilo 2 hasta su muerte
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Hilos_2.class.getName()).log(Level.SEVERE, null, ex);
//        }
        HilosVarios Hilo1=new HilosVarios();   
        HilosVarios2 Hilo2=new HilosVarios2(Hilo1); //Paso por parametro hasta que no termine el 1 no empieza el 2
        Hilo2.start(); // Supuestamente comienza primero el hilo 1
        Hilo1.start();
        System.out.println("Termina tarea"); //Hilo principal main y se ejecutara al mismo tiempo
    }
}
class HilosVarios extends Thread{
    @Override
    public void run(){
       for(int i=0;i<15;i++){
           try {
               System.out.println("Ejecutando Hilo "+getName());
               Thread.sleep(70);
           } catch (InterruptedException ex) {
               Logger.getLogger(HilosVarios.class.getName()).log(Level.SEVERE, null, ex);
           }
       } 
    }
}

class HilosVarios2 extends Thread{
    public HilosVarios2(Thread Hilo)
    {
        this.Hilo=Hilo;
    }
    @Override
    public void run(){
        try {
            Hilo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(HilosVarios2.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<15;i++){
           try {
               System.out.println("Ejecutando Hilo "+getName());
               Thread.sleep(70);
           } catch (InterruptedException ex) {
               Logger.getLogger(HilosVarios.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }
    private Thread Hilo;
}
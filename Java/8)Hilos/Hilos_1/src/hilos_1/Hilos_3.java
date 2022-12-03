/*
    video 173 al 175?
 */
package hilos_1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class Hilos_3 {
    public static void main(String[] args) {
        Banco1 b=new Banco1();
        for(int i=0;i<100;i++){
            EjecucionTransferencia1 r=new EjecucionTransferencia1(b, i, 2000);
            Thread t=new Thread(r);
            t.start();
        }
    }   
}
class Banco1{
    private final double[] cuentas;
    private Lock CierreBanco=new ReentrantLock(); //Para bloquear una parte del codigo para que solo acceda un hilo a la vez
    private Condition SaldoSuficiente;
    public Banco1(){
        cuentas=new double[100];
        for(int i=0;i<cuentas.length;i++)
        {
            cuentas[i]=2000;
        }
        SaldoSuficiente=CierreBanco.newCondition();
    }
    public void transferencia(int origen,int destino, double cantidad) throws InterruptedException{ //Ver lo de throws
        CierreBanco.lock(); //Bloqueo solo para que pueda ser accedido por el hilo presente
        try{
            while(cuentas[origen]<cantidad){//Si la cantidad de dinero que quiero transferir superar el dinero en la cuenta
               // System.out.println("-------Cantidad Insuficiente------: "+origen+" Saldo: "+cuentas[origen]+"....."+cantidad);
                SaldoSuficiente.await(); //Pone hilo a la espera y libera codigo
            }
            System.out.println(Thread.currentThread()); //Hilo que va a ejecutar la trasferencia
            cuentas[origen]-=cantidad; //Dinero que sale de la cuenta origen
            System.out.printf("%10.2f de %d para %d\n",cantidad,origen,destino);
            cuentas[destino]+=cantidad;//Dinero que entra en la cuenta destino
            System.out.printf("Saldo total: %10.2f\n",getSaldoTotal());
            SaldoSuficiente.signalAll();
        }
        finally{
            CierreBanco.unlock(); //Desbloqueo en una clausa finally por las dudas de que surga una excepcion
        }
    }
    public double getSaldoTotal(){
        double suma_cuentas=0;
        for(double a: cuentas)
        {
            suma_cuentas+=a;
        }
        return suma_cuentas;
    }
}

class EjecucionTransferencia1 implements Runnable{

    private Banco1 banco;
    private int origen;
    private double cantMax;
    public EjecucionTransferencia1(Banco1 b,int origen,double max){
        banco=b;
        this.origen=origen;
        cantMax=max;
    }
    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            while(true){
                    int destino=(int)(100*Math.random()); //casting de nro aletoria de 0 a 100
                    double cantidad=cantMax*Math.random(); //cantidad a transferir
                    banco.transferencia(origen, destino, cantidad);
                    Thread.sleep(((int)Math.random()*10));
            } 
        }
        catch (InterruptedException ex) {
                Logger.getLogger(EjecucionTransferencia1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
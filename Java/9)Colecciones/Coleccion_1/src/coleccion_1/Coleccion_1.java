/*
Repasar video 181 182 para ver como funciona bien
 */
package coleccion_1;

import java.util.*;

/**
 *
 * @author Andres
 */
public class Coleccion_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente cl1=new Cliente("Andres", "0001", 200);
        Cliente cl2=new Cliente("Jorge", "0002", 260);
        Cliente cl3=new Cliente("Sandro", "0003", 250);
        Cliente cl4=new Cliente("Julio", "0004", 100);
        Cliente cl5=new Cliente("Julio", "0004", 100); //Mismo nro de cuenta
        Set <Cliente> ClientesBanco=new HashSet<Cliente>(); //Creo collecion "Set" es una interfas por eso uso HashSet(Una clase) para que sea implementada
       //Agrego los clientes a la coleccion
        ClientesBanco.add(cl1);
        ClientesBanco.add(cl2);
        ClientesBanco.add(cl3);
        ClientesBanco.add(cl4);
        ClientesBanco.add(cl5);
/*        for(Cliente p : ClientesBanco){
            if(p.getNombre().equals("Julio")){
                ClientesBanco.remove(p);
            }
        }*/
        Iterator<Cliente> it=ClientesBanco.iterator();
         while(it.hasNext())//Mientras haya cosas que recorrer
        {
            String nombre_cliente=it.next().getNombre(); //next pasa al siguiente elemento y luego lo analiza
            if(nombre_cliente.equals("Julio")){
                it.remove();
            }
        }
        for(Cliente p : ClientesBanco){
            System.out.println(p.getNombre()+" "+p.getNroCuenta()+" "+p.getSaldo());
        }
/*        Iterator<Cliente> it=ClientesBanco.iterator();
        while(it.hasNext())//Mientras haya cosas que recorrer
        {
            String nombre_cliente=it.next().getNombre(); //next pasa al siguiente elemento y luego lo analiza
            System.out.println(nombre_cliente);
        }*/
    }
}

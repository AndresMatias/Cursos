/*
    Video 185
 */
package coleccion_1;
import java.util.*;
/**
 *
 * @author Andres
 */
public class ListaEnlazada2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<String> Paises=new LinkedList<String>();
        Paises.add("España");
        Paises.add("Colombia");
        Paises.add("Mexico");
        Paises.add("Peru");
        
        LinkedList<String> Capitales=new LinkedList<String>();
        Capitales.add("Madrid");
        Capitales.add("Bogota");
        Capitales.add("DF");
        Capitales.add("Lima");
//        System.out.println(Paises.size());
//        System.out.println(Capitales.size());
        ListIterator<String> itA=Paises.listIterator();
        ListIterator<String> itB=Capitales.listIterator();
        
        while(itB.hasNext()){
            if(itA.hasNext()){
                itA.next();       
            }
            itA.add(itB.next()); //Agrego Capitales
        }
        System.out.println(Paises);
        itB=Capitales.listIterator(); //Vuelve a su posicion original
        while(itB.hasNext()){
            itB.next();
            if(itB.hasNext()){
                itB.next();
                itB.remove();
            }
        }
         System.out.println(Capitales); //Solo quedan Madrid y DF
         Paises.removeAll(Capitales); //Elimina la coleccion Capitales como las modifique solo elimina madrid y df
         System.out.println(Paises);
    }
    
}

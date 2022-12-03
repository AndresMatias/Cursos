/*
    Video 184
 */
package coleccion_1;

import java.util.*;

/**
 *
 * @author Andres
 */
public class ListaEnlazada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList <String> personas=new LinkedList<String>();
        personas.add("Pepe");
        personas.add("Sandra");
        personas.add("Ana");
        personas.add("Julio");
        System.out.println(personas.size());
        personas.add("Laura"); //Se agrega en ultima posicion
        ListIterator<String> it=personas.listIterator();
        it.next();
        it.add("Clemente"); //Se posiciona despues de Pepe
        for(String per : personas){
            System.out.println("Nombre: "+per);
        }
            
    }
    
}

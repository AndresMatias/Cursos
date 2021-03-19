/*
 * Video 189
 */
package coleccion_1;
import java.util.*;
/**
 *
 * @author Andres
 */
public class Mapas1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<String,Empleado> personal=new HashMap<String,Empleado>();//HashMap<clave,valor>
        personal.put("145", new Empleado("Andres"));
        personal.put("146", new Empleado("Julio"));
        personal.put("147", new Empleado("Ana"));
        personal.put("148", new Empleado("Sandra"));
        System.out.println(personal);
        personal.remove("147"); //Elimino con la clave 147
        System.out.println(personal);
        personal.put("148", new Empleado("Natalia")); //Reemplazo a Sandra con la clave
        System.out.println(personal);
        //System.out.println(personal.entrySet()); //Lo mismo que arriva pero en forma de entrySet
        for(Map.Entry<String,Empleado> entrada : personal.entrySet()){
            String clave=entrada.getKey();
            Empleado valor=entrada.getValue(); //el meotdo toString se llama por defecto
            System.out.println("Clave: "+clave+", Valor: "+valor);
        }
    }
    
}
class Empleado{
    private String nombre;
    private double sueldo;
    public Empleado(String nombre){
        this.nombre = nombre;
        this.sueldo = 2000;
    }
    public String toString(){
        return "[Nombre: "+nombre+", sueldo: "+sueldo+"]";
    }
}
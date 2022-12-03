/*
Video 161 permite crear listas dinamicas
 */
package array_list;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Andres
 */
public class Array_List {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ArrayList <Empleado> lista_empleados=new ArrayList<Empleado>(); 
       
        // lista_empleados.ensureCapacity(12); //Crea un array list de 12 para evitar el cosumo excesivo de recurso cuando se pasa los 10 de crear un array mas grande pasar todo al otro array y destruir el anterior
        
        lista_empleados.add(new Empleado("Andres",24,0));
        lista_empleados.add(new Empleado("Jorge",25,1000));
        lista_empleados.add(new Empleado("Daniel",22,100));
        lista_empleados.add(new Empleado("Andres",26,10));
        lista_empleados.add(new Empleado("Andres",24,0));
        lista_empleados.add(new Empleado("Jorge",25,1000));
        lista_empleados.add(new Empleado("Daniel",22,100));
        lista_empleados.add(new Empleado("Andres",26,10));
        lista_empleados.add(new Empleado("Andres",24,0));
        lista_empleados.add(new Empleado("Jorge",25,1000));
        lista_empleados.add(new Empleado("Andres",24,0));
        lista_empleados.add(new Empleado("Jorge",25,1000));
        
        lista_empleados.set(1,new Empleado("Olga", 20,2000)); //Inserto un nuevo elemento en la 2da posicion pero se reemplaza el elemento de la 2da posicion
        lista_empleados.get(5).mostrarDatos(); //Muestro algo en particular
        //lista_empleados.trimToSize();//Corta el exeso de memoria (min 19:25) recorta el espacio sobrante del array list y cierra el array list
        
        System.out.println(lista_empleados.size());
        System.out.println("\n\n\n");
       
       /* for(Empleado e : lista_empleados) //Por for each
        {
           e.mostrarDatos();
        }*/
       
        Iterator <Empleado> mi_iterador=lista_empleados.iterator();
        while (mi_iterador.hasNext()) 
        {
            mi_iterador.next().mostrarDatos();        
        }
        mi_iterador.hasNext();
       /* for(int i=0;i<lista_empleados.size();i++) //Por for comun
        {
           Empleado e=lista_empleados.get(i);
           e.mostrarDatos();
        }*/
       
        /*Empleado vector[]=new Empleado[lista_empleados.size()];
        lista_empleados.toArray(vector); //metodo to array para copiar todo en un vector
        for(int i=0;i<vector.length;i++) //Por for comun con vector comun
        {
           vector[i].mostrarDatos();
        }*/
    }    
}
class Empleado {
    private String Nombre;
    private int Edad,Salario;
    public Empleado(String Nombre,int Edad,int Salario) 
        {
            this.Nombre=Nombre;
            this.Edad=Edad;
            this.Salario=Salario;
        }
    public void mostrarDatos()
    {
        System.out.println("Nombre:"+Nombre+", Edad:"+Edad+", Salario:"+Salario);
    }
}
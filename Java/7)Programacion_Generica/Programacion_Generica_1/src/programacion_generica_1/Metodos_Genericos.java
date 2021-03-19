/*
      Video 166
      //Ver video 167 herencia
 */
package programacion_generica_1;

import java.util.GregorianCalendar;

/**
 *
 * @author Andres
 */
public class Metodos_Genericos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String nombres[]={"jose","maria","pepe"};
        String elementos=MisMatrices.<String>getElementos(nombres); // <String>: Se puede ignorar
        System.out.println(MisMatrices.<String>getElementos(nombres));
         System.out.println(MisMatrices.<String>getMenor(nombres));
         GregorianCalendar fechas[]={   new GregorianCalendar(2015,05,12),
                                        new GregorianCalendar(2016,05,11),
                                        new GregorianCalendar(2017,05,10)};
        System.out.println(MisMatrices.getMenor(fechas)); //ver como ahcer para que de bien el formato
    }
    
}
 class MisMatrices{
    public static <T> String getElementos(T[]b){
         return "El array tiene "+b.length+" elementos";
     }
    public static <T extends Comparable> T getMenor(T[]a){
         if((a==null) || (a.length==0))
         {
            return null;  
         }
         T ElementoMenor=a[0];
         //System.out.println(ElementoMenor);
         for(int i=1;i<a.length;i++)
         {
              /*System.out.println(ElementoMenor);*/
              //System.out.println(a[i]);
             if(ElementoMenor.compareTo(a[i])>0)
             {
                 ElementoMenor=a[i];
             }
       
         }
         return ElementoMenor;
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
    public String mostrarDatos()
    {
        return ("Nombre:"+Nombre+", Edad:"+Edad+", Salario:"+Salario);
    }
}
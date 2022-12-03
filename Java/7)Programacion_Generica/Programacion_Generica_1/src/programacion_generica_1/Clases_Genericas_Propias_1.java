/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion_generica_1;

/**
 *
 * @author Andres
 */
public class Clases_Genericas_Propias_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Clases_Genericas<String> una=new Clases_Genericas<String>();
        una.setPrimero("Juan");
        System.out.println(una.getPrimero());
        
        Persona pers1=new Persona("Ana");
        Clases_Genericas<Persona> pers2=new Clases_Genericas<Persona>();
        pers2.setPrimero(pers1);
         System.out.println(pers2.getPrimero());
    }
    
}

class Persona{
    public Persona(String nombre){
        this.nombre=nombre;
    }
    @Override
    public String toString(){ //Para convertir a string sobreescribe el metodo toString repasar
        return nombre;
    }
    private String nombre;
}
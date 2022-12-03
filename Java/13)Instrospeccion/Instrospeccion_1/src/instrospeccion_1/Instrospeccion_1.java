/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrospeccion_1;

/**
 *
 * @author Andres
 */
public class Instrospeccion_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        persona antonio=new persona("Antonio");
        empleado maria=new empleado("Maria", 1000);
        //Antonio
        System.out.println(antonio.getNombre());
        //Maria
        System.out.println(maria.getNombre());
        System.out.println(maria.getSalario());
        
        //Instrospeccion 
        Class cl1=antonio.getClass(); //devuelve el paquete donde esta y que clase es
        System.out.println(cl1);
        System.out.println("getName: "+cl1.getName()); //lo mismo pero sin poner la palabra class delante
        //ver forName no entiende bien que hace o para que sirve
    }
    
}

class persona{
    private String Nombre;
    public persona(String Nombre) {
        this.Nombre=Nombre;
    }

    public String getNombre() {
        return Nombre;
    }
     
}

class empleado extends persona{
    private double Salario;
    public empleado(String Nombre,double Salario) {
        super(Nombre);
        this.Salario=Salario;
    }
    void setIncentivo(double incentivo){
        Salario=Salario+incentivo;
    }

    public String getSalario() {
        return "El Salario es " + Salario;
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrospeccion_1;

import java.lang.module.ModuleDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class Instrospeccion_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        String NombreClase;
        
        System.out.println("Introduce el nombre de la clase: ");
        NombreClase=entrada.next(); 
        try {
            Class cl1=Class.forName(NombreClase); //con forname ingreso donde esta la clase ej: java.lang.Math
            Class superCl1=cl1.getSuperclass();
            System.out.println("Clase: "+NombreClase);
            if(superCl1!=null && superCl1!=Object.class){ //Si heredas de objet y de otra clase imprime
                System.out.println("extends: "+superCl1.getName());
            }
            System.out.println("\n--------------Constructores--------------\n");
            imprimirConstructores(cl1);
            System.out.println("\n--------------Metodos--------------\n");
            imprimirMetodos(cl1);
            System.out.println("\n--------------Campos--------------\n");
            imprimirCampos(cl1);
        } catch (Exception e) {
        }
        
    }
    //Imprime constructores de la clase
    public static void imprimirConstructores(Class cl){
        Constructor[] constructores=cl.getDeclaredConstructors();
        for(Constructor c:constructores){
            String nombre=c.getName();
            System.out.print("   "+ Modifier.toString(c.getModifiers())); //imprimo modificador del constructor
            System.out.print("   "+ nombre + "("); //imprimo nombre del constructor
            //Imprime tipo de parametros
            Class[] tipoParams=c.getParameterTypes();
            for(int i=0;i<tipoParams.length;i++){
                if(i>0){
                    System.out.print(",  ");
                }
                System.out.print(tipoParams[i].getName());
            }
            System.out.print(");");
            System.out.println();
        }   
    }
    //Imprime metodos de la clase
    public static void imprimirMetodos(Class cl){
        Method[]  metodos=cl.getDeclaredMethods();
        for(Method m: metodos){
            Class tipoDeVuelto=m.getReturnType(); //tipo de dato que devuelve el metodo
            String nombre=m.getName();
            //Imprime modificador tipo y nombre
            System.out.print("   " + Modifier.toString(m.getModifiers())); //modificadores
            System.out.print("   " + tipoDeVuelto.getName() + " " + nombre + "(");
            //Imprime tipo de parametros
            Class[] tipoParams=m.getParameterTypes();
            for(int i=0;i<tipoParams.length;i++){
                if(i>0){
                    System.out.print(",  ");
                }
                System.out.print(tipoParams[i].getName());
            }
            System.out.print(");");
            System.out.println();
        }   
    }
    //Imprime campos de clase de la clase
    public static void imprimirCampos(Class cl){
        Field[]  campos=cl.getDeclaredFields();
        for(Field f: campos){
            Class tipoCampo=f.getType(); //tipo de dato que devuelve el metodo
            String nombre=f.getName();
            //Imprime modificador tipo y nombre
            System.out.print("   " + Modifier.toString(f.getModifiers()));
            System.out.print("   " + tipoCampo.getName() + " " + nombre + "(");
            System.out.println();
        }   
    }
}

//probar introduciendo java.lang.Math o instrospeccion_1.empleado
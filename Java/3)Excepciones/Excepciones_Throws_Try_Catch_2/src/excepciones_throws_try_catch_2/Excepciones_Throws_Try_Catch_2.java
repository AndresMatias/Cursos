/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones_throws_try_catch_2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author Andres
 */
public class Excepciones_Throws_Try_Catch_2 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println("Que deseas hacer?");
        System.out.println("1. Introducir datos");
	System.out.println("2. Salir del programa");
        Scanner entrada=new Scanner(System.in);
	int decision=entrada.nextInt();
	if (decision==1)
        {
            try 
            {
                Pedir_Datos();
            } 
            catch(InputMismatchException e) 
            {
                System.out.println("Error en el tipo de dato");
            }          
	}
        else
        {
            System.out.println("Adios");
            System.exit(0);
	}
	entrada.close();		
    }                         //throws IOException si reemplazo con esto en el try catch tambien pero el programa se va a clavar proque cuando se genere la excepcion no seria de ioexcepcion  
    static void Pedir_Datos() throws InputMismatchException //throws InputMismatchException:Si no va bien, genera un objeto tipo "InputMismatchException" 
    {                                                       //Si lanzo una exceopcion de ioexcepcion en vez de runtime, estoy obligado a usar try y cathc video 145 minuto 6:40
        //try {
            Scanner entrada=new Scanner(System.in);
            System.out.println("Introduce tu nombre, por favor");
            String nombre_usuario=entrada.nextLine();
            System.out.println("Introduce edad, por favor");
            int edad=entrada.nextInt();	
            System.out.println("Hola " + nombre_usuario + ". El año que viene tendras " + (edad+1) + " años");
            entrada.close();
            System.out.println("Hemos terminado");
        /*} 
        catch (InputMismatchException e) 
        {
            System.out.println("Error en el tipo de dato");
        }*/
    }  
}


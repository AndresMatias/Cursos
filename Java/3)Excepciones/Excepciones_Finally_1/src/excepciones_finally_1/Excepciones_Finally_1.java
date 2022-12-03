/*
    Video 150
 */
package excepciones_finally_1;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
public class Excepciones_Finally_1 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner Entrada=new Scanner(System.in);
        int Figura=5;
        System.out.println("Eliga opcion\n1)Cuadrado\n2)Circulo\n3)Rectangulo\n4)Triangulo");
        
        try
        {
            Figura=Entrada.nextInt(); //Si se produce un error ignora a Entrada.close no cerrando la conexion por lo cual no libera recursos
            //Entrada.close();
        }
        catch(Exception e)
        {
            System.out.println("Error");
        }
        finally //Codigo que se ejecuta tanto si se ejecuta o no el codigo en el try catch
        {
            Entrada.close(); //Libero recurso
        }
        switch(Figura)
        {
            case 1:
                int Lado=Integer.parseInt(JOptionPane.showInputDialog("Ingrese lado"));
                System.out.println("Area: "+ Math.pow(Lado,2));
                break; //Sino pongo break pasa al siguiente case
            case 2:
                int Radio=Integer.parseInt(JOptionPane.showInputDialog("Ingrese Radio"));
                System.out.println("Area: "+Math.PI*Math.pow(Radio,2));
                break;
            case 3:
                int Base=Integer.parseInt(JOptionPane.showInputDialog("Ingrese base"));
                int Altura=Integer.parseInt(JOptionPane.showInputDialog("Ingrese altura"));
                System.out.println("Area"+(Base*Altura));
                break;
            case 4:
                int Base_1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese base"));
                int Altura_1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese altura"));
                System.out.println("Area"+((Base_1*Altura_1)/2));
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }    
        int Altura=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su altura en cm: "));
        System.out.println("Su peso idel si es hombre es: "+ (Altura-110)+"kg");
        System.out.println("Su peso idel si es mujer es: "+ (Altura-120)+"kg");
    }
}

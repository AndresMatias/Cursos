/*
    Este programa captura varias excepciones en caso de que se produscan
 */
package excepciones_capturas_varias_1;

import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
public class Excepciones_Capturas_Varias_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //Se considera mala practica de programcion usar try y catch para excepciones no controladas proque pueden corregirse desde el codigo
        try
        {
           Division(); 
        }
        catch(ArithmeticException e)
        {
            System.out.println("Divison por 0");
        }
        catch(NumberFormatException e)
        {
            System.out.println("No introduciste un numero");
            System.out.println(e.getMessage()); //Devuelve los datos errones que introduciste
            System.out.println("Se ha generado este tipo de error: "+e.getClass()); //Clase a la que pertenece el metodo
            System.out.println("Se ha generado este tipo de error: "+e.getClass().getName()); //getName: Nombre del paquete al que pertenece 
        }
        
    }
    static void Division()
    {
        int N1=Integer.parseInt(JOptionPane.showInputDialog("Dividendo"));
        int N2=Integer.parseInt(JOptionPane.showInputDialog("Divisor"));
        System.out.println("Resultado de la division: "+(N1/N2));
    }
}

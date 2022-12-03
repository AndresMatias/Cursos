/*
    throws:En declaracion de metodos
    throw:En cualquier punto del codigo
    video 146
 */
package excepciones_throw.no_throws._1;

import java.io.EOFException;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
public class Excepciones_ThrowNo_Throws_1 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String Mail=JOptionPane.showInputDialog("Mail");
        try 
        {
            Analisis_Mail(Mail);
        } catch (EOFException e) 
        {
            System.out.println("Error");
        }
        
    }
    static void Analisis_Mail(String Mi_Mail) throws EOFException//Static:No se invoca sobre un objeto
    {
        int arroba=0;
        boolean punto=false;
        if(Mi_Mail.length()<4)
        {
            //ArrayIndexOutOfBoundsException Mi_Excepcion=new ArrayIndexOutOfBoundsException();
            //throw Mi_Excepcion; //Lanzo excepcion manualmente throw sin s
            //Tambien puedo declarar de la siguiente forma
            //throw new ArrayIndexOutOfBoundsException(); //No comprobada
            throw new EOFException();   //Comproba obliga a usar try y catch en la parte de arriba en el main preferentemente
                                        //No tiene sentido esta excepcion pero se lanza igual manualmente por lo tanto va a suceder si o si
        }
        else
        {
            for(int i=0;i<Mi_Mail.length();i++)
            {
                if(Mi_Mail.charAt(i)=='@')
                {
                    arroba++;
                }
                if(Mi_Mail.charAt(i)=='.')
                {
                    punto=true;
                }
            }
            if((arroba==1)&&(punto==true))
            {
                System.out.println("Correcto");
            }
            else
            {
                System.out.println("Incorrecto");
            }
        }
    }
}

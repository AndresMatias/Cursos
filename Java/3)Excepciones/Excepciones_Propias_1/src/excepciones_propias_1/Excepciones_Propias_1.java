/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones_propias_1;

import java.io.EOFException;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
public class Excepciones_Propias_1 
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
        } catch (Mail_Error_Excepcion e) 
        {
            System.out.println("Error");
            e.printStackTrace(); //Imprime la pila de llamada del error, da pista de lo que pasa
        }       
    }
    static void Analisis_Mail(String Mi_Mail) throws Mail_Error_Excepcion //Static:No se invoca sobre un objeto
    {
        int arroba=0;
        boolean punto=false;
        if(Mi_Mail.length()<4)
        {
            //throw new Mail_Error_Excepcion(); //Utiliza constructor por defecto de Exception
            throw new Mail_Error_Excepcion("El mail debe tener mas de 3 caracteres"); //Sale este mensaje si no capturo el error con try catch
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
class Mail_Error_Excepcion extends Exception //Creo mi propia excepcion puede heredar de runtimeexception pero es un erro no controlado por lo cual no es obligatorio el try catch
{
    //Se recomiendan tener dos constructores uno por defecto y otro con string para indicar un msj si no captura la excepcion
    Mail_Error_Excepcion()
    {
        
    }
    Mail_Error_Excepcion(String Msj_Error)
    {
        super(Msj_Error); //Llamo al constructor de Exception y personalizo el mensaje
    }
}
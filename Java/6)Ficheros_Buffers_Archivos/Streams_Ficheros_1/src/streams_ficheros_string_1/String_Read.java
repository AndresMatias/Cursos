/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streams_ficheros_string_1;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class String_Read {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Leer_Fichero Mi_Fichero=new Leer_Fichero();
        Mi_Fichero.Leer();
    } 
}
class Leer_Fichero 
{ 
    public void Leer()
    {
        
        try 
        {
            FileReader Mi_Archivo=new FileReader("src/streams_ficheros_string_1/Fichero Read.txt"); //El flujo se abre solo si todo va bien
            int C=0;
            while(C!=-1)
            {
                C=Mi_Archivo.read(); //Devuelve el codigo del caracter
                char Caracter=(char)C;//Casting ver video
                System.out.println("Caracter mas su codigo:"+Caracter+":"+C);
            }
            Mi_Archivo.close();//Cierro flujo de datos, sin nececidad de finally porque es un flujo cerrado
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Leer_Fichero.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error");
        }
    }
}
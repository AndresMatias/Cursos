/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streams_ficheros_string_1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class String_Write 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Escribir_Fichero Mi_Fichero=new Escribir_Fichero();
        Mi_Fichero.Escribir();
    } 
}
class Escribir_Fichero
{
    public void Escribir()
    {
        String Contenedor=" Prueba de escritura";
        try 
        {
            //FileWrite Se utiliza para caracteres
            FileWriter Mi_Archivo_1=new FileWriter("src/streams_ficheros_string_1/Fichero Write 1.txt",true); //el true sirve para agregar sobre el fichero existente y si no existe lo crea
            FileWriter Mi_Archivo_2=new FileWriter("src/streams_ficheros_string_1/Fichero Write 2.txt");
            for(int i=0;i<Contenedor.length();i++) //Una forma de escribir
            {
                Mi_Archivo_1.write(Contenedor.charAt(i));
            }
            Mi_Archivo_2.write(Contenedor); //Escribe todo de una
            Mi_Archivo_1.close();
            Mi_Archivo_2.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Escribir_Fichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
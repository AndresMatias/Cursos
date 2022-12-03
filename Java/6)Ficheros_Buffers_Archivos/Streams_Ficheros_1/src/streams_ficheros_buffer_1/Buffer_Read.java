/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streams_ficheros_buffer_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class Buffer_Read {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Escribir_Fichero Mi_Fichero=new Escribir_Fichero();
        Mi_Fichero.Escribir();
    } 
}
class Escribir_Fichero
{
    private FileReader Mi_Archivo;
    public void Escribir()
    {
        String Linea="";
        try 
        {
            Mi_Archivo=new FileReader("src/streams_ficheros_buffer_1/Fichero.txt");
            BufferedReader Mi_Buffer=new BufferedReader(Mi_Archivo);
            while(Linea!=null)
            {
                Linea=Mi_Buffer.readLine(); //Cuando llega al final devuelve un null
                System.out.println(Linea); 
            }
            Mi_Archivo.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Escribir_Fichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

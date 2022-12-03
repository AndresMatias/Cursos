/*
    Video 155 y 156
 */
package streams_ficheros_bytes_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class Bytes_Leer_Escribir 
{   
    public static void main(String[] args) 
    {
        int Vector[] = null,Byte_Entrada,Contador=0,Tamaño;
        boolean Bandera=false; 
        try 
        {
            FileInputStream Mi_Arhcivo=new FileInputStream("src/streams_ficheros_bytes_1/Meme_9.jpg");   
            Tamaño=Mi_Arhcivo.available(); //Devuleve el tamaño de entrada
            Vector=new int[Tamaño];
            while(!Bandera)//Distinto de true, esta implicito
            {   
                Byte_Entrada=Mi_Arhcivo.read();
                if(Byte_Entrada!=-1)
                {         
                    Vector[Contador]=Byte_Entrada;
                    Contador++;
                }
                if(Byte_Entrada==-1)
                {
                    Bandera=true;
                }             
            }
            System.out.println("Numero de Bytes: "+Tamaño);
            System.out.println("Tamaño Vector: "+Vector.length);
            Mi_Arhcivo.close();   
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Bytes_Leer_Escribir.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error, no se encuentra la copia");
        }
        Escribir(Vector);
    }
    
    static void Escribir(int Vector[])
    {
        try 
        {
            //FileOutputStream se utiliza para flujos de datos en bytes
            FileOutputStream Salida=new FileOutputStream("src/streams_ficheros_bytes_1/Meme_9_Copia.jpg");
            for(int i=0;i<Vector.length;i++)
            {
                Salida.write(Vector[i]);
            }
            Salida.close();
        } 
        catch(IOException ex) 
        {
            System.out.println("Error al crear la copia");
        }
    }
}

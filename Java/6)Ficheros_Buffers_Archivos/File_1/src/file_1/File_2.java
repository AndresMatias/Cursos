/*
 Video 160
 */
package file_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class File_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        File archivo=new File("C:"+File.separator+"Users"+File.separator+"Andres"+File.separator+"Nuevo Directorio"+File.separator+"Prueba texto.txt"); //File.separator:Para compatibilidad entre SO
        //archivo.mkdir(); //Creo un nuevo directorio el que puse arriva
        String archivo_destino=archivo.getAbsolutePath();
        try {
            archivo.createNewFile(); //Creo un nuevo archivo de texto basado en la ruta anterior
        } catch (IOException ex) {
            Logger.getLogger(File_2.class.getName()).log(Level.SEVERE, null, ex);
        }
        Escrbiendo accede_es=new Escrbiendo();
        accede_es.escribir(archivo_destino);
        //archivo.delete(); Elimina el archivo creado
    }

    
}
class Escrbiendo 
{

    public void escribir(String ruta)
    { 
        String frase="Esto es un ejemplo";
        try 
        {
            FileWriter escritura=new FileWriter(ruta);
            for(int i=0;i<frase.length();i++)
            {
                escritura.write(frase.charAt(i));
            }
            escritura.close();
        } catch (Exception e) 
        {
            
        }
    }
}
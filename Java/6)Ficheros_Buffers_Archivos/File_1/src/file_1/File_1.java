/*
    Video 159
 */
package file_1;

import java.io.File;

/**
 *
 * @author Andres
 */
public class File_1 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        File archivo=new File("Ejemplo Archivo"); //Sino pongo una ruta java toma por defecto donde guardo mi proyecto
        System.out.println(archivo.getAbsoluteFile()); //Muestra el directorio donde se guarda mi archivo
        System.out.println(archivo.exists()); //Determino si mi archivo existe
        archivo=new File("src"); //Este directorio si existe
        System.out.println(archivo.exists());
        archivo=new File("C:/Users/Andres");
        String[] nombre= archivo.list(); //list:Devuelve un array con lso nombres y directorios que esta dentro de la ruta especificada
        for(int i=0;i<nombre.length;i++)
        {
             System.out.println(nombre[i]);
             File sub= new File(archivo.getAbsoluteFile(),nombre[i]);
             if(sub.isDirectory()) //Si es un directorio
             {
                String[] sub_carpeta=sub.list();
                for(int j=0;j<sub_carpeta.length;j++)
                {
                    System.out.println(sub_carpeta[j]);
                }
             }
        }
    }
    
}

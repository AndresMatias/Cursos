/*
 clase creaada para obtener la ruta inicial del servidor mediante
 */
package controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import vista.Lamina;

/**
 *
 * @author Andres
 */
public class Obtener_Ruta {
    private FileReader entrada;
    public String[] Obtener(Lamina L_1){
        //Declaro variables
        String datos[]=new String[3];
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(   //Filtro para buscar extensiones de archivos
                "Archivos de texto", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(L_1); //Devuelve true o false para saber si se abre la ventana en la lamina o marco
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                entrada=new FileReader(chooser.getSelectedFile().getAbsolutePath()); //Guardo en la ruta escogida
            } catch (FileNotFoundException ex) {
            }
        }
        try{
            BufferedReader mibuffer=new BufferedReader(entrada);
            for(int i=0;i<2;i++){
                datos[i]=mibuffer.readLine();
            }
        }
        catch (Exception e) {
            System.out.println("No conecta clase: Conexion");
        }
        finally{
            try {
                entrada.close(); //Cierro buffer
            } catch (IOException ex) {
            }
        }

        return datos;
    }
    
}

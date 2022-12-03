/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz_for_each;

/**
 *
 * @author Andres
 */
public class Matriz_For_Each {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int i,j;
        int Matriz[][]={{1,2,3,10}, //Declaro Matriz de 3x4(filas x columnas)
                        {4,5,6,10}, //Este tipo de declaracion aplica tambien para string y otros tipos
                        {7,8,9,10}};
        System.out.println("Dimensines"); //Imprimo el nro de filas
        System.out.println("Filas: "+Matriz.length); //Imprimo el nro de filas
        System.out.println("Columnas: "+Matriz[1].length); //Imprimo el nro de columnas        
        System.out.println("\nFor Comun"); //Imprimo el nro de filas
        for(i=0;i<3;i++) //Matriz comun
        {  
            for(j=0;j<4;j++) 
            {
                System.out.println("Nro: "+Matriz[i][j]);
            }
        }
        System.out.println("\n\n\nLenght");
        for(i=0;i<Matriz.length;i++) //Matriz con lenght
        {  
            for(j=0;j<Matriz[0].length;j++) 
            {
                System.out.println("Nro: "+Matriz[i][j]);
            }
        }
        System.out.println("\n\n\nFor Each");
        for(int []Fila:Matriz) //Matriz con for each
        {  
            for(int Nro:Fila) 
            {
                System.out.println("Nro: "+Nro);
            }
        }
    }
    
}

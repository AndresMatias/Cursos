/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones_1;

import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
public class Excepciones_1 
{
    public static void main(String[] args) 
    {    
        int Matriz[]=new int[5],Edad;
        String Nombre;
        Matriz[0]=10;
        Matriz[1]=22;
        Matriz[2]=35;
        Matriz[3]=46;
        Matriz[4]=55;
        Matriz[5]=56;//Espacio que no esta en la matriz, error puesto a proposito
        for(int M:Matriz) //bulce for each
        {
            System.out.println(M);
        }
        Nombre=JOptionPane.showInputDialog("Introduce tu nombre");
        Edad=Integer.parseInt(JOptionPane.showInputDialog("Introduce tu edad"));
        System.out.println("Nombre: "+Nombre+"\nEdad: "+Edad);
    }
    
}

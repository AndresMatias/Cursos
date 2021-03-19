/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debugging_1;

import javax.swing.JOptionPane;


public class Debugging_1 
{
    public static void main(String[] args) 
    {
        int Elementos=Integer.parseInt(JOptionPane.showInputDialog("Numero de elementos"));
        int Numeros_Aleatorios[]=new int[Elementos];
        for(int i=0;i<Numeros_Aleatorios.length;i++)
        {
            Numeros_Aleatorios[i]=(int)(Math.random()*100); //Entre parentecis para que le haga casting a toda la expresion y no solo a math
        }
        for(int N:Numeros_Aleatorios)
        {
            System.out.println("Nro: "+N);
        }
    }
  
}

/*
    Video 157
 */
package serializacion_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Serializacion_1 
{
    public static void main(String[] args) 
    {
        Administrador jefe=new Administrador("Juan", 80000, 2005,12,15);
        Empleado[] personal=new Empleado[3]; 
	jefe.setIncentivo(5000);	
	personal[0]=jefe;
	personal[1]=new Empleado("Ana", 25000, 2008, 10,1);
	personal[2]=new Empleado("Luis", 18000, 2012, 9,15);
        try 
        {
            //Guardo a personal
            ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("src/serializacion_1/Empleado.txt")); //FileOutputStream hereda de OutputStream
            salida.writeObject(personal);
            salida.close();
            
            //Extraigo informacion de Empleado.dat
            ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("src/serializacion_1/Empleado.txt"));
            Empleado[] personalRecuperado=(Empleado[]) entrada.readObject(); //Casting porque devuelve un objeto tipo "Object"
            entrada.close();
            for(Empleado empleado : personalRecuperado) //Bucle For Each
            {
                System.out.println(empleado);
            }
        } 
        catch (IOException ex) //Para OutputStream
        {
            Logger.getLogger(Serializacion_1.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (ClassNotFoundException ex)  //Para ReadObject
        {
            Logger.getLogger(Serializacion_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
//-----------------------------------------------------------------------------------------------------------
class Empleado implements Serializable //Implemento interfaz "serializable" para convertir en bytes
{
    private static final long serialVersionUID=1L;//Explicacion en Serializacion_2 y video 157
    private String nombre;
    private double sueldo;
    private Date fechaContrato;
    public Empleado(String n, double s, int año, int mes, int dia)
    {
	nombre=n;
        sueldo=s;
	GregorianCalendar calendario=new GregorianCalendar(año, mes-1,dia);
	fechaContrato=calendario.getTime();	
    }
    public String getNombre() 
    {
	return nombre;
    }
    public double getSueldo() 
    {
	return sueldo;
    }
    public Date getFechaContrato() 
    {
	return fechaContrato;
    }
    public void subirSueldo(double porcentaje)
    {
	double aumento=sueldo*porcentaje/100;
	sueldo+=aumento;
    }
    @Override
    public String toString() //Provee una descripcion de la clase "toString"
    {
	return "El Nombre es = " + nombre + ",y su sueldo es = " + sueldo + ", fecha de contrato= " + fechaContrato;
    }	
}
//--------------------------------------------------------------------------------------------------------
class Administrador extends Empleado
{
    private static final long serialVersionUID=1L; //Explicacion en Serializacion_2 y video 157
    private double incentivo;
    public Administrador(String n, double s, int agno, int mes, int dia)
    {
	super(n,s,agno,mes,dia);
	incentivo=0;
    }
    @Override
    public double getSueldo()
    {
	double sueldoBase=super.getSueldo();
	return sueldoBase + incentivo;
    }
    public void setIncentivo(double b)
    {
	incentivo=b;
    }
    @Override
    public String toString()
    {
	return super.toString() + " Incentivo = " + incentivo;
    }	
}

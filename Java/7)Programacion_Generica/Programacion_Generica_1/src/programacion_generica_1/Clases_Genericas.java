/*
    Video 165
 */
package programacion_generica_1;

/**
 *
 * @author Andres
 */
public class Clases_Genericas<T> { //el <T> es para declararla como generica
    public Clases_Genericas(){
        primero=null;
    }
    public void setPrimero(T nuevoValor){
        primero=nuevoValor;
    }
    public T getPrimero(){ //Funcion generica porque nose que devuelve
        return primero;
    }
    private T primero;
}
/*
Video 186 y 187
 */
package coleccion_1;

import java.util.*;

/**
 *
 * @author Andres
 */
public class Arboles1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        TreeSet<String> ordenaPersonas=new TreeSet<String>();
//        ordenaPersonas.add("Ana");
//        ordenaPersonas.add("Juan");
//        ordenaPersonas.add("Daniela");
//        for(String p : ordenaPersonas){
//            System.out.println("Nombre: "+p); //No imprime en el orden que lo agregue sino en orden alfabetico (repasar arbol de info 2 creo)
//        }
        Articulo primero=new Articulo(1, "primero");
        Articulo segundo=new Articulo(2, "segundo");
        Articulo tercero=new Articulo(3, "tercero");
        Articulo cuarto=new Articulo(4, "cuarto");
        Articulo quinto=new Articulo(5, "quinto");
        TreeSet<Articulo> ordenaArticulos=new TreeSet<Articulo>();
        ordenaArticulos.add(segundo);
        ordenaArticulos.add(tercero);
        ordenaArticulos.add(primero);
        ordenaArticulos.add(quinto);
        ordenaArticulos.add(cuarto); //por compareTo
         for(Articulo a : ordenaArticulos){
            System.out.println("Nombre: "+a.getDescripcion()); //No imprime en el orden que lo agregue sino en orden alfabetico (repasar arbol de info 2 creo)
        }
        Articulo compararArticulos=new Articulo();
        TreeSet<Articulo> ordenaArticulos2=new TreeSet<Articulo>(compararArticulos); //le paso por parametros el comparador ver video 187 minuto 9:30, se van a ordenar segun lo que marque compararArticulos
        ordenaArticulos2.add(primero);
        ordenaArticulos2.add(quinto);
        ordenaArticulos2.add(tercero);
        ordenaArticulos2.add(cuarto);
        ordenaArticulos2.add(segundo); //Por metodo compare en vez de compare to
        System.out.println("\n\n\n\nImprime por orden alfabetico");
        for(Articulo a : ordenaArticulos2){
            System.out.println("Nombre: "+a.getDescripcion()); //No imprime en el orden que lo agregue sino en orden alfabetico (repasar arbol de info 2 creo)
        }
    }   
}

class Articulo implements Comparable<Articulo>, Comparator<Articulo>{ //Ordena por tamaño de menor a mayor
    
    private int Nro_Articulo;
    private  String descripcion;
    public  Articulo(int num,String desc){
        Nro_Articulo=num;
        descripcion=desc;
    }
    public Articulo(){
        
    }
    public String getDescripcion(){
        return descripcion;
    }
    @Override
    public int compareTo(Articulo o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Nro: "+Nro_Articulo+"Nro Objeto: "+o.Nro_Articulo);
        return Nro_Articulo-o.Nro_Articulo; //cuando agrego un objeto en ordenarArituclos.add el treeset llama a este metodo y se vuelve un valor que en base a ese valor en el return de esta linea ordena el objeto en el treeset
    }

    @Override
    public int compare(Articulo o1, Articulo o2) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String descripcionA=o1.getDescripcion();
        String descripcionB=o2.getDescripcion();
        return descripcionA.compareTo(descripcionB); //Comparacion por orden alfabetico
    }
    
}
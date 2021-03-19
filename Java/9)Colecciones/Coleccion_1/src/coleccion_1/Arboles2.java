/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coleccion_1;

import java.util.Comparator;
import java.util.TreeSet;

/**
 *
 * @author Andres
 */
public class Arboles2 {

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
        Articulos primero=new Articulos(1, "primero");
        Articulos segundo=new Articulos(2, "segundo");
        Articulos tercero=new Articulos(3, "tercero");
        Articulos cuarto=new Articulos(4, "cuarto");
        Articulos quinto=new Articulos(5, "quinto");
        TreeSet<Articulos> ordenaArticulos=new TreeSet<Articulos>();
        ordenaArticulos.add(segundo);
        ordenaArticulos.add(tercero);
        ordenaArticulos.add(primero);
        ordenaArticulos.add(quinto);
        ordenaArticulos.add(cuarto); //por compareTo
         for(Articulos a : ordenaArticulos){
            System.out.println("Nombre: "+a.getDescripcion()); //No imprime en el orden que lo agregue sino en orden alfabetico (repasar arbol de info 2 creo)
        }
//        Articulos compararArticulos=new Articulos();
//        TreeSet<Articulos> ordenaArticulos2=new TreeSet<Articulos>(compararArticulos); //le paso por parametros el comparador ver video 187 minuto 9:30, se van a ordenar segun lo que marque compararArticulos
        comparadorArticulos compArt=new comparadorArticulos();
        TreeSet<Articulos> ordenaArticulos2=new TreeSet<Articulos>(compArt);
        ordenaArticulos2.add(primero);
        ordenaArticulos2.add(quinto);
        ordenaArticulos2.add(tercero);
        ordenaArticulos2.add(cuarto);
        ordenaArticulos2.add(segundo); //Por metodo compare en vez de compare to
        System.out.println("\n\n\n\nImprime por orden alfabetico");
        for(Articulos a : ordenaArticulos2){
            System.out.println("Nombre: "+a.getDescripcion()); //No imprime en el orden que lo agregue sino en orden alfabetico (repasar arbol de info 2 creo)
        }
    }   
}

class Articulos implements Comparable<Articulos>{ //Ordena por tamaño de menor a mayor
    
    private int Nro_Articulo;
    private  String descripcion;
    public  Articulos(int num,String desc){
        Nro_Articulo=num;
        descripcion=desc;
    }
    public String getDescripcion(){
        return descripcion;
    }
    @Override
    public int compareTo(Articulos o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Nro: "+Nro_Articulo+"Nro Objeto: "+o.Nro_Articulo);
        return Nro_Articulo-o.Nro_Articulo; //cuando agrego un objeto en ordenarArituclos.add el treeset llama a este metodo y se vuelve un valor que en base a ese valor en el return de esta linea ordena el objeto en el treeset
    }  
}

class comparadorArticulos implements Comparator<Articulos>{

    @Override
    public int compare(Articulos o1, Articulos o2) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String descripcionA=o1.getDescripcion();
        String descripcionB=o2.getDescripcion();
        return descripcionA.compareTo(descripcionB); //Comparacion por orden alfabetico
    }
    
}
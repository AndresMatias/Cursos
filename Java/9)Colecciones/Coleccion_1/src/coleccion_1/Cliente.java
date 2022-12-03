/*
Video 181 y 182
 */
package coleccion_1;

import java.util.Objects;

/**
 *
 * @author Andres
 */
public class Cliente {
    private String Nombre,NroCuenta;
    private double Saldo;
    public Cliente(String Nombre,String NroCuenta,double Saldo){
        this.Nombre=Nombre;
        this.NroCuenta=NroCuenta;
        this.Saldo=Saldo;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getNroCuenta() {
        return NroCuenta;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setNroCuenta(String NroCuenta) {
        this.NroCuenta = NroCuenta;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.NroCuenta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.NroCuenta, other.NroCuenta)) {
            return false;
        }
        return true;
    }
}

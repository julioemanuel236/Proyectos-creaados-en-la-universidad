
package tienda;

import excepciones.*;

public abstract class Producto {

    private String nombre;
    private String tipo;
    private int cantidad;
    private int cantidadMinima;
    private double precioBase;
    private int cantidadVendida = 0;
    
    public Producto(String nombre, String tipo, int cantidad, int cantidadMinima, double precioBase) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.cantidadMinima = cantidadMinima;
        this.precioBase = precioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public double getPrecioBase() {
        return precioBase;
    }        
    
    public void vender(int cantidad)throws NoCantidadSuficienteException{
        if(cantidad > this.cantidad)throw new NoCantidadSuficienteException(cantidad);
        this.cantidad -= cantidad;
        this.cantidadVendida += cantidad;
    }
    
    public void abastecer(int cantidad)throws CantidadNoValidaException{
        if(cantidad<0)throw new CantidadNoValidaException(cantidad);
        this.cantidad += cantidad;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }
    
    
    public abstract double calcularPrecio();
    
}

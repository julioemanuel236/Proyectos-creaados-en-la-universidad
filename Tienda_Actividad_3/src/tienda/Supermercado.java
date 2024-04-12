
package tienda;


public class Supermercado extends Producto{

    public Supermercado(String nombre, int cantidad, int cantidadMinima, double precioBase) {
        super(nombre, "Supermercado" , cantidad, cantidadMinima, precioBase);
    }

    @Override
    public double calcularPrecio() {
        return getPrecioBase()*1.04d;
    }
    
    
}

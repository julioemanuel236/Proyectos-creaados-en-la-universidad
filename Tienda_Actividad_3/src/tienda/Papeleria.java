
package tienda;

public class Papeleria extends Producto{

    public Papeleria(String nombre,  int cantidad, int cantidadMinima, double precioBase) {
        super(nombre, "Papeleria" , cantidad, cantidadMinima, precioBase);
    }

    @Override
    public double calcularPrecio() {
        return getPrecioBase()*1.16d;
    }
        
}

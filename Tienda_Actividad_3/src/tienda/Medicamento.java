package tienda;


public class Medicamento extends Producto{

    public Medicamento(String nombre, int cantidad, int cantidadMinima, double precioBase) {
        super(nombre, "Medicamento" , cantidad, cantidadMinima, precioBase);
    }

    @Override
    public double calcularPrecio() {
        return getPrecioBase()*1.12d;
    }
    
    
}

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String cedula;
    
    protected ArrayList<Producto> productos;
    
    public Cliente(String nombre, String cedula){
        this.nombre = nombre;
        this.cedula = cedula;
        productos = new ArrayList<Producto>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    public void agregarProducto(Producto producto){
        productos.add(producto);
    }
    public int dineroTotal(){
        return 0;
    }
    public String toString(){
        return "Nombre: "+nombre+ "Cedula: "+cedula;
    }
}

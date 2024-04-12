public abstract class Objetos {
    private int precio;
    private String nombre;

    public Objetos (int precio, String nombre){
        this.precio = precio;
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void usar(Jugable jugable);
}
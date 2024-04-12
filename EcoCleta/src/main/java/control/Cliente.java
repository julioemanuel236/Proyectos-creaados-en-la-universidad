package control;

public class Cliente {
    
    private String nombre;
    private String id;
    private String direccion;
    private int edad;
    private boolean mayorEdad;
    
    public Cliente(String nombre, String id, String direccion, int edad) {
        this.nombre = nombre;
        this.id = id;
        this.direccion = direccion;
        this.edad = edad;
        this.mayorEdad = edad>=18;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getEdad() {
        return edad;
    }

    public boolean esMayorEdad() {
        return mayorEdad;
    }
    
    
    
    
}

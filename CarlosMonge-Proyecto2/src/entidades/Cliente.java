package entidades;

import control.Datos;

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
    
    
    public String getInfo(){
        String separador = Datos.SEPARADOR;
        //informacion en formato para guardar
        return nombre+separador+id+separador+direccion+separador+String.valueOf(edad);
    }
    
}

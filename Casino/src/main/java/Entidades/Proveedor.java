package Entidades;

import estructuras.Pila;


public class Proveedor {
    private static int NEXTID = 1;
    
    private int id;
    private String descripcion;
    
    private Pila juegos;
    
    public Proveedor(String descripcion){    
        this.id = NEXTID++;
        this.descripcion = descripcion;
        this.juegos = new Pila();
    }

    public static int getNEXTID() {
        return NEXTID;
    }

    public static void setNEXTID(int NEXTID) {
        Proveedor.NEXTID = NEXTID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Pila getJuegos() {
        return juegos;
    }

    public void setJuegos(Pila juegos) {
        this.juegos = juegos;
    }
    
    
}

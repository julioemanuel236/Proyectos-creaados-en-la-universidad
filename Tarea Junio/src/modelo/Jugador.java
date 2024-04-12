package modelo;

public class Jugador {
    private String nombre;
    private int id;
    public Jugador(String nombre,int id){
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public int getId(){
        return id;
    }
    @Override
    public String toString() {
        return nombre;
    }
}

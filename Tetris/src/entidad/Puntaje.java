package entidad;

public class Puntaje {
    /*
        clase que sirve para manejar los puntajes
        contiene un nombre y una cantidad de puntos
    */
    private String nombre;
    private int puntaje;

    public Puntaje(String nombre,int puntaje){
        this.nombre = nombre;
        this.puntaje = puntaje;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
        
}

package Torneo_PKG;

import java.io.Serializable;

public abstract class Juego implements Serializable{
    String nombre;
    String casaMatriz;
    int cantjugadores;
    String tipoJuego;

    /*
     * Constructor: Recibe nombre, casa Matriz, cantidad de jugadores y el tipo de juego
     */
    public Juego(String nombre, String casaMatriz, int cantjugadores, String tipoJuego){
        this.nombre = nombre;
        this.casaMatriz = casaMatriz;
        this.cantjugadores = cantjugadores;
        this.tipoJuego = tipoJuego;
    } 

    /*
     * Getters
     */
    public String getNombre(){return nombre;}
    public String getCasaMatriz(){return casaMatriz;}
    public int getCantjugadores(){return cantjugadores;}
    public String getTipoJuego(){return tipoJuego;}

    /*
     * Setters
     */
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setCasaMatriz(String casaMatriz){this.casaMatriz = casaMatriz;}
    public void setCantjugadores(int cantjugadores){this.cantjugadores = cantjugadores;}
    public void setTipoJuego(String tipoJuego) {this.tipoJuego = tipoJuego;}

    /*
     * Recibe un juego
     * Retorna si el juego es el mismo al actual
     */
    public boolean esIgual(Juego juego){
        if(nombre.equals(juego.getNombre()))
            return true;
        return false;
    }

    /*
     * toString con atributos
     */
    public String toString(){
        return "Nombre: " + nombre + " - Casa Matriz: " + casaMatriz + 
                " - Cantidad de Jugadores: " + cantjugadores + " - Tipo de Juego: " + tipoJuego;
    }
}

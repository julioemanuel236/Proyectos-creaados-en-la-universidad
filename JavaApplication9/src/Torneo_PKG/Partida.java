package Torneo_PKG;

import java.io.Serializable;

public class Partida implements Serializable{
    String fecha;
    int tiempo;
    int puntaje;
    Juego juego;

    /*
     * Constructor
     * Recibe fecha, tiempo, puntaje, y el juego correspondiente de la partida
     */
    public Partida(String fecha, int tiempo, int puntaje, Juego juego){
        this.fecha = fecha;
        this.tiempo = tiempo;
        this.puntaje = puntaje;
        this.juego = juego;
    }

    /*
     * Getters
     */
    public String getFecha(){return fecha;}
    public int getTiempo(){return tiempo;}
    public int getPuntaje(){return puntaje;}
    public Juego getJuego (){return juego;}

    /*
     * Setters
     */
    public void setFecha(String fecha){this.fecha = fecha;}
    public void setTiempo(int tiempo){this.tiempo = tiempo;}
    public void setPuntaje(int puntaje){this.puntaje = puntaje;}
    public void setJuego(Juego juego){this.juego = juego;}

    /*
     * Recibe un juego 
     * Retorna el valor de verdad del juego es el de la partida
     */
    public boolean esJuego(Juego juego){
        if(this.juego.getNombre().equals(juego.getNombre()))
            return true;
        
            return false;
    }
    
}


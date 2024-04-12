package Torneo_PKG;

import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable{
    private String nombre;
    private String correo;
    private String nickName;

    private ArrayList<Partida> partidas;

    public Jugador(String nombre, String correo, String nickName) {
        this.nombre = nombre;
        this.correo = correo;
        this.nickName = nickName;
        partidas = new ArrayList<>();
    }

    /*
     * Getters
     */
    public String getNombre() {return nombre;}
    public String getCorreo() {return correo;}
    public String getNickName() {return nickName;}
    public Partida getPartida(int i){return partidas.get(i);}

    /*
     * Setters
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    } public void setCorreo(String correo) {
        this.correo = correo;
    } public void setNickName(String nikcName) {
        this.nickName = nikcName;
    } public void setPartida(int i, Partida partida){
        partidas.set(i, partida);
    }

    /*
     * Recibe una partida y la agrega a la lista
     * No retorna nada
     */
    public void agregarPartida(Partida partida){partidas.add(partida);}

    /*
     * Retorna la suma del puntaje de todas las partidas del jugador     
    */    
    public int puntajeAcumulado(){
        int puntaje = 0;
        for (int i = 0; i < partidas.size(); i++) {
            puntaje += partidas.get(i).getPuntaje();
        }
        return puntaje;
    }

    /*
     * Recibe un juego y suma el total de puntos
     * Retorna la suma de puntos
     */
    public int puntajeAcumulado(Juego juego){
        int puntajeTotal = 0;

        for (int partidaActual = 0; partidaActual < partidas.size(); partidaActual++){
            puntajeTotal += partidas.get(partidaActual).getPuntaje();
        }

        return puntajeTotal;
    }

    /*
     * Recibe un juego y retorna el mayor puntaje
     * -----------------------------------------------------------------Revisar
     */
    public int mejorPuntaje(Juego juego){
        int puntajeMax = 0;

        for (int partidaActual = 0; partidaActual < partidas.size(); partidaActual++){
            
            if(juego.getClass().isInstance(partidas.get(partidaActual).getJuego()))
                if(partidas.get(partidaActual).getPuntaje() > puntajeMax)
                    puntajeMax = partidas.get(partidaActual).getPuntaje();
            
        }

        return puntajeMax;
    }

    /*
     * Recibe un juego e identifica el mayor puntaje
     * Retorna la partida con dicho puntaje
     * -----------------------------------------------------------------Revisar
     */
    public Partida mejorPartida(Juego juego){
        int puntajeMax = 0;
        int posMax = 0;

        for (int partidaActual = 0; partidaActual < partidas.size(); partidaActual++){
            
            if(juego.getClass().isInstance(partidas.get(partidaActual).getJuego()))
                if(partidas.get(partidaActual).getPuntaje() > puntajeMax)
                    puntajeMax = partidas.get(partidaActual).getPuntaje();
                    posMax = partidaActual;
            
        }

        return partidas.get(posMax);
    }

    /*
     * No recibe nada.
     * Retorna el juego con mayor puntaje 
     * -----------------------------------------------------------------
     */
    public Juego mejorJuego(){
        //por implementar
        return null;
    }

    /*
     * No recibe nada. 
     * Retorna la cantidad de partidas totales (en los 4 juegos) del jugador
     */
    public int cantidadPartidas(){
        return partidas.size();
    }

    /*
     * Recibe un juego
     * Retorna la cantidad de partidas jugadas de ese juego
     * -----------------------------------------------------------------Revisar
     */
    public int cantidadPartidas(Juego juego){
        int partidasTotales = 0;

        for (int partidaActual = 0; partidaActual < partidas.size(); partidaActual++){
            
            if(juego.getClass().isInstance(partidas.get(partidaActual).getJuego()))
                partidasTotales++;
            
        }

        return partidasTotales;
    }

    /*
     * No recibe nada
     * Retorna la cantidad de horas jugadas totales (en los 4 juegos) del jugador
     */
    public int horasJugadas(){
        int horasTotal = 0;

        for (int partidaActual = 0; partidaActual < partidas.size(); partidaActual++){
            horasTotal += partidas.get(partidaActual).getTiempo() / 3600;
        }

        return horasTotal;
    }

    /*
     * Recibe un juego
     * Retorna la cantidad de horas jugadas de ese juego
     * -----------------------------------------------------------------Revisar
     */
    public int horasJugadas(Juego juego){
        int horasTotal = 0;

        for (int partidaActual = 0; partidaActual < partidas.size(); partidaActual++){
            
            if(juego.getClass().isInstance(partidas.get(partidaActual).getJuego()))
                horasTotal += partidas.get(partidaActual).getTiempo() / 3600;
            
        }

        return horasTotal;
    }

}

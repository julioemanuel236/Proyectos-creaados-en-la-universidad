package Torneo_PKG;

public class Ajedrez extends Juego{
    /*
     * Constructor recibe atributos de juego
     */
    public Ajedrez(String nombre, String casaMatriz, int cantjugadores, String tipoJuego) {
        super(nombre, casaMatriz, cantjugadores, tipoJuego);
    }

    /*
     * Sistema de puntajes
     * Si es victoria, asigna 10 puntos, si empate 5 puntos, si derrota 0 puntos
     */
    public int definirPuntaje(int res){
        if(res == 1)
            return 10;
        else if(res == 0)
            return 5;
        return 0;
    }
}

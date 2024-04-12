package Torneo_PKG;

public class ApexLegends extends Juego{
    /*
     * Constructor recibe atributos de Juego
     */
    public ApexLegends(String nombre, String casaMatriz, int cantjugadores, String tipoJuego) {
        super(nombre, casaMatriz, cantjugadores, tipoJuego);
    }

    /*
     * Sistema de Puntajes
     * Kill = 10 puntos - Death = -6 puntos
     * No es posible tener puntaje negativo*
     */
    public int definirPuntos(int kills, int deaths){
        int puntosKill = kills * 5;
        int puntosDeath = deaths * 3;

        int total = puntosKill - puntosDeath;

        if(total >= 0)
            return total;
        return 0;
    }
}

package Torneo_PKG;

public class Fortnite extends Juego{
    /*
     * Constructor recibe atributos de Juego
     */
    public Fortnite(String nombre, String casaMatriz, int cantjugadores, String tipoJuego) {
        super(nombre, casaMatriz, cantjugadores, tipoJuego);
    }

    /*
     * Sistema de puntajes
     * Puestos del 1-100, asigna un punto por puesto avanzado
     */
    public int definirPuntaje(int puesto){
        return 101 - puesto;
    }
}

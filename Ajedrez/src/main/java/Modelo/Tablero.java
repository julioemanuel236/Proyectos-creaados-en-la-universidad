package Modelo;

import java.util.ArrayList;

public class Tablero {
    private Pieza[][] casillas;

    public Tablero() {
        // Inicializar el tablero con 8x8 casillas
        casillas = new Pieza[8][8];
    }

    // Método para colocar una pieza en una posición específica del tablero
    public void colocarPieza(Pieza pieza, int fila, int columna) {
        casillas[fila][columna] = pieza;
    }

    // Método para obtener una pieza en una posición específica del tablero
    public Pieza obtenerPieza(int fila, int columna) {
        return casillas[fila][columna];
    }
    
    public Pieza obtenerPiezaEnPosicion(int x, int y) {
        if (esCoordenadaValida(x, y)) {
            return casillas[y][x];
        } else {
            return null;
        }
    }
    
    public boolean esCoordenadaValida(int x, int y) {
        return x >= 0 && x < casillas.length && y >= 0 && y < casillas[0].length;
    }
}

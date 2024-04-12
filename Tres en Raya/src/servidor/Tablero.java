package servidor;

import java.awt.Color;

public class Tablero {

    private Color[][] tablero; // Cambio de char a Color
    private int nFilas;
    private int nColumnas;

    public Tablero(int filas, int columnas) {
        this.nFilas = filas;
        this.nColumnas = columnas;
        this.tablero = new Color[nFilas][nColumnas]; // Cambio de char a Color
        initializeTablero();
    }

    private void initializeTablero() {
        for (int i = 0; i < nFilas; i++) {
            for (int j = 0; j < nColumnas; j++) {
                tablero[i][j] = Color.WHITE; // Inicializar con color predeterminado o transparente
            }
        }
    }

    public boolean colocarFicha(int fila, int columna, Color jugadorColor) {
        if (fila >= 0 && fila < nFilas && columna >= 0 && columna < nColumnas && tablero[fila][columna] == Color.WHITE) {
            tablero[fila][columna] = jugadorColor;
            return true;
        }
        return false;
    }

    public Color obtenerFicha(int fila, int columna) {
        return tablero[fila][columna];
    }

    public boolean tableroLleno() {
        for (int i = 0; i < nFilas; i++) {
            for (int j = 0; j < nColumnas; j++) {
                if (tablero[i][j] == Color.WHITE) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hayGanador(Color jugadorColor) {
        // Verificar filas
        for (int i = 0; i < nFilas; i++) {
            boolean ganadorEnFila = true;
            for (int j = 0; j < nColumnas; j++) {
                if (!tablero[i][j].equals(jugadorColor)) {
                    ganadorEnFila = false;
                    break;
                }
            }
            if (ganadorEnFila) {
                return true;
            }
        }

        // Verificar columnas
        for (int j = 0; j < nColumnas; j++) {
            boolean ganadorEnColumna = true;
            for (int i = 0; i < nFilas; i++) {
                if (!tablero[i][j].equals(jugadorColor)) {
                    ganadorEnColumna = false;
                    break;
                }
            }
            if (ganadorEnColumna) {
                return true;
            }
        }

        // Verificar diagonal principal
        boolean ganadorEnDiagonalPrincipal = true;
        for (int i = 0; i < nFilas; i++) {
            if (!tablero[i][i].equals(jugadorColor)) {
                ganadorEnDiagonalPrincipal = false;
                break;
            }
        }
        if (ganadorEnDiagonalPrincipal) {
            return true;
        }

        // Verificar diagonal secundaria
        boolean ganadorEnDiagonalSecundaria = true;
        for (int i = 0; i < nFilas; i++) {
            if (!tablero[i][nFilas - 1 - i].equals(jugadorColor)) {
                ganadorEnDiagonalSecundaria = false;
                break;
            }
        }
        return ganadorEnDiagonalSecundaria;
    }

}

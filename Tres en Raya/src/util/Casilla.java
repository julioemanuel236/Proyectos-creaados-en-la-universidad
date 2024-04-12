package util;

import java.io.Serializable;

public class Casilla implements Serializable {

    private int fila;
    private int columna;
    private char contenido; // 'X', 'O' o '-'

    public Casilla(int f, int c) {
        this.fila = f;
        this.columna = c;
        this.contenido = '-';
    }

    public void setFila(int f) {
        this.fila = f;
    }

    public void setColumna(int c) {
        this.columna = c;
    }

    public void setContenido(char contenido) {
        this.contenido = contenido;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public char getContenido() {
        return contenido;
    }
}

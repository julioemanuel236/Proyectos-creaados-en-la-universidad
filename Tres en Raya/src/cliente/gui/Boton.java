package cliente.gui;

import javax.swing.*;
import java.awt.Color;

public class Boton {

    private int fila;
    private int columna;
    private JButton boton;

    public Boton(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.boton = new JButton();
        this.boton.setBackground(Color.WHITE); // Establecer el color de fondo a blanco
    }

    public JButton getBoton() {
        return this.boton;
    }
}

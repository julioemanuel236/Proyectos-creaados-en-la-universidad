package pkgGUI;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class Boton {

    private int fila;
    private int columna;
    private JButton boton;

    public Boton(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.boton = new JButton();
        this.boton.setBackground(Color.WHITE); // Establecer el color de fondo a blanco
        this.boton.setForeground(Color.white);
        this.boton.setFont(new Font("Arial",Font.BOLD,20));
    }

    public JButton getBoton() {
        return this.boton;
    }
}

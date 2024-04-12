package pkgGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel {

    protected JButton start;
    protected Boton[][] matrizbotones;
    protected JTextField puntos;
    protected JTextField resultado;

    private int nfilas = 3;
    private int ncolumnas = 3;
    private boolean juegoActivo = false;

    private Color turnoColor = Color.RED; // Inicializa con el color del primer jugador

    public Panel() {
        // Botón START
        start = new JButton("Start");
        start.setActionCommand("start");

        // Matriz de botones
        matrizbotones = new Boton[nfilas][ncolumnas];

        // Barra de puntuación
        puntos = new JTextField("0", 10);
        JLabel labelpunt = new JLabel("Puntuación");
        resultado = new JTextField(10);

        puntos.setEditable(false);
        resultado.setEditable(false);

        // Paneles auxiliares
        JPanel barra = new JPanel(new BorderLayout());
        JPanel botones = new JPanel(new GridLayout(nfilas, ncolumnas));

        barra.add(labelpunt, BorderLayout.PAGE_START);
        barra.add(puntos, BorderLayout.WEST);
        barra.add(start, BorderLayout.CENTER);
        barra.add(resultado, BorderLayout.EAST);

        // Se crea la matriz de botones
        for (int i = 0; i < nfilas; i++) {
            for (int j = 0; j < ncolumnas; j++) {
                matrizbotones[i][j] = new Boton(i, j);
                matrizbotones[i][j].getBoton().setSize(10, 10);
                matrizbotones[i][j].getBoton().setActionCommand(i + " " + j);
                matrizbotones[i][j].getBoton().setEnabled(false); // Al principio los botones desactivados
                botones.add(matrizbotones[i][j].getBoton());

            }
        }

        // Panel GENERAL
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(barra, BorderLayout.PAGE_START);
        this.add(botones, BorderLayout.CENTER);
        this.setSize(500, 500);
    }

    public void addListeners(Controlador controlador) {
        start.addActionListener(controlador);

        for (int i = 0; i < nfilas; i++) {
            for (int j = 0; j < ncolumnas; j++) {
                matrizbotones[i][j].getBoton().addActionListener(controlador);
            }
        }
    }

    public void habilitarBotones() {
        for (int i = 0; i < nfilas; i++) {
            for (int j = 0; j < ncolumnas; j++) {
                matrizbotones[i][j].getBoton().setEnabled(true);
            }
        }
        juegoActivo = true;
    }

    public void iniciarJuego() {
        juegoActivo = true;
        resultado.setText("");
        puntos.setText("0");
        habilitarBotones();
    }

    public boolean isJuegoActivo() {
        return juegoActivo;
    }


    public boolean verificarCasillaVacia(int fila, int columna) {
        Color fondo = matrizbotones[fila][columna].getBoton().getBackground();
        return fondo.equals(Color.WHITE);
    }


    public boolean verificarVictoria(int fila, int columna, Color jugadorColor) {
        // Verificar si hay tres colores iguales en fila
        boolean ganadorEnFila = true;
        for (int col = 0; col < 3; col++) {
            if (!matrizbotones[fila][col].getBoton().getBackground().equals(jugadorColor)) {
                ganadorEnFila = false;
                break;
            }
        }

        // Verificar si hay tres colores iguales en columna
        boolean ganadorEnColumna = true;
        for (int fil = 0; fil < 3; fil++) {
            if (!matrizbotones[fil][columna].getBoton().getBackground().equals(jugadorColor)) {
                ganadorEnColumna = false;
                break;
            }
        }

        // Verificar si hay tres colores iguales en diagonal (si aplica)
        boolean ganadorEnDiagonalPrincipal = false;
        boolean ganadorEnDiagonalSecundaria = false;
        if (fila == columna) {
            ganadorEnDiagonalPrincipal = true;
            for (int i = 0; i < 3; i++) {
                if (!matrizbotones[i][i].getBoton().getBackground().equals(jugadorColor)) {
                    ganadorEnDiagonalPrincipal = false;
                    break;
                }
            }
        }
        if (fila + columna == 2) {
            ganadorEnDiagonalSecundaria = true;
            for (int i = 0; i < 3; i++) {
                if (!matrizbotones[i][2 - i].getBoton().getBackground().equals(jugadorColor)) {
                    ganadorEnDiagonalSecundaria = false;
                    break;
                }
            }
        }

        // Verificar si hay un ganador
        return ganadorEnFila || ganadorEnColumna || ganadorEnDiagonalPrincipal || ganadorEnDiagonalSecundaria;
    }

    public boolean verificarEmpate() {
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                if (matrizbotones[fila][columna].getBoton().getText().isEmpty()) {
                    return false; // Aún hay casillas disponibles, no es empate
                }
            }
        }
        return true; // No quedan casillas disponibles, es empate
    }



    public void mostrarResultado(boolean ganar) {
        juegoActivo = false;
        if (ganar) {
            resultado.setText("ENHORABUENA :)");
            for (int fila = 0; fila < nfilas; fila++) {
                for (int columna = 0; columna < ncolumnas; columna++) {
                    matrizbotones[fila][columna].getBoton().setEnabled(false);
                }
            }
        } else {
            resultado.setText("Game Over :( ");
        }
    }


}

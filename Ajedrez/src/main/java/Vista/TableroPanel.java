
package Vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import Control.Controlador;
import Modelo.*;

public class TableroPanel extends JPanel {
    private final Color colorBlanco = Color.LIGHT_GRAY;
    private final Color colorNegro = Color.BLUE;
    private final int tamañoCasilla = 60; // Tamaño de cada casilla
    private final int filas = 8; // Número de filas del tablero
    private final int columnas = 8; // Número de columnas del tablero
    private ArrayList<Pieza> listaDePiezas;
    private Controlador control;
    private int mouseX;
    private int mouseY;
    private Pieza piezaSeleccionada;
    private Pieza piezaCapturada;

    public TableroPanel(ArrayList<Pieza> listaDePiezas, Controlador control) {
        this.listaDePiezas = listaDePiezas;
        this.control = control;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                actualizarPanel(e); // Llama al método para actualizar el panel cuando se hace clic
            }
        });
    }

    public void actualizarPanel(MouseEvent e){
        mouseX = e.getX() / tamañoCasilla;
        mouseY = e.getY() / tamañoCasilla;

        if (piezaSeleccionada == null) {
            // Si no hay ninguna pieza seleccionada y se hace clic en una pieza válida
            Pieza piezaEnPosicion = control.obtenerPiezaEnPosicion(mouseX, mouseY);
            if (piezaEnPosicion != null && piezaEnPosicion.getColor() == control.getTurnoActual()) {
                piezaSeleccionada = piezaEnPosicion;
            }
            repaint();
        } 
        else {
            // Si hay una pieza seleccionada y se hace clic en una casilla vacía o en otra pieza
            if (control.realizarMovimiento(piezaSeleccionada, mouseX, mouseY)) {
                // Se ha realizado el movimiento con éxito
                control.capturarPieza(piezaCapturada);
                TColor colorOpuesto;
                // 3. Comprobar si hay alguna pieza que pueda bloquear la amenaza
                if(control.getTurnoActual() == TColor.Blanco)
                {
                    colorOpuesto = TColor.Blanco;
                }
                else{
                    colorOpuesto = TColor.Negro;
                }

                if(control.jaque(colorOpuesto)){
                    System.out.println("El rey está en Jaque");
                }
                
                if (control.jaqueMate(colorOpuesto)) {
                    JOptionPane.showMessageDialog(null, "¡Jaque Mate! Ganador: " + (control.getTurnoActual() == TColor.Blanco ? "Negras" : "Blancas"));
                        // Agrega aquí la lógica para finalizar el juego o reiniciar
                }
                else{
                    control.cambiarTurno();
                    piezaSeleccionada = null; // Después del movimiento, deselecciona la pieza
                    piezaCapturada = null;
                }
            } 
            else {
                // El movimiento no es válido, deselecciona la pieza
                piezaSeleccionada = null;
            }
        }

        repaint(); // Actualiza la representación gráfica del tablero
    }
    
    Modelo.Tablero tablero = new Modelo.Tablero();
        
    public void dibujarPiezasEmpezar(Graphics g) {
        
        for (Pieza pieza : listaDePiezas) {
            if (pieza != piezaCapturada) {
                int x = pieza.getX() * tamañoCasilla;
                int y = pieza.getY() * tamañoCasilla;

                // Aquí, utiliza la lógica para dibujar cada tipo de pieza
                switch (pieza.getTipo()) {
                    case Peon:
                        // Dibuja un rectángulo para el peón en (x, y)
                        g.setColor(pieza.getColor() == TColor.Blanco ? Color.WHITE : Color.BLACK);
                        int tamañoPieza = tamañoCasilla / 2; // Tamaño proporcional al de la casilla
                        int xOffset = (tamañoCasilla - tamañoPieza) / 2; // Centra la pieza en la casilla
                        int yOffset = (tamañoCasilla - tamañoPieza) / 2; // Centra la pieza en la casilla
                        g.fillRect(x + xOffset, y + yOffset, tamañoPieza, tamañoPieza);
                        break;
                    case Torre:
                        // Dibuja un rectángulo vertical para la torre en (x, y)
                        g.setColor(pieza.getColor() == TColor.Blanco ? Color.WHITE : Color.BLACK);
                        g.fillRect(x + tamañoCasilla / 4, y, tamañoCasilla / 2, tamañoCasilla);
                        break;
                    case Caballo:
                        int[] xPoints = {x + tamañoCasilla / 2, x, x, x + tamañoCasilla, x + tamañoCasilla};
                        int[] yPoints = {y, y + tamañoCasilla / 2, y + tamañoCasilla, y + tamañoCasilla, y + tamañoCasilla / 2};
                        g.setColor(pieza.getColor() == TColor.Blanco ? Color.WHITE : Color.BLACK);
                        g.fillPolygon(xPoints, yPoints, 5);
                        break;
                    case Alfil:
                        Polygon alfil = new Polygon();
                        alfil.addPoint(x + tamañoCasilla / 2, y);
                        alfil.addPoint(x, y + tamañoCasilla);
                        alfil.addPoint(x + tamañoCasilla, y + tamañoCasilla);
                        g.setColor(pieza.getColor() == TColor.Blanco ? Color.WHITE : Color.BLACK);
                        g.fillPolygon(alfil);
                        break;
                    case Reina:
                        g.setColor(pieza.getColor() == TColor.Blanco ? Color.WHITE : Color.BLACK);
                        g.fillOval(x + tamañoCasilla / 4, y + tamañoCasilla / 4, tamañoCasilla / 2, tamañoCasilla / 2);
                        break;
                    case Rey:
                        int[] xPuntos = {x + tamañoCasilla / 2, x + tamañoCasilla * 3 / 4, x + tamañoCasilla / 2, x + tamañoCasilla / 4};
                        int[] yPuntos = {y + tamañoCasilla / 4, y + tamañoCasilla / 2, y + tamañoCasilla * 3 / 4, y + tamañoCasilla / 2};
                        g.setColor(pieza.getColor() == TColor.Blanco ? Color.WHITE : Color.BLACK);
                        g.fillPolygon(xPuntos, yPuntos, 4);
                        break;
                }
            }
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                Color colorCasilla = ((fila + columna) % 2 == 0) ? colorBlanco : colorNegro;
                g.setColor(colorCasilla);
                g.fillRect(columna * tamañoCasilla, fila * tamañoCasilla, tamañoCasilla, tamañoCasilla);
            }
        }

        dibujarPiezasEmpezar(g);
      
    }
    
    public void mostrarMovimientosValidos(Graphics g, int fila, int columna, Pieza pieza) {
        ArrayList<int[]> movimientos = control.obtenerMovimientosValidos(pieza);
    
        // Lógica para resaltar visualmente los movimientos válidos en el tablero
        // Por ejemplo, podrías cambiar el color de fondo de las casillas válidas o agregar un borde

        // Suponiendo que el TableroPanel tiene un método resaltarCasilla(int x, int y)
        for (int[] movimiento : movimientos) {
            int x = movimiento[0];
            int y = movimiento[1];
            resaltarCasilla(g, fila, columna, Color.RED); // Método hipotético para resaltar una casilla en el panel del tablero
        }
    }
    
    private void resaltarCasilla(Graphics g, int fila, int columna, Color color) {
        g.setColor(color);
        g.fillRect(columna * tamañoCasilla, fila * tamañoCasilla, tamañoCasilla, tamañoCasilla);
    }
}

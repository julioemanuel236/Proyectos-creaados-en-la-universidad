package cliente.gui;

import cliente.NetworkClientTest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    protected Panel panel;
    protected String host = "localhost";
    protected int port = 9000;
    protected NetworkClientTest testClient;

    //private char turno = 'X'; // 'X' representa el primer jugador, 'O' representa el segundo jugador
    private Color turnoColor = Color.RED; // Inicializa con el color rojo

    public Controlador(Panel panel) {
        this.panel = panel;
    }

    public Controlador() {
        
    }

	@Override
    public void actionPerformed(ActionEvent e) {
		
        if (!panel.isJuegoActivo()) {
            testClient = new NetworkClientTest(host, port, panel);
            testClient.connect();
            panel.start.setEnabled(false);
            panel.habilitarBotones();
        } 
        else {
            String pulsado = e.getActionCommand();
            String[] posicion = pulsado.split(" ");

            int fila = Integer.parseInt(posicion[0]);
            int col = Integer.parseInt(posicion[1]);

            System.out.println("Se ha pulsado el botón : " + fila + " " + col);

            // Verifica si la casilla está vacía antes de realizar el movimiento
            if (panel.verificarCasillaVacia(fila, col)) {
                testClient.enviarMovimiento(fila, col, turnoColor);

                // Cambia el color del turno del jugador
                turnoColor = (turnoColor == Color.RED) ? Color.BLUE : Color.RED;

                // Actualiza el contenido del botón con el color del jugador
                panel.matrizbotones[fila][col].getBoton().setBackground(turnoColor);
                panel.matrizbotones[fila][col].getBoton().setEnabled(false);

                // Realiza la lógica para verificar si alguien ganó
                if (panel.verificarVictoria(fila, col, turnoColor)) {
                    panel.mostrarResultado(true);
                    panel.habilitarBotones(); // Deshabilita los botones después de que se haya ganado
                } else if (panel.verificarEmpate()) {
                    panel.mostrarResultado(false);
                    panel.habilitarBotones(); // Deshabilita los botones después de un empate
                }
            }
        }
    }
	
	public void start() {
		panel.iniciarJuego();
	}

}

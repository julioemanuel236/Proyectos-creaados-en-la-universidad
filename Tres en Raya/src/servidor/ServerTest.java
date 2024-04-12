package servidor;

import java.awt.Color;
import java.io.*;
import java.net.Socket;

public class ServerTest extends NetworkServer {

	private Tablero tablero;
	private Color currentPlayerColor;

	public ServerTest(int port) {
		super(port);
		tablero = new Tablero(3, 3); // Tablero de 3x3 para tic tac toe
		currentPlayerColor = Color.RED; // Color del primer jugador
	}

	public static void main(String[] args) {
		int port = 9000;

		ServerTest server = new ServerTest(port);
		
		cliente.gui.Demo dm1 = new cliente.gui.Demo(); 

		cliente.gui.Demo dm2 = new cliente.gui.Demo();
		
		cliente.gui.Controlador start = new cliente.gui.Controlador();
		start.start();
		server.listen();
	}

	@Override
	protected void handleConnection(Socket socket) throws IOException {
		ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
		outputStream.flush();
		ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

		PrintWriter output = SocketUtils.getWriter(socket);

		output.println("Welcome to Tic Tac Toe!");

		try {
			while (!tablero.hayGanador(currentPlayerColor) && !tablero.tableroLleno()) {
				output.println("Your move, Player " + currentPlayerColor);
				int row = (int) inputStream.readObject();
				int col = (int) inputStream.readObject();

				if (tablero.colocarFicha(row, col, currentPlayerColor)) {
					output.println("Move successful");
				} else {
					output.println("Invalid move");
					continue;
				}

				// Enviar el estado actual del tablero al cliente
				enviarTablero(outputStream);

				// Cambiar de jugador para el próximo turno
				currentPlayerColor = (currentPlayerColor == Color.RED) ? Color.BLUE : Color.RED;
			}

			// Verificar el resultado del juego
			if (tablero.hayGanador(Color.RED)) {
				output.println("Player Red wins!");
			} else if (tablero.hayGanador(Color.BLUE)) {
				output.println("Player Blue wins!");
			} else {
				output.println("It's a draw!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		socket.close();
	}

	private void enviarTablero(ObjectOutputStream outputStream) throws IOException {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				outputStream.writeObject(tablero.obtenerFicha(i, j));
			}
		}
	}
}

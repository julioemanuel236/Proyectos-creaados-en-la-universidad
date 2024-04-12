package pkgCliente;

import pkgSerializable.Casilla;
import pkgGUI.Panel;

import java.awt.Color;
import java.io.*;
import java.net.Socket;

public class NetworkClientTest extends pkgCliente.NetworkClient {

    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private BufferedReader in;

    public NetworkClientTest(String host, int port, Panel panel) {
        super(host, port, panel);
    }

    @Override
    protected void handleConnection(Socket client) throws IOException {

        socket = client;

        outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.flush();
        inputStream = new ObjectInputStream(socket.getInputStream());

        in = SocketUtils.getReader(socket);

        System.out.println("Connected to: " + getHost());
        System.out.println("Connection Local port: " + client.getPort());
        System.out.println("Connection Remote port: " + client.getLocalPort());
        System.out.println(in.readLine());
    }

    public void enviarMovimiento(int fila, int columna, Color turnoColor) {
        if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3) {
            try {
                outputStream.writeObject(fila);
                outputStream.writeObject(columna);
                outputStream.writeObject(turnoColor); // Enviar el color del jugador
                System.out.println("CLIENTE -> Fila: " + fila + " Columna: " + columna + " Turno: " + turnoColor);

                // Leer respuesta del servidor
                String response = in.readLine();
                if (response.equals("ok")) {
                    System.out.println("Movimiento enviado y aceptado por el servidor");
                } else if (response.equals("fin")) {
                    // Fin del juego, recibir resultado
                    boolean ganar = in.readLine().equals("win");
                    System.out.println("Juego terminado: " + (ganar ? "Ganado" : "Perdido"));
                    panel.mostrarResultado(ganar);
                    socket.close();
                }

            } catch (IOException e) {
                System.out.println("Excepción enviando movimiento desde el cliente");
                e.printStackTrace();
            }
        }
    }

}

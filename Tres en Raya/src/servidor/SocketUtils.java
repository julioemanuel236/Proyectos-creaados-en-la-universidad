package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketUtils {

    public static BufferedReader getReader(Socket socket) throws IOException{
        return (new BufferedReader(new InputStreamReader(socket.getInputStream())));
    }

    public static PrintWriter getWriter(Socket socket) throws IOException {
        // second arg TRUE means autoflush
        return (new PrintWriter(socket.getOutputStream(), true));
    }

    // Make uninstantiable class
    private SocketUtils() {}
}

import java.time.Clock;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Principal {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int oro = 0;
            System.out.println("Bienvenido al juego");
            System.out.println("Introduzca su nombre de usuario");
            String nombre = sc.nextLine();
            if (nombre.equals("")) {
                nombre = "Jugador";
            }
            Jugador jugador = new Jugador(nombre, oro, new LinkedList<Jugable>());
            if (jugador.getPersonajes().size() == 0) {
                oro = 500;
                System.out.println("Se le ha acreditado 500 de oro");
                jugador.setOro(oro);
                mostrarTienda(jugador);
                mostrarTienda(jugador);
            }
            boolean salir = false;
            while (!salir) {
                System.out.println("1. Iniciar partida");
                System.out.println("2. Tienda");
                System.out.println("3. Generar tablero");
                System.out.println("4. Inventario");
                System.out.println("5. Salir");
                int eleccion = sc.nextInt();
                switch (eleccion) {
                    case 1:
                        Partida partida = new Partida(jugador, jugador.getPersonajes().get(0), jugador.getPersonajes().get(1), new Tablero(), new ArrayList<Enemigo>(), 0, jugador.getOro(), false);
                        partida.iniciarPartida();
                        break;
                    case 2:
                        mostrarTienda(jugador);
                        break;
                    case 3:
                        Tablero tablero = new Tablero();
                        tablero.generarTablero();
                        break;
                    case 4:
                        jugador.mostrarInventario();
                        break;
                    case 5:
                        salir = true;
                        break;
                }
            }
        }

        public static void mostrarTienda(Jugador jugador) {//Caballero,Arquero,Mago,Gigante,Dragon
            System.out.println("Bienvenido a la tienda");
            System.out.println("Tiene " + jugador.getOro() + " de oro");
            System.out.println("Personajes disponibles");
            System.out.println("1. Caballero  2. Arquero  3. Mago  4. Gigante  5. Dragon 6. Salir");
            Scanner sc = new Scanner(System.in);
            int eleccion = sc.nextInt();
            switch (eleccion) {
                case 1:
                    if (jugador.getOro() >= 200) {
                        jugador.setOro(jugador.getOro() - 200);
                        jugador.añadirPersonaje(new Caballero());
                    } else {
                        System.out.println("No tiene suficiente oro");
                    }
                    break;
                case 2:
                    if (jugador.getOro() >= 200) {
                        jugador.setOro(jugador.getOro() - 200);
                        jugador.añadirPersonaje(new Arquero());
                    } else {
                        System.out.println("No tiene suficiente oro");
                    }
                    break;
                case 3:
                    if (jugador.getOro() >= 200) {
                        jugador.setOro(jugador.getOro() - 200);
                        jugador.añadirPersonaje(new Mago());
                    } else {
                        System.out.println("No tiene suficiente oro");
                    }
                    break;
                case 4:
                    if (jugador.getOro() >= 200) {
                        jugador.setOro(jugador.getOro() - 200);
                        jugador.añadirPersonaje(new Gigante());
                    } else {
                        System.out.println("No tiene suficiente oro");
                    }
                    break;
                case 5:
                    if (jugador.getOro() >= 200) {
                        jugador.setOro(jugador.getOro() - 200);
                        jugador.añadirPersonaje(new Dragon());
                    } else {
                        System.out.println("No tiene suficiente oro");
                    }
                    break;
                default:
                    System.out.println("Eleccion invalida");
            }
        }


}
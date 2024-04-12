
package Control;

import Modelo.*;
import java.util.ArrayList;

public class Controlador {
    private String jugador1;
    private String jugador2;
    private ArrayList<Pieza> Piezas;
    private TColor turnoActual;
    private Pieza piezaCapturada;
    
    Modelo.Tablero tablero = new Modelo.Tablero();
    
    public Controlador(String jugador1, String jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    public void Empezar() {
        FactoryPieza factory = new FactoryPieza();

        Piezas = new ArrayList<>();
        turnoActual = TColor.Blanco;

        for (int columna = 0; columna < 8; columna++) {
            // Peones Blancos
            Piezas.add(factory.factoryMethod(Ttipo.Peon, TColor.Blanco, columna, 1));
        }

        // Torres Blancas
        Piezas.add(factory.factoryMethod(Ttipo.Torre, TColor.Blanco, 0, 0));
        Piezas.add(factory.factoryMethod(Ttipo.Torre, TColor.Blanco, 7, 0));
        
        // Caballos Blancos
        Piezas.add(factory.factoryMethod(Ttipo.Caballo, TColor.Blanco, 1, 0));
        Piezas.add(factory.factoryMethod(Ttipo.Caballo, TColor.Blanco, 6, 0));
        
        // Alfiles Blancos
        Piezas.add(factory.factoryMethod(Ttipo.Alfil, TColor.Blanco, 2, 0));
        Piezas.add(factory.factoryMethod(Ttipo.Alfil, TColor.Blanco, 5, 0));
        
        // Reina y Rey Blancos
        Piezas.add(factory.factoryMethod(Ttipo.Reina, TColor.Blanco, 3, 0));
        Piezas.add(factory.factoryMethod(Ttipo.Rey, TColor.Blanco, 4, 0));
        
        for (int columna = 0; columna < 8; columna++) {
            // Peones Negros
            Piezas.add(factory.factoryMethod(Ttipo.Peon, TColor.Negro, columna, 6));
        }

        // Torres Negros
        Piezas.add(factory.factoryMethod(Ttipo.Torre, TColor.Negro, 0, 7));
        Piezas.add(factory.factoryMethod(Ttipo.Torre, TColor.Negro, 7, 7));
        
        // Caballos Negros
        Piezas.add(factory.factoryMethod(Ttipo.Caballo, TColor.Negro, 1, 7));
        Piezas.add(factory.factoryMethod(Ttipo.Caballo, TColor.Negro, 6, 7));
        
        // Alfiles Negros
        Piezas.add(factory.factoryMethod(Ttipo.Alfil, TColor.Negro, 2, 7));
        Piezas.add(factory.factoryMethod(Ttipo.Alfil, TColor.Negro, 5, 7));
        
        // Reina y Rey Negros
        Piezas.add(factory.factoryMethod(Ttipo.Reina, TColor.Negro, 3, 7));
        Piezas.add(factory.factoryMethod(Ttipo.Rey, TColor.Negro, 4, 7));

        // Colocar las piezas en el tablero
        for (Pieza pieza : Piezas) {
            tablero.colocarPieza(pieza, pieza.getY(), pieza.getX());
        }
    }
    
    public boolean realizarMovimiento(Pieza pieza, int x, int y) {
        // Verifica si la posición destino está dentro de los límites del tablero
        if (!tablero.esCoordenadaValida(x, y)) {
            return false; // Movimiento inválido si está fuera del tablero
        }

        Pieza piezaEnNuevaPosicion = obtenerPiezaEnPosicion(x, y);
        if (piezaEnNuevaPosicion != null) {
            // Verificar si la pieza es del color contrario (si es capturable)
            if (piezaEnNuevaPosicion.getColor() != pieza.getColor() && pieza.validarMovimiento(x, y)) {
                // Captura exitosa: eliminar la pieza de la lista de piezas
                Piezas.remove(piezaEnNuevaPosicion);
            } else {
                // No se puede mover a esa posición, hay una pieza del mismo color
                return false;
            }
        }

        // Realiza el movimiento de la pieza a la posición destino
        if (!pieza.validarMovimiento(x, y)) {
            return false; // Movimiento inválido según las reglas de la pieza
        }

        // Actualiza la posición de la pieza
        pieza.setX(x);
        pieza.setY(y);

        return true; // Movimiento válido
    }
    
    public ArrayList<int[]> obtenerMovimientosValidos(Pieza pieza) {
        ArrayList<int[]> movimientos = new ArrayList<>();

        ArrayList<int[]> movimientosValidos = new ArrayList<>();

        int xActual = pieza.getX();
        int yActual = pieza.getY();
        TColor colorPieza = pieza.getColor();
        
        // Lógica de generación de movimientos según el tipo de pieza
        switch (pieza.getTipo()) {
            case Peon:
                // Movimiento hacia adelante
                int avance = (colorPieza == TColor.Blanco) ? -1 : 1; // Determina la dirección del avance

                // Movimiento inicial de dos casillas
                int casillaInicial = (colorPieza == TColor.Blanco) ? 6 : 1; // Fila donde comienza el peón
                if (yActual + avance >= 0 && yActual + avance < 8) {
                    if (casillaVacia(xActual, yActual + avance) && yActual == casillaInicial) {
                        movimientosValidos.add(new int[]{xActual, yActual + avance});
                        if (casillaVacia(xActual, yActual + avance * 2)) {
                            movimientosValidos.add(new int[]{xActual, yActual + avance * 2});
                        }
                    }
                }

                // Movimiento de captura diagonal
                int[] posiblesCapturas = {xActual - 1, yActual + avance}; // Diagonal izquierda
                if (casillaValida(posiblesCapturas[0], posiblesCapturas[1])) {
                    if (!casillaVacia(posiblesCapturas[0], posiblesCapturas[1])
                            && tablero.obtenerPiezaEnPosicion(posiblesCapturas[0], posiblesCapturas[1]).getColor() != colorPieza) {
                        movimientosValidos.add(posiblesCapturas);
                    }
                }

                posiblesCapturas[0] = xActual + 1; // Diagonal derecha
                if (casillaValida(posiblesCapturas[0], posiblesCapturas[1])) {
                    if (!casillaVacia(posiblesCapturas[0], posiblesCapturas[1])
                            && tablero.obtenerPiezaEnPosicion(posiblesCapturas[0], posiblesCapturas[1]).getColor() != colorPieza) {
                        movimientosValidos.add(posiblesCapturas);
                    }
                }
                return movimientosValidos;
                
            case Torre:

                // Direcciones posibles para una torre: arriba, abajo, izquierda y derecha
                int[][] direcciones = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

                // Itera sobre las direcciones posibles
                for (int[] direccion : direcciones) {
                    int dx = direccion[0];
                    int dy = direccion[1];

                    int fila = pieza.getX() + dx;
                    int columna = pieza.getY() + dy;

                    // Mientras la casilla evaluada esté dentro del tablero y esté vacía o tenga una pieza oponente
                    while (casillaValida(fila, columna) && (casillaVacia(fila, columna) || hayPiezaOponente(fila, columna, Piezas, pieza.getColor() ))) {
                        movimientosValidos.add(new int[] { fila, columna });

                        // Avanza en la dirección actual
                        fila += dx;
                        columna += dy;
                    }
                }

                return movimientosValidos;
            case Caballo:
                int[][] direcciones1 = { { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 } };

                for (int[] direccion : direcciones1) {
                    int newX = pieza.getX() + direccion[0];
                    int newY = pieza.getY() + direccion[1];

                    if (casillaValida(newX, newY) && (casillaVacia(newX, newY) || hayPiezaOponente(newX, newY, Piezas, pieza.getColor()))) {
                        movimientos.add(new int[] { newX, newY });
                    }
                }      
                return movimientos;

            case Alfil:
                int[][] direcciones2 = { { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

                for (int[] direccion : direcciones2) {
                    for (int i = 1; i < 8; i++) {
                        int newX = pieza.getX() + direccion[0] * i;
                        int newY = pieza.getY() + direccion[1] * i;

                        if (casillaValida(newX, newY)) {
                            if (casillaVacia(newX, newY)) {
                                movimientos.add(new int[] { newX, newY });
                            } else if (hayPiezaOponente(newX, newY, Piezas, pieza.getColor())) {
                                movimientos.add(new int[] { newX, newY });
                                break;
                            } else {
                                break; // Detener la búsqueda si hay una pieza propia en el camino
                            }
                        } else {
                            break; // Detener la búsqueda si se sale del tablero
                        }
                    }
                }

                return movimientos;
            case Reina:
                int[][] direcciones3 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

                for (int[] direccion : direcciones3) {
                    int newX = pieza.getX() + direccion[0];
                    int newY = pieza.getY() + direccion[1];

                    while (casillaValida(newX, newY)) {
                        if (casillaVacia(newX, newY)) {
                            movimientos.add(new int[] { newX, newY });
                        } else if (hayPiezaOponente(newX, newY,Piezas, pieza.getColor())) {
                            movimientos.add(new int[] { newX, newY });
                            break;
                        } else {
                            break; // Detener la búsqueda si hay una pieza propia en el camino
                        }

                        newX += direccion[0];
                        newY += direccion[1];
                    }
                }

                return movimientos;
            case Rey:
                int[][] direcciones4 = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, /* (x, y) */ { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
                };

                for (int[] direccion : direcciones4) {
                    int newX = pieza.getX() + direccion[0];
                    int newY = pieza.getY() + direccion[1];

                    if (casillaValida(newX, newY) && (casillaVacia(newX, newY) || hayPiezaOponente(newX, newY, Piezas, pieza.getColor()))) {
                        movimientos.add(new int[] { newX, newY });
                    }
                }

                return movimientos;
            default:
                return movimientosValidos;
                
    
        }
    }
    
    public void cambiarTurno() {
        if (turnoActual == TColor.Blanco) {
            turnoActual = TColor.Negro;
        } else {
            turnoActual = TColor.Blanco;
        }
    }
    
    public boolean jaqueMate(TColor color) {
        Pieza rey = obtenerRey(color);
        if (rey == null || !jaque(color)) {
            return false; // No hay jaque, no puede haber jaque mate
        }

        ArrayList<int[]> movimientosRey = obtenerMovimientosValidos(rey);
        if (!movimientosRey.isEmpty()) {
            return false; // El rey puede moverse, no es jaque mate
        }

        TColor colorOpuesto = (color == TColor.Blanco) ? TColor.Negro : TColor.Blanco;
        ArrayList<Pieza> piezas = obtenerPiezasPorColor(colorOpuesto);

        // Verificar si alguna pieza puede bloquear la amenaza al rey
        for (Pieza pieza : piezas) {
            ArrayList<int[]> movimientos = obtenerMovimientosValidos(pieza);
            for (int[] movimiento : movimientos) {
                if (puedeBloquear(pieza, movimiento, rey)) {
                    return false; // Existe una pieza que puede bloquear la amenaza, no es jaque mate
                }
            }
        }

        // Verificar si alguna pieza puede capturar la pieza amenazante
        Pieza amenaza = obtenerPiezaQueAmenaza(colorOpuesto, rey);
        for (Pieza pieza : piezas) {
            ArrayList<int[]> movimientos = obtenerMovimientosValidos(pieza);
            for (int[] movimiento : movimientos) {
                if (movimiento[0] == amenaza.getX() && movimiento[1] == amenaza.getY()) {
                    return false; // Se puede capturar la pieza que amenaza al rey, no es jaque mate
                }
            }
        }

        // Si no se ha cumplido ninguna condición previa, es jaque mate
        return true;
    }
    
    public boolean jaqueDespuesMovimiento(Pieza piezamovida, int posX,int posY, int xDestino, int yDestino) {
        // Realizar el movimiento de la pieza a la posición destino
        // Esto podría variar dependiendo de tu implementación específica

        // Verificar si el rey del jugador actual está en jaque después del movimiento
        TColor colorJugadorActual = piezamovida.getColor();
        Pieza reyJugadorActual = encontrarRey(turnoActual); // Encuentra el rey del jugador

        // Iterar sobre las piezas del oponente para verificar si alguna amenaza al rey
        for (Pieza pieza : getPiezas()) {
            if (pieza.getColor() != colorJugadorActual) {
                if (pieza.validarMovimiento(reyJugadorActual.getX(), reyJugadorActual.getY())) {
                    // El rey está en jaque, deshacer el movimiento y retornar true
                    // Podrías implementar un método para deshacer el movimiento
                    // DeshacerMovimiento(piezaMovida, xDestino, yDestino);
                    return true;
                }
            }
        }

        // Si ninguna pieza del oponente amenaza al rey, entonces no está en jaque
        return false;
    }
    
    public Pieza encontrarRey(TColor colorJugador) {
        // Iterar sobre las piezas para encontrar el rey del color del jugador
        for (Pieza pieza : getPiezas()) {
            if (pieza.getTipo() == Ttipo.Rey && pieza.getColor() == colorJugador) {
                return pieza; // Devuelve la pieza del rey del jugador
            }
        }
        return null; // Si no se encuentra el rey, devuelve null
    }
  
    public boolean ganador() {
        if(jaqueMate(TColor.Blanco)||jaqueMate(TColor.Negro)){
            return true;
        }
        return false;
    }
    public void mostrarJugador1() {
        
    }

    public ArrayList<Pieza> getPiezas() {
        return Piezas;
    }
    
    public Pieza obtenerPiezaEnPosicion(int x, int y) {
        for (Pieza pieza : Piezas) {
            if (pieza.getX() == x && pieza.getY() == y) {
                return pieza;
            }
        }
        return null;
    }

    public TColor getTurnoActual() {
        return turnoActual;
    }

    public Pieza getPiezaCapturada() {
        return piezaCapturada;
    }
    
    public void capturarPieza(Pieza pieza) {
        piezaCapturada = pieza;
        Piezas.remove(pieza); // Elimina la pieza de la lista de piezas
    }
    
    public ArrayList<Pieza> obtenerPiezasPorColor(TColor color) {
        ArrayList<Pieza> piezasDelColor = new ArrayList<>();
        for (Pieza pieza : Piezas) {
            if (pieza.getColor() == color) {
                piezasDelColor.add(pieza);
            }
        }
        return piezasDelColor;
    }
    
    public void deshacerMovimiento(Pieza pieza, int newX, int newY, Pieza piezaCapturada) {
        // Guardar la posición anterior de la pieza
        int prevX = pieza.getX();
        int prevY = pieza.getY();

        // Mueve la pieza a su posición previa
        pieza.setX(newX);
        pieza.setY(newY);

        // Si se capturó una pieza durante el movimiento, vuelve a agregarla a la lista de piezas
        if (piezaCapturada != null) {
            Piezas.add(piezaCapturada);
        }
    }
    
    public Pieza obtenerRey(TColor color) {
        if (Piezas != null) {
            for (Pieza pieza : Piezas) {
                if (pieza.getTipo() == Ttipo.Rey && pieza.getColor() == color) {
                    return pieza; // Devuelve la pieza del rey del color especificado
                }
            }
        }
        return null; // No se encontró el rey del color especificado o Piezas es null
    }
    
    public boolean jaque(TColor colorRey) {
        Pieza rey = obtenerRey(colorRey);

        if (rey != null) {
            System.out.println(rey.getTipo()+" "+rey.getColor()+" "+rey.getX()+" "+rey.getY());
            for (Pieza pieza : getPiezas()) {
                if (pieza.getColor() != colorRey) {
                    ArrayList<int[]> movimientos = obtenerMovimientosValidos(pieza);
                    for (int[] movimiento : movimientos) {
                        System.out.println(pieza.getTipo() +" "+ pieza.getColor()+" PUEDE IR A "+movimiento[0] + " "+movimiento[1]);
                        if (movimiento[1] == rey.getX() && movimiento[0] == rey.getY()) {
                            System.out.println("JAQUE");
                            return true; // El rey está en jaque
                        }
                    }
                }
            }
        }
        return false; // El rey no está en jaque
    }
      
    public ArrayList<Pieza> obtenerPiezasAtacantes(TColor color) {
        
        TColor colorOpuesto;

            if(turnoActual == TColor.Blanco)
            {
                colorOpuesto = TColor.Negro;
            }
            else{
                colorOpuesto = TColor.Blanco;
            }
        Pieza rey = obtenerRey(colorOpuesto);
        ArrayList<Pieza> piezasAtacantes = new ArrayList<>();

        for (Pieza pieza : Piezas) {
            if (pieza.getColor() == color) {
                ArrayList<int[]> movimientosPieza = obtenerMovimientosValidos(pieza);
                for (int[] movimiento : movimientosPieza) {
                    int xPieza = movimiento[0];
                    int yPieza = movimiento[1];
                    if (rey.getX() == xPieza && rey.getY() == yPieza) {
                        piezasAtacantes.add(pieza);
                    }
                }
            }
        }

        return piezasAtacantes;
    }
    
    public Pieza obtenerPiezaQueAmenaza(TColor color, Pieza piezaAmenazada) {
        TColor colorOpuesto;
        // 3. Comprobar si hay alguna pieza que pueda bloquear la amenaza
        if(turnoActual == TColor.Blanco)
        {
            colorOpuesto = TColor.Negro;
        }
        else{
            colorOpuesto = TColor.Blanco;
        }
        
        for (Pieza pieza : Piezas) {
            if (pieza.getColor() == colorOpuesto) {
                ArrayList<int[]> movimientosPieza = obtenerMovimientosValidos(pieza);
                for (int[] movimiento : movimientosPieza) {
                    int xPieza = movimiento[0];
                    int yPieza = movimiento[1];
                    if (piezaAmenazada.getX() == xPieza && piezaAmenazada.getY() == yPieza) {
                        return pieza;
                    }
                }
            }
        }
        return null;
    }
    
    private boolean puedeBloquear(Pieza pieza, int[] movimiento, Pieza rey) {
        // Verificar si el movimiento intercepta la línea entre la pieza amenazante y el rey
        int[] posRey = {rey.getX(), rey.getY()};
        while (true) {
            if (movimiento[0] == posRey[0] && movimiento[1] == posRey[1]) {
                return true;
            }
            if (posRey[0] > movimiento[0]) {
                posRey[0]--;
            } else if (posRey[0] < movimiento[0]) {
                posRey[0]++;
            }
            if (posRey[1] > movimiento[1]) {
                posRey[1]--;
            } else if (posRey[1] < movimiento[1]) {
                posRey[1]++;
            }
            if (posRey[0] == pieza.getX() && posRey[1] == pieza.getY()) {
                return false;
            }
        }
    }
    
    public boolean casillaVacia(int x, int y) {
        // Verifica si la posición (x, y) está dentro de los límites del tablero
        if (x < 0 || x >= 8 || y < 0 || y >= 8) {
            return false; // Fuera de los límites del tablero
        }

        
        if (tablero.obtenerPieza(y, y) == null) {
             return true; // La casilla está vacía
        }

        // Devolver false si la casilla está ocupada por una pieza
        return true;
    }
    
    public boolean casillaValida(int x, int y) {
        // Verifica si la posición (x, y) está dentro de los límites del tablero (8x8)
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
    
    public boolean hayPiezaOponente(int x, int y, ArrayList<Pieza> listaDePiezas, TColor colorPropio) {
        for (Pieza pieza : listaDePiezas) {
            if (pieza.getX() == x && pieza.getY() == y && pieza.getColor() != colorPropio) {
                return true; // Hay una pieza del oponente en esta posición
            }
        }
        return false; // No hay una pieza del oponente en esta posición
    }
}

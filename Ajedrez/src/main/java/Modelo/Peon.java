
package Modelo;

public class Peon extends Pieza {
    private boolean primerMovimiento;

    Tablero tablero = new Tablero();
    
    public Peon(TColor color, int x, int y) {
        super(Ttipo.Peon, color, x, y);
        this.primerMovimiento = true;
    }

    @Override
    public void mover(int x, int y) {
        // Implementación del movimiento del peón
        if (validarMovimiento(x, y)) {
            setX(x);
            setY(y);
            primerMovimiento = false;
        } else {
            System.out.println("Movimiento inválido para el peón.");
        }
    }

    @Override
    public boolean validarMovimiento(int x, int y) {
        int diffX = x - getX();
        int diffY = y - getY();

        Tablero tablero = new Tablero();
        
        // Movimiento del peón blanco
        if (getColor() == TColor.Blanco) {
            // Movimiento hacia adelante una casilla
            if (diffX == 0 && diffY == 1) {
                return tablero.obtenerPiezaEnPosicion(x, y) == null; // Verificar si la casilla está vacía
            }
            // Primer movimiento puede avanzar dos casillas
            else if (primerMovimiento && diffX == 0 && diffY == 2) {
                // Verificar si las casillas intermedias están vacías
                return tablero.obtenerPiezaEnPosicion(x, y) == null && tablero.obtenerPiezaEnPosicion(x, y + 1) == null;
            }
            // Captura hacia la izquierda o derecha
            else if (diffX == -1 || diffX == 1) {
                return diffY == 1 && tablero.obtenerPiezaEnPosicion(x, y) != null && isCaptura(x,y,tablero); // Verificar si hay una pieza para capturar
            }
            
            // Movimiento único del peón
            if (esMovimientoCapturaAlPaso(x, y)) {
                
                return true;
            }
        }
        // Movimiento del peón negro
        else {
            // Movimiento hacia adelante una casilla
            if (diffX == 0 && diffY == -1) {
                return tablero.obtenerPiezaEnPosicion(x, y) == null; // Verificar si la casilla está vacía
            }
            // Primer movimiento puede avanzar dos casillas
            else if (primerMovimiento && diffX == 0 && diffY == -2) {
                // Verificar si las casillas intermedias están vacías
                return tablero.obtenerPiezaEnPosicion(x, y) == null && tablero.obtenerPiezaEnPosicion(x, y - 1) == null;
            }
            // Captura hacia la izquierda o derecha
            else if (diffX == -1 || diffX == 1) {
                return diffY == -1 && tablero.obtenerPiezaEnPosicion(x, y) == null && isCaptura(x,y,tablero); // Verificar si hay una pieza para capturar
            }
        }

        return false;
    }

    private boolean esMovimientoCapturaAlPaso(int x, int y) {
        int diffX = Math.abs(x - getX());
        int diffY = Math.abs(y - getY());

        // Verifica si es un movimiento en diagonal
        if (diffX == 1 && diffY == 1) {
            // Obtener la dirección hacia la que se está moviendo el peón
            int direccionY = (getColor() == TColor.Blanco) ? -1 : 1;

            // Calcular las coordenadas adyacentes
            int adyacenteX = x;
            int adyacenteY = getY() + direccionY;

            // Verificar si la posición adyacente contiene un peón oponente
            Pieza piezaAdyacente = tablero.obtenerPiezaEnPosicion(adyacenteX, adyacenteY);
            if (piezaAdyacente instanceof Peon && piezaAdyacente.getColor() != getColor()) {
                return true; // Captura al paso válida
            }
        }

        return false; // No es una captura al paso válida
    }
    
    @Override
    public boolean isCaptura(int posX, int posY, Tablero tablero) {
        Pieza piezaEnPosicion = tablero.obtenerPieza(posY, posY); // Método para obtener la pieza en la posición indicada

        if (piezaEnPosicion != null) {
            int diffX = Math.abs(posX - getX());
            int diffY = posY - getY();

            if (getColor() == TColor.Blanco) {
                return (diffX == 1 && diffY == 1 && piezaEnPosicion.getColor() == TColor.Negro);
            } else {
                return (diffX == 1 && diffY == -1 && piezaEnPosicion.getColor() == TColor.Blanco);
            }
        }
        return false;
    }
    
    public boolean alcanzoUltimaFila() {
        if ((getColor() == TColor.Blanco && getY() == 0) || (getColor() == TColor.Negro && getY() == 7)) {
            return true;
        }
        return false;
    }

    public void coronarPieza(Pieza nuevaPieza) {
        // Reemplaza el peón por la nueva pieza
        this.setTipo(nuevaPieza.getTipo());
        // ... cualquier otra lógica que necesites para manejar la coronación
    }
    
    
}

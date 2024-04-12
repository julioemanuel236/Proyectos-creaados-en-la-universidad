package Modelo;

public class Alfil extends Pieza {

    Tablero tablero = new Tablero();
    
    public Alfil(TColor color, int x, int y) {
        super(Ttipo.Alfil, color, x, y);
    }

    @Override
    public void mover(int x, int y) {
        // Implementación del movimiento del alfil
        if (validarMovimiento(x, y)) {
            setX(x);
            setY(y);
        } else {
            System.out.println("Movimiento inválido para el alfil.");
        }
    }

    @Override
    public boolean validarMovimiento(int x, int y) {
        int diffX = Math.abs(x - getX());
        int diffY = Math.abs(y - getY());

        // Verificar si el movimiento es diagonal
        if (diffX != diffY) {
            return false;
        }

        // Verificar si alguna pieza bloquea el camino del alfil
        int dirX = (x > getX()) ? 1 : -1;
        int dirY = (y > getY()) ? 1 : -1;

        int posX = getX() + dirX;
        int posY = getY() + dirY;

        while (posX != x && posY != y) {
            Pieza piezaEnPosicion = tablero.obtenerPiezaEnPosicion(posX, posY);

            // Verificar si hay una pieza en la posición intermedia
            if (piezaEnPosicion != null) {
                // Si la pieza es del mismo color, el movimiento no es válido
                if (piezaEnPosicion.getColor() == getColor()) {
                    return false;
                }
            }

            posX += dirX;
            posY += dirY;
        }

        // Verificar si en la posición final hay una pieza para una posible captura
        Pieza piezaFinal = tablero.obtenerPiezaEnPosicion(x, y);
        if (piezaFinal != null) {
            // Si la pieza en la posición final es del mismo color, no puede moverse
            if (piezaFinal.getColor() == getColor()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean isCaptura(int posX, int posY, Tablero tablero) {  
        
        Pieza piezaEnPosicion = tablero.obtenerPieza(posX, posY); // Método para obtener la pieza en la posición indicada

        if (piezaEnPosicion != null) {
            return validarMovimiento(posX, posY) && (getColor() != piezaEnPosicion.getColor());
        }
        return false;
    }
}

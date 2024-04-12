
package Modelo;


public class Reina extends Pieza {

    Tablero tablero = new Tablero();
    
    public Reina(TColor color, int x, int y) {
        super(Ttipo.Reina, color, x, y);
    }

    @Override
    public void mover(int x, int y) {
        // Implementación del movimiento de la reina
        if (validarMovimiento(x, y)) {
            setX(x);
            setY(y);
        } else {
            System.out.println("Movimiento inválido para la reina.");
        }
    }

    @Override
    public boolean validarMovimiento(int x, int y) {
        int diffX = Math.abs(x - getX());
        int diffY = Math.abs(y - getY());

        // Movimiento horizontal, vertical o diagonal
        if ((diffX != 0 && diffY == 0) || (diffX == 0 && diffY != 0) || (diffX == diffY)) {
            int dirX = (x > getX()) ? 1 : (x < getX()) ? -1 : 0;
            int dirY = (y > getY()) ? 1 : (y < getY()) ? -1 : 0;

            int posX = getX() + dirX;
            int posY = getY() + dirY;

            // Verificar si hay alguna pieza bloqueando el camino
            while (posX != x || posY != y) {
                Pieza piezaEnPosicion = tablero.obtenerPiezaEnPosicion(posX, posY);

                // Si hay una pieza en la posición intermedia
                if (piezaEnPosicion != null) {
                    // Si es del mismo color, no puede moverse
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

        return false;
    }

    @Override
    public boolean isCaptura(int posX, int posY, Tablero tablero) {
        Pieza piezaEnPosicion = tablero.obtenerPieza(posY, posY); // Método para obtener la pieza en la posición indicada

        if (piezaEnPosicion != null) {
            return validarMovimiento(posX, posY) && (getColor() != piezaEnPosicion.getColor());
        }
        return false;
    }
}

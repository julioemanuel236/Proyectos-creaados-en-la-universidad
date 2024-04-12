package Modelo;

public class Torre extends Pieza {
    boolean seHaMovido;

    Tablero tablero = new Tablero();
    
    public Torre(TColor color, int x, int y) {
        super(Ttipo.Torre, color, x, y);
        seHaMovido = false;
    }

    @Override
    public void mover(int x, int y) {
        // Implementación del movimiento de la torre
        if (validarMovimiento(x, y)) {
            setX(x);
            setY(y);
            seHaMovido = true;
        } else {
            System.out.println("Movimiento inválido para la torre.");
        }
    }

    @Override
    public boolean validarMovimiento(int x, int y) {
        int diffX = Math.abs(x - getX());
        int diffY = Math.abs(y - getY());

        // Movimiento horizontal o vertical
        if ((diffX != 0 && diffY == 0) || (diffY != 0 && diffX == 0)) {
            // Verificar si no hay ninguna pieza bloqueando el camino en la fila o columna
            int pasoX = (x - getX()) / (diffX == 0 ? 1 : diffX);
            int pasoY = (y - getY()) / (diffY == 0 ? 1 : diffY);

            int casillaX = getX() + pasoX;
            int casillaY = getY() + pasoY;

            while (casillaX != x || casillaY != y) {
                if (tablero.obtenerPiezaEnPosicion(casillaX, casillaY) != null) {
                    return false; // Hay una pieza bloqueando el camino
                }
                casillaX += pasoX;
                casillaY += pasoY;
            }

            return true; // Movimiento horizontal o vertical válido
        }

        return false; // Movimiento inválido para la torre
    }

    @Override
    public boolean isCaptura(int posX, int posY, Tablero tablero) {
        Pieza piezaEnPosicion = tablero.obtenerPieza(posY, posY); // Método para obtener la pieza en la posición indicada

        if (piezaEnPosicion != null) {
            return validarMovimiento(posX, posY) && (getColor() != piezaEnPosicion.getColor());
        }
        return false;
    }
    
    public boolean haMovido(){
        return seHaMovido;
    }
}

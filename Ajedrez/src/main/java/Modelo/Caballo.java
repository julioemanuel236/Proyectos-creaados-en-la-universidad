
package Modelo;

public class Caballo extends Pieza {

    Tablero tablero = new Tablero();
    
    public Caballo(TColor color, int x, int y) {
        super(Ttipo.Caballo, color, x, y);
    }

    @Override
    public void mover(int x, int y) {
        // Implementación del movimiento del caballo
        if (validarMovimiento(x, y)) {
            setX(x);
            setY(y);
        } else {
            System.out.println("Movimiento inválido para el caballo.");
        }
    }

    @Override
    public boolean validarMovimiento(int xDestino, int yDestino) {
        int xActual = this.getX();
        int yActual = this.getY();

        int deltaX = Math.abs(xDestino - xActual);
        int deltaY = Math.abs(yDestino - yActual);

        return (deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1);
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

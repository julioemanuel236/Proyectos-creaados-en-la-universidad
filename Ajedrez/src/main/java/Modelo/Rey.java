package Modelo;

public class Rey extends Pieza {
    String jugador1 = "";
    String jugador2 = "";
    boolean seHaMovido;
    
    
    Tablero tablero = new Tablero();
    Control.Controlador control = new Control.Controlador(jugador1,jugador2);
    
    public Rey(TColor color, int x, int y) {
        super(Ttipo.Rey, color, x, y);
        seHaMovido = false;
    }

    @Override
    public void mover(int x, int y) {
        // Implementación del movimiento del rey
        if (validarMovimiento(x, y)) {
            setX(x);
            setY(y);
            seHaMovido = true;
        } else {
            System.out.println("Movimiento inválido para el rey.");
        }
    }

    @Override
    public boolean validarMovimiento(int x, int y) {
        int diffX = Math.abs(x - getX());
        int diffY = Math.abs(y - getY());

        // Movimiento en cualquier dirección pero una casilla a la vez
        if ((diffX <= 1 && diffY <= 1) && (diffX + diffY > 0) || (diffX == 2 && diffY == 0)) {
            // Verificar si la posición final está bajo amenaza (jaque)
            if (control.jaque( getColor())) {
                return false; // No se puede mover a una posición en jaque
            }

            // Verificar si se está intentando hacer enroque
            if (diffX == 2 && diffY == 0 && !haMovido()) {
                // Si se mueve dos espacios a la derecha o a la izquierda, es un enroque
                if (x > getX()) {
                    // Enroque corto
                    Pieza torre = tablero.obtenerPiezaEnPosicion(7, getY());
                    if (torre != null && torre instanceof Torre && !torre.haMovido() && !hayPiezasEntreReyYTorre(torre)) {
                        // No hay piezas entre el rey y la torre y ninguna de las dos ha movido antes
                        return true;
                    }
                } else if (x < getX()) {
                    // Enroque largo
                    Pieza torre = tablero.obtenerPiezaEnPosicion(0, getY());
                    if (torre != null && torre instanceof Torre && !torre.haMovido() && !hayPiezasEntreReyYTorre(torre)) {
                        // No hay piezas entre el rey y la torre y ninguna de las dos ha movido antes
                        return true;
                    }
                }
            }

            // Si no se está intentando hacer enroque, simplemente mover una casilla a cualquier dirección
            return true;
        }

        return false;
    }

    private boolean hayPiezasEntreReyYTorre(Pieza torre) {
        // Verificar si hay piezas entre el rey y la torre en el caso de un enroque
        int posXRey = getX();
        int posXTorre = torre.getX();

        int minY = Math.min(posXRey, posXTorre);
        int maxY = Math.max(posXRey, posXTorre);

        for (int i = minY + 1; i < maxY; i++) {
            Pieza pieza = tablero.obtenerPiezaEnPosicion(i, getY());
            if (pieza != null) {
                return true;
            }
        }

        return false;
    }

    // En la clase Rey
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

package Modelo;

public abstract class Pieza {
    private Ttipo tipo;
    private TColor color;
    private int x;
    private int y;
    private boolean seHaMovido;

    public Pieza(Ttipo tipo, TColor color, int x, int y) {
        this.tipo = tipo;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public abstract void mover(int x, int y);

    public abstract boolean validarMovimiento(int x, int y);

    public abstract boolean isCaptura(int posX, int posY, Tablero tablero);

    // Getters y setters para obtener y establecer la posición de la pieza
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Otros getters para obtener información sobre la pieza
    public Ttipo getTipo() {
        return tipo;
    }

    public TColor getColor() {
        return color;
    }
    
    public boolean haMovido() {
        return seHaMovido;
    }

    public void setTipo(Ttipo tipo) {
        this.tipo = tipo;
    }
    
}

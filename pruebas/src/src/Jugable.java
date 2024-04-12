public class Jugable extends PersonajeGenerico{
    public Jugable(int vida, int movimiento, int daño, int porcentajeAcierto, String nombre, String color, int costo, boolean vuela) {
        super(vida, movimiento, daño, porcentajeAcierto, nombre, color, costo, vuela);
    }

    public int getVidaMaxima() {
        return super.getVida();
    }

    public char getInicial() {
        return super.getInicial();
    }

    public void setPosX(int x) {
        super.setPosX(x);
    }

    public void setPosY(int y) {
        super.setPosY(y);
    }

    public int getPosX() {
        return super.getPosX();
    }

    public int getPosY() {
        return super.getPosY();
    }

    public int[] getPosicion() {
        int[] posicion = {getPosX(), getPosY()};
        return posicion;
    }

    public char getLetra() {
        return (super.getNombre().charAt(0));
    }

    public int getAtaque() {
        return super.getDaño();
    }
}
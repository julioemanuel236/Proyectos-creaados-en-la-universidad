public class Enemigo extends PersonajeGenerico{
    public Enemigo(int vida, int movimiento, int daño, int porcentajeAcierto, String nombre, String color, int costo, boolean vuela) {
        super(vida, movimiento, daño, porcentajeAcierto, nombre, color, costo, vuela);
    }

    public int[] getPosicion() {
        int[] posicion = {getPosX(), getPosY()};
        return posicion;
    }

    public char getLetra() {
        return (super.getNombre().charAt(0));
    }
}


public class CapaDeMovilidad extends Objetos {
    public CapaDeMovilidad() {
        super(75, "capa de movilidad");
    }

    public void usar(Jugable jugable){
        jugable.setMovimiento(jugable.getMovimiento() + 1);
    }
}
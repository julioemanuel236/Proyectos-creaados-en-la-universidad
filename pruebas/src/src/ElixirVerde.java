public class ElixirVerde extends Objetos {
    public ElixirVerde() {
        super(25, "elixir verde");
    }

    public void usar(Jugable jugable){
        jugable.setVida(jugable.getVida() + 50);
    }
}
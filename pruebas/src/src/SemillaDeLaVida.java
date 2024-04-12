public class SemillaDeLaVida extends Objetos {
    public SemillaDeLaVida() {
        super(50, "semilla de la vida");
    }
    public void usar(Jugable jugable){
        jugable.setVida(jugable.getVidaMaxima());
    }
}
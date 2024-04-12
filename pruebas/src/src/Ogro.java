public class Ogro extends Enemigo {
    public Ogro() {
        super(300, 1, 50, 60, "Ogro", "\u001B[31m", 0,false);
        this.setTipoAtaque("cuadro");
    }
}
package game;

public class CapaMovilidad extends Item {

	public CapaMovilidad() {
		super("Capa de Movilidad",75);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void usar(Heroe e) {
		e.maxMov++;
		App.print("Movimento maximo del heroe aumentado");
	}

}
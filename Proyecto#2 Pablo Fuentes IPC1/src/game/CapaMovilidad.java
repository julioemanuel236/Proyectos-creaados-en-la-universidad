package game;
import unidades.Heroe;

public class CapaMovilidad extends Item {

	public CapaMovilidad() {
		super("Capa de Movilidad",75,"Te permite moverte una casilla");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void usar(Heroe e) {
		e.maxMov++;
		App.print("Movimento maximo del heroe aumentado");
	}

}

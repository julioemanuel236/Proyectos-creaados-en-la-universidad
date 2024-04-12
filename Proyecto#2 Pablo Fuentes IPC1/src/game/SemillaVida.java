package game;
import unidades.Heroe;

public class SemillaVida extends Item {

	public SemillaVida() {
		super("Semilla de la Vida",50,"Resucita a un Heroe caido en batalla");
		
	}

	@Override
	public void usar(Heroe e) {
		if(e.vida<=0) {
			e.vida=e.vidaMaxima;
			System.out.println("Se ha revivido al heroe");
		}
		
		else System.out.println("No ha tenido ningun efecto");
	}

}

package objetos;

import juego.Tablero;

public class Torpedo extends Bomba{

	public Torpedo(int x, int y,Tablero t) {
		super(x, y,t);
		DIR = new int[] {1,3,5,7};
	}

}

package objetos;

import juego.Tablero;

public class Misil extends Bomba {
	
	public Misil(int x, int y,Tablero t) {
		super(x, y,t);
		DIR = new int[]{0,2,4,6};
	}

}

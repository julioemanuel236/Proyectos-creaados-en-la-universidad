package objetos;

import java.awt.Graphics2D;

import juego.Tablero;

public class Objeto {
	int x;
	int y;
	public Tablero t;
	public boolean activado;
	
	public Objeto(int x,int y,Tablero t) {
		this.x=x;
		this.y=y;
		this.t=t;
		activado = false;
	}
	
	public int activar() {
		activado=true;
		t.pintar(x,y,(Graphics2D)t.getGraphics());
		return 0;
	}
	
}

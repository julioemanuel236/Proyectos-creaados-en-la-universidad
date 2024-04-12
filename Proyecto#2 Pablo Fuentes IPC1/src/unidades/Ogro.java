package unidades;

import game.*;
public class Ogro extends Enemigo {

	public Ogro() {
		super(300, 50, 1, false, 'O',25);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean atacar() {
		Tablero tablero = App.player.tablero;
		for (int i = 0; i < 8; i++) {
			int x = getX() + dx[i];
			int y = getY() + dy[i];
			if (x < 0 || x >= tablero.width || y < 0 || y >= tablero.height)
				continue;
			if (tablero.map[y][x] instanceof Heroe) {
				this.hit((Entity) tablero.map[y][x]);
				return true;
			}
		}
			return false;	
	}

}

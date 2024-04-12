package unidades;

import game.*;

public class Gargola extends Enemigo {

	public Gargola() {
		super(150, 100, 3, true,'G',45);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean atacar() {
		Tablero tablero = App.player.tablero;
		int arr[]= {0,2,4,6};
		
		for(int i=1;i<4;i++) {
			for(int j=1;j<3;j++) {
					
				int ax=getX()+(dx[arr[i]]*j);
				int ay=getY()+(dy[arr[i]]*j);
				if(ax<0||ay<0||ax>=tablero.width||ay>=tablero.height)continue;
				if(tablero.map[ay][ax] instanceof Heroe) {
					this.hit((Entity)tablero.map[ay][ax]);
					return true;
				}
			}
		}
		return false;
	}


}

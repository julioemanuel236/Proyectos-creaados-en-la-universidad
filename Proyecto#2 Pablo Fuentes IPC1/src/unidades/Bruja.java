package unidades;

import game.*;
public class Bruja extends Enemigo {

	public Bruja() {
		super(150, 45, 3, true,'B',100);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean atacar() {
		Tablero tablero = App.player.tablero;
		int dir=0;
		int arr[]= {0,2,4,6};

		boolean find=false;
		for(int i=1;i<4;i++) {
			for(int j=1;j<3;j++) {
					
				int ax=getX()+(dx[arr[i]]*j);
				int ay=getY()+(dy[arr[i]]*j);
				if(ax<0||ay<0||ax>=tablero.width||ay>=tablero.height)continue;
				if(tablero.map[ay][ax] instanceof Heroe) {
					dir=arr[i];
					break;
				}
			}
			if(find)break;
		}
		if(!find)return false;
		
		for(int i=0;i<3;i++) {
			int x=getX()+(dx[dir]*i);
			int y=getX()+(dx[dir]*i);
			if(x<0||x>=tablero.width||y<0||y>=tablero.height)continue;
			if(tablero.map[y][x] instanceof Entity) {
				hit((Entity)tablero.map[y][x]);
				break;
			}
		}
		return true;
	}



}

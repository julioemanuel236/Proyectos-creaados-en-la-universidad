package game;

import java.util.Scanner;

public class FlorCarnivora extends Enemigo {

	public FlorCarnivora() {
		super(250, 30, 0, false,'F');
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean atacar() {
		Tablero tablero = App.tablero;
		
		boolean find=false;
		int arr[]= {0,2,4,6};
		for(int i=0;i<4;i++) {
			for(int j=1;j<=3;j++) {
				int ax=x+(dx[arr[i]]*j);
				int ay=y+(dy[arr[i]]*j);
				if(ax<0||ay<0||ax>=tablero.width||ay>=tablero.height)continue;
				if(tablero.map[ay][ax] instanceof Heroe) {
					find=true;
					break;
				}
			}
			if(find)break;
		}
		if(!find)return false;
		for(int j=0;j<4;j++) {
			int dir=arr[j];
			for(int i=1;i<4;i++) {
				int ax=getX()+(dx[dir]*i);
				int ay=getY()+(dy[dir]*i);
				if(ax<0||ay<0||ax>=tablero.width||ay>=tablero.height)continue;
				if(tablero.map[ay][ax] instanceof Entity) {
					if(i==1) {
						((Entity)tablero.map[ay][ax]).vida=0;
						((Entity)tablero.map[ay][ax]).die();
					}
					else this.hit((Entity)tablero.map[ay][ax]);
				}
			}
		}
		return true;
	}


}
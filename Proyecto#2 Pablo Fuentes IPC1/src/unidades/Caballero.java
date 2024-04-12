package unidades;

import game.*;

public class Caballero extends Heroe {

	public Caballero(String nombre) {
		super(nombre,300,45,1,false,'c');
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean atacar() {		
		Tablero tablero = App.player.tablero;
		for(int i=0;i<8;i++) {
			int x=getX()+dx[i];
			int y=getY()+dy[i];
			if(x<0||x>=tablero.width||y<0||y>=tablero.height)continue;
			//System.out.println(x+" "+y);
			if(tablero.map[y][x] instanceof Entity) {				
				hit((Entity)tablero.map[y][x]);				
			}
		}
		
		return true;
	}
	
	public String inf() {
		return "Caballero "+super.info();
	}
	
	@Override
	public String shopping() {
		return "Caballero: "+super.shopping();
	}
	
}
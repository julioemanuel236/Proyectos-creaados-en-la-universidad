package game;

public class Cancerbero extends Enemigo {

	public Cancerbero() {
		super(400, 45, 1,false,'C');
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean atacar() {
		Tablero tablero = App.tablero;
		boolean find=false;
		
		for(int i=0;i<8;i++) {
			int x=getX()+dx[i];
			int y=getY()+dy[i];
			if(x<0||x>=tablero.width||y<0||y>=tablero.height)continue;
			if(tablero.map[y][x] instanceof Heroe) {
				find = true;
				break;
			}
		}
			
		
		if(!find)return false;
		for(int i=0;i<8;i++) {
			int x=getX()+dx[i];
			int y=getY()+dy[i];
			if(x<0||x>=tablero.width||y<0||y>=tablero.height)continue;
			if(tablero.map[y][x] instanceof Entity) {
				this.hit((Entity)tablero.map[y][x]);
			}
		}
		return true;
		
	}


}

package game.battleship;

public class Sea extends Entity {

	
	
	public Sea(int x, int y,int w,int h) {
		super(x, y, "/images/Sea.png",w,h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean action() {	
		return false;
	}

}

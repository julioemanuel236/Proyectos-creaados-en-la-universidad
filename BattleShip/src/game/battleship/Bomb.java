package game.battleship;

public  class Bomb extends Entity {
    final int dx[]= {1,1,0,-1,-1,-1,0,1};
    final int dy[]= {0,1,1,1,0,-1,-1,-1};
    
    public Bomb(int x,int y,int w,int h) {
        super(x, y,"/images/Bomb.png",w,h);
    }

	@Override
	public boolean action() {
		App.board.board[y][x].discover();
		return false;
	}

    
}

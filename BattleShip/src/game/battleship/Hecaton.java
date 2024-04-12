package game.battleship;

public class Hecaton extends Bomb {

    public Hecaton(int x,int y,int w,int h){
        super(x,y,w,h);
    }

    @Override
    public boolean action() {
    	App.board.board[y][x].discover();
    	for(int i=0;i<dx.length;i++) {
    		int x=this.x+dx[i];
    		int y=this.y+dy[i];
    		if(isValid(x,y))
    			App.board.board[y][x].discover();
    	}
    	return true;
    }
    
}

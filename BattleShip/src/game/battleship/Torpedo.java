package game.battleship;

import java.util.Random;

public class Torpedo extends Bomb{
	int pos[] = {1,3,5,7};
    
    public Torpedo(int x,int y,int w,int h){
        super(x,y,w,h);
    }

    @Override
    public boolean action() {
    	int attack = pos[(new Random()).nextInt(4)];
    	int x=this.x;
    	int y=this.y;
    	int c=0;
    	do {
    		x+=dx[attack];
    		y+=dy[attack];
    		if(!isValid(x,y)&&c==0)action();
    		c++;
    	}while(isValid(x,y)&&!App.board.board[y][x].discover());;
        return true;
    }
    
    
}

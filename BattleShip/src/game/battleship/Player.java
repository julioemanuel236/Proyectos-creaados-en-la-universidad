
package game.battleship;

public class Player {
    
    public String name;
    public int pts;
    int bombs[];
    int dif;
    public Player(String name,int difficulty){
        this.name=name;
        this.dif=difficulty;
        pts=0;
        makeInventary(difficulty);
    }
    
    public void makeInventary(int dif){
    	bombs = new int[4];
        if(dif==0) {
        	bombs[0] = 10;
        	bombs[1]=bombs[2]=bombs[3]=4;
        }
        else if(dif==1) {
        	bombs[0] = 9;
        	bombs[1]=bombs[2]=bombs[3]=3;
        }
        else {
        	bombs[0] = 5;
        	bombs[1]=bombs[2]=bombs[3]=2;
        }
    }
    
}

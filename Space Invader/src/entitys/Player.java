package entitys;
import sprites.PlayerSprite;

public class Player extends Entity{

	
	private int life;
	
	
	public Player() {
		life = 3;
		setSprite(new PlayerSprite());
	}

	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	
}

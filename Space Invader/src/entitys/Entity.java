package entitys;

import sprites.Sprite;

public class Entity {
	private int x;
	private int y;
	
	private int toX;
	private int toY;
	
	private Sprite sprite;
	
	public void updatePos() {
		
	}
	
	public void UpdateUI() {
		sprite.setLocation(getX(),getY());
	}
		
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
		
	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

}

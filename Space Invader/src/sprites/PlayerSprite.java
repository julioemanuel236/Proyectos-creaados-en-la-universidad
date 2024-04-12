package sprites;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class PlayerSprite extends Sprite{
	
	
	public PlayerSprite() {
		setFocusable(true);
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillOval(0, 0, WIDTH, HEIGHT);
	}
}

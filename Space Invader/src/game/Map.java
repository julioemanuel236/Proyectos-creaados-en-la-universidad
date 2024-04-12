package game;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.LinkedList;
import entitys.*;


public class Map extends Component{
	
	LinkedList<Entity> entitys = new LinkedList<>();
	
	
	
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		super.paint(g);
	}
}

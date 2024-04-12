import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class graphics extends JPanel{
	JFrame root=new JFrame();
	public graphics() {
		root.setSize(500,500);
		setSize(500,500);
		setBackground(Color.white);
		setLayout(null);
		root.setVisible(true);
		root.setDefaultCloseOperation(root.EXIT_ON_CLOSE);
		root.add(this);
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2=(Graphics2D) g;
		g2.setColor(Color.blue);
		g2.drawOval(0,0,50,50);
		g2.drawOval(50,50,50,50);
	}
	
	public static void main(String[] args) {
		new graphics();
	}
	
}

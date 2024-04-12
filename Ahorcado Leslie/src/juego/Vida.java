package juego;
import java.awt.Image;

import javax.swing.*;

public class Vida extends JPanel{
	
	JLabel vidas[] = new JLabel[6];
	ImageIcon img0 = new ImageIcon(new ImageIcon(getClass().getResource("/vida.png")).getImage().getScaledInstance(85, 85,Image.SCALE_SMOOTH));
	ImageIcon img1 = new ImageIcon(new ImageIcon(getClass().getResource("/novida.png")).getImage().getScaledInstance(85, 85,Image.SCALE_SMOOTH));
	int hurt=5;
	
	public Vida() {
		for(int i=0;i<6;i++) {
			JLabel jl = new JLabel();
			jl.setIcon(img0);
			jl.setSize(85,85);
			jl.setLocation((i*85)+(i*5),5);
			add(jl);
			setSize(jl.getX()+jl.getWidth()+5,95);
			vidas[i]=jl;
		}
	}
	
	public void Hit() {
		vidas[hurt].setIcon(img1);
		vidas[hurt].repaint();
		hurt--;
	}
	
}

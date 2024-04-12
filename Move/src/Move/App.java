package Move;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;

public class App extends JFrame{
	JLabel[] labels=new JLabel[31];
	
	public App() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		for(int i=0;i<31;i++) {
			labels[i]=new JLabel();
			labels[i].setOpaque(true);
			labels[i].setBackground(Color.black);
			labels[i].setLocation(20*i,0);
			labels[i].setSize(20,20);
			this.add(labels[i]);
		}
		this.setSize(new Dimension(500,500));
		this.setLocationRelativeTo(null);

		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		App root=new App();
		for(int i=0;i<31;i++)
		Move.mover(root.labels[i], 0, 400, 2, 2, 1);
		
	}
}

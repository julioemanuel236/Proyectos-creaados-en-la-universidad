package game.battleship;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Panel extends JPanel {

	JButton home;
	App app;
	public Panel(int w,int h,App app) {
		super();
		this.app=app;
		setLayout(null);
		setSize(w,h);
		home = new JButton();
		home.setIcon((new ImageIcon(new ImageIcon(getClass().getResource("/images/Home.png")).getImage().
                getScaledInstance(w/10, h/10, Image.SCALE_SMOOTH))));
		home.setSize(w/10,h/10);
		home.setContentAreaFilled(false);
		add(home);
		home.addActionListener((ActionEvent)->{
			//if(App.visible==)
			if(Panel.this instanceof GamePanel) {
				int op = JOptionPane.showConfirmDialog(home, "Se perderá todo el avance");
				if(op!=0)return;
			}			
			app.switchPanel(app.menu);
		});
		home.setBorder(null);

		home.setFocusable(false);
	}
}

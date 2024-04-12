package game.battleship;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class CollectionPanel extends Panel {
	ScrollPanel sp;
	
	public CollectionPanel(int w, int h, App app) {
		super(w, h, app);
		ini();
	}
	
	public void addBoard(Board b) {
		JLabel j = new JLabel(b.id);
		j.setSize(getWidth(),40);
		j.setOpaque(true);
		j.setBackground(Color.white);
		j.setForeground(Color.black);
		j.setFont(new Font("Arial",Font.BOLD,20));
		j.setHorizontalAlignment(JLabel.CENTER);
		sp.add_item(j,(sp.back.countComponents()>0?10:0));
		sp.add_item(b, 0);
	}
	
	public void ini() {
		JButton plus = new JButton();
		plus.setSize(home.getWidth()+15,home.getHeight()+15);
		plus.setLocation(-5,home.getHeight());
		plus.setBorder(null);
		ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getResource("/images/Plus.png")).getImage().getScaledInstance(plus.getWidth(), plus.getHeight(), Image.SCALE_SMOOTH));
		plus.setContentAreaFilled(false);
		plus.setIcon(icon);
		plus.addActionListener((ActionEvent)->{
			App.app.cargarMapas();
		});
		add(plus);
		sp = new ScrollPanel(getWidth(),getHeight());		
		sp.border.show("all",false);
		sp.back.setBackground(Color.BLACK);		
		sp.vsb.active=Color.BLUE;
		sp.hsb.setVisible(false);				
		sp.setLocation((getWidth()/2)-(sp.getWidth()/2),(getHeight())-(sp.getHeight()));
		sp.back.setSize(getWidth(),0);
		add(sp);
		System.out.println(App.boards.keySet().size());
	}

}

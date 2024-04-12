package game.battleship;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import game.battleship.MainPanel.Button;

public class MapPanel extends Panel {
	ScrollPanel sp;
	
	public MapPanel(int w, int h,App app) {		
		super(w, h,app);
		
		setSize(w,h);		
		ini();
		background(w,h);
	}

	
	private void background(int w,int h) {
		
		JLabel background = new JLabel();
		background.setIcon((new ImageIcon(new ImageIcon(getClass().getResource("/images/Background.png")).getImage().
                getScaledInstance(w, h, Image.SCALE_SMOOTH))));
		background.setSize(w,h);
		add(background);		
	}

	public void ini() {
		sp = new ScrollPanel(getWidth()/2,4*getHeight()/6);		
		sp.border.show("all",false);
		sp.back.setBackground(Color.LIGHT_GRAY);
		sp.vsb.active=Color.BLUE;
		sp.hsb.setVisible(false);				
		sp.setLocation((getWidth()/2)-(sp.getWidth()/2),(getHeight())-(sp.getHeight()));
		add(sp);
		System.out.println(App.boards.keySet().size());
	}
	
	public void reload() {
		sp.back.removeAll();
		sp.back.setSize(sp.back.getWidth(),0);
		ArrayList<Board> elegir = new ArrayList<>();
		ActionListener al = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				App.board = elegir.get(Integer.parseInt(((Button)e.getSource()).value));
				app.switchPanel(new GamePanel(getWidth(),getHeight(),app));
			}
			
		};
		int k=0;
		for(String i:App.boards.keySet()) {
			String arr[]=App.boards.get(i);
			final Board b = new Board(i,arr[1],arr[2],500,450);
			
			System.out.println(i);
			if(b.getDifficulty()==App.player.dif) {				
				elegir.add(b);
				Button bt = new Button(b.id+" "+b.lenX+"X"+b.lenY,""+k);
				bt.setSize(3*sp.getWidth()/4,60);
				bt.setFocusable(false);
				bt.addActionListener(al);
				sp.add_item(bt, 0);
				k++;
			}
		}
		
		JLabel background = new JLabel();
		background.setIcon((new ImageIcon(new ImageIcon(getClass().getResource("/images/Background.png")).getImage().
                getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH))));
		background.setSize(getWidth(), getHeight());
		background.setLocation(-sp.getX(),-sp.getY());
		sp.back.add(background);
	}
	
}

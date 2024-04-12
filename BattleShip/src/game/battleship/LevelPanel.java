package game.battleship;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game.battleship.MainPanel.Button;

public class LevelPanel extends Panel{

	
	public LevelPanel(int width,int height,App app){
		super(width,height,app);
		setLayout(null);
		setSize(width,height);
		buttons();	
		background(width,height);
	}
	
	private void buttons() {
		Button principiante = new Button("Principiante","0");
		principiante.setSize(getWidth()/2,60);
		principiante.setLocation(getWidth()/4,2*getHeight()/7);
		add(principiante);
		
		Button intermedio = new Button("Intermedio","1");
		intermedio.setSize(getWidth()/2,60);
		intermedio.setLocation(getWidth()/4,4*getHeight()/7);
		add(intermedio);
		
		Button titanico = new Button("Titanico","2");
		titanico.setSize(getWidth()/2,60);
		titanico.setLocation(getWidth()/4,6*getHeight()/7);
		add(titanico);
		
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = JOptionPane.showInputDialog("Como te llamas");
				if(nombre==null)return;
				String nnombre="";
				for(int i=0;i<nombre.length();i++)
					if(nombre.charAt(i)==' ')nnombre+='_';
					else nnombre+=nombre.charAt(i);
				nombre=nnombre;
				App.player = new Player(nombre,Integer.parseInt(((Button)e.getSource()).value));
				App.mapaPanel.reload();
				app.switchPanel(app.mapaPanel);
			}
			
		};
		
		principiante.addActionListener(al);
		intermedio.addActionListener(al);
		titanico.addActionListener(al);
	}
	
	private void background(int w,int h) {
		
		JLabel background = new JLabel();
		background.setIcon((new ImageIcon(new ImageIcon(getClass().getResource("/images/Background.png")).getImage().
                getScaledInstance(w, h, Image.SCALE_SMOOTH))));
		background.setSize(w,h);
		add(background);		
	}

}

package game;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.*;
import java.util.Random;

public class Pelota extends JComponent{
		
	private int radius = 100;
	private Random rand = new Random();
	int xdir = 1,ydir = 1;
	private Container parent;
	
	AudioClip sound;
	public Pelota(int x,int y,Container parent) {
		this.setLocation(x,y);
		this.setSize(radius,radius);
		this.parent = parent;
		this.parent.add(this);
		this.sound = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/coin2.wav"));
	}
	boolean choco = false;
	private void animate(){
		long delay = 5;
		
		try {
			while(true) {
				move();
				Thread.sleep(delay);				
				if(choco) {
					delay--;
					choco = false;
				}
				if(delay<1)delay = 1;
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void move() {
		int x = this.getX(),y=this.getY();
		if(x == 0 || x+radius == parent.getWidth()) {
			xdir*=-1;
			AudioClip ac = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/coin2.wav"));
			ac.loop();
			choco = true;
		}
		if(y == 0 || y+radius == parent.getHeight()) {
			ydir*=-1;
			AudioClip ac = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/coin2.wav"));
			ac.loop();
			choco = true;
		}
		
		x+=xdir;
		y+=ydir;
		
		setLocation(x,y);
		System.out.println(x+" "+y+" "+radius);
		parent.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		
		g.setColor(Color.red);
		g.fillOval(0, 0, radius, radius);		
	}


	
	public int getRadius() {
		return this.radius;
	}

	public void setRadius(int size) {
		this.radius = size;
	}
	

	public static void main(String args[]) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.blue);
		panel.setLayout(null);
		frame.setSize(500,500);
		panel.setSize(frame.getSize());		
		frame.setUndecorated(true);
		frame.setLayout(null);
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Pelota p = new Pelota(1,1,panel);
		p.animate();
	}
}

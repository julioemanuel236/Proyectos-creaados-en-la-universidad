package mainwindow;

import java.awt.Graphics;
import java.awt.Image;

public class RadioButton extends Button{

	public RadioButton() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RadioButton(Image img) {
		super(img);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean mouseEntry(int x,int y) {
		x-=getAbsoluteX();
		y-=getAbsoluteY();
		
		int radio = Math.min(getWidth(),getHeight())/2;
		
		int mx = (getWidth()/2);
		int my = (getHeight()/2);
		
		int dx = Math.abs(x-mx);
		int dy = Math.abs(y-my);
		
		int distancia = (int)Math.sqrt((dx*dx)+(dy*dy));
		
		//System.out.println(mx+"/"+my + ": "+x+"/"+y);
		//System.out.println(distancia +  " " + radio + " " + getClass().getSimpleName());
		
		if(distancia <= radio && !isMouseIn()) {
			//System.out.println("ENTRANDO A"+getClass().getSimpleName());
			setMouseIn(true);
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean mouseLeave(int x,int y) {
		x-=getAbsoluteX();
		y-=getAbsoluteY();
		int radio = Math.min(getWidth(),getHeight())/2;
		
		int mx = (getWidth()/2);
		int my = (getHeight()/2);
		
		int dx = Math.abs(x-mx);
		int dy = Math.abs(y-my);
		int distancia = (int)Math.sqrt((dx*dx)+(dy*dy));
		
		if(distancia > radio && isMouseIn()) {
			//System.out.println("SALIENDO DE"+getClass().getSimpleName());
			setMouseIn(false);
			return true;
		}
		
		return false;
	}
	/*
	@Override
	public void paint(Graphics g) {
		//g.fillRect(0, 0, getWidth(), getHeight());
		
		super.paint(g);
		
		//g.fillOval((getWidth()/2)-10, (getHeight()/2)-10, 20, 20);
	}*/
}

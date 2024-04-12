package arbolbusquedabinario;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.*;
public class AlgoMio extends JFrame{

	private class Line{
		int x0,y0,x1,y1;
		
		public Line(int a,int b,int c,int d) {
			x0 = a;
			y0 = b;
			x1 = c;
			y1 = d;
		}
		
		public void paintOn(Graphics g) {
			g.drawLine(x0, y0, x1, y1);
		}
	}
		
	public AlgoMio() {
		setSize(500,500);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		(new Thread() {
			public void run() {
				Scanner entry = new Scanner(System.in);
				
				while(true) {
					int x = getWidth()/2;
					int y = getHeight()/2;
					int a,b,c,d;
					a = entry.nextInt()*2;
					b = entry.nextInt()*2;
					c = entry.nextInt()*2;
					d = entry.nextInt()*2;
					new Line(a+x,b+y,c+x,d+y).paintOn(getGraphics());
				}
			}
		}).start();
	}
	
	public static void main(String[] args) {
		new AlgoMio();
	}
}

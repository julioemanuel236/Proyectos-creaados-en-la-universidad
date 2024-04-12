package Game;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;
import java.lang.System;
import java.awt.Point;
import java.util.Random;
public class Snake{
	
	private Random rand = new Random();
	
	public class Body extends JLabel{
		
		int X;
		int Y;
		int Dir;
		boolean cola;
		int tipe;
		private static Random rand = new Random();
		public Body(int x,int y,int dir,Field f,int width,int height) {	
			this.X=x;
			this.Y=y;
			this.Dir=dir;
			this.setSize(width,height);
			this.ini(f);
			this.tipe = 1+rand.nextInt(3);
		}
		
		public Body(Field f) {
			this.ini(f);
		}
		
		private void ini(Field f) {
			//this.setSize(20,20);
			this.setLayout(null);
			this.setOpaque(true);
			int r = rand.nextInt(255);
			int g = rand.nextInt(255);
			int b = rand.nextInt(255);
			this.setBackground(new Color(r,g,b));
			f.add(this);
		}
		
		public void poner(int x,int y,int dir,int n,int m) {
			
			//System.out.println(x+" "+y);
			this.X=x;
			this.Y=y;
			this.Dir=dir;
			this.setLocation(X, Y);
		}

		public void agrandar(int a,int b) {			
			(new Thread() {
				public void run() {
					int x = X;
					int y = Y;
					int w=Body.this.getWidth()+1;
					int h=Body.this.getHeight()+1;
					
					for(;w<=a||h<=b;w++,h++) {						
						Body.this.setSize(w,h);
						setLocation(X+((a-w)/2),Y+((b-h)/2));
						try {
							this.sleep(10);
						}
						catch(Exception e) {
							
						}
					Body.this.updateUI();
					}
				}
			}).start();
		}
	
		
		@Override
		public void paint(Graphics g) {
			g.setColor(getBackground());
			if(tipe == 1) {
				
				if(Dir == 1) {
					int x[] = {getWidth()/2,0,getWidth()};
					int y[] = {getHeight(),0,0};
					g.fillPolygon(x,y,3);					
				}
				else if(Dir == 2) {
					int x[] = {getWidth(),0,getWidth()};
					int y[] = {0,getHeight()/2,getHeight()};
					g.fillPolygon(x,y,3);
				}
				else if(Dir == 3) {
					int x[] = {getWidth()/2,0,getWidth()};
					int y[] = {0,getHeight(),getHeight()};
					g.fillPolygon(x,y,3);

				}
				else if(Dir == 4) {
					int x[] = {0,getWidth(),0};
					int y[] = {0,getHeight()/2,getHeight()};
					g.fillPolygon(x,y,3);
					
				}
				
			}
			else if(tipe == 2){
				g.fillOval(0, 0, getWidth(), getHeight());
				//super.paint(g);
			}
			else super.paint(g);
		}
		
		public void makeTail() {
			cola = true;
		}
		
		public void makeBody() {
			cola = false;
		}
	}

	Body[] Snake = new Body[1000];
	int new_body=1;
	int cabeza=0;
	int cola=0;
	int size=1;
	int dx;
	int dy;
	int nextDir=3;
	public Snake(Field f) {
		Snake[0]=new Body(100,100,3,f,20,20);
		Snake[0].poner(100, 0,3,f.getWidth()/20,f.getHeight()/20);
	}
	
	public void crecer(Field f,App app){
		app.setTitle("THE SNAKE GAME By NOBODY: "+(size)+" PTS");
		Snake[size-1].makeBody();
		int x=Snake[size-1].X;
		int y=Snake[size-1].Y;
		int dir=Snake[size-1].Dir;
		if(dir==1)y+=20;
		else if(dir==2)x-=20;
		else if(dir==3)y-=20;
		else if(dir==4)x+=20;
		Snake[size] = new Body(x,y,dir,f,1,1);
		Snake[size].makeTail();
		f.setLayer(Snake[size], 1);
		f.add(Snake[size]);
		
		Snake[size++].agrandar(20,20);
		//Snake[size++].updateUI();
		
	}
	
	public void morir() {
		(new Thread() {
			public void run() {
				for(Body i:Snake) {		
					try {
						this.sleep(10);
						i.setBackground(Color.blue);
					}
					catch(Exception e) {
						return;
					}
				}
			}
		}
				).start();		
	}		
} 
package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class App extends JFrame{

	Field field;
	
	Car[] cars = new Car[21];
	
	Player_Car player = new Player_Car(new Color(142,80,226));
	
	Queue<Boolean> q = new LinkedList<Boolean>();
	
	int[] sendas = {10,130,250,370,490};

	private class Field extends JLayeredPane{
		
		public JLabel[] divs=new JLabel[16];
		
		public Field(App a) {
			this.setSize(a.getWidth(),a.getHeight());
			this.setLayout(null);
			this.setOpaque(true);
			this.setBackground(Color.DARK_GRAY);
			for(int i=0,j=100,k=-300;i<16;i++,j+=120) {
				if(i%4==0&&i>0) {k+=300;j=100;}
				Crear_Divisores(i,j,k,20,250);
			}
			a.add(this);
		}
		
		private void Crear_Divisores(int i,int x,int y,int w,int h) {
			divs[i]=new JLabel();
			divs[i].setLayout(null);
			divs[i].setOpaque(true);
			divs[i].setBackground(Color.white);
			divs[i].setSize(w,h);
			divs[i].setLocation(x,y);		
			this.setLayer(divs[i],0);
			this.add(divs[i]);
			
		}
		
	}
	
	private class Car extends JLabel{
		
		public Car(Color color) {
			this.setSize(80,120);
			this.setOpaque(true);
			this.setBackground(color);
		}
		
		public Car() {
			this.setSize(80,120);
			this.setOpaque(true);
		}
	
	}
	
	private class Player_Car extends Car{
		
		boolean moving=false;
		boolean movingup=false;
		boolean movingdown=false;
		int dir=0;
		int x_inicial,x_final;
		
		public Player_Car(Color color){
			this.setBackground(color);
			KeyListener k=new KeyListener() {

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getExtendedKeyCode()==e.VK_LEFT)App.this.q.add(false);
					else if(e.getExtendedKeyCode()==e.VK_RIGHT)App.this.q.add(true);
					if(e.getExtendedKeyCode()==e.VK_A)App.this.q.add(false);
					else if(e.getExtendedKeyCode()==e.VK_D)App.this.q.add(true);
					else if(e.getExtendedKeyCode()==e.VK_UP)movingup=true;
					else if(e.getExtendedKeyCode()==e.VK_DOWN)movingdown=true;
					else if(e.getExtendedKeyCode()==e.VK_W)movingup=true;
					else if(e.getExtendedKeyCode()==e.VK_S)movingdown=true;
				}

				@Override
				public void keyReleased(KeyEvent e) {
					if(e.getExtendedKeyCode()==e.VK_W)movingup=false;
					else if(e.getExtendedKeyCode()==e.VK_S)movingdown=false;
					if(e.getExtendedKeyCode()==e.VK_UP)movingup=false;
					else if(e.getExtendedKeyCode()==e.VK_DOWN)movingdown=false;
				}
				
			};
			this.addKeyListener(k);
		}
	}
	
	private App() {
		this.setAlwaysOnTop(true);;
		this.setSize(600,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		field = new Field(this);
		this.setResizable(false);
		Crear_Enemigos();
		player.setLocation(250,600);
		field.setLayer(player, 10);
		field.add(player,10);
		Start_Button();
		this.setVisible(true);
		
	}
	
	private void Start_Button() {
		JButton start=new JButton();
		start.setSize(150,80);
		start.setOpaque(true);
		start.setBackground(new Color(200,200,200));
		start.setForeground(Color.black);
		start.setText("START");
		start.setLocation((field.getWidth()/2)-(start.getWidth()/2),(field.getHeight()/2)-(start.getHeight()/2));
		start.requestFocus();
		field.add(start,1);
		
		ActionListener k= new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				start.setVisible(false);
				player.requestFocus();
				Run();
			}
			
		};
		start.addActionListener(k);
		
	}
	
	private void Crear_Enemigos() {
		Random r=new Random();
		for(int i=0;i<21;i++) {
			cars[i]= new Car(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			cars[i].setLocation(sendas[r.nextInt(5)],-((i*150)+50));
			field.add(cars[i],1);
		}
	}
	
	private void Run() {
		(new Thread(){
			
			public void run() {
				int pts=0;
				int delay=10;
				Random r = new Random();
				while(true) {
					for(int j=0;j<16;j++) {
						JLabel i=field.divs[j];
						i.setLocation(i.getX(),i.getY()+5);
						if(i.getY()>field.getHeight())i.setLocation(i.getX(),field.divs[(j+4)%16].getY()-300);
						i.updateUI();
					}
					for(int j=0;j<21;j++) {
						JLabel i=cars[j];
						i.setLocation(i.getX(),i.getY()+5);
						if(i.getY()>field.getHeight()) {
							pts++;
							if(pts%20==0&&pts>0) {
								delay--;
								System.out.println(pts+" "+delay);
							}
							i.setLocation(sendas[r.nextInt(5)],cars[(j+20)%21].getY()-(120+r.nextInt(200)));
							i.setBackground(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
						}
						i.updateUI();
					}
					if(player.movingup&&player.getY()>0)player.setLocation(player.getX(),player.getY()-5);
					if(player.movingdown&&player.getY()+player.getHeight()<field.getHeight())player.setLocation(player.getX(),player.getY()+5);
					if(!player.moving) {
						if(!q.isEmpty()) {
							player.dir=q.poll()?1:0;
							player.x_inicial=player.getX();
							player.x_final=player.x_inicial+(player.dir>0?120:-120);
							if(player.x_final>0&&player.x_final<field.getWidth())player.moving=true;
						}
					}
					if(player.moving){
						player.setLocation(player.getX()+(player.dir>0?20:-20),player.getY());
						if(player.getX()==player.x_final) {
							player.dir=0;
							player.moving=false;
						}
					
						
					}
					
					for(int j=0;j<21;j++) {
						JLabel i=cars[j];
					 	if(player.getX()>=i.getX()&&player.getX()<=i.getX()+i.getWidth())
					 		if(player.getY()>=i.getY()&&player.getY()<=i.getY()+i.getHeight())return;
						
					else if(player.getX()+player.getWidth()>=i.getX()&&player.getX()+player.getWidth()<=i.getX()+i.getWidth())
							if(player.getY()>=i.getY()&&player.getY()<=i.getY()+i.getHeight())return; 
					
					else if(player.getX()>=i.getX()&&player.getX()<=i.getX()+i.getWidth())
				 			if(player.getY()+player.getHeight()>=i.getY()&&player.getY()+player.getHeight()<=i.getY()+i.getHeight())return; 
					 	
					else if(player.getX()+player.getWidth()>=i.getX()&&player.getX()+player.getWidth()<=i.getX()+i.getWidth())
							if(player.getY()+player.getHeight()>=i.getY()&&player.getY()+player.getHeight()<=i.getY()+i.getHeight())return;
					
					}
					
					try {
						sleep(delay);
					}
					catch(Exception e) {					
					}
					
				}
				
			}
		}).start();
	}
	
	public static void main(String[] args) {
		new App();
	}
	
}

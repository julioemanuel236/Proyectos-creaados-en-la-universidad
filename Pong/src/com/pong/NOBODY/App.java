package com.pong.NOBODY;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame{

	JLayeredPane field;
	JLabel back;
	Player player;
	Ball ball;
	Block[] blocks = new Block[140];
	int lastpointerx;	
	boolean next;
	
	KeyListener kmove = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getExtendedKeyCode()==e.VK_RIGHT)player.moving=1;
			if(e.getExtendedKeyCode()==e.VK_LEFT)player.moving=-1;
			if(e.getExtendedKeyCode()==e.VK_SPACE&&ball.velx==0) {
				ball.velx=1;
				ball.vely=-1;
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			 if(e.getExtendedKeyCode()==e.VK_RIGHT)player.moving=0;
			 if(e.getExtendedKeyCode()==e.VK_LEFT)player.moving=0;
			lastpointerx=player.getX();
		}
		
	};
		
	MouseListener press = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			next=true;
			if(ball.velx==0) {
			ball.velx=1;
			ball.vely=-1;
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
	
		
	};
	
	MouseMotionListener move = new MouseMotionListener() {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			player.setLocation(e.getX(),player.getY());
			
		}
		
	};
	
	private class Entity extends JLabel{
		boolean fisics=true;
		public Entity() {
			
		}
		
		protected boolean inside(Entity e) {
			if(!this.fisics)return false;
			if(this.get1().x>=e.get1().x-this.getWidth()&&
			   this.get1().y>=e.get1().y-this.getHeight()&&
			   this.get1().x<=e.get4().x&&this.get1().y<=e.get4().y)return true;
			  return false;
		}
		
		protected Point lugar_choque(Entity e) {		
			Point p= new Point();
			int mx=5;
			int my=5;	
			if(ball.get4().x<this.get1().x+mx)p.x=-1;
			else if(ball.get1().x>this.get4().x-mx)p.x=1;
			if(ball.get4().y<this.get1().y+my)p.y=1;
			else if(ball.get1().y>this.get4().y-my)p.y=-1;
			
			return p;
		}
		
		protected void setImagen(String s) {
			this.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(s)).getImage().getScaledInstance(this.getWidth(), this.getHeight(),0) ));
		}
		
		public Point get1() {
			return new Point(this.getX(),this.getY());
		}

		public Point get4() {
			return new Point(this.getX()+this.getWidth(),this.getY()+this.getHeight());
		}
		
	}
	
	private class Ball extends Entity{
		int velx=0;
		int vely=0;
		
		public Ball() {
			this.setSize(20,20);
			//this.setOpaque(true);
			this.setBackground(Color.WHITE);
			this.setImagen("/ball.png");
			this.setLocation(player.getLocation().x+(player.getWidth()/2)-this.getWidth()/2,player.getLocation().y-this.getHeight()-1);
			field.add(this);
		}
	}
	
	private class Player extends Entity{
		private boolean width=false;
		public int velocidad;
		public int moving=0;
		public Player() {
			this.setSize(70,10);
			//this.setOpaque(true);
			this.setImagen("/player.png");
			this.setBackground(Color.BLACK);
			this.setLocation((int)((field.getPreferredSize().width/2)-(this.getWidth()/2)),field.getPreferredSize().height-this.getHeight()-10);
			field.add(this);
		}
		
		public void width(int w) {
			if(width) {
				
			}
		}		
	
	}
	
	private class Block extends Entity{
		static int width=77;
		static int height=27;
		
		public Block(int x,int y) {
			this.setSize(this.width,this.height);
			this.setBackground(Color.red);
			this.setLocation(x,y);
			this.setImagen("/block_darkgray.png");
			field.setLayer(this, 1);
			field.add(this);
		}
		
		public void destroy() {
			this.fisics=false;
			(new Thread() { 
				public void run() {
					while(Block.this.getWidth()>0||Block.this.getHeight()>0) {
						Block.this.setSize(Math.max(Block.this.getWidth()-2,0),Math.max(Block.this.getHeight()-2,0));
						Block.this.setLocation(Block.this.getX()+1,Block.this.getY()+1);
						Block.this.repaint();
						try {
							this.sleep(5);
						}
						catch(Exception e) {
							
						}
					}
				}
			}).start();
			
		}
	}
	
	public App() {
		this.setResizable(false);
		init_field();
		start_button();
		generar_bloques();
		player = new Player();
		field.setLayer(player,2);
		
		ball = new Ball();
		field.setLayer(ball, 1);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		player.requestFocus();
	}

	private void start_button() {
		JButton start= new JButton();
		start.setSize(100,40);
		start.setText("START");
		start.setOpaque(true);
		start.setBackground(Color.DARK_GRAY);
		start.setForeground(Color.white);
		start.setLocation((int)((field.getPreferredSize().getWidth()/2)-(start.getWidth()/2)),(int)((field.getPreferredSize().getHeight()/2)-(start.getHeight()/2)));
		ActionListener START= new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				start.setVisible(false);
				player.requestFocus();
				player.addKeyListener(kmove);
				field.addKeyListener(kmove);
				back.addMouseMotionListener(move);
				run();
			}
			
		
			
		};
		start.addActionListener(START);
		field.setLayer(start,3);
		field.add(start);
	}
	
	private void init_field() {
		field= new JLayeredPane();
		back=new JLabel();
		field.setPreferredSize(new Dimension(700,400));
		back.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/fondo2.png")).getImage().getScaledInstance((int)field.getPreferredSize().getWidth(),(int)field.getPreferredSize().getHeight(),0) ));
		back.setBackground(Color.white);
		back.setOpaque(true);
		back.setSize(field.getPreferredSize());
		back.setLocation(0,0);
		back.addMouseListener(press);
		field.setLocation(0,0);
		field.setLayout(null);

		field.setBackground(Color.white);
		field.setLayer(back,0);
		field.add(back);
		this.add(field);
	}

	private void generar_bloques() {
		int k=0;
		for(int i=1;i<7;i++) {
			for(int j=1;j<8;j++) {
				blocks[k++]= new Block(j*Block.width+(j>0?j+2:1),i*Block.height);
			}
		}
		
	}
	
	private void run() {
		(new Thread() {
			public void run(){				
				int cont=0;
				while(true) {

					
					for(int i=0;blocks[i]!=null;i++) {
						if(blocks[i].inside(ball)) {
							Point p=blocks[i].lugar_choque(ball);
								 if(p.x>0&&ball.velx<0)ball.velx*=-1;
							else if(p.x<0&&ball.velx>0)ball.velx*=-1;						
								 if(p.y>0&&ball.vely>0)ball.vely*=-1;
							else if(p.y<0&&ball.vely<0)ball.vely*=-1;
							
							blocks[i].destroy();

						}
					}
					
					//Game Over
					if(ball.getY()+ball.getHeight()>=back.getHeight()) {
						ball.setLocation(ball.getX(),back.getHeight()-ball.getHeight());
						ball.repaint();
						return;
					}
					
					if(player.moving==1&&player.getX()+player.getWidth()<=field.getPreferredSize().getWidth())player.setLocation(player.getX()+3,player.getY());
					else if(player.moving==-1&&player.getX()>=0)player.setLocation(player.getX()-3,player.getY());
					if(player.getX()<0)player.setLocation(0,player.getY());
					if(player.getX()+player.getWidth()>=field.getPreferredSize().getWidth()) {
						player.setLocation((int)field.getPreferredSize().getWidth()-player.getWidth(),player.getY());
						player.repaint();
					}
					if(ball.vely==0)ball.setLocation((player.getX()+player.getWidth()/2)-ball.getWidth()/2,ball.getY());
					//paredes
					if(ball.getX()>=field.getWidth()-ball.getWidth())ball.velx=-ball.velx;
					if(ball.getX()<=0)ball.velx=-ball.velx;
					if(ball.getY()<=0)ball.vely=-ball.vely;
					
					//player
					if(player.inside(ball)) {
						Point p=player.lugar_choque(ball);
							 if(p.x>0&&ball.velx<0)ball.velx*=-1;
						else if(p.x<0&&ball.velx>0)ball.velx*=-1;
							 if(p.y>0&&ball.vely>0)ball.vely*=-1;
						else if(p.y<0&&ball.vely<0)ball.vely*=-1;
					}
					
					//Update
					ball.setLocation(ball.getX()+ball.velx,ball.getY()+ball.vely);
					ball.repaint();
					player.repaint();

					//FPS
					try {
						this.sleep(2);
						
					}
					catch(Exception ex) {
						
					}
				}
			}
		}).start();
		
	}
	
	public static void main(String[] args) {
		new App();
	
	}
	
}

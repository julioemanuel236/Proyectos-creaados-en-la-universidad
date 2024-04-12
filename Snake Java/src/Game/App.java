package Game;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.applet.AppletContext;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.Thread;
import java.util.Queue;
import java.util.LinkedList;

public class App extends JFrame{
	Field field=new Field();
	Snake snake = new Snake(field);
	Food food=new Food(field);
	long FPS=50;
	long last_FPS=0;
	Queue<Integer> next_dir=new LinkedList<Integer>();
	int last_dir=3;
	boolean AUTO=false;
	KeyListener k;
	JLabel Fondo= new JLabel();
	JLabel f = new JLabel();
	public App() {
		Fondo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/fondo_0_transparente.png")).getImage().getScaledInstance(700, 700,Image.SCALE_SMOOTH)));
		
		Fondo.setSize(700,700);
		
		f.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/fondo_0_transparente.png")).getImage().getScaledInstance(700, 700,Image.SCALE_SMOOTH)));
		
		f.setSize(700,700);
		
		
		this.setSize(700,700);	
		//this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setTitle("THE SNAKE GAME By NOBODY");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(field);	
		
		
		
		Start_Button();
		Key_Listener();
		this.addKeyListener(k);
		field.addKeyListener(k);
		field.setLayer(Fondo,0);
		field.add(Fondo);
		//this.setSize(field.getGraphicsConfiguration().getDevice().getFullScreenWindow().getSize());
		//this.setSize(getGraphicsConfiguration().getDevice().getFullScreenWindow().getSize());
		this.setVisible(true);
	}

	private void Key_Listener() {
		k=new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			//	System.out.println("DIR: "+e.getKeyChar());
				char c=e.getKeyChar();
					 if(c=='w'&&last_dir!=3)snake.nextDir=1;
				else if(c=='d'&&last_dir!=4)snake.nextDir=2;
				else if(c=='s'&&last_dir!=1)snake.nextDir=3;
				else if(c=='a'&&last_dir!=2)snake.nextDir=4;
				else snake.nextDir=0;
				if(snake.nextDir>0&&snake.nextDir!=last_dir) {
			//		System.out.println(last_dir+" "+c);
					next_dir.add(snake.nextDir);
					last_dir=snake.nextDir;
				}
				//for(Integer i:next_dir)
					//System.out.print(i+"\n");
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
		};	

	}

	private void Start_Button() {
			JButton start=new JButton();
			JButton auto = new JButton();
			start.setText("JUGAR");
			auto.setText("Auto");
			start.setSize(100,50);
			auto.setSize(100,50);
			start.setLocation(175,250);
			auto.setLocation(275,250);
			start.addKeyListener(k);
			field.add(start);
			field.add(auto);
			ActionListener empezar = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent ae) {
					start.setVisible(false);
					auto.setVisible(false);
					Start();
				}
			};
			
			ActionListener autoplay = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent ae) {
					start.setVisible(false);
					auto.setVisible(false);
					AUTO=true;
					Start();
				}
			};
			start.addActionListener(empezar);
			auto.addActionListener(autoplay);
	}
	  
	private void Start() {
		(new Thread(){
		
			public void run() {
			field.requestFocus();
			int delay=5;
			int move = 5;
			int iterations = snake.Snake[0].getWidth()/move;
			auto ia=new auto();
			boolean game_over=false;
			if(AUTO)field.removeKeyListener(k);
			while(!game_over) {
				if(AUTO)next_dir.add(ia.Where(field, snake, food));
				
				if(!next_dir.isEmpty())snake.Snake[0].Dir=next_dir.poll(); 
				//System.out.println("quiere ir a: "+snake.Snake[0].Dir);
				//if(snake.size%5==0)delay--;
				int n=field.getWidth()/20;
				int m=field.getHeight()/20;

				for(int i=0;i<iterations;i++){
					
					for(int j=0;j<snake.size;j++) {						
						int x=snake.Snake[j].X;
						int y=snake.Snake[j].Y;
						int dir=snake.Snake[j].Dir;
				//		System.out.println(j+": "+x+' '+y);
						Snake.Body b=snake.Snake[j];
						
						if(dir==1)y-=move; 
						else if(dir==2)x+=move;
						else if(dir==3)y+=move;
						else if(dir==4)x-=move;
						
						b.poner(x, y, dir,field.getWidth()/20,field.getHeight()/20);
						
						b.updateUI();
					}
					try {
						this.sleep(delay);
					}catch(Exception e){
					
					}
				}
				Snake.Body b=snake.Snake[0];
				if(b.X<0)b.X=((n-1)*20);
				else if(b.X>=n*20)b.X=0;
				if(b.Y<0)b.Y=((m-1)*20);
				else if(b.Y>=m*20)b.Y=0;
				Snake.Body a=snake.Snake[0];
				if(food.X==a.X&&food.Y==a.Y) {
					snake.crecer(field,App.this);
					food.nueva(snake);
				}
				//if(a.X<0||a.X>field.getWidth()-20||a.Y<0||a.Y>field.getHeight()-20)game_over=true;
			
				for(int i=snake.size-1;i>0;i--) {
					b=snake.Snake[i];
					if(b.X<0)b.X=((n-1)*20);
					else if(b.X>=n*20)b.X=0;
					if(b.Y<0)b.Y=((m-1)*20);
					else if(b.Y>=m*20)b.Y=0;
					snake.Snake[i].Dir=snake.Snake[i-1].Dir;
					int tx=snake.Snake[0].X;
					int ty=snake.Snake[0].Y;
					if(tx<0||ty<0||tx>field.getWidth()||ty>field.getHeight()||
					a.X==b.X&&a.Y==b.Y) {
						game_over=true;
						break;
					}
				}
				//snake.Snake[0].Dir=snake.nextDir;
			}
			snake.morir();	
			
		}
		}).start();
	}
		
	public static void main(String[] args) {
		new App();
	}
}
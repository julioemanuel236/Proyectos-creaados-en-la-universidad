package packman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Queue;
import java.util.LinkedList;

@SuppressWarnings("serial")
class Packman extends Component{
	
	int ini=60;
	int bi=ini;
	int apertura=60;
	int ga=360-(apertura*2);
	int faceAngle=2;
	int toAngle=2;
	boolean abriendo=true;
	boolean animation=false;
	int last_dir=0;
	int dir = 0;
	int face = 2;
	boolean rotating=false;
	Queue<Integer> move = new LinkedList<Integer>();
	
	void start(){
		(new Thread(){
			public void run(){
				animation=true;
				while(animation){
			
					if(!move.isEmpty())
						dir = move.poll();
				//	System.out.println(dir);
					toAngle = (dir*90)%360;
					if(faceAngle!=toAngle) {
						faceAngle=toAngle;
						bi=((dir*90)%360)+(apertura);
						ga=360-(apertura*2);
					}					
					
						//System.out.println(ga);
					if(ga<=360-(apertura*2))abriendo=false;
					else if(ga>=360)abriendo=true;
					if(abriendo){
						bi+=2;
						ga-=4;
					}
					else {
						bi-=2;
						ga+=4;
					}
				
					
					if(dir==1) {//UP 87
						if(getY()-3>=0)
							setLocation(getX(),getY()-3);				        
					}	
					
					else if(dir==3) {//DOWN 83
						if(getY()+3<=getParent().getHeight())
							setLocation(getX(),getY()+3);
					}
					else if(dir==4) {//RIGHT 68
						if(getX()+3<getParent().getWidth())
							setLocation(getX()+3,getY());
					}
					else if(dir==2) {//LEFT 65
						if(getX()-3>=0)
							setLocation(getX()-3,getY());
					}
					
					repaint();
					try{
						sleep(5);
					}
					catch(Exception e){
					}

				}
			}
		}).start();
	}

	public void paint(Graphics g){
		g.setColor(Color.yellow);
		g.fillArc(0,0,this.getWidth(),this.getHeight(),bi,ga);
	}

	Packman(int w,int h){
		this.setSize(w,h);
	}
	
	void poner(Container c) {
		c.add(this);
		c.repaint();
		c.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int c = e.getKeyCode();
				if(c==e.VK_W)move.add(1);
				else if(c==e.VK_S)move.add(3);					
				else if(c==e.VK_D)move.add(4);
				else if(c==e.VK_A)move.add(2);
				else return;
				
				System.out.println(c);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

	}
	
 	public static void main(String args[]){
 		JFrame main = new JFrame();
 		JPanel panel = new JPanel();
 		//main.add(panel);
 		panel.setOpaque(true);
 		panel.setBackground(Color.black);
 		panel.setLayout(null);
 		main.setSize(500,500);
 		main.setLayout(null);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//main.add(panel);
		panel.setSize(main.getSize());
		Packman p = new Packman(60,60);
		p.poner(main);
		p.start();
		p.repaint();
		main.setSize(500,500);
		main.setVisible(true);
		
		
 	}

}
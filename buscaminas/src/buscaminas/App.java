package buscaminas;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
public class App extends JFrame{
	private JPanel back = new JPanel();
	
	private class Casilla extends JLayeredPane{
		public JLabel back = new JLabel("#");
		public JLabel front = new JLabel();
		
		public Casilla(){
			__init();
		}
		public Casilla(int w,int h){
			this.setSize(w,h);
			back.setSize(w,h);
			
			front.setSize(w,h);
			front.setForeground(java.awt.Color.red);
			front.setHorizontalAlignment(front.CENTER);
			front.setVerticalAlignment(front.CENTER);
			front.setFont(new Font("Robot",0,20));
			
			back.setForeground(java.awt.Color.white);
			back.setHorizontalAlignment(front.CENTER);
			back.setVerticalAlignment(front.CENTER);
			back.setFont(new Font("Robot",0,20));
			__init();
		}
		
		public void __init() {
			JLabel up =  new JLabel();
			up.setSize(this.getWidth(),2);
			JLabel down =  new JLabel();
			down.setSize(this.getWidth(),2);
			JLabel left =  new JLabel();
			left.setSize(2,this.getHeight());
			JLabel right =  new JLabel();
			right.setSize(2,this.getHeight());
			up.setBackground(java.awt.Color.black);
			down.setBackground(java.awt.Color.black);
			left.setBackground(java.awt.Color.black);
			right.setBackground(java.awt.Color.black);
			up.setLocation(0,0);
			down.setLocation(0,this.getHeight()-down.getHeight());
			left.setLocation(0,0);
			right.setLocation(this.getWidth()-right.getWidth(),0);
			up.setOpaque(true);
			down.setOpaque(true);
			left.setOpaque(true);
			right.setOpaque(true);
			this.setLayout(null);
			back.setBackground(java.awt.Color.LIGHT_GRAY);
			back.setOpaque(true);
			front.setBackground(java.awt.Color.DARK_GRAY);
			front.setOpaque(true);
			this.setLayer(front,2);
			this.setLayer(back,1);
			this.setLayer(up,3);
			this.setLayer(down,3);
			this.setLayer(left,3);
			this.setLayer(right,3);
			this.add(up);
			this.add(down);
			this.add(left);
			this.add(right);
			this.add(front);
			this.add(back);
			listeners();
		}
		
		public void listeners() {
			front.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					if(e.getButton()==e.BUTTON1)
						front.setVisible(false);
					else {
						if(front.getText().equals(""))
							front.setText("¶");
						else if(front.getText().equals("¶"))
							front.setText("");
					}
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
	}

	private class P1{
		
	}
	
	private class P2 extends P1{
		
	}
	
	private class P3 extends P2{
		
	}
	
	
	
	public App() {
		P1 p2 = new P2();
		P1 p3 = new P3();
		
		
		if(p3 instanceof P1)System.out.println("asdad");
		int n=8,m=8,t=50;
		back.setSize(n*t,m*t);
		back.setPreferredSize(new java.awt.Dimension(n*t,m*t));
		back.setBackground(java.awt.Color.GRAY);
		back.setOpaque(true);
		back.setLayout(null);
		back.setLocation(0,0);
		//this.setLayout(null);
		
		Casilla c = new Casilla();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				c = new Casilla(t,t);
				c.setLocation(i*t,j*t);
				back.add(c);
				
			}
		}
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.add(back);
		this.pack();
	}
	
	public static void main(String args[]) {
		new App();
	}
}

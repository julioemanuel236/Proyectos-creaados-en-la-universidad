package events;

import javax.swing.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.EventHandler;

public class App extends JFrame{
	
	public App() {
		this.setSize(500,500);
		this.setLayout(null);
		this.setCursor(Cursor.HAND_CURSOR);
		this.setBackground(Color.DARK_GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		KeyListener key= new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.print(e.getKeyChar());
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		MouseListener mouse=new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Se dio click en: "+e.getX()+" "+e.getY());
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
			
		};
		this.addKeyListener(key);
		this.addMouseListener(mouse);
		(new Thread() {
			public void run() {
				while(true) {
					Point mp=App.this.getMousePosition();
					if(mp!=null)System.out.println(mp.getX()+" "+mp.getY());
					else System.out.println("PUNTERO FUERA DE LA VENTANA");
					try {
						this.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}).start();
		MouseMotionListener mousemove=new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println(e.getXOnScreen()+" "+e.getYOnScreen());
				
			}
			
		};
		this.addMouseMotionListener(mousemove);
	}
	
	public static void main(String[] args) {
		App root=new App();
		Move.mover(root, 1000, 500,10 , 10, 1);
	}
}